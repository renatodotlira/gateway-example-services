package demo.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.dao.AdjectiveClient;
import demo.dao.ArticleClient;
import demo.dao.NounClient;
import demo.dao.SubjectClient;
import demo.dao.VerbClient;
import demo.domain.Word;

@Service
public class WordServiceImpl implements WordService {

	@Autowired VerbClient verbClient;
	@Autowired SubjectClient subjectClient;
	@Autowired ArticleClient articleClient;
	@Autowired AdjectiveClient adjectiveClient;
	@Autowired NounClient nounClient;

	@HystrixCommand(fallbackMethod = "defaultMethodSubject")
	@Override
	public Word getSubject() {
		return subjectClient.getWord();
	}

	@HystrixCommand(fallbackMethod = "defaultMethodVerb")
	@Override
	public Word getVerb() {
		return verbClient.getWord();
	}

	@HystrixCommand(fallbackMethod = "defaultMethodArticle")
	@Override
	public Word getArticle() {
		return articleClient.getWord();
	}

	@HystrixCommand(fallbackMethod = "defaultMethod")
	@Override
	public Word getAdjective() {
		return adjectiveClient.getWord();
	}

	@HystrixCommand(fallbackMethod = "defaultMethodNoun")
	@Override
	public Word getNoun() {
		return nounClient.getWord();
	}

	public Word defaultMethod(){
		Word word = new Word();
		word.setWord("default");
		return word;
	}

	public Word defaultMethodSubject(){
		Word word = new Word();
		word.setWord("DEFAULT SUBJECT");
		return word;
	}

	public Word defaultMethodVerb(){
		Word word = new Word();
		word.setWord("DEFAULT VERB");
		return word;
	}

	public Word defaultMethodNoun(){
		Word word = new Word();
		word.setWord("DEFAULT NOUN");
		return word;
	}

	public Word defaultMethodArticle(){
		Word word = new Word();
		word.setWord("DEFAULT ARTICLE");
		return word;
	}
}
