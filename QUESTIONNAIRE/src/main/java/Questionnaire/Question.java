/**
 * 
 */
package Questionnaire;

/** Question for questionaire
 * @see Questionnaire
 * @author BRICOUT Gael - BEAREZ Antoine
 */
public class Question {
	private String nameQuestion;
	private int nbPoints;
	private Answer<?> answer; //The answer for the actual question
	
	
	public Question(String nameQuestion, Answer<?> answer, int nbPoints) {
		this.answer = answer;
		this.nameQuestion = nameQuestion;
		this.nbPoints = nbPoints;
	}

	/** Getter for nbPoints
	 * @return the nbPoints
	 */
	public int getNbPointsOfTheQuestion() {
		return nbPoints;
	}

	/** Getter for nameQuestion
	 * @return the nameQuestion
	 */
	public String getNameOfTheQuestion() {
		return nameQuestion;
	}


	/** Getter (the answer to the question)
	 * @return the answer
	 */
	public Answer<?> getAnswer() {
		return answer;
	}
}
