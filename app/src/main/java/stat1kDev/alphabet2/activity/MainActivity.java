package stat1kDev.alphabet2.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import com.google.android.gms.ads.AdView;

import stat1kDev.alphabet2.R;
import stat1kDev.alphabet2.utilities.ActivityUtilities;
import stat1kDev.alphabet2.utilities.AdsUtilities;

public class MainActivity extends Activity implements View.OnClickListener{

    Button  btn1,  btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11, btn12,
            btn13, btn14, btn15, btn16, btn17, btn18, btn19, btn20, btn21, btn22, btn23,
            btn24, btn25, btn26, btn27, btn28, btn29, btn30, btn31, btn32, btn33;

    private Context mContext;
    private Activity mActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initControl();

        mActivity = this;
        mContext = getApplicationContext();

        AdsUtilities.getInstance(mContext).showFullScreenAd();
        AdsUtilities.getInstance(mContext).showBannerAd((AdView) findViewById(R.id.adsView));

    }

    private void initControl() {
        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);
        btn5 = findViewById(R.id.button5);
        btn6 = findViewById(R.id.button6);
        btn7 = findViewById(R.id.button7);
        btn8 = findViewById(R.id.button8);
        btn9 = findViewById(R.id.button9);
        btn10 = findViewById(R.id.button10);
        btn11 = findViewById(R.id.button11);
        btn12 = findViewById(R.id.button12);
        btn13 = findViewById(R.id.button13);
        btn14 = findViewById(R.id.button14);
        btn15 = findViewById(R.id.button15);
        btn16 = findViewById(R.id.button16);
        btn17 = findViewById(R.id.button17);
        btn18 = findViewById(R.id.button18);
        btn19 = findViewById(R.id.button19);
        btn20 = findViewById(R.id.button20);
        btn21 = findViewById(R.id.button21);
        btn22 = findViewById(R.id.button22);
        btn23 = findViewById(R.id.button23);
        btn24 = findViewById(R.id.button24);
        btn25 = findViewById(R.id.button25);
        btn26 = findViewById(R.id.button26);
        btn27 = findViewById(R.id.button27);
        btn28 = findViewById(R.id.button28);
        btn29 = findViewById(R.id.button29);
        btn30 = findViewById(R.id.button30);
        btn31 = findViewById(R.id.button31);
        btn32 = findViewById(R.id.button32);
        btn33 = findViewById(R.id.button33);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn10.setOnClickListener(this);
        btn11.setOnClickListener(this);
        btn12.setOnClickListener(this);
        btn13.setOnClickListener(this);
        btn14.setOnClickListener(this);
        btn15.setOnClickListener(this);
        btn16.setOnClickListener(this);
        btn17.setOnClickListener(this);
        btn18.setOnClickListener(this);
        btn19.setOnClickListener(this);
        btn20.setOnClickListener(this);
        btn21.setOnClickListener(this);
        btn22.setOnClickListener(this);
        btn23.setOnClickListener(this);
        btn24.setOnClickListener(this);
        btn25.setOnClickListener(this);
        btn26.setOnClickListener(this);
        btn27.setOnClickListener(this);
        btn28.setOnClickListener(this);
        btn29.setOnClickListener(this);
        btn30.setOnClickListener(this);
        btn31.setOnClickListener(this);
        btn32.setOnClickListener(this);
        btn33.setOnClickListener(this);
    }

    public void doIntent(int id, String soundName) {
        Intent intent = new Intent(this, DetailLetterActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("drawableId", id);
        bundle.putString("soundName", soundName);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public void onClick(View v){

        switch (v.getId()) {
            case R.id.button1:
                doIntent(R.drawable.b01, "f01.ogg");
                break;

            case R.id.button2:
                doIntent(R.drawable.b02, "f02.ogg");
                break;

            case R.id.button3:
                doIntent(R.drawable.b03, "f03.ogg");
                break;

            case R.id.button4:
                doIntent(R.drawable.b04, "f04.ogg");
                break;

            case R.id.button5:
                doIntent(R.drawable.b05, "f05.ogg");
                break;

            case R.id.button6:
                doIntent(R.drawable.b06, "f06.ogg");
                break;

            case R.id.button7:
                doIntent(R.drawable.b07, "f07.ogg");
                break;

            case R.id.button8:
                doIntent(R.drawable.b08, "f08.ogg");
                break;

            case R.id.button9:
                doIntent(R.drawable.b09, "f09.ogg");
                break;

            case R.id.button10:
                doIntent(R.drawable.b10, "f10.ogg");
                break;

            case R.id.button11:
                doIntent(R.drawable.b11, "f11.ogg");
                break;

            case R.id.button12:
                doIntent(R.drawable.b12, "f12.ogg");
                break;

            case R.id.button13:
                doIntent(R.drawable.b13, "f13.ogg");
                break;

            case R.id.button14:
                doIntent(R.drawable.b14, "f14.ogg");
                break;

            case R.id.button15:
                doIntent(R.drawable.b15, "f15.ogg");
                break;

            case R.id.button16:
                doIntent(R.drawable.b16, "f16.ogg");
                break;

            case R.id.button17:
                doIntent(R.drawable.b17, "f17.ogg");
                break;
            case R.id.button18:
                doIntent(R.drawable.b18, "f18.ogg");
                break;

            case R.id.button19:
                doIntent(R.drawable.b19, "f19.ogg");
                break;

            case R.id.button20:
                doIntent(R.drawable.b20, "f20.ogg");
                break;

            case R.id.button21:
                doIntent(R.drawable.b21, "f21.ogg");
                break;

            case R.id.button22:
                doIntent(R.drawable.b22, "f22.ogg");
                break;

            case R.id.button23:
                doIntent(R.drawable.b23, "f23.ogg");
                break;

            case R.id.button24:
                doIntent(R.drawable.b24, "f24.ogg");
                break;

            case R.id.button25:
                doIntent(R.drawable.b25, "f25.ogg");
                break;

            case R.id.button26:
                doIntent(R.drawable.b26, "f26.ogg");
                break;

            case R.id.button27:
                doIntent(R.drawable.b27, "f27.ogg");
                break;

            case R.id.button28:
                doIntent(R.drawable.b28, "f28.ogg");
                break;

            case R.id.button29:
                doIntent(R.drawable.b29, "f29.ogg");
                break;

            case R.id.button30:
                doIntent(R.drawable.b30, "f30.ogg");
                break;

            case R.id.button31:
                doIntent(R.drawable.b31, "f31.ogg");
                break;

            case R.id.button32:
                doIntent(R.drawable.b32, "f32.ogg");
                break;

            case R.id.button33:
                doIntent(R.drawable.b33, "f33.ogg");
                break;
        }
    }


    @Override
    public void onBackPressed() {
        ActivityUtilities.tapPromtToExit(this);
    }

    @Override
    public void onResume() {
        AdsUtilities.getInstance(mContext).loadFullScreenAd(mActivity);

        super.onResume();
    }
}
