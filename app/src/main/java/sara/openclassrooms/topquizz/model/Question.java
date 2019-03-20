package sara.openclassrooms.topquizz.model;

import java.util.IllegalFormatException;
import java.util.List;

public class Question {
    private String mQuestion; //le texte de la question
    private List<String> mChoiceList; //liste des reponses proposees
    private int mAnswerIndex; // l'index de la reponse precedente

    public Question(String question, List<String> choiceList, int answerIndex) {
        this.mQuestion = question;
        this.mChoiceList = choiceList;
        this.mAnswerIndex = answerIndex;
    }

    public String getQuestion() {

        return mQuestion;
    }

    public void setQuestion(String question) {

        mQuestion = question;
    }

    public List<String> getChoiceList() {
        return mChoiceList;
    }

    public void setChoiceList(List<String> choiceList) {

        if (choiceList==null) {
            throw new  IllegalArgumentException("Array can not be null");//a revoir
        }
    }

        public int getAnswerIndex () {
            return mAnswerIndex;
        }


        public void setAnswerIndex ( int answerIndex){
            if ((answerIndex <= 0) || (answerIndex >= 3)) {
                throw new IllegalArgumentException("Answer index is out of bound");
            }
            mAnswerIndex = answerIndex;

        }
    }

