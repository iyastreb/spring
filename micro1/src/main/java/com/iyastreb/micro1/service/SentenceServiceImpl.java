package com.iyastreb.micro1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iyastreb.micro1.dao.AdjClient;
import com.iyastreb.micro1.dao.ArticleClient;
import com.iyastreb.micro1.dao.NounClient;
import com.iyastreb.micro1.dao.SubjectClient;
import com.iyastreb.micro1.dao.VerbClient;

@Service
public class SentenceServiceImpl implements SentenceService {

	private NounClient nounClient;
	private AdjClient adjClient;
	private ArticleClient articleClient;
	private VerbClient verbClient;
	private SubjectClient subjectClient;

	@Override
	public String buildSentence() {
		String res = String.format("%s %s %s %s %s.",
				subjectClient.getWord(),
				verbClient.getWord(),
				articleClient.getWord(),
				adjClient.getWord(),
				nounClient.getWord());
		return res;
	}
	
	@Autowired
	public void setNounClient(NounClient nounClient) {
		this.nounClient = nounClient;
	}

	@Autowired
	public void setAdjClient(AdjClient adjClient) {
		this.adjClient = adjClient;
	}

	@Autowired
	public void setArticleClient(ArticleClient articleClient) {
		this.articleClient = articleClient;
	}

	@Autowired
	public void setVerbClient(VerbClient verbClient) {
		this.verbClient = verbClient;
	}

	@Autowired
	public void setSubjectClient(SubjectClient subjectClient) {
		this.subjectClient = subjectClient;
	}	
}
