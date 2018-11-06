package a18080.a0.a0.http127.cookie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }

    public void goToLink(View view) {
        Intent intent;
        if(view.getId() == R.id.bLogin) {
            intent = new Intent(this, LoginActivity.class);
        } else {
            intent = new Intent(this, SignupActivity.class);
        }
        startActivity(intent);
    }
}
