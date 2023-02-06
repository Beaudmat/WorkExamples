package questions;

/**
 * Class to be extended to TFQuestion and SAQuestion providing common elements
 * @author Matthew Beaudoin, 2022
 * 
 * This code was written as an assignment for Java2
 */

public abstract class Question {
    
    // Id of the question
    protected int questionId;
    // Text displayed for the question
    protected String questionText;

    /** Constructor method with default values */
    public Question(){
        this.questionId = 1;
        this.questionText = "TBD";
    }

    /**
     * Constructor method that accepts values
     * @param num Id of the question
     * @param ques Text displayed for the question
     */
    public Question(int num, String ques){
        setQuestionId(num);
        setQuestionText(ques);
    }

    /**
     * Sets the question id
     * @param num Id of the question
     * @throws IllegalArgumentException Throws if the id is not an integer greater then zero
     */
    public void setQuestionId(int num) throws IllegalArgumentException{
        if(num <= 0){
            throw new IllegalArgumentException("The question ID must be an Integer greater then zero");
        }
        this.questionId = num;
    }

    /**
     * 
     * @return Returns the id of the question
     */
    public int getQuestionId(){
        return this.questionId;
    }

    /**
     * 
     * @param ques Text displayed for the question
     * @throws IllegalArgumentException Throws if the question text is left blank
     */
    public void setQuestionText(String ques) throws IllegalArgumentException{
        if(ques.isBlank()){
            throw new IllegalArgumentException("Question text can not be blank");
        }
        this.questionText = ques;
    }

    /**
     * 
     * @return Returns the text of the question that is displayed
     */
    public String getQuestionText(){
        return this.questionText;
    }

    /**
     * 
     * @param guess Guess for the questions answer
     * @return Returns true or false depending on if the answer is correct
     */
    public abstract boolean isCorrect(Object guess);

    /** Overrides toString and returns a formatted string*/
    @Override
    public String toString(){
        if(questionText.equals("TBD"))
            return String.format("#%d: No question text entered.\n", questionId);
        return String.format("#%d: %s.\n", questionId, questionText);
    }
}