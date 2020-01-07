/**
 * 
 */
package AnswerContents;

import Questionnaire.Answer;
import Questionnaire.AnswerFactory;

/** create a Multi answer
 * @author BRICOUT Gael - BEAREZ Antoine
 */
public class MultiAnswer extends Answer<String>{
	
	public MultiAnswer(String content) {
		super(content);
		
	}

	@Override
	/**
	 * is a multi Answer ?
	 */
	public boolean accept(String content) {
		return content.indexOf(AnswerFactory.MULTI_ANSWER_SEPARATOR) != -1;
	}

	@Override
	/**
	 * Display the type of the answer
	 */
	public String toStringConsole() {
		return "(Plusieurs réponses autorisées) ";
	}
	
	@Override
	/**
	 * Check if the answer of user is the correct answer
	 */
	public boolean isCorrect(Answer<?> theAnswerOfUser) {
		String[] answerSplited = this.getTheAnswer().split(AnswerFactory.MULTI_ANSWER_SEPARATOR);
		for (int i = 0; i < answerSplited.length; i++) {
			if(theAnswerOfUser.toString().equalsIgnoreCase(answerSplited[i])) {
				return true;
			}
		}
		return false;
	}
	
}
