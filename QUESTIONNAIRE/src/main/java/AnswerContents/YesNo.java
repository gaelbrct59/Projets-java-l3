/**
 * 
 */
package AnswerContents;

import Questionnaire.Answer;

/** create a YesNo
 * @author BRICOUT Gael - BEAREZ Antoine
 */
public class YesNo extends Answer<YesNoType>{

	public YesNo(YesNoType content) {
		super(content);
	}

	@Override
	/**
	 * if content is equals to "oui" or "non"
	 */
	public boolean accept(String content) {
		return (content.equals("oui") || content.equals("non"));
	}

	@Override
	/**
	 * Display the type of the answer
	 */
	public String toStringConsole() {
		return "(oui/non) ";
	}

	@Override
	/**
	 * Check if the answer of user is the correct answer
	 */
	public boolean isCorrect(Answer<?> theAnswerOfUser) {
		return this.getTheAnswer().toString().equalsIgnoreCase(theAnswerOfUser.toString());
	}

	
	
	
}
