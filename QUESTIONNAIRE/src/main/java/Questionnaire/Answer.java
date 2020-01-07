package Questionnaire;

/** Answer for question
 * @see Question
 * @author BRICOUT Gael - BEAREZ Antoine
 */
public abstract class Answer<T> {
	
    private T answerOfQuestion;
    
    public abstract boolean accept(String content);
    public abstract String toStringConsole();
    public abstract boolean isCorrect(Answer<?> theAnswerOfUser);
    
    public Answer(T content) {
    	this.answerOfQuestion = content;
    }
    
    /**
     * type getter
     * @return T : type
     */
    public T getTheAnswer() {
    	return this.answerOfQuestion;
    }
    /**
     * Transform the answer in string
     */
    public String toString() {
    	return ""+ this.answerOfQuestion;
    }
    
}
