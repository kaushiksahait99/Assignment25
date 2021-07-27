package com.example.myappnew;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

public class welcome_Activity extends TabActivity {
    TabHost tabhost;
    TabHost.TabSpec tabSpec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        tabhost=findViewById(android.R.id.tabhost);

        tabSpec=tabhost.newTabSpec("Tab 1");
                tabSpec.setContent(new Intent(welcome_Activity.this,MainActivity.class));
                tabSpec.setIndicator("Users");
                tabhost.addTab(tabSpec);


        tabSpec=tabhost.newTabSpec("Tab 2");
        tabSpec.setContent(new Intent(welcome_Activity.this,MainActivity2.class));
        tabSpec.setIndicator("Favourites");
        tabhost.addTab(tabSpec);
    }
}