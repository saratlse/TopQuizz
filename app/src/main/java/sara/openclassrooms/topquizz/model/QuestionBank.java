


package sara.openclassrooms.topquizz.model;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class QuestionBank {


    private List<Question> mQuestionList;
    private int mNextquestionIndex;


    public QuestionBank(List<Question> questionList) { // constructeur
        mQuestionList = questionList; // on initialise la list

        Collections.shuffle(mQuestionList);// on melange les questions

        mNextquestionIndex = 0;

    }

    public Question getQuestion(){
        if (mNextquestionIndex == mQuestionList.size()){
            mNextquestionIndex = 0;
        }
        return mQuestionList.get(mNextquestionIndex++); //on incremente de 1
    }

}
