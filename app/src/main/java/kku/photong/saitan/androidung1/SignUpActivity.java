package kku.photong.saitan.androidung1;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import kku.photong.saitan.androidung1.R;

public class SignUpActivity extends AppCompatActivity {
    // Explicit
    private EditText nameEditText,phonEditText,userEditText, passwordEditText;
    private ImageView imageView;
    private Button button;
    private String nameString, phonString, userString, passString;
    private Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {// create sign Up
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        nameEditText = (EditText) findViewById(R.id.editText4);
        phonEditText = (EditText) findViewById(R.id.editText3);
        userEditText = (EditText) findViewById(R.id.editText2);
        passwordEditText = (EditText) findViewById(R.id.editText);
        imageView = (ImageView) findViewById(R.id.imageView);
        button = (Button) findViewById(R.id.button4);

        //Sign Up Controller
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Get value From Edit Text
                nameString = nameEditText.getText().toString().trim();//trim-> ตัดช่องว่างออก
                phonString = phonEditText.getText().toString().trim();
                userString = userEditText.getText().toString().trim();
                passString = passwordEditText.getText().toString().trim();

                //Check Space
                if (nameString.equals("") || phonString.equals("") || userString.equals("")||passString.equals("")){
                    //have Space
                    Log.d("12novV1","Have Space"); // debugging
                    MyAlert myAlert = new MyAlert(SignUpActivity.this, R.drawable.doremon48, "มีช่องว่าง", "กรุณากรอกให้ครบทุกช่อง");
                    myAlert.myDialog();

                }
            }
        });

        // Image Controller
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");//เอาโปรแกรมทีี่สามารถเปิดภาพได้
                startActivityForResult(Intent.createChooser(intent,"โปรดเลือกแอพดูภาพ"),0);
            }
        });

    }//Main Method

    @Override
    protected void onActivityResult(int requestCode,// รับ 0 ที่ส่งมา
                                    int resultCode, //
                                    Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (( requestCode == 0)&&(resultCode==RESULT_OK)) {

            Log.d("12novV1","Result OK");
            uri = data.getData();
            try {
                Bitmap bitmap= BitmapFactory.decodeStream(getContentResolver().openInputStream(uri));
                imageView.setImageBitmap(bitmap);
            }catch (Exception e){
                e.printStackTrace();
            }

        }//if

    }

}// Main Class
