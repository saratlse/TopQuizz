
//GameActivity est le controller dans la classe GameActivity,
// D'interroger le modèle pour récupérer une question, puis de la présenter au joueur avec quatre propositions de réponse ;
//De récupérer la réponse du joueur, de vérifier sa validité et d'afficher le statut (réponse correcte ou erronée) ;
//De comptabiliser le score du joueur ;
//En fin de partie, de présenter le score au joueur.








package sara.openclassrooms.topquizz.controller;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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

    private int mNumberOfQuestions;
    private int mScore;
    public static final String BUNDLE_EXTRA_SCORE = "BUNDLE_EXTRA_SCORE";






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        mQuestionBank = this.generateQuestions(); //on cree une methode generateQuestions

        mNumberOfQuestions = 4; //le jeu s'arrete apres 4 questions
        mScore = 0; // j initialise la variable score a zero
        mNumberOfQuestions = 4;


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

        mButton1.setOnClickListener(this);
        mButton2.setOnClickListener(this);
        mButton3.setOnClickListener(this);
        mButton4.setOnClickListener(this);

        mCurrentQuestion = mQuestionBank.getQuestion();
        this.displayQuestion(mCurrentQuestion);
    }



        //cette methode sera utilise quelque soit le bouton ou l'utilisateur va cliquer
        @Override
        public void onClick(View v) {

            int  responseIndex  = (int)v.getTag();//je cree une variable int reponse

            if (responseIndex == mCurrentQuestion.getAnswerIndex()) {
                Toast.makeText(this,"Correct",Toast.LENGTH_SHORT).show();
                mScore ++; //j'incremente de 1 a chaque bonne reponse

            } else {
                Toast.makeText(this, "Wrong Answer!",Toast.LENGTH_SHORT).show();
            }
            if (--mNumberOfQuestions == 0){
                endGame();
            }else {
                mCurrentQuestion = mQuestionBank.getQuestion();
                displayQuestion(mCurrentQuestion);
            }

        }

    private void endGame() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Well done !")
                .setMessage("Your score is " + mScore)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(); //je cree un intent en utilisant le constructeur par defaut
                        intent.putExtra(BUNDLE_EXTRA_SCORE, mScore);//pour mettre la valeur dans l'intent j'utilise la methode PUTEXTRA
                        //PUTEXTRA prend en parametre le score et on lui associe un identifiant BUndle
                        setResult(RESULT_OK,intent);//on appel la methode setREsult popur enregistrer l'intent aupres d'android
                        // et l'envoyer le resultat a la mainActivity
                        finish();

                    }
                })
                .create()
                .show();

    }


    //la methode displayQuestion prend en parametre une question et met a jour
    //les differents champs de l'interface graphique
    private void displayQuestion (final Question question){
        mQuestion.setText(question.getQuestion());
        mButton1.setText(question.getChoiceList().get(0));//identifiant 0
        mButton2.setText(question.getChoiceList().get(1));
        mButton3.setText(question.getChoiceList().get(2));
        mButton4.setText(question.getChoiceList().get(3));

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
