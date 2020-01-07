/**
 * 
 */
package Questionnaire;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/** Factory for a questionnaire (singleton)
 * @author BRICOUT Gael - BEAREZ Antoine
 */
public class QuestionnaireFactory {
	public static int NB_POINTS = 0;
	public static final QuestionnaireFactory FACTORY = new QuestionnaireFactory();
	private QuestionnaireFactory(){}
	/**
	 * Create a Questionnaire with a file
	 * @param fileName : path of file
	 * @return the only one questionnaire
	 * @throws IOException
	 */
	public Questionnaire createQuestionnaire (String fileName) throws IOException {
		Questionnaire questionnaire = new Questionnaire();
		File source = new File(fileName);
		BufferedReader in = null ;
		try {
			in = new BufferedReader(new FileReader(source));
			String text ;
			// read block of 3 li n e s : text , answer and number of points
			while (( text = in.readLine())!= null ) {
				String answer = in.readLine();
				String nbPoints = in.readLine();
				if(answer == null || nbPoints == null ) {
					throw new IOException("bad format");
				}
				questionnaire.addQuestion(this.createQuestion(text, answer, nbPoints));
			}
		} catch (FileNotFoundException e) {
			throw new IOException(e);
		}
		finally{
			in.close();
		}
	return questionnaire;
	}
	
	/**
	 * Create a question with the file in parameters in createQuestion
	 * @param text : String
	 * @param answer : Answer
	 * @param points : String
	 * @return the Question
	 * @throws IOException
	 */
	public Question createQuestion (String text, String answer, String points) throws IOException {
		try {
			int nbPoints = Integer.parseInt(points);
			return new Question(text, AnswerFactory.FACTORY.buildAnswer(answer), nbPoints);
		}
		catch(NumberFormatException e) {
			throw new IOException("bad format (createQuestion)");
		}
	
	}

}