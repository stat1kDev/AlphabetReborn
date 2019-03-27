package stat1kDev.alphabet2.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import stat1kDev.alphabet2.R;

public class DetailLetterActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_letter);

        imageView = findViewById(R.id.iv_letterImage);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            int idLatter = bundle.getInt("drawableId");
            imageView.setImageResource(idLatter);
        }

    }


}
