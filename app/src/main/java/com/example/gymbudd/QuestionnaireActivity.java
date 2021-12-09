package com.example.gymbudd;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class QuestionnaireActivity extends AppCompatActivity {

    Button button_Submit;
    FirebaseFirestore db;
    FirebaseAuth fAuth;

    private Spinner spinnerAge;
    private Spinner spinnerGender;
    private Spinner spinnerFitnessGoal;
    private Spinner spinnerGymFreq;
    private Spinner spinnerGymProgramInterest;
    private Spinner spinnerGymTiming;
    private Spinner spinnerSameGender;
    private Spinner spinnerInterestPT;
    private Spinner spinnerGymSession;
    private Spinner spinnerEquipmentFamiliar;
    private Spinner spinnerHadWorkoutPartner;
    private Spinner spinnerRate;
    private EditText usernameinput;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire);
        db = FirebaseFirestore.getInstance();
        fAuth = FirebaseAuth.getInstance();

        spinnerAge = findViewById(R.id.spinnerAge);
        spinnerGender = findViewById(R.id.spinnerGender);
        spinnerFitnessGoal = findViewById(R.id.spinnerFitnessGoals);
        spinnerGymFreq = findViewById(R.id.spinnerGymFreq);
        spinnerGymProgramInterest = findViewById(R.id.spinnerGymProgramInterest);
        spinnerGymTiming = findViewById(R.id.spinnerGymTiming);
        spinnerSameGender = findViewById(R.id.spinnerSameGender);
        spinnerInterestPT = findViewById(R.id.spinnerInterestPT);
        spinnerGymSession = findViewById(R.id.spinnerGymSession);
        spinnerEquipmentFamiliar = findViewById(R.id.spinnerEquipmentFamiliar);
        spinnerHadWorkoutPartner = findViewById(R.id.spinnerHadWorkoutPartner);
        spinnerRate = findViewById(R.id.spinnerRate);
        usernameinput = (EditText) findViewById(R.id.usernameinput);
        button_Submit = (Button) findViewById(R.id.submitQuestionnaire) ;

        String[] userAges = getResources().getStringArray(R.array.ages);
        ArrayAdapter adapter1 = new ArrayAdapter(this,android.R.layout.simple_spinner_item, userAges);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAge.setAdapter(adapter1);

        String[] userGenders = getResources().getStringArray(R.array.genders);
        ArrayAdapter adapter2 = new ArrayAdapter(this,android.R.layout.simple_spinner_item, userGenders);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerGender.setAdapter(adapter2);

        String[] userFitnessGoal = getResources().getStringArray(R.array.fitness_goals);
        ArrayAdapter adapter3 = new ArrayAdapter(this,android.R.layout.simple_spinner_item, userFitnessGoal);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFitnessGoal.setAdapter(adapter3);

        String[] userGymFreq = getResources().getStringArray(R.array.frequency_gym);
        ArrayAdapter adapter4 = new ArrayAdapter(this,android.R.layout.simple_spinner_item, userGymFreq);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerGymFreq.setAdapter(adapter4);

        String[] userGymProgramInterest = getResources().getStringArray(R.array.gymprogram_interest);
        ArrayAdapter adapter5 = new ArrayAdapter(this,android.R.layout.simple_spinner_item, userGymProgramInterest);
        adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerGymProgramInterest.setAdapter(adapter5);

        String[] userGymTiming = getResources().getStringArray(R.array.gym_timing);
        ArrayAdapter adapter6 = new ArrayAdapter(this,android.R.layout.simple_spinner_item, userGymTiming);
        adapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerGymTiming.setAdapter(adapter6);

        String[] userSameGender = getResources().getStringArray(R.array.same_gender);
        ArrayAdapter adapter7 = new ArrayAdapter(this,android.R.layout.simple_spinner_item, userSameGender);
        adapter7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSameGender.setAdapter(adapter7);

        String[] userInterestPT = getResources().getStringArray(R.array.PT_interest);
        ArrayAdapter adapter8 = new ArrayAdapter(this,android.R.layout.simple_spinner_item, userInterestPT);
        adapter8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerInterestPT.setAdapter(adapter8);

        String[] userGymSession = getResources().getStringArray(R.array.gym_session);
        ArrayAdapter adapter9 = new ArrayAdapter(this,android.R.layout.simple_spinner_item, userGymSession);
        adapter9.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerGymSession.setAdapter(adapter9);

        String[] userEquipmentFamiliar = getResources().getStringArray(R.array.equipment_familiar);
        ArrayAdapter adapter10 = new ArrayAdapter(this,android.R.layout.simple_spinner_item, userEquipmentFamiliar);
        adapter10.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerEquipmentFamiliar.setAdapter(adapter10);

        String[] userHadWorkoutPartner = getResources().getStringArray(R.array.had_partner);
        ArrayAdapter adapter11 = new ArrayAdapter(this,android.R.layout.simple_spinner_item, userHadWorkoutPartner);
        adapter11.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerHadWorkoutPartner.setAdapter(adapter11);

        String[] userRate = getResources().getStringArray(R.array.rates);
        ArrayAdapter adapter12 = new ArrayAdapter(this,android.R.layout.simple_spinner_item, userRate);
        adapter12.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerRate.setAdapter(adapter12);



        button_Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String age = spinnerAge.getSelectedItem().toString();
                String gender = spinnerGender.getSelectedItem().toString();
                String fitnessGoal = spinnerFitnessGoal.getSelectedItem().toString();
                String gymFreq = spinnerGymFreq.getSelectedItem().toString();
                String gymProgramInterest = spinnerGymProgramInterest.getSelectedItem().toString();
                String gymTiming = spinnerGymTiming.getSelectedItem().toString();
                String sameGender = spinnerSameGender.getSelectedItem().toString();
                String interestPT = spinnerInterestPT.getSelectedItem().toString();
                String gymSession = spinnerGymSession.getSelectedItem().toString();
                String equipmentFamiliar = spinnerEquipmentFamiliar.getSelectedItem().toString();
                String hardWorkoutPartner = spinnerHadWorkoutPartner.getSelectedItem().toString();
                String rate = spinnerRate.getSelectedItem().toString();
                String userName = usernameinput.getText().toString();
                String identifier = getIntent().getExtras().get("CLASS").toString();
                String email = getIntent().getExtras().get("EMAIL").toString();
                String name = getIntent().getExtras().get("NAME").toString();

                User user = new User(email, name, age, gender, fitnessGoal, gymFreq, gymProgramInterest, gymTiming, sameGender, interestPT, gymSession,
                        equipmentFamiliar, hardWorkoutPartner, rate, identifier, userName);
                Map<String, User> userMap = new HashMap<>();


                userMap.put(fAuth.getCurrentUser().getUid(), user);
                db.collection("Data").add(userMap).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(QuestionnaireActivity.this, "User Added", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(QuestionnaireActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
                        Log.d("Test", e.toString());
                    }
                });
                Intent nextT = new Intent(QuestionnaireActivity.this, ProfileActivity.class);
                startActivity(nextT);
            }
        });


    }
}