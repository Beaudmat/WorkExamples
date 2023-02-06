//This code was written for an assignment for Java2
package questions;
public class ClientClass {
    
    public static void main(String[] args){
        SAQuestion TestT = new SAQuestion();
        TestT.setAnswer("This is an answer");
        TestT.setQuestionText("This is a question");
        System.out.println(TestT);

        TFQuestion TestTF = new TFQuestion();
        TestTF.setAnswer(false);
        TestTF.setQuestionText("This is the second question");
        TestTF.setQuestionId(2);
        System.out.println(TestTF);

    }
}
