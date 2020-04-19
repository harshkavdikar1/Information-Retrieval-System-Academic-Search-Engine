package com.irs.service;

import java.util.List;

public interface IResearchPaperAutoComplete {

	List<String> researchPaperSuggester(String term) throws Exception;
}
