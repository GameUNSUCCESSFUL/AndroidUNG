package kku.photong.saitan.androidung1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    // Ctrl+Alt+L เรียง code

    // Explicite
    private Button signInButton, signUpButton;//ประกาศ prefix และ data type , commitment key ship+ctrl+Enter

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bind widget
        //R. จะ error เมื่อมีอักษรตัวใหญ่ใน XML
        //Sign In
        signInButton = (Button) findViewById(R.id.button2);
        signUpButton = (Button) findViewById(R.id.button);

        //Sign Up
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,SignUpActivity.class));//เคลื่อนย้าย mainActivity.this -> SignUpActivity.class
            }
        });

    } // Main Method

} // Main Class อิอิ
