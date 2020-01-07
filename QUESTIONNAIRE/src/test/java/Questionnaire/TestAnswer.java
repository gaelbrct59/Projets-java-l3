package Questionnaire;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit test for Answer
 * @see Answer
 */
public abstract class TestAnswer {
	
	protected abstract String getContent();
    protected abstract Answer<?> createAnswer();
    protected abstract Answer<?> createCorrectAnswer();
    protected abstract Answer<?> createIncorrectAnswer();
    
	Answer<?> answer = createAnswer();
	Answer<?> correctAnswer = createCorrectAnswer();
	Answer<?> incorrectAnswer = createIncorrectAnswer();
	Question question = new Question("hello", answer, 10);
	
    @Test
    public void testAcceptReturnTrue() {
    	
        assertTrue(answer.accept(getContent()));
    }

    @Test
    public void testIsCorrectReturnTrue() {
    	assertEquals(true,answer.isCorrect(correctAnswer));
    }
    @Test
    public void testIsCorrectReturnFalse() {
    	
    	assertTrue(!answer.isCorrect(incorrectAnswer));
    }
}
