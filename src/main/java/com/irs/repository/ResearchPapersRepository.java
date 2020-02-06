package com.irs.repository;

import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;

import com.irs.model.ResearchPaper;

@Repository
public interface ResearchPapersRepository extends SolrCrudRepository<ResearchPaper, Integer>{

		
}
