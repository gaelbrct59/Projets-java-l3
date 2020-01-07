package AnswerContents;

import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

import Questionnaire.Answer;
import Questionnaire.AnswerFactory;

/** create a Multiple choice
 * @author BRICOUT Gael - BEAREZ Antoine
 */
public class MultipleChoice extends Answer<String>{
	private static ArrayList<String> answers = new ArrayList<String>();
	private String correctAnswer;
	
	public MultipleChoice(String content) {
		super(shuffleAString(answers, content));
		correctAnswer = content.split(AnswerFactory.MULTIPLE_CHOICE_SEPARATOR)[0];
	
	}

	@Override
	/**
	 * Display the type of the answer wanted
	 */
	public String toStringConsole() {
		return "(A choisir : " + this.getTheAnswer() +") ";
	}

	/**
	 * Shuffle the ArrayList in parameters
	 * @param newAnswerToShuffle : String
	 * @return new shuffled String
	 */
	private static String shuffleAString(ArrayList<String> newAnswerToShuffle, String toShuffle) {
		ArrayList<String> answerToShuffle = newAnswerToShuffle;
		
		StringTokenizer st = new StringTokenizer(toShuffle, AnswerFactory.MULTIPLE_CHOICE_SEPARATOR);
	    while (st.hasMoreTokens()) {
	    	answerToShuffle.add(st.nextToken());
	    }
	    Collections.shuffle(answerToShuffle);
	    
	    return String.join(AnswerFactory.MULTIPLE_CHOICE_SEPARATOR, answerToShuffle);
	}


	@Override
	/**
	 * is a multipleChoice ?
	 */
	public boolean accept(String content) {
		return content.indexOf(AnswerFactory.MULTIPLE_CHOICE_SEPARATOR) != -1;
	}

	
	@Override
	/**
	 * Check if the answer of user is the correct answer
	 */
	public boolean isCorrect(Answer<?> theAnswerOfUser) {
		
		while(!answers.contains(theAnswerOfUser.toString())) {
			System.out.println("Choisir une reponse qui appartient aux propositions citées.");
			theAnswerOfUser = AnswerFactory.FACTORY.buildAnswer(util.Read.ScannerAsk());
		}

		return this.correctAnswer.equalsIgnoreCase(theAnswerOfUser.toString());
	}

	
}
