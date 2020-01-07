/**
 * 
 */
package Questionnaire;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author BRICOUT Gael - BEAREZ Antoine
 */
public class TestAnswerFactory {

	@Test
	public void testBuildAnswerReturnCorrectType() {
		assertTrue(AnswerFactory.FACTORY.buildAnswer("5") instanceof AnswerContents.Digital);
		assertTrue(AnswerFactory.FACTORY.buildAnswer("e | e") instanceof AnswerContents.MultipleChoice);
		assertTrue(AnswerFactory.FACTORY.buildAnswer("e ; e") instanceof AnswerContents.MultiAnswer);
		assertTrue(AnswerFactory.FACTORY.buildAnswer("oui") instanceof AnswerContents.YesNo);
		assertTrue(AnswerFactory.FACTORY.buildAnswer("C language < Java") instanceof AnswerContents.Textual);
	}

}
