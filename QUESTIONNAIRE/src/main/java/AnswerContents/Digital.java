/**
 * 
 */
package AnswerContents;


import Questionnaire.Answer;
/** create a digital
 * @author BRICOUT Gael - BEAREZ Antoine
 */
public class Digital extends Answer<Integer>{

	public Digital(int content) {
		super(content);
	}
	
	@Override
	/**
	 * if the content is a int
	 */
	public boolean accept(String content){
		boolean res = true;
		try {
			Integer.parseInt(content);
			
		}catch (NumberFormatException e) {
			res = false;
		}
		return res;
	}
	/**
	 * Display 'numerique' in the console, for the type of the answer
	 */
	@Override
	public String toStringConsole() {
		return "(Numerique) ";
	}
	
	@Override
	/**
	 * Check if the answer of user is the correct answer
	 */
	public boolean isCorrect(Answer<?> theAnswerOfUser) {
		return this.getTheAnswer().toString().equalsIgnoreCase(theAnswerOfUser.toString());
	}

}
