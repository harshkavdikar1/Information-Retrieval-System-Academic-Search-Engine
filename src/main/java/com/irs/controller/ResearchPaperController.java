package com.irs.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.irs.service.IAddResearchPapers;
import com.irs.service.IResearchPaperAutoComplete;
import com.irs.service.ISearchResearchPapers;

@Controller
public class ResearchPaperController {

	@Autowired
	private IAddResearchPapers addResearchPapers;

	@Autowired
	private ISearchResearchPapers searchResearchPapers;
	
	@Autowired
	private IResearchPaperAutoComplete rpSuggest;

	@GetMapping("/add")
	public String addResearchPapersToSolr() throws IOException {
		addResearchPapers.addResearchPapersToSolr();
		return "results";
	}

	@PostMapping("/search")
	public String searchForReseacrhPapers(@RequestParam String content, ModelMap model)
			throws SolrServerException, IOException {
		List<Object> results = searchResearchPapers.search(content);
		model.put("content", content);
		model.put("responsetime", results.get(0));
		model.put("numberofmatches", results.get(1));
		model.put("result", results.get(2));
		model.put("file", results.get(3));
		return "results";
	}

	@GetMapping("/")
	public String setHomePage() {
		return "results";
	}

	@GetMapping("/error")
	public String setErrorPage() {
		return "results";
	}
	
	@RequestMapping(value="/researchPapersAutocomplete")
	@ResponseBody
	public List<String> plantNamesAutocomplete(@RequestParam(value="term", required = false, defaultValue="") String term) throws Exception  {
		return rpSuggest.researchPaperSuggester(term);
	}
}
