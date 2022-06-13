package org.tensorflow.lite.examples.ClickSnake;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.tensorflow.lite.examples.ClickSnake.tflite.Classifier;

public class HomeActivity extends AppCompatActivity {

    Button btnRealTime;
    Button btnStorage;
    Button btnLogOut;
    FirebaseAuth mAuth;
    FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        btnRealTime = findViewById(R.id.btnRealTime);
        btnStorage = findViewById(R.id.btnStorage);
        btnLogOut = findViewById(R.id.btnLogOut);
        mAuth=FirebaseAuth.getInstance();

        btnRealTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, ClassifierActivity.class));
            }
        });

        btnStorage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, StorageActivity.class));
            }
        });

        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                Intent intent = new Intent(HomeActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
                Toast.makeText(HomeActivity.this,"LogOut Successful...",Toast.LENGTH_SHORT).show();
            }
        });

    }
}