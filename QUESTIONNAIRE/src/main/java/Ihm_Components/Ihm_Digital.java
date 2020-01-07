package Ihm_Components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

import Ihm.Ihm_AnswerContent;
import Ihm.QuestionnaireFactoryIHM;
import Questionnaire.Question;
/** Digital content JTextField
 * @author BRICOUT Gael - BEAREZ Antoine
 */
public class Ihm_Digital extends Ihm_AnswerContent implements KeyListener{

	private JTextField jtf;
	
	public Ihm_Digital(Question question) {
		super(question);
		jtf = new JTextField();
        
        jtf.setFont(new Font("Arial", Font.BOLD, 14));
        jtf.setPreferredSize(new Dimension(150, 30));
        jtf.setForeground(Color.BLUE);
        
        jtf.addKeyListener(this);
        
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

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	/**
	 * must be an integer, or a suppr or delete, nothing else (8=delete ; 127=supr)
	 */
	public void keyPressed(KeyEvent e) {
		
		if((e.getKeyChar() < '0' || e.getKeyChar() > '9') && e.getExtendedKeyCode() != 8 && e.getExtendedKeyCode() != 127) {
			this.jtf.setEditable(false);
		}else {
			this.jtf.setEditable(true);
		}
		

	}

	@Override
	public void keyReleased(KeyEvent e) {}
	
	
	
	
}
