package com.hridoykrisna.email;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.FileUtils;
import android.provider.DocumentsContract;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private String filename;
    private static final int REQUEST_CHOOSER = 1;

    //
    EditText fromEt, toEt, subjectEt, messageEt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#FF1717"));

        getSupportActionBar().setBackgroundDrawable(colorDrawable);

        fromEt = findViewById(R.id.fromEtId);
        toEt = findViewById(R.id.toEtId);
        subjectEt = findViewById(R.id.subjectETId);
        messageEt = findViewById(R.id.messageEtId);

        fromEt.setText(Utils.EMAIL);
        toEt.requestFocus();

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
                Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                intent.setType("application/pdf");
                startActivityForResult(intent, REQUEST_CHOOSER);
                return true;
            case R.id.sendId:
                Toast.makeText(getApplicationContext(), "Send Selected", Toast.LENGTH_SHORT).show();
                sentEmail();
                return true;
            case R.id.settingId:
                Toast.makeText(getApplicationContext(), "Item 3 Selected", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void sentEmail() {
        String to, subject, message;
        to = toEt.getText().toString();
        subject = subjectEt.getText().toString();
        message = messageEt.getText().toString();

        if (to.isEmpty()) {
            toEt.setError("Please Enter To address");
            return;
        }
        if (subject.isEmpty()) {
            toEt.setError("Please Enter To address");
            return;
        }
        if (message.isEmpty()) {
            toEt.setError("Please Enter To address");
            return;
        }

        JavaMailAPI javaMailAPI = new JavaMailAPI(this,to,subject,message);

        javaMailAPI.execute();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQUEST_CHOOSER:
                if (resultCode == RESULT_OK) {
                    String FilePath = data.getData().getPath();
                    Toast.makeText(getApplicationContext(), "File: "+FilePath.toString(), Toast.LENGTH_LONG).show();
                }
                break;
        }
    }
}
