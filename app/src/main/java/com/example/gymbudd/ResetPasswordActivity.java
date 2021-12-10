package com.example.gymbudd;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ResetPasswordActivity extends AppCompatActivity {
    private EditText editText_email;
    private Button button_cancel;
    private Button button_changePass;
    private ProgressBar progressBar;

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);


        editText_email = (EditText) findViewById(R.id.type_email);
        button_cancel = (Button) findViewById(R.id.cancel_button);
        button_changePass = (Button) findViewById(R.id.btn_changePass);
        progressBar = (ProgressBar) findViewById(R.id.progressBar) ;

        auth = FirebaseAuth.getInstance();

        button_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        button_changePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePassword();
            }
        });



    }

    private void changePassword() {
        String email = editText_email.getText().toString().trim();

        Toast.makeText(ResetPasswordActivity.this, email, Toast.LENGTH_SHORT).show();
        if(email.isEmpty()){
            editText_email.setError("Email field is empty");
            editText_email.requestFocus();
            return;
        }
//        if(Patterns.EMAIL_ADDRESS.matcher(email).matches()){
//            editText_email.setError("please type valid email");
//            editText_email.requestFocus();
//            return;
//
//        }
        progressBar.setVisibility(View.VISIBLE);

        auth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isComplete()) {
                    Toast.makeText(ResetPasswordActivity.this, "Email Sent", Toast.LENGTH_SHORT).show();
                    Log.d("Tag", "Email Sent");
                }
            }
        });


    }
}