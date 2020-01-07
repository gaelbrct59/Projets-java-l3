/**
 * 
 */
package Questionnaire;

import AnswerContents.Digital;
import AnswerContents.MultiAnswer;
import AnswerContents.MultipleChoice;
import AnswerContents.Textual;
import AnswerContents.YesNo;
import AnswerContents.YesNoType;

/** Factory for answers
 * @see Answer
 * @author BRICOUT Gael - BEAREZ Antoine
 */
public class AnswerFactory {
	public final static AnswerFactory FACTORY = new AnswerFactory();
	
	public static final String MULTI_ANSWER_SEPARATOR = " ; ";
	public static final String MULTIPLE_CHOICE_SEPARATOR = " | ";
	
	/**
	 * Build an answer, depend to the type of the content
	 * @see Answer
	 * @param answer : Answer
	 * @return Answer with the correct type
	 */
	public final Answer<?> buildAnswer(String answer){
		
		if(new Digital(1).accept(answer)) {
			
			return new Digital(Integer.parseInt(answer));
			
		}else if (new YesNo(YesNoType.values()[0]).accept(answer)) {

			return new YesNo(YesNoType.valueOf(answer));
			
		}else if(new MultipleChoice("").accept(answer)) {
			
			return new MultipleChoice(answer); 
			
		}else if(new MultiAnswer("").accept(answer)) {
			
			return new MultiAnswer(answer);
			
		}else {
			return new Textual(answer);
			
		}
	}
	
	
}
