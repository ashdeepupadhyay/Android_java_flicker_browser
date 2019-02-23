package com.android.ashdeep.flickerbrowser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.ashdeep.flickerbrowser.ui.main.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow();
        }
        //GetRawData theRawData=new GetRawData("https://api.flickr.com/services/feeds/photos_public.gne?tags=android,lollipop&format=json&nojsoncallback=1");
        //theRawData.execute();
        GetFlickerJsonData jsonData=new GetFlickerJsonData("android,lollipop",true);
        jsonData.execute();
    }
}
