
//GameActivity est le controller dans la classe GameActivity,
// D'interroger le modèle pour récupérer une question, puis de la présenter au joueur avec quatre propositions de réponse ;
//De récupérer la réponse du joueur, de vérifier sa validité et d'afficher le statut (réponse correcte ou erronée) ;
//De comptabiliser le score du joueur ;
//En fin de partie, de présenter le score au joueur.








package sara.openclassrooms.topquizz.controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;

import sara.openclassrooms.topquizz.R;
import sara.openclassrooms.topquizz.model.Question;
import sara.openclassrooms.topquizz.model.QuestionBank;


//pour implementer la logique du clique sur chaque boutons on implemte la logique du clic
// sur chaque bouton avec implements View.onClickListener
public class GameActivity extends AppCompatActivity implements View.OnClickListener {


    private TextView mQuestion;
    private Button mButton1;
    private Button mButton2;
    private Button mButton3;
    private Button mButton4;


    //on implemente le modele
    private QuestionBank mQuestionBank;
    private Question mCurrentQuestion;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        mQuestionBank = this.generateQuestions(); //on cree une methode generateQuestions


        //widgets
        mQuestion = (TextView) findViewById(R.id.tvQuestion);
        mButton1 = (Button) findViewById(R.id.btnAnswer1);
        mButton2 = (Button) findViewById(R.id.btnAnswer2);
        mButton3 = (Button) findViewById(R.id.btnAnwer3);
        mButton4 = (Button) findViewById(R.id.btnAnswer4);


        //on donne une valeur aux boutons
        //exemple quand on clique sur le bouton 1 cela renvoi a l'identifiant 0
        mButton1.setTag(0);
        mButton2.setTag(1);
        mButton3.setTag(2);
        mButton4.setTag(3);

        mCurrentQuestion = mQuestionBank.getQuestion();
        this.displayQuestion(mCurrentQuestion);}



        //cette methode sera utilise quelque soit le bouton ou l'utilisateur va cliquer
        @Override
        public void onClick(View v) {

        }




    //la methode displayQuestion prend en parametre une question et met a jour
    //les differents champs de l'interface graphique
    private void displayQuestion (final Question question){
        mQuestion.setText(question.getQuestion());
        mButton1.setTag(question.getChoiceList().get(0));
        mButton2.setTag(question.getChoiceList().get(1));
        mButton3.setTag(question.getChoiceList().get(2));
        mButton4.setTag(question.getChoiceList().get(3));



    }


    private QuestionBank generateQuestions() {
        //on retrouve la methode generateQuestions qui va generer une List de questions

        Question question1 = new Question("Who is the dictator of Cuba?",
                Arrays.asList("Saddam Hussain",
                        "Kadafy",
                        "Mario Bros",
                        "FidelCastro"),
                3);

        Question question2 = new Question("What is the house number of the Simpsons?",
                Arrays.asList("555",
                        "742",
                        "424",
                        "247"),
                1);

        Question question3 = new Question("Who is the director of Reservoir Dogs?",
                Arrays.asList("Spielberg",
                        "Luc Besson",
                        "Georges Lucas",
                        "Tarentino"),
                3);
        Question question4 = new Question("Who is the drummer of Metallica?",
                Arrays.asList("Los Del Rio",
                        "Michael Jackson",
                        "Stevie Wonder",
                        "Lars Ulrich"),
                3);

        //la list de question est ajoute a la questionBank
        return new QuestionBank(Arrays.asList(question1,
                question2,
                question3,
                question4));

    }

}
