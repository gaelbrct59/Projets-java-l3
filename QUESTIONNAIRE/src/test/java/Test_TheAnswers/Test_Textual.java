/**
 * 
 */
package Test_TheAnswers;

import AnswerContents.Textual;
import Questionnaire.Answer;
import Questionnaire.TestAnswer;

/**
 * @author BRICOUT Gael - BEAREZ Antoine
 */
public class Test_Textual extends TestAnswer{
	private final static String ANS_TRUE = "Java";
	private final static String ANS_FALSE = "C language";
	@Override
	protected String getContent() {
		return ANS_TRUE;
	}

	@Override
	protected Answer<?> createAnswer() {
		return new Textual(this.getContent());
	}

	@Override
	protected Answer<?> createIncorrectAnswer() {
		return new Textual(ANS_FALSE);
	}

	@Override
	protected Answer<?> createCorrectAnswer() {
		return new Textual(ANS_TRUE);
	}

}
