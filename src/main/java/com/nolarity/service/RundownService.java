package com.nolarity.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nolarity.Constants;
import com.nolarity.dao.RundownRepository;
import com.nolarity.dao.RundownRowRepository;
import com.nolarity.dao.StoryRepository;
import com.nolarity.model.Rundown;
import com.nolarity.model.RundownRow;
import com.nolarity.model.Story;

@Service
public class RundownService {

	private static String newRowTitle = Constants.NEW_ROW_TITLE;
	
	@Autowired
	private RundownRepository rundownRepo;

	@Autowired
	private RundownRowRepository rowRepo;

	@Autowired
	private StoryRepository storyRepo;

	/**
	 * This method finds all rundowns.
	 * Returns a Set<Rundown>
	 * @return
	 */
	@Transactional(readOnly = true)
	public Set<Rundown> findAll() {
		return rundownRepo.findAll().stream().collect(Collectors.toSet());
	}

	/**
	 * This method adds a new rundown with a new row and new story.
	 * Returns added Rundown.
	 * @param rundown
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Rundown add(Rundown rundown) {
		Set<RundownRow> rows = rundown.getRundownRows();
		if (rows != null) {
			for (RundownRow row : rows) {
				Story story = new Story("unapproved", newRowTitle, "Script goes here.", 0);
				storyRepo.save(story);
				row.setRowStoryId(story.getStoryId());
				rowRepo.save(row);
			}
		}
		return rundownRepo.save(rundown);
	}

	/**
	 * This method gets a rundown by id in order to add a new row to it. 
	 * Returns the Rundown with the new row and a new story.
	 * @param rundownId
	 * @return
	 */
	@Transactional(readOnly = true)
	public Rundown getRundownById(long rundownId) {
		if (rundownId <= 0) {
			return null;
		} else {
			return rundownRepo.findByRundownId(rundownId);
		}
	}

	/**
	 * This method adds a row with new story to an existing rundown by id.
	 * It finds the stories in the rundown.
	 * Then checks to see if NEW_ROW_TITLE exists and adds next counter if true.
	 * Returns the Rundown.
	 * @param rundownId
	 * @param newRow
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Rundown addRowToRundown(long rundownId, RundownRow newRow) {
		Rundown rundown = rundownRepo.findByRundownId(rundownId);
		String newRowSuffix = "";	// this will be the counter if there is more than one New Row
		int newStoryCount = 0;

		Set<RundownRow> rows = rundown.getRundownRows();

		List<Long> storyIds= rundownRepo.findStoryIdsByRundown(rundownId);
		List<Story> stories = new ArrayList<Story>();
		
		for (Long storyId : storyIds) {
			stories.add(storyRepo.findByStoryId(storyId));
		}
		
		for (Story story : stories) {
			if (story.getTitle().startsWith(newRowTitle)) {
				newStoryCount++;
			}
		}
		
		if(newStoryCount > 0) {
			newRowSuffix = " (" + newStoryCount + ")";
			
		} else {
			newRowSuffix = "";
		}
		
		Story story = new Story("unapproved", newRowTitle + newRowSuffix, "Script goes here.", 0);
		storyRepo.save(story);
		newRow.setRowStoryId(story.getStoryId());
		rows.add(newRow);
		rowRepo.save(newRow);
		return rundownRepo.save(rundown);
	}

}
