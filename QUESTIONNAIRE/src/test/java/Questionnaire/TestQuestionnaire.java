package Questionnaire;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import AnswerContents.Textual;

public class TestQuestionnaire {
	
	private static final int TEST_NB_PTNS = 10;
	
	Answer<String> answer1= new Textual("Hello");
	Answer<String> answer2= new Textual("Hello world");
	Question question = new Question("is this hello ?",answer1,TEST_NB_PTNS);
	Questionnaire questionnaire = new Questionnaire();

	
	@Test
	public void testAskAllGetTheCorrectNbOfPoints() {
		questionnaire.addQuestion(question);
		assertEquals(QuestionnaireFactory.NB_POINTS, 0);
		questionnaire.askAll(false);
		assertEquals(QuestionnaireFactory.NB_POINTS, TEST_NB_PTNS);
	}
	
	@Test
	public void testAskAllGetTheCorrectNbOfPointsTo0() {
		questionnaire.addQuestion(question);
		ArrayList<String> answers = new ArrayList<String>();
		answers.add(answer2.toString());
		assertEquals(QuestionnaireFactory.NB_POINTS, TEST_NB_PTNS); //On verifie que le nombre de points ne bouge pas malgre la methode askAll
		questionnaire.askAll(answers);
		assertEquals(QuestionnaireFactory.NB_POINTS, TEST_NB_PTNS);
	}

}
