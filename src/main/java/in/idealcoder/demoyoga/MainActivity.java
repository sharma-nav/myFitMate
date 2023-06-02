package in.idealcoder.demoyoga;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.formats.MediaView;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAdView;

public class MainActivity extends AppCompatActivity {



    Button button1,button2;
    private UnifiedNativeAd nativeAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MobileAds.initialize(this, getString(R.string.ADMOB_ADS_UNIT_ID));
        refreshAd();


        Toolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);


        button1 = findViewById(R.id.startyoga1);
        button2 = findViewById(R.id.startyoga2);



        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,SecondActivity2.class);
                startActivity(intent);

            }
        });
    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.id_privacy){

            Intent intent  = new Intent(Intent.ACTION_VIEW, Uri.parse("https://iotexpert1.blogspot.com/2020/10/privacy-policy-of-six-pack-abs-workout.html"));
            startActivity(intent);

            return true;
        }
        if (id == R.id.id_terms){

            Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://iotexpert1.blogspot.com/2020/10/privacy-policy-of-six-pack-abs-workout.html"));
            startActivity(intent);


            return true;
        }
        if (id == R.id.rate){

            try {
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("market://details?id=" + getPackageName())));
            } catch(Exception ex) {
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://play.google.com/store/apps/details?id=" + getPackageName())));

            }


            return true;
        }
        if (id == R.id.more){


            Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://play.google.com/store/apps/developer?id=reddit+Inc."));
            startActivity(intent);

            return true;
        }
        if (id == R.id.share){

            Intent myIntent = new Intent(Intent.ACTION_SEND);
            myIntent.setType("text/plain");
            String sharebody = " This is the best app for Yoga \n By This app you can easily create your flexible body \n This is the free App hurry Now\n" + "https://play.google.com/store/apps/details?id=in.idealcoder.demoyoga&hl=en";
            String sharesub = "Yoga app";
            myIntent.putExtra(Intent.EXTRA_SUBJECT,sharesub);
            myIntent.putExtra(Intent.EXTRA_TEXT,sharebody);
            startActivity(Intent.createChooser(myIntent,"Share using"));
            return true;
        }


        return true;
    }

    public void beforeage18(View view) {

        Intent intent = new Intent(MainActivity.this,SecondActivity.class);
        startActivity(intent);



    }

    public void aftereage18(View view) {

        Intent intent = new Intent(MainActivity.this,SecondActivity2.class);
        startActivity(intent);
    }

    public void food(View view) {


        Intent intent = new Intent(MainActivity.this,FoodActivity.class);
        startActivity(intent);
    }



    private void populateUnifiedNativeAdView(UnifiedNativeAd nativeAd, UnifiedNativeAdView adView) {
        adView.setMediaView((MediaView) adView.findViewById(R.id.ad_media));
        adView.setHeadlineView(adView.findViewById(R.id.ad_headline));
        adView.setBodyView(adView.findViewById(R.id.ad_body));
        adView.setCallToActionView(adView.findViewById(R.id.ad_call_to_action));
        adView.setIconView(adView.findViewById(R.id.ad_app_icon));
        adView.setPriceView(adView.findViewById(R.id.ad_price));
        adView.setAdvertiserView(adView.findViewById(R.id.ad_advertiser));
        adView.setStoreView(adView.findViewById(R.id.ad_store));
        adView.setStarRatingView(adView.findViewById(R.id.ad_stars));
        ((TextView)adView.getHeadlineView()).setText(nativeAd.getHeadline());
        adView.getMediaView().setMediaContent(nativeAd.getMediaContent());
        if (nativeAd.getBody() == null) {
            adView.getBodyView().setVisibility(View.INVISIBLE);
        } else {
            adView.getBodyView().setVisibility(View.VISIBLE);
            ((TextView) adView.getBodyView()).setText(nativeAd.getBody());
        }
        if (nativeAd.getCallToAction() == null) {
            adView.getCallToActionView().setVisibility(View.INVISIBLE);
        } else {
            adView.getCallToActionView().setVisibility(View.VISIBLE);
            ((Button) adView.getCallToActionView()).setText(nativeAd.getCallToAction());
        }
        if (nativeAd.getIcon() == null) {
            adView.getIconView().setVisibility(View.GONE);
        } else {
            ((ImageView) adView.getIconView()).setImageDrawable(nativeAd.getIcon().getDrawable());
            adView.getIconView().setVisibility(View.VISIBLE);
        }
        if (nativeAd.getPrice() == null) {
            adView.getPriceView().setVisibility(View.INVISIBLE);
        } else {
            adView.getPriceView().setVisibility(View.VISIBLE);
            ((TextView) adView.getPriceView()).setText(nativeAd.getPrice());
        }
        if (nativeAd.getStore() == null) {
            adView.getStoreView().setVisibility(View.INVISIBLE);
        } else {
            adView.getStoreView().setVisibility(View.VISIBLE);
            ((TextView) adView.getStoreView()).setText(nativeAd.getStore());
        }
        if (nativeAd.getStarRating() == null) {
            adView.getStarRatingView().setVisibility(View.INVISIBLE);
        } else {
            ((RatingBar) adView.getStarRatingView()).setRating(nativeAd.getStarRating().floatValue());
            adView.getStarRatingView().setVisibility(View.VISIBLE);
        }
        if (nativeAd.getAdvertiser() == null) {
            adView.getAdvertiserView().setVisibility(View.INVISIBLE);
        } else {
            ((TextView) adView.getAdvertiserView()).setText(nativeAd.getAdvertiser());
            adView.getAdvertiserView().setVisibility(View.VISIBLE);
        }
        adView.setNativeAd(nativeAd);
    }
    private void refreshAd() {
        AdLoader.Builder builder = new AdLoader.Builder(this, getString(R.string.ADMOB_ADS_UNIT_ID));
        builder.forUnifiedNativeAd(new UnifiedNativeAd.OnUnifiedNativeAdLoadedListener() {
            @Override
            public void onUnifiedNativeAdLoaded(UnifiedNativeAd unifiedNativeAd) {
                if (nativeAd != null) {
                    nativeAd.destroy();
                }
                nativeAd = unifiedNativeAd;
                FrameLayout frameLayout = findViewById(R.id.fl_adplaceholder);
                UnifiedNativeAdView adView = (UnifiedNativeAdView) getLayoutInflater().inflate(R.layout.ad_unified, null);
                populateUnifiedNativeAdView(unifiedNativeAd, adView);
                frameLayout.removeAllViews();
                frameLayout.addView(adView);
            }
        });
        NativeAdOptions adOptions = new NativeAdOptions.Builder().build();
        builder.withNativeAdOptions(adOptions);
        AdLoader adLoader = builder.withAdListener (new AdListener(){
            @Override
            public void onAdFailedToLoad(int i) {
            }
        }).build();
        adLoader.loadAd(new AdRequest.Builder().build());
    }



}