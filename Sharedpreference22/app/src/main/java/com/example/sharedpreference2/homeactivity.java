package com.example.sharedpreference2;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class homeactivity extends AppCompatActivity {
    TextView textView_fullname;
    TextView textView_email;
    Button button_logout;
    SharedPreferences sharedPreferences;
    private static final String Shared_pref_name = "mypref";
    private static final String keyname = "name";
    private static final String keyemail = "email";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homeactivity);
        textView_email =textView_email.findViewById(R.id.textview_email);
        textView_fullname =textView_fullname.findViewById(R.id.textview_fullname);
        button_logout = button_logout.findViewById(R.id.button_logout);
        sharedPreferences =getSharedPreferences(Shared_pref_name,MODE_PRIVATE);
        String name =sharedPreferences.getString(keyname,null);
        String email =sharedPreferences.getString(keyemail,null);
        if (name !=null || email !=null){
            textView_email.setText(name);
            textView_fullname.setText(name);
            button_logout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SharedPreferences.Editor editor =sharedPreferences.edit();
                    editor.apply();
                    editor.commit();
                    Toast.makeText(v.getContext(),name,Toast.LENGTH_SHORT).show();
                }
            });
        }


    }
}