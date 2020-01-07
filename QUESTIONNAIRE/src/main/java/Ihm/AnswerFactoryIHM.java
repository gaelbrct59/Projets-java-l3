/**
 * 
 */
package Ihm;

import Ihm_Components.Ihm_Digital;
import Ihm_Components.Ihm_MultiAnswer;
import Ihm_Components.Ihm_MultipleChoice;
import Ihm_Components.Ihm_Textual;
import Ihm_Components.Ihm_YesNo;

import Questionnaire.Question;

/** Build the correct frame for the ihm, depend to the answer's type
 * @author BRICOUT Gael - BEAREZ Antoine
 */
public class AnswerFactoryIHM {
	private AnswerFactoryIHM() {	}
	public final static AnswerFactoryIHM FACTORY = new AnswerFactoryIHM();
	
	
	public void buildFrame(Question question){
		Class<?> c = question.getAnswer().getClass();
		switch (c.getName()) {
		case "AnswerContents.Digital":
			new Ihm_Digital(question);
			break;
		case "AnswerContents.MultiAnswer":
			new Ihm_MultiAnswer(question);
			break;
		case "AnswerContents.MultipleChoice":
			new Ihm_MultipleChoice(question);
			break;
		case "AnswerContents.YesNo":
			new Ihm_YesNo(question);
			break;

		default: //Textual
			new Ihm_Textual(question);
			break;
		}
		
		
		
		
	}
	

}
