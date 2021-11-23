package com.example.videoview_ratingbar;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.VideoView;

/**
 * This Activity shows a Streaming Service that features a video and rating option.
 * The user is able to watch and control the video in the VideoView.
 * It is also possible to give a rating by using the RatingBar and the Button.
 *
 * Layout File: activity_main.xml
 * Video: https://mixkit.co/free-stock-video/waterfall-in-forest-2213/
 *
 * @author Lukas Plenk
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private VideoView videoView;
    private TextView feedback;
    private RatingBar ratingBar;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoView = findViewById(R.id.videoView);
        feedback = findViewById(R.id.text_feedback);
        ratingBar = findViewById(R.id.ratingBar);
        button = findViewById(R.id.button);

        button.setOnClickListener(this);

        // This String stores the path to the video
        String videoPath = "android.resource://" +getPackageName() +"/" +R.raw.video;

        // The VideoView uses a Uri to load the video
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);

        // The MediaController gives the option to play, pause and skip the video
        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
    }

    /**
     * This method examines the number of stars on the RatingBar and shows it in a TextView.
     * @param view is the view that was clicked on.
     */
    @Override
    public void onClick(View view) {

        feedback.setText(ratingBar.getRating() +" Stars got submitted");
    }
}