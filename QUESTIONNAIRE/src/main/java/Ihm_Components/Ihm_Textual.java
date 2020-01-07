package Ihm_Components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JTextField;

import Ihm.Ihm_AnswerContent;
import Ihm.QuestionnaireFactoryIHM;
import Questionnaire.Question;

/** Textual (TextField)
 * @author BRICOUT Gael - BEAREZ Antoine
 */
public class Ihm_Textual extends Ihm_AnswerContent {

	private JTextField jtf;
	
	public Ihm_Textual(Question question) {
		super(question);
		jtf = new JTextField();
        
        jtf.setFont(new Font("Arial", Font.BOLD, 14));
        jtf.setPreferredSize(new Dimension(150, 30));
        jtf.setForeground(Color.BLUE);
        
        
        QuestionnaireFactoryIHM.pan.add(jtf);
        QuestionnaireFactoryIHM.components.add(this);
        
	}
	

	@Override
	public String getAnswerToSubmit() {
		if(jtf.getText().isEmpty()) {
			return null;
		}
		return jtf.getText();
	}

}
