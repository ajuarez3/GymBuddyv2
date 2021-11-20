package com.example.gymbudd;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;
import android.widget.Button;



public class MainActivity extends AppCompatActivity {
    Button click;
    VideoView videov;
    MediaController mediaC;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        click = (Button)findViewById(R.id.button);
        videov = (VideoView)findViewById(R.id.videoView);
        mediaC = new MediaController(this);

    }

    public void videoplay(View v)
    {
        String videopath = "android:resource://com.example.gymbudd/"+R.raw.stretch;
        Uri uri = Uri.parse(videopath);
        videov.setVideoURI(uri);
        videov.setMediaController(mediaC);
        mediaC.setAnchorView(videov);
        videov.start();
    }

}
