package stat1kDev.alphabet2.activity;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

import stat1kDev.alphabet2.R;
import stat1kDev.alphabet2.utilities.ActivityUtilities;

public class DetailLetterActivity extends Activity implements View.OnClickListener {

    Button bLetterImage;

    SoundPool mSoundPool;
    AssetManager assets;

    int idLatter;
    int mButton;
    String soundName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_letter);

        bLetterImage = findViewById(R.id.b_letterImage);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            idLatter = bundle.getInt("drawableId");
            bLetterImage.setBackgroundResource(idLatter);

            soundName = bundle.getString("soundName");
        }

        mSoundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
        assets = getAssets();

        mButton = loadSound(soundName);
        bLetterImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playSound(mButton);
            }
        });

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


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.backFromDetailLetter:
                ActivityUtilities.getInstance().invokeNewActivity(this, MainActivity.class, true);
                break;

            //case R.id.drawing:
                //TODO: ActivityUtilities.getInstance().invokeNewActivity(dsadsa, MainActivity.class, true);
              //  break;

        }
    }
}
