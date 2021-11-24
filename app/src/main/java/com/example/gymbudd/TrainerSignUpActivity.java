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
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseUser;

public class TrainerSignUpActivity extends AppCompatActivity {
    private EditText editTrainerfName;
    private EditText editTrainerlName;
    private EditText editTraineremail;
    private EditText editTrainerchoosePassword;
    private EditText editTrainerrepeatPassword;
    private Button buttonTrainerSignup;
    private Button buttonTrainerBack;

    private FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener authStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trainer_sign_up);

        mAuth = FirebaseAuth.getInstance();
        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser currentUser = mAuth.getCurrentUser();

            }
        };

        editTrainerfName = (EditText) findViewById(R.id.trainer_fname);
        editTrainerlName = (EditText) findViewById(R.id.trainer_last_name);
        editTraineremail = (EditText) findViewById(R.id.trainer_email);
        editTrainerchoosePassword = (EditText) findViewById(R.id.trainer_password);
        editTrainerrepeatPassword = (EditText) findViewById(R.id.trainer_retype_password);
        buttonTrainerSignup = (Button) findViewById(R.id.trainer_btn_register);
        buttonTrainerBack = (Button) findViewById(R.id.trainer_btn_back);

        buttonTrainerBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ronaldo = new Intent(TrainerSignUpActivity.this, LoginActivity.class);
                startActivity(ronaldo);
            }
        });

        buttonTrainerSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstName = editTrainerfName.getText().toString();
                String lastName = editTrainerlName.getText().toString();
                String email = editTraineremail.getText().toString();
                //Toast.makeText(SignUpActivity.this, email, Toast.LENGTH_SHORT).show();
                String password = editTrainerchoosePassword.getText().toString().trim();
                String passwordrepeat = editTrainerrepeatPassword.getText().toString().trim();


                if (!password.equals(passwordrepeat)){
                    Toast.makeText(TrainerSignUpActivity.this, "Password don't match", Toast.LENGTH_SHORT).show();
                } else if (firstName.equals("") || lastName.equals("") || email.equals("")
                        || password.equals("")) {
                    Toast.makeText(TrainerSignUpActivity.this, "One or more field empty", Toast.LENGTH_SHORT).show();
                }else{
                    mAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (!task.isSuccessful()) {
                                        FirebaseAuthException e = (FirebaseAuthException)task.getException();
                                        Log.d("demo", "Failed Registration: "+e.getMessage());
                                        //Toast.makeText(SignupActivity.this, "Failed Registration: "+e.getMessage(), Toast.LENGTH_SHORT).show();
                                        Toast.makeText(TrainerSignUpActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                                    }else {
                                        Toast.makeText(TrainerSignUpActivity.this, "Signup Successful", Toast.LENGTH_SHORT).show();
                                        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                                        Intent intent = new Intent(TrainerSignUpActivity.this, QuestionnaireActivity.class);
                                        intent.putExtra("CLASS", "Trainer");
                                        intent.putExtra("EMAIL", email);
                                        intent.putExtra("NAME", firstName + " " + lastName);
                                        startActivity(intent);
                                        finish();
                                    }
                                }
                            });
                }

            }
        });
    }

}