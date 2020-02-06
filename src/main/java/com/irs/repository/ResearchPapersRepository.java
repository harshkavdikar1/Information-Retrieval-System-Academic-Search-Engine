package com.irs.repository;

import org.springframework.data.solr.repository.SolrCrudRepository;

import com.irs.model.ResearchPaper;

public interface ResearchPapersRepository extends SolrCrudRepository<ResearchPaper, Integer>{

		
}
