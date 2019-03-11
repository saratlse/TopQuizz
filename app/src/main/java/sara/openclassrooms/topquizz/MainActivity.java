package sara.openclassrooms.topquizz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private TextView mGreetingText;
    private EditText mNameInput;
    private Button mPlayButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        mGreetingText = (TextView)findViewById(R.id.tvWelcome);
        mNameInput = (EditText)findViewById(R.id.etName);
        mPlayButton = (Button)findViewById(R.id.btnPlay);


        mPlayButton.setEnabled(false);//je desactive le bouton


        mNameInput.addTextChangedListener(new TextWatcher() { //on est notifie quand le user tape son nom
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {//cette methode sera appelé quand le user commence a taper son nom
                mPlayButton.setEnabled(s.toString().length()!=0);//on appelle cette methode il faut que le nbre de caractere soit different de 0
            }

            @Override
            public void afterTextChanged(Editable s) {

            }

        });

        mPlayButton.setOnClickListener(new View.OnClickListener() { // cette methode est appele a chaque fois que le user clique sur le bouton
            @Override
            public void onClick(View v) {

                Intent gameActivity = new Intent(MainActivity.this,GameActivity.class);
                startActivity(gameActivity);

            }

        });

    }

}
