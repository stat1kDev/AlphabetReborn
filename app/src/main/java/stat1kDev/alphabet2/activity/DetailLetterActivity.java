package stat1kDev.alphabet2.activity;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import com.google.android.gms.ads.AdView;

import java.io.IOException;

import stat1kDev.alphabet2.R;
import stat1kDev.alphabet2.utilities.ActivityUtilities;
import stat1kDev.alphabet2.utilities.AdsUtilities;

public class DetailLetterActivity extends AppCompatActivity {

    private Button bLetterImage;

    private SoundPool mSoundPool;
    private AssetManager assets;

    private int idLatter;
    private int mButton;
    private String soundName;
    private Context mContext;
    private Activity mActivity;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_letter);

        initToolbar(true);
        enableUpButton();

        bLetterImage = findViewById(R.id.b_letterImage);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            idLatter = bundle.getInt("drawableId");
            bLetterImage.setBackgroundResource(idLatter);

            soundName = bundle.getString("soundName");
        }

        mSoundPool = new SoundPool.Builder().setMaxStreams(10).build();
        assets = getAssets();

        mButton = loadSound(soundName);
        bLetterImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playSound(mButton);
            }
        });

        mActivity = this;
        mContext = getApplicationContext();

        AdsUtilities.getInstance(mContext).showFullScreenAd();
        AdsUtilities.getInstance(mContext).showBannerAd((AdView) findViewById(R.id.adsView));

    }

    protected void playSound(int sound) {
        if (sound > 0)
            mSoundPool.play(sound, 1, 1, 1, 0, 1);

    }

    private int loadSound(String fileName) {
        AssetFileDescriptor afd;
        try {
            afd = assets.openFd(fileName);
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Couldn't load file '" + fileName + "'", Toast.LENGTH_SHORT).show();
            return -1;
        }
        return mSoundPool.load(afd, 1);
    }

    public void initToolbar(boolean isTitleEnabled) {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(isTitleEnabled);
    }

    public void enableUpButton() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.datail_letter_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.drawing:
                ActivityUtilities.getInstance().invokeNewActivity(this, DrawingActivity.class, true);
                return true;
            case android.R.id.home:
                ActivityUtilities.getInstance().invokeNewActivity(this, MainActivity.class, true);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
