package questions;

/**
 * Class to create True or False questions
 * @author Matthew Beaudoin, 2022
 * 
 * This code was written for an assignment for Java2
 */

public class TFQuestion extends Question {
    
    // Stores the answer for the question
    private boolean answer;

    /** Constructor method with default values */
    public TFQuestion(){
        super();
        answer = false;
    }

    /**
     * Constructor method that accepts values
     * @param num Id for the question
     * @param ques Text displayed for the question
     * @param ans Answer to the question
     */
    public TFQuestion(int num, String ques, boolean ans){
        super(num,ques);
        answer = ans;
    }

    /**
     * Sets a new answer for the question
     * @param ans answer to the question
     */
    public void setAnswer(boolean ans){
        answer = ans;
    }

    /**
     * 
     * @return returns the answer to the question
     */
    public boolean isAnswer(){
        return answer;
    }

    /** Overrides is correct and returns true or false depending on if the answer is correct */
    @Override
    public boolean isCorrect(Object guess){
        if(guess instanceof Boolean){
            if(answer == (Boolean)guess) return true;
        }
        if(guess instanceof String){
            if(answer == Boolean.parseBoolean((String)guess)) return true;
        }
        return false;
    }

    /** Overrides toString and returns a formatted String */
    @Override
    public String toString(){
        if(questionText.equals("TBD"))
            return String.format("#%d: No question text entered. [true or false?]\n", questionId);
        return String.format("#%d: %s. [true or false]\n", questionId, questionText);
    }
}
