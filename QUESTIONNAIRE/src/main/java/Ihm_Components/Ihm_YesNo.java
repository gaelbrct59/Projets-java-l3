package Ihm_Components;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;

import Ihm.Ihm_AnswerContent;
import Ihm.QuestionnaireFactoryIHM;
import Questionnaire.Question;

/** Yes no (radio button)
 * @author BRICOUT Gael - BEAREZ Antoine
 */
public class Ihm_YesNo extends Ihm_AnswerContent {
	JCheckBox oui = new JCheckBox("Oui");
	JCheckBox non = new JCheckBox("Non");
	public Ihm_YesNo(Question question) {
		super(question);
		
		ButtonGroup group = new ButtonGroup();
        group.add(oui);
        group.add(non);        
        
		QuestionnaireFactoryIHM.pan.add(oui);
		QuestionnaireFactoryIHM.pan.add(non);
		QuestionnaireFactoryIHM.components.add(this);
	}

	@Override
	public String getAnswerToSubmit() {
		if (oui.isSelected()) {
			return oui.getText();
		}else if (non.isSelected()){
			return non.getText();
		}else {
			return null;
		}
	}

}
