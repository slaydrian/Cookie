package a18080.a0.a0.http127.cookie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SignupActivity extends AppCompatActivity {
    private String[] inputArr = new String[10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
    }

    public void recordRegistration(View view) {
        //TODO: Password check
        //TODO: Email check
        //TODO: Date check. Preferably change to date picker
        String coupleName = ((EditText)findViewById(R.id.tvCoupleName)).getText().toString();
        String anniversary = ((EditText)findViewById(R.id.tvAnniversary)).getText().toString();
        String password = ((EditText)findViewById(R.id.tvPassword)).getText().toString();
        String password2 = ((EditText)findViewById(R.id.tvPasswordConfirmation)).getText().toString();

        String name1 = ((EditText)findViewById(R.id.tvName1)).getText().toString();
        String birthday1 = ((EditText)findViewById(R.id.tvBirthday1)).getText().toString();
        String email1 = ((EditText)findViewById(R.id.tvEmail1)).getText().toString();

        String name2 = ((EditText)findViewById(R.id.tvName2)).getText().toString();
        String birthday2 = ((EditText)findViewById(R.id.tvBirthday2)).getText().toString();
        String email2 = ((EditText)findViewById(R.id.tvEmail2)).getText().toString();

        inputArr[0] = coupleName;
        inputArr[1] = anniversary;
        inputArr[2] = password;
        inputArr[3] = password2;
        inputArr[4] = name1;
        inputArr[5] = birthday1;
        inputArr[6] = email1;
        inputArr[7] = name2;
        inputArr[8] = birthday2;
        inputArr[9] = email2;

        Intent intent = new Intent(this, confirmSignupActivity.class);
        intent.putExtra("input", inputArr);
        startActivity(intent);
    }
}
