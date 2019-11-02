package com.example.raystorm;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    ViewFlipper flipper;
    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // downloadJSON("http://http://clean.raystorm.com/fuel/api/image_service.php");
        int images[] = {R.drawable.villa2 ,R.drawable.villa3, R.drawable.villa1};
        flipper = findViewById(R.id.flipper);

        for (int i = 0; i < images.length; i++){
            flipperImage(images[i]);
        }
        video();
    }

    public void flipperImage(int image){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);
        flipper.addView(imageView);
        flipper.setFlipInterval(2000);
        flipper.setAutoStart(true);
        flipper.setInAnimation(this, android.R.anim.slide_in_left);
        flipper.setOutAnimation(this, android.R.anim.fade_out);
    }

    private void video(){
        videoView = findViewById(R.id.videoView);
        String path = "android.resource://" + getPackageName() + "/" + R.raw.test;
        videoView.setVideoURI(Uri.parse(path));
        videoView.requestFocus();
        videoView.start();
        videoView.setVisibility(View.INVISIBLE);
    }
}
