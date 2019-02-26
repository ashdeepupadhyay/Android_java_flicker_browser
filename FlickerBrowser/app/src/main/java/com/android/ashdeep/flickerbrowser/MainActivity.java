package com.android.ashdeep.flickerbrowser;

import android.drm.ProcessedData;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.ashdeep.flickerbrowser.ui.main.MainFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private static final String LOG_TAG="MainActivity";
    private List<Photo> mphotosList=new ArrayList<Photo>();
    private RecyclerView mRecyclerView;
    private FlickrRecyclerViewAdapter flickrRecyclerViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        activiteToolBar();

        mRecyclerView=(RecyclerView)findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        ProcessPhotos processPhotos=new ProcessPhotos("android,lollipop",true);
        processPhotos.exexute();
       // if (savedInstanceState == null) {
        //    getSupportFragmentManager().beginTransaction()
         //           .replace(R.id.container, MainFragment.newInstance())
         //           .commitNow();
      //  }
        //GetRawData theRawData=new GetRawData("https://api.flickr.com/services/feeds/photos_public.gne?tags=android,lollipop&format=json&nojsoncallback=1");
        //theRawData.execute();

        //GetFlickerJsonData jsonData=new GetFlickerJsonData("android,lollipop",true);
        //jsonData.execute();
    }

    public class ProcessPhotos extends GetFlickerJsonData{
        public ProcessPhotos(String searchCriteria, boolean matchAll) {
            super(searchCriteria, matchAll);
        }

        public void exexute()
        {
            super.execute();
            ProcessData processData =new ProcessData();
            processData.execute();
        }

        public class ProcessData extends DownloadJsonData {
            protected void onPostExecute(String webData){
                super.onPostExecute(webData);
                flickrRecyclerViewAdapter=new FlickrRecyclerViewAdapter(MainActivity.this,getMPhotos());
                mRecyclerView.setAdapter(flickrRecyclerViewAdapter);
            }

        }
    }
}
