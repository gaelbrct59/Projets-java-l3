package Questionnaire;

import java.util.ArrayList;

import util.Read;

/** New questionnaire, with Answers and Question
 * @see Answer
 * @see Question
 * @author BRICOUT Gael - BEAREZ Antoine
 */
public class Questionnaire {
	
	private ArrayList<Question> theQuestions;
	
	public Questionnaire() {
		this.theQuestions = new ArrayList<Question>();
	}
	
	/**
	 * Add a question to the questionnaire
	 * @param newQuestion : Question
	 */
	public void addQuestion(Question newQuestion) {
		theQuestions.add(newQuestion);
	}
	
	
	/**
	 * Method which manage the display of question, check if the answer is correct and go to the next question
	 * @param ask : boolean (display or not the question, and the ask to the user (for test)
	 */
	public void askAll(boolean ask) {
		Answer<?> answerOfTheUser;
		for(Question question : this.theQuestions) {
			if(ask) {
				displayForConsole(question);
				answerOfTheUser = AnswerFactory.FACTORY.buildAnswer(Read.ScannerAsk());
			}else {
				//On renvoie la bonne réponse 
				answerOfTheUser = question.getAnswer();
			}
			
			checkTheAnswerOfTheUser(answerOfTheUser, question);
		}
		System.out.println("Vous avez finalement : " + QuestionnaireFactory.NB_POINTS + " points");
	}
	
	/**
	 * Method askAll Override
	 * @param answered : String arrayList
	 */
	public void askAll(ArrayList<String> answered) {
		for (int i = 0; i < answered.size(); i++) {
			if(this.theQuestions.get(i).getAnswer().isCorrect(AnswerFactory.FACTORY.buildAnswer(answered.get(i)))) {
				QuestionnaireFactory.NB_POINTS += this.theQuestions.get(i).getNbPointsOfTheQuestion();
			}
		}
	}
	
	/**
	 * EXTRACTED : Check if the user has correctly answered 
	 * @param answerOfTheUser : scanner
	 * @param question : Question
	 */
	private void checkTheAnswerOfTheUser(Answer<?> answerOfTheUser, Question question) {
		if(question.getAnswer().isCorrect(answerOfTheUser)) {
			System.out.println("Réponse correcte, + " + question.getNbPointsOfTheQuestion() + " points");
			QuestionnaireFactory.NB_POINTS += question.getNbPointsOfTheQuestion();
		}else {
			System.out.println("Réponse fausse ! La réponse était " + question.getAnswer().getTheAnswer());
		}
	}

	/**
	 * EXTRACTED : Displayer for the console
	 * @param question : Question
	 */
	private void displayForConsole(Question question) {
		System.out.println("Question : " + question.getNameOfTheQuestion() + " {" + question.getNbPointsOfTheQuestion() + " points}");
		System.out.println(question.getAnswer().toStringConsole() + " votre réponse : ");
	}
	
	/** Getter for theQuestions
	 * @return the theQuestions
	 */
	public ArrayList<Question> getTheQuestions() {
		return theQuestions;
	}

}
