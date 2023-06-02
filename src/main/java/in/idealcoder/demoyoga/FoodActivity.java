package in.idealcoder.demoyoga;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class FoodActivity extends AppCompatActivity {


    ListView listView;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        String[] tstory = getResources().getStringArray(R.array.title_story);
        final String[] dstory = getResources().getStringArray(R.array.details_story);


        listView = findViewById(R.id.list);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.row,R.id.rowtxt,tstory);
        listView.setAdapter(adapter);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String t = dstory[position];
                Intent intent = new Intent(FoodActivity.this,FoodDetailActivity.class);
                intent.putExtra("story",t);
                startActivity(intent);

            }
        });

    }

    public void foodgoback(View view) {

        Intent intent = new Intent(FoodActivity.this,MainActivity.class);
        startActivity(intent);
        finish();


    }

    /**
     * Called when the activity has detected the user's press of the back
     * key. The {@link #getOnBackPressedDispatcher() OnBackPressedDispatcher} will be given a
     * chance to handle the back button before the default behavior of
     * {@link Activity#onBackPressed()} is invoked.
     *
     * @see #getOnBackPressedDispatcher()
     */
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(FoodActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}