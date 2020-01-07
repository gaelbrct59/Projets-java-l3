package AnswerContents;

import Questionnaire.Answer;

/** Textual content for the question
 * @author BRICOUT Gael - BEAREZ Antoine
 */
public class Textual extends Answer<String>{

	public Textual(String content) {
		super(content);
	}

	@Override
	/**
	 * if the content ils a text
	 */
	public boolean accept(String content) {
		return true;
	}

	@Override
	/**
	 * Display the type of the answer
	 */
	public String toStringConsole() {
		return "(Symbolique) ";
	}
	
	@Override
	/**
	 * Check if the answer of user is the correct answer
	 */
	public boolean isCorrect(Answer<?> theAnswerOfUser) {
		return this.getTheAnswer().toString().equalsIgnoreCase(theAnswerOfUser.toString());
	}

}
