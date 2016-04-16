package com.headfracturestudios.golfscorecard;

import android.app.ListActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends ListActivity {


//    private static final String KEY_HOLE_NUMBER = "KEY_HOLE_NUMBER";
//    private static final String KEY_SCORE = "KEY_SCORE";
    private static final String PREFS_FILE = "com.headfracturestudios.goldscorecard.preferences";
    private static final String KEY_STROKECOUNT = "KEY_STROKECOUNT";
    private ListView mListView;
    private Hole[] mHoles = new Hole[18];
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;
    private HoleAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSharedPreferences = getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();

        Toolbar toolbar = (Toolbar) findViewById(R.id.drop_menu);
        //setSupportActionBar(toolbar);
        int strokes = 0;
        mListView = (ListView) findViewById(R.id.drop_menu);
        for (int i = 0; i < mHoles.length; i++) {
            strokes = mSharedPreferences.getInt(KEY_STROKECOUNT + i, 0);
            mHoles[i] = new Hole(i+1, strokes);



        }
        mAdapter = new HoleAdapter(this, mHoles);
        setListAdapter(mAdapter);
//        mListView.setAdapter(mAdapter);
//        mListView.setEmptyView(null);
        //setActionBar(toolbar);

    }

    @Override
    protected void onPause() {
        super.onPause();

        for (int i = 0; i<mHoles.length; i++){

            mEditor.putInt(KEY_STROKECOUNT + i, mHoles[i].getScore());
        }
        mEditor.apply();
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu. menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();



        //noinspection SimplifiableIfStatement
        if (id == R.id.drop_menu) {
            mEditor.clear();
            mEditor.apply();

            for (Hole hole: mHoles){
                hole.setScore(0);
            }

            mAdapter.notifyDataSetChanged();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
