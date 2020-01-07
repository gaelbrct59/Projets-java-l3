package Ihm;


import java.awt.Color;
import java.awt.Font;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Questionnaire.Question;
import Questionnaire.Questionnaire;
import Questionnaire.QuestionnaireFactory;

/** Create the JFrame and his components (Questions, Answer, Button)
 * @author BRICOUT Gael - BEAREZ Antoine
 */
public class QuestionnaireFactoryIHM extends JFrame {

	private Questionnaire q;
	private static final long serialVersionUID = 1L;
	public JFrame background;
	public final static JPanel pan = new JPanel();
	public final static ArrayList<Ihm_AnswerContent> components = new ArrayList<Ihm_AnswerContent>();
	
	public QuestionnaireFactoryIHM() throws IOException {
		
	}

	/**
	 * Create and init IHM version for questionnaireIHM
	 * @param file : String
	 * @return the Questionnaire
	 * @throws IOException 
	 */
	public Questionnaire createQuestionnaireIHM(String file) throws IOException {
		this.q = QuestionnaireFactory.FACTORY.createQuestionnaire(file);
		this.background = new JFrame();
		pan.setLayout(new BoxLayout(pan, BoxLayout.PAGE_AXIS));
		initBackgroundJFrame();
		initPanelSContentJPanel();
		this.background.setVisible(true);
		return null;
	}

	/** EXTRACTED : init the panel's Contents
	 * @throws IOException
	 */
	private void initPanelSContentJPanel() throws IOException {
	    //Définition de sa couleur de fond
	    pan.setBackground(Color.decode("#FFFBEC"));        
	    //On prévient notre JFrame que notre JPanel sera son content pane 
		
		this.background.setContentPane(pan);
		this.implementTheJPanel();
	}


	/** 
	 * EXTRACTED : init the JFrame
	 */
	private void initBackgroundJFrame() {
		//Définit un titre pour notre fenêtre
		background.setTitle("Questionnaire");
	    //Définit sa taille : 400 pixels de large et 100 pixels de haut
		background.setSize(900, 800);
	    //Nous demandons maintenant à notre objet de se positionner au centre
		background.setLocationRelativeTo(null);
	    //Termine le processus lorsqu'on clique sur la croix rouge
		background.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Create the elements in JPanel
	 * @throws IOException 
	 */
	public void implementTheJPanel() throws IOException {
		
		for(Question question : q.getTheQuestions()) {
			
			JLabel labelQuestion = displayQuestion(question);
			QuestionnaireFactoryIHM.pan.add(labelQuestion);
			this.displayAnswer(question);
			
		}
		new Submit(this.getQuestionnaire());
	}


	/** get the answer's type in the questionnaire
	 * @param question : Question
	 * @return label
	 */
	private JLabel displayAnswer(Question question) {
		JLabel labelQuestion = new JLabel(question.getAnswer().toString());
		// Modifier la police, le style et la taille de police d'un texte
		labelQuestion.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,20));
		
		AnswerFactoryIHM.FACTORY.buildFrame(question);
		
		return labelQuestion;
	}


	/** display the question in the questionnaire
	 * @param question : Question
	 * @return label 
	 */
	private JLabel displayQuestion(Question question) {
		JLabel textLabel = new JLabel(question.getNameOfTheQuestion());
		// Modifier la police, le style et la taille de police d'un texte
		textLabel.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,20));
		return textLabel;
	}

	/**
	 * Get the actual questionnaire
	 * @return actual questionnaire
	 */
	public Questionnaire getQuestionnaire() {
		return this.q;
	}


	
	
	
}
