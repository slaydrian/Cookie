package a18080.a0.a0.http127.cookie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class confirmSignupActivity extends AppCompatActivity {
    private String[] inputArr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_signup);

        inputArr = getIntent().getStringArrayExtra("input");
        ((TextView)findViewById(R.id.tvCoupleName)).setText(inputArr[0]);
        ((TextView)findViewById(R.id.tvAnniversary)).setText(inputArr[1]);
        ((TextView)findViewById(R.id.tvPassword)).setText(inputArr[2]);
        ((TextView)findViewById(R.id.tvName1)).setText(inputArr[4]);
        ((TextView)findViewById(R.id.tvBirthday1)).setText(inputArr[5]);
        ((TextView)findViewById(R.id.tvEmail1)).setText(inputArr[6]);
        ((TextView)findViewById(R.id.tvName2)).setText(inputArr[7]);
        ((TextView)findViewById(R.id.tvBirthday2)).setText(inputArr[8]);
        ((TextView)findViewById(R.id.tvEmail2)).setText(inputArr[9]);
    }

    public void editInput(View view) {
        finish();
    }

    public void registerCouple(View view) {
        Intent intent = new Intent(this, mainMenuActivity.class);
        //DBHandler dbHandler = new DBHandler(this, null, null, 1);
        Couple couple = new Couple(inputArr);
        //dbHandler.addHandler(couple);
        startActivity(intent);
    }
}
