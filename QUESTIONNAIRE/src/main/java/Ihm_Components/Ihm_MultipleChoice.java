/**
 * 
 */
package Ihm_Components;

import javax.swing.JComboBox;
import Ihm.Ihm_AnswerContent;
import Ihm.QuestionnaireFactoryIHM;
import Questionnaire.AnswerFactory;
import Questionnaire.Question;

/** Multiple choice for IHM (ComboBox)
 * @author BRICOUT Gael - BEAREZ Antoine
 */
public class Ihm_MultipleChoice extends Ihm_AnswerContent {
	private JComboBox<String> combo;
	public Ihm_MultipleChoice(Question question) {
		super(question);
		
		String[] theAnswers = question.getAnswer().toString().split(" ["+AnswerFactory.MULTIPLE_CHOICE_SEPARATOR+"] ");
		
		combo = new JComboBox<String>(theAnswers);
		QuestionnaireFactoryIHM.pan.add(combo);	
		QuestionnaireFactoryIHM.components.add(this);
	}

	@Override
	public String getAnswerToSubmit() {
		return (String)this.combo.getSelectedItem();
	}
}
