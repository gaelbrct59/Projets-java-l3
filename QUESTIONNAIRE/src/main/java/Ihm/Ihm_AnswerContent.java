package Ihm;

import javax.swing.JLabel;

import Questionnaire.Question;

/** Factory for answers components
 * @author BRICOUT Gael - BEAREZ Antoine
 */
public abstract class Ihm_AnswerContent {
	public Question question;
	
	/** Getter for question
	 * @return the question
	 */
	public Question getQuestion() {
		return question;
	}

	public Ihm_AnswerContent(Question question) {
		this.question = question;
		JLabel newlabel = new JLabel(question.getAnswer().toStringConsole());
		
		QuestionnaireFactoryIHM.pan.add(newlabel);
	}
	
	public abstract String getAnswerToSubmit();
	
}
