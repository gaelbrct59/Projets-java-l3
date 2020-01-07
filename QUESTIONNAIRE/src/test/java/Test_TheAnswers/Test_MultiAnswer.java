package Test_TheAnswers;

import AnswerContents.MultiAnswer;
import AnswerContents.Textual;
import Questionnaire.Answer;
import Questionnaire.AnswerFactory;
import Questionnaire.TestAnswer;

/**
 * @author BRICOUT Gael - BEAREZ Antoine
 */
public class Test_MultiAnswer extends TestAnswer{
	private final static String ANS_TRUE = "n1 ";
	private final static String ANS_FALSE = "n5";
	@Override
	protected String getContent() {
		return ANS_TRUE+AnswerFactory.MULTI_ANSWER_SEPARATOR;
	}

	@Override
	protected Answer<?> createAnswer() {
		return new MultiAnswer(this.getContent());
	}

	@Override
	protected Answer<?> createIncorrectAnswer() {
		return new Textual(ANS_FALSE);
	}

	@Override
	protected Answer<?> createCorrectAnswer() {
		return new MultiAnswer(ANS_TRUE);
	}

}
