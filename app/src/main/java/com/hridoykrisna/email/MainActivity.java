package com.hridoykrisna.email;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#FF1717"));

        getSupportActionBar().setBackgroundDrawable(colorDrawable);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.attachmentId:
                Toast.makeText(getApplicationContext(), "Attachment Selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.sendId:
                Toast.makeText(getApplicationContext(), "Send Selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.settingId:
                Toast.makeText(getApplicationContext(), "Item 3 Selected", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
