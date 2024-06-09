package com.example.sharedpreference2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
EditText editText_name;
EditText editText_email;
Button button_save;
SharedPreferences sharedPreferences;
private static final String Shared_pref_name = "mypref";
    private static final String keyname = "name";
    private static final String keyemail = "email";
    String name = sharedPreferences.getString(keyname,null);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        editText_email =editText_email.findViewById(R.id.edittext_email);
        editText_name =editText_name.findViewById(R.id.edittext_email);
        button_save = button_save.findViewById(R.id.button_save);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = getSharedPreferences(Shared_pref_name,MODE_PRIVATE);
        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
SharedPreferences.Editor editor =sharedPreferences.edit();
editor.putString(keyemail,editText_email.getText().toString());
editor.putString(keyname,editText_name.getText().toString());
                editor.apply();
                Intent intent =new Intent();
                startActivity(intent);
            }
        });

    }
}