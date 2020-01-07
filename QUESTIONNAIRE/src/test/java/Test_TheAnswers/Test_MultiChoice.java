/**
 * 
 */
package Test_TheAnswers;

import AnswerContents.MultipleChoice;
import AnswerContents.Textual;
import Questionnaire.Answer;
import Questionnaire.AnswerFactory;
import Questionnaire.TestAnswer;

/**
 * @author BRICOUT Gael - BEAREZ Antoine
 */
public class Test_MultiChoice extends TestAnswer{
	private final static String ANS_TRUE = "n1";
	private final static String ANS_FALSE = "n2";
	@Override
	protected String getContent() {
		return ANS_TRUE+AnswerFactory.MULTIPLE_CHOICE_SEPARATOR+ANS_FALSE;
	}

	@Override
	protected Answer<?> createAnswer() {
		return new MultipleChoice(this.getContent());
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
