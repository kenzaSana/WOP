package com.example.kenzack.wop;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TabHost;

import com.exemle.fragments.Fragment1;
import com.exemle.fragments.fragment2;
import com.exemle.fragments.fragment3;
import com.exemple.adapters.MyfragmentAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ActionBarActivity implements ViewPager.OnPageChangeListener , TabHost.OnTabChangeListener {

    ViewPager viewPager;
    TabHost tabhost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViewPager();
        initTabHost();
    }

    private void initTabHost() {
        tabhost=(TabHost)findViewById(R.id.tabHost);
        tabhost.setup();
        String[] tabNames={"My World","My friend's World","import pictures","the App World","Tab5","Tab6"};
        for(int i=0;i<tabNames.length;i++){
            TabHost.TabSpec tapSec;
            tapSec=tabhost.newTabSpec(tabNames[i]);
            tapSec.setIndicator(tabNames[i]);
            tapSec.setContent(new FakeContent(getApplicationContext()));
            tabhost.addTab(tapSec);
        }
        tabhost.setOnTabChangedListener(this);

    }

    @Override
    public void onTabChanged(String tabId) {
        int selecteditem=tabhost.getCurrentTab();
        viewPager.setCurrentItem(selecteditem);

    }

    public class FakeContent implements TabHost.TabContentFactory {
        Context context;
        public FakeContent(Context mcontext){
            context=mcontext;
        }
        @Override
        public View createTabContent(String tag) {
            View fakeView= new View(context);
            fakeView.setMinimumHeight(0);
            fakeView.setMinimumWidth(0);
            return fakeView;
        }
    }

    private void initViewPager() {
        viewPager=(ViewPager)findViewById(R.id.view_pager);
        List<Fragment> listFragments=new ArrayList<Fragment>();
        listFragments.add(new Fragment1());
        listFragments.add(new fragment2());
        listFragments.add(new fragment3());

        MyfragmentAdapter myfragmentAdapter=new MyfragmentAdapter(getSupportFragmentManager(),listFragments);
        viewPager.setAdapter(myfragmentAdapter);
        viewPager.setOnPageChangeListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int selecteditem) {
        tabhost.setCurrentTab(selecteditem);

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}

