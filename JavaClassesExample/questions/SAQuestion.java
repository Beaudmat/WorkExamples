package questions;

/**
 * Class to create Short Answer Questions
 * @author Matthew Beaudoin, 2022
 * 
 * This code was written for an assignment for Java2
 */

public class SAQuestion extends Question{

    // Stores the answer for the question
    private String answer;

    /** Constructor method with default values */
    public SAQuestion(){
        super();
        answer = "TBD";
    }

    /** 
     * Constructor method that accepts values 
     * @param num Id of the question
     * @param ques Text displayed for the question
     * @param ans Answer to the question
    */
    public SAQuestion(int num, String ques, String ans){
        super(num,ques);
        setAnswer(ans);
    }

    /**
     * Sets a new answer for the question
     * @param ans Answer to the question
     * @throws IllegalArgumentException Throws if ans is null
     */
    public void setAnswer(String ans) throws IllegalArgumentException{
        if(ans == null){
            throw new IllegalArgumentException("Answer can not be null");
        }
        answer = ans;
    }

    /**
     * 
     * @return Returns the answer to the question
     */
    public String getAnswer(){
        return answer;
    }

    /** Overrides is correct and returns true or false depending on if the answer is correct */
    @Override
    public boolean isCorrect(Object guess){
        if(answer.equalsIgnoreCase(guess.toString())) return true;
        return false;
    }

    /** Overrides toString and returns a formatted String */
    @Override
    public String toString(){
        return super.toString();
    }
}