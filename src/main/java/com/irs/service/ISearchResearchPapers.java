package com.irs.service;

import java.io.IOException;
import java.util.List;

import org.apache.solr.client.solrj.SolrServerException;

public interface ISearchResearchPapers {

	List<Object> search(String content) throws SolrServerException, IOException;

}
