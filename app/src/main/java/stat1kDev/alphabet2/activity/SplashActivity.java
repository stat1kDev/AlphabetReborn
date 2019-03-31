package stat1kDev.alphabet2.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import stat1kDev.alphabet2.R;
import stat1kDev.alphabet2.utilities.ActivityUtilities;

public class SplashActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imageView;
    private Animation animation;
    private ProgressBar progressBar;
    private ConstraintLayout layout;
    private Button privacy;

    private static final int SPLASH_DURATION = 2500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        progressBar = findViewById(R.id.progressBar);
        layout = findViewById(R.id.splashLayout);
        imageView = findViewById(R.id.ivSplashIcon);
        animation = AnimationUtils.loadAnimation(getBaseContext(), R.anim.rotate);

        privacy = findViewById(R.id.privacy);
        privacy.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()) {
            case R.id.privacy:
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.google.com/document/d/1fsoU0HMnTSrlA2sCGvxPmbhQmi2W0arx4uHfpLPntbo/edit"));
                startActivity(browserIntent);
                break;
        }
    }

    private void initFunctionality() {
        layout.postDelayed(new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(View.GONE);
                imageView.startAnimation(animation);
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        ActivityUtilities.getInstance().invokeNewActivity(SplashActivity.this, MainActivity.class, true);

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        }, SPLASH_DURATION);
    }

    @Override
    protected void onResume() {
        super.onResume();
        initFunctionality();
    }
}


