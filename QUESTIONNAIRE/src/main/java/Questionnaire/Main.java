/**
 * 
 */
package Questionnaire;

import java.io.IOException;
import java.util.ArrayList;

import Ihm.QuestionnaireFactoryIHM;


/** Main class for Questionnaire (version console)
 * @author BRICOUT Gael - BEAREZ Antoine
 */
public class Main {

	/**
	 * @param args : args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		final String consolVersion1 = "Version console sans multi";
		final String consolVersion2 = "Version console avec multi";
		final String IHMVersion1 = "Version IHM sans multi";
		final String IHMVersion2 = "Version IHM avec multi";
		
		System.out.println("Quelle version choisir ?");
		ArrayList<String> method = new ArrayList<String>();
		method.add(consolVersion1);
		method.add(consolVersion2);
		method.add(IHMVersion1);
		method.add(IHMVersion2);
		switch(util.Chooser.choose(method, "Quelle version choisir ?")) {
		case consolVersion1:
			consolVersion1();
			break;
		case consolVersion2:
			consolVersion2();
			break;
		case IHMVersion1:
			IHMversion1();
			break;
		case IHMVersion2:
			IHMversion2();
			break;
		}

	}

	/** Third version : IHM without multiple choice & multi answer
	 * @throws IOException
	 */
	private static void IHMversion1() throws IOException {
		QuestionnaireFactoryIHM init = new QuestionnaireFactoryIHM();
		init.createQuestionnaireIHM("examples/question_tolkien.txt");
	}
	
	/** Third version : IHM without multiple choice & multi answer
	 * @throws IOException
	 */
	private static void IHMversion2() throws IOException {
		QuestionnaireFactoryIHM init = new QuestionnaireFactoryIHM();
		init.createQuestionnaireIHM("examples/question_tolkien_2.txt");
	}

	/** First version : console version without multiChoice & multiAnswer
	 * @throws IOException
	 */
	private static void consolVersion1() throws IOException {
		Questionnaire q = QuestionnaireFactory.FACTORY.createQuestionnaire("examples/question_tolkien.txt");
		q.askAll(true);
	}

	/** Second version : console with multiChoice & multiAnswer
	 * @throws IOException
	 */
	private static void consolVersion2() throws IOException {
		Questionnaire q = QuestionnaireFactory.FACTORY.createQuestionnaire("examples/question_tolkien_2.txt");
		q.askAll(true);
	}

}
