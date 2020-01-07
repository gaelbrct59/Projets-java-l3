/**
 * 
 */
package Ihm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Questionnaire.Questionnaire;
import Questionnaire.QuestionnaireFactory;

/** Submit the answers from the questionnaire
 * @author BRICOUT Gael - BEAREZ Antoine
 */
public class Submit extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel newLabelButton;
	private ArrayList<String> theAnswers;
	private Questionnaire questionnaire;
	private JButton bouton;
	
	public Submit(Questionnaire q) {
		this.questionnaire = q;
		
		initButtonSubmit();
        initTheLabel();
        
		QuestionnaireFactoryIHM.pan.add(newLabelButton);
	}

	/**
	 * EXTRACTED : Init label
	 */
	private void initTheLabel() {
		newLabelButton = new JLabel("Remplir tous les formulaires");
		newLabelButton.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,20));
	}
	
	/**
	 * EXTRACTED : init the button submit
	 */
	private void initButtonSubmit() {
		bouton = new JButton("Envoyer les reponses");
		QuestionnaireFactoryIHM.pan.add(bouton);
		bouton.addActionListener(this); 
	
        bouton.setBorderPainted(false); // Ne pas afficher les bordures.
        bouton.setFocusPainted(false); // On n'affiche pas l'effet de focus.
        bouton.setBackground(Color.decode("#33CCCC"));
        bouton.setPreferredSize(new Dimension(250, 100));
        bouton.setForeground(Color.WHITE);
	}
	
	/**
	 * Get all the answers from the questionnaire
	 * @return ArrayList String
	 */
	public ArrayList<String> getAnswers() {
		theAnswers = new ArrayList<String>();
		for(Ihm_AnswerContent answers : QuestionnaireFactoryIHM.components) {
			this.theAnswers.add(answers.getAnswerToSubmit());
		}
		return theAnswers;
	}
	
	@Override
	/**
	 * Call askAll and count the points, depend to correct answers
	 */
	public void actionPerformed(ActionEvent e) {
		
		ArrayList<String> tmpAnswers = this.getAnswers();
		if(tmpAnswers.contains(null)) {
			this.newLabelButton.setText("Veuillez remplir tous les formulaires !");
		}else {
			questionnaire.askAll(tmpAnswers);
			this.newLabelButton.setText("Nombre de points : " + QuestionnaireFactory.NB_POINTS);
			bouton.setBackground(Color.DARK_GRAY);
			
			bouton.setEnabled(false);

		}
	}
}
