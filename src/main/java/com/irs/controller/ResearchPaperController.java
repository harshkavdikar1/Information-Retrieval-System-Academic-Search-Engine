package com.irs.controller;


import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.irs.service.ResearchPaperServiceInterface;


@RestController
public class ResearchPaperController {
	
	@Autowired
	private ResearchPaperServiceInterface rps;
	
	@PostConstruct
	public void ad() throws IOException {
		rps.addResearchPapers();
	}
	
	@GetMapping("/start")
	public String add() throws IOException {
		return "Successfull";
	}
}
