package com.irs.controller;


import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.irs.model.ResearchPaper;
import com.irs.service.ResearchPaperServiceInterface;


@RestController
public class ResearchPaperController {
	
	@Autowired
	private ResearchPaperServiceInterface rps;
	
	@GetMapping("/start")
	public ArrayList<ResearchPaper> add() throws IOException {
		return rps.addResearchPapers();
	}
}
