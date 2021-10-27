package com.example.newsapp.Features;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.newsapp.R;

public class NotificationActivity extends AppCompatActivity {

    Button btnGetNotification;
    EditText editTextNotifyName;
    TextView textViewNotifyName;
    NotificationManager nm;
    public final String Notification_ID = "1";
    public final String Notification_Name ="Example";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        Intent intent2 = getIntent();

        btnGetNotification = findViewById(R.id.btnGetNotification);
        editTextNotifyName = findViewById(R.id.editTextNotifyName);
        textViewNotifyName = findViewById(R.id.textViewNotifyName);

        String part2 = "We're glad to have you on our app, hope you like it ...";

        nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O)
        {
            createNotificationChannel();
        }

        btnGetNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder n = new NotificationCompat.Builder(getApplicationContext(), Notification_ID);
                n.setContentTitle(editTextNotifyName.getText().toString());
                n.setContentText(part2);
                n.setSmallIcon(R.drawable.ic_person);
                nm.notify(1,n.build());
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void createNotificationChannel() {
        NotificationChannel nc = new NotificationChannel(Notification_ID, Notification_Name, NotificationManager.IMPORTANCE_DEFAULT);
        nc.enableVibration(true);
        nm.createNotificationChannel(nc);
    }
}