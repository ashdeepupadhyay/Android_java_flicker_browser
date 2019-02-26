package com.android.ashdeep.flickerbrowser;

import android.support.v7.widget.Toolbar;
import android.support.v7.app.AppCompatActivity;
public class BaseActivity extends AppCompatActivity {
    private Toolbar mToolbar;
    protected Toolbar activiteToolBar(){
        if(mToolbar==null)
        {
            mToolbar=(Toolbar)findViewById(R.id.app_bar);
            if(mToolbar!=null)
            {
                setSupportActionBar(mToolbar);
            }
        }
        return mToolbar;
    }
}
