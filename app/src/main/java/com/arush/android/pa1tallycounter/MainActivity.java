package com.arush.android.pa1tallycounter;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int count;
    TextView textView;
    // When True counts up, else counts down
    boolean counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Toast.makeText(this, "Please select a mode.", Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            String val = String.valueOf(counter);
            Log.i("Check Counter:", val);
            if (counter) {
                count++;
            }
            else {
                count--;
            }
            textView.setText("Count = " + count);
        }
        return super.onTouchEvent(event);
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

        switch (id) {
            case R.id.action_about:
                Toast.makeText(this, "This App is made by Arush Gupta", Toast.LENGTH_LONG).show();
                return true;
            case R.id.action_clear:
                count = 0;
                textView.setText("Count = " + count);
                return true;
            case R.id.action_countUp:
                counter = true;
                return true;
            case R.id.action_countDown:
                counter = false;
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
