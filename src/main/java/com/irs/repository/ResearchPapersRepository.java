package com.irs.repository;

import java.util.List;

import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;

import com.irs.model.ResearchPaper;

public interface ResearchPapersRepository extends SolrCrudRepository<ResearchPaper, Integer>{

		@Query("paper:\"?0\"")
		List<ResearchPaper> findByPaperContaining(String paper);
		
		ResearchPaper findByAuthor(String author);
}
