package com.gbegbe.app.splash;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

import com.gbegbe.app.Onboarding;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.gbegbe.app.R;
import com.gbegbe.app.app_data.HomeActivity;

public class SplashActivity extends AppCompatActivity {
    public static InterstitialAd mInterstitialAdMob;
    String f212gm;
    int f213i = 0;
    private SharedPreferences f214sp;


    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView((int) R.layout.activity_splash);
        setStoreToken(getResources().getString(R.string.app_name));
        mInterstitialAdMob = showAdmobFullAd();
        loadAdmobAd();
        goNext();
    }

    private void setStoreToken(String str) {
        SharedPreferences sharedPreferences = getSharedPreferences(getPackageName(), 0);
        this.f214sp = sharedPreferences;
        String string = sharedPreferences.getString("gm", "");
        this.f212gm = string;
        if (this.f213i == 0 && string.equals("")) {
            SharedPreferences.Editor edit = this.f214sp.edit();
            edit.putString("gm", "0");
            edit.commit();
            this.f212gm = this.f214sp.getString("gm", "");
        }

    }



    private void goNext() {
        new Handler().postDelayed(new Runnable() {
            public void run() {
                SplashActivity.this.startActivity(new Intent(SplashActivity.this, Onboarding.class));
                SplashActivity.this.finish();
            }
        }, 5000);
    }

    private InterstitialAd showAdmobFullAd() {
        InterstitialAd interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId(getString(R.string.interstitial_full_screen));
        interstitialAd.setAdListener(new AdListener() {
            public void onAdLoaded() {
            }

            public void onAdOpened() {
            }

            public void onAdClosed() {
                SplashActivity.this.loadAdmobAd();
            }
        });
        return interstitialAd;
    }


    public void loadAdmobAd() {
        mInterstitialAdMob.loadAd(new AdRequest.Builder().build());
    }

    public static void showAdmobInterstitial() {
        InterstitialAd interstitialAd = mInterstitialAdMob;
        if (interstitialAd != null && interstitialAd.isLoaded()) {
            mInterstitialAdMob.show();
        }
    }
}
