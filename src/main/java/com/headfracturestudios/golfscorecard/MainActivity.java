package com.headfracturestudios.golfscorecard;

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

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {



//    private TextView mHoleNumber;
//    private TextView mScore;
//    private Button mSubButton;
//    private Button mAddButton;
    private ListView mListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Hole[] mHoles = new Hole[18];

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        mHoleNumber = (TextView) findViewById(R.id.holeNumberTextView);
//        mScore = (TextView) findViewById(R.id.scoreTextView);
//        mSubButton = (Button) findViewById(R.id.subtractButton);
//        mAddButton = (Button) findViewById(R.id.addButton);
        mListView = (ListView) findViewById(R.id.holesListView);
        for(int i = 0; i < mHoles.length ; i++){
            mHoles[i] = new Hole();
            mHoles[i].setHoleNumber(i + 1);
            mHoles[i].setScore(0);
        }
        HoleAdapter adapter = new HoleAdapter(this, mHoles);

        mListView.setAdapter(adapter);
        mListView.setEmptyView(null);






    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
