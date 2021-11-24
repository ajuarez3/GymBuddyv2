package com.example.gymbudd;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class ProfileActivity extends AppCompatActivity {
    private TextView genderTextView, nameTextView, ageTextView;
    private TextView emailTextView, keywordsTextView;
    private ImageView userImageView, emailImageView;
    private ImageView imageViewSettings, videoImageView;

    private static int RESULT_LOAD_IMAGE = 1;
    FirebaseStorage storage = FirebaseStorage.getInstance();
    FirebaseAuth auth = FirebaseAuth.getInstance();
    FirebaseFirestore dataStore = FirebaseFirestore.getInstance();


    private String email,password;

    TextView myTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        genderTextView = findViewById(R.id.Gender_textview);
        nameTextView = findViewById(R.id.name_textview);
        ageTextView = findViewById(R.id.age_textview);
        keywordsTextView = findViewById(R.id.keywords);
        emailTextView = findViewById(R.id.email_textview);
        userImageView = findViewById(R.id.user_imageview);
        emailImageView = findViewById(R.id.email_imageView);
        imageViewSettings = findViewById(R.id.imageViewSettings);
        videoImageView = findViewById(R.id.imageViewVideo);

        imageViewSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_settings = new Intent(ProfileActivity.this, SettingActivity.class);
                startActivity(intent_settings);
            }
        });
        videoImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_video = new Intent(ProfileActivity.this, Workouts.class);
                startActivity(intent_video);
            }
        });

        setImageIfExist(userImageView);
        ActivityResultLauncher<Intent> intentLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                Uri selectedImage = result.getData().getData();
                String[] filePathColumn = { MediaStore.Images.Media.DATA };
                Cursor cursor = getContentResolver().query(selectedImage,
                        filePathColumn, null, null, null);
                cursor.moveToFirst();

                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                String picturePath = cursor.getString(columnIndex);
                cursor.close();

                ImageView imageView = (ImageView) findViewById(R.id.user_imageview);
                try {
                    Bitmap map = BitmapFactory.decodeStream(getContentResolver().openInputStream(selectedImage));
                    userImageView.setImageBitmap(map);
                    uploadToFirebase(map);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                //imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));
            }
        });
        populateData();

        userImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                intentLauncher.launch(i);
            }
        });

    }

    public void populateData() {

        dataStore.collection("Data").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (DocumentSnapshot s : task.getResult().getDocuments()) {
                        Map map = s.getData();
                        if (map.containsKey(auth.getCurrentUser().getUid())) {
                            HashMap<String, String> userInfo = (HashMap) map.get(auth.getCurrentUser().getUid());
                            Toast.makeText(ProfileActivity.this, "FOUND CURRENT USER", Toast.LENGTH_SHORT).show();
                            genderTextView.setText(userInfo.get("gender"));
                            ageTextView.setText(userInfo.get("age"));
                            nameTextView.setText(userInfo.get("name"));
                            emailTextView.setText(userInfo.get("email"));
                            String keywords = "Keywords\nFitness Goal: " + userInfo.get("fitnessGoal")
                                    +  "\nGym Timing: " + userInfo.get("gymTiming")
                                    + "\nTrainer/Student: " + userInfo.get("identifier")
                                    + "\nGym Experience: " + userInfo.get("rate");
                            keywordsTextView.setText(keywords);
                        }
                    }

                } else {

                }
            }
        });
    }

    private void setImageIfExist(ImageView userImageView) {
        StorageReference storageReference = storage.getReference();
        String str = "images/" + auth.getCurrentUser().getUid() + ".jpg";
        StorageReference personRef = storageReference.child(str);

        final long ONE_MEGA = 1024 * 1024 * 5;

        personRef.getBytes(ONE_MEGA).addOnSuccessListener(bytes -> {
            Bitmap bmp = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
            userImageView.setImageBitmap(bmp);
        }).addOnFailureListener(exception -> userImageView.setImageResource(R.drawable.person_view));
    }

    private void uploadToFirebase(Bitmap map) {
        StorageReference storageReference = storage.getReference();
        String str = "/images/" + auth.getCurrentUser().getUid() + ".jpg";
        StorageReference personRef = storageReference.child(str);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        map.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] data = baos.toByteArray();

        UploadTask uploadTask = personRef.putBytes(data);
        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle unsuccessful uploads
            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                // taskSnapshot.getMetadata() contains file metadata such as size, content-type, and download URL.
                //Uri downloadUrl = taskSnapshot();
            }
        });
    }
}