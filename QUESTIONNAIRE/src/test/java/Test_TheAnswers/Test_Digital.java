/**
 * 
 */
package Test_TheAnswers;

import AnswerContents.Digital;
import Questionnaire.Answer;
import Questionnaire.TestAnswer;

/**
 * @author BRICOUT Gael - BEAREZ Antoine
 */
public class Test_Digital extends TestAnswer{

	private final static int ANS_TRUE = 1;
	private final static int ANS_FALSE = 5;
	@Override
	protected String getContent() {
		return new Integer(ANS_TRUE).toString();
	}

	@Override
	protected Answer<?> createAnswer() {
		return new Digital(Integer.parseInt(this.getContent()));
	}


	@Override
	protected Answer<?> createIncorrectAnswer() {
		return new Digital(ANS_FALSE);
	}

	@Override
	protected Answer<?> createCorrectAnswer() {
		return new Digital(ANS_TRUE);
	}

	

}
