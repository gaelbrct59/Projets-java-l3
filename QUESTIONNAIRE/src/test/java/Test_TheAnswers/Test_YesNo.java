/**
 * 
 */
package Test_TheAnswers;

import AnswerContents.YesNo;
import AnswerContents.YesNoType;
import Questionnaire.Answer;
import Questionnaire.TestAnswer;

/**
 * @author BRICOUT Gael - BEAREZ Antoine
 */
public class Test_YesNo extends TestAnswer{

	@Override
	protected String getContent() {
		return new YesNo(YesNoType.values()[0]).toString();
	}

	@Override
	protected Answer<?> createAnswer() {
		return new YesNo(YesNoType.valueOf(this.getContent()));
	}

	@Override
	protected Answer<?> createIncorrectAnswer() {
		return new YesNo(YesNoType.valueOf("non"));
	}

	@Override
	protected Answer<?> createCorrectAnswer() {
		return this.createAnswer();
	}
}
