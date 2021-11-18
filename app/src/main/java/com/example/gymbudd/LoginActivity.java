package com.example.gymbudd;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthListener;
    EditText editText_email, editText_password;
    Button button_login, button_signup, trainer_signup;

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.signOut();
        if (mAuth.getCurrentUser() != null) {
            Intent intent = new Intent(LoginActivity.this, QuestionnaireActivity.class);
            startActivity(intent);
        }
    }

    //GGaXscC6BXcVE5TGmc6nfLlfeXb2
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        EditText editTextEmail = findViewById(R.id.editText_email);
        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser currentUser = mAuth.getCurrentUser();
            }
        };

        editText_email = (EditText) findViewById(R.id.editText_email);
        editText_password = (EditText) findViewById(R.id.editText_password);
        button_login = (Button) findViewById(R.id.button_login);
        button_signup = (Button) findViewById(R.id.button_signup);
        trainer_signup = (Button) findViewById(R.id.trainer_signup) ;

        button_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

        trainer_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent messi = new Intent(LoginActivity.this, TrainerSignUpActivity.class);
                startActivity(messi);
            }
        });

        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!editText_email.getText().toString().equals("") && !editText_password.getText().toString().equals("")) {
                    loginUsers();
                }else {
                    Toast.makeText(LoginActivity.this, "Enter email and password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void loginUsers() {
        String email = editText_email.getText().toString();
        String password = editText_password.getText().toString();
        Log.d("demo", "I am here");

        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Log.d("demo", "I am successful");
                    Toast.makeText(LoginActivity.this, "Logged in", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, GymBuddyActivity.class);
                    startActivity(intent);
                    editText_email.setText("");
                    editText_password.setText("");
                }else {
                    Toast.makeText(LoginActivity.this, "LOG IN FAILED", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}