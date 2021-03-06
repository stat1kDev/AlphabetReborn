package stat1kDev.alphabet2.utilities;

import android.app.Activity;
import android.content.Context;
import android.view.View;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import stat1kDev.alphabet2.R;

public class AdsUtilities {

    private static AdsUtilities mAdsUtilities;

    private InterstitialAd mInterstitialAd;

    private int interstitialCount = -1;


    private AdsUtilities(Context context) {
        MobileAds.initialize(context, context.getResources().getString(R.string.app_ad_id));
    }

    public static AdsUtilities getInstance(Context context) {
        if (mAdsUtilities == null) {
            mAdsUtilities = new AdsUtilities(context);
        }
        return mAdsUtilities;
    }

    public void showBannerAd(final AdView mAdView) {

            AdRequest adRequest = new AdRequest.Builder().tagForChildDirectedTreatment(true).build();
            mAdView.loadAd(adRequest);

            mAdView.setAdListener(new AdListener() {
                @Override
                public void onAdLoaded() {
                    super.onAdLoaded();
                    mAdView.setVisibility(View.VISIBLE);
                }

                @Override
                public void onAdFailedToLoad(int errorCode) {
                    super.onAdFailedToLoad(errorCode);
                    mAdView.setVisibility(View.GONE);
                }
            });

    }


    public void loadFullScreenAd(Activity activity) {

        if (interstitialCount == (3)) {
            mInterstitialAd = new InterstitialAd(activity);
            mInterstitialAd.setAdUnitId(activity.getResources().getString(R.string.interstitial_ad_unit_id));
            AdRequest adRequestInter = new AdRequest.Builder().tagForChildDirectedTreatment(true).build();
            mInterstitialAd.setAdListener(new AdListener() {
                @Override
                public void onAdLoaded() {
                    mInterstitialAd.show();
                }
            });
            mInterstitialAd.loadAd(adRequestInter);

            interstitialCount = 0;
        } else {
            interstitialCount++;
        }

    }


    public boolean showFullScreenAd() {
            if (mInterstitialAd != null) {
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                    return true;
                }
            }

        return false;
    }
}