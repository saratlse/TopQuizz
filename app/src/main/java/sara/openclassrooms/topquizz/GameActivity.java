package sara.openclassrooms.topquizz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {


    private TextView mQuestion;
    private Button mButton1;
    private Button mButton2;
    private Button mButton3;
    private Button mButton4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);


        mQuestion = (TextView)findViewById(R.id.tvQuestion);
        mButton1 = (Button)findViewById(R.id.btnAnswer1);
        mButton2 = (Button)findViewById(R.id.btnAnswer2);
        mButton3 = (Button)findViewById(R.id.btnAnwer3);
        mButton4 = (Button) findViewById(R.id.btnAnswer4);
    }
}
