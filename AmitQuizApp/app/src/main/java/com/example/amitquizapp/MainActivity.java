package com.example.amitquizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tv1;
    EditText ed1,ed2;
    RadioGroup rg1,rg2,rg3,rg4,rg5,rg6,rg7,rg8;
    int id1,id2,id3,id4,id5,id6,id7,id8,score = 0;
    Button b1,b2;
    CheckBox cb1;
    String edit7,edit8,s1 = "HTC",s2 = "java";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = findViewById(R.id.edit1);
        ed2 = findViewById(R.id.edit2);
        rg1 = findViewById(R.id.rdgroup1);
        rg2 = findViewById(R.id.rdgroup2);
        rg3 = findViewById(R.id.rdgroup3);
        rg4 = findViewById(R.id.rdgroup4);
        rg5 = findViewById(R.id.rdgroup5);
        rg6 = findViewById(R.id.rdgroup6);
        rg7 = findViewById(R.id.rdgroup7);
        rg8 = findViewById(R.id.rdgroup8);
        b1 = findViewById(R.id.submit);
        b2 = findViewById(R.id.Reset);
        cb1 = findViewById(R.id.check1);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                id1 = rg1.getCheckedRadioButtonId();
                if(id1==R.id.radio12){
                    score+=0;
                }
                else if(id1== R.id.radio13){
                    score+=1;
                }
                else if(id1 == R.id.radio14){
                    score+=0;
                }
                else if(id1 == R.id.radio15){
                    score+=0;
                }

                id2 = rg2.getCheckedRadioButtonId();
                if(id2==R.id.radio21){
                    score+=1;
                }
                else if(id2== R.id.radio22){
                    score+=0;
                }
                else if(id2 == R.id.radio23){
                    score+=0;
                }
                else if(id2 == R.id.radio24){
                    score+=0;
                }

                id3 = rg3.getCheckedRadioButtonId();
                if(id3==R.id.radio31){
                    score+=1;
                }
                else if(id3== R.id.radio32){
                    score+=0;
                }
                else if(id3 == R.id.radio33){
                    score+=0;
                }
                else if(id3 == R.id.radio34){
                    score+=0;
                }

                id4 = rg4.getCheckedRadioButtonId();
                if(id4==R.id.radio41){
                    score+=0;
                }
                else if(id4== R.id.radio42){
                    score+=0;
                }
                else if(id4 == R.id.radio43){
                    score+=1;
                }
                else if(id4 == R.id.radio44){
                    score+=0;
                }

                id5 = rg5.getCheckedRadioButtonId();
                if(id5==R.id.radio51){
                    score+=0;
                }
                else if(id5== R.id.radio52){
                    score+=0;
                }
                else if(id5 == R.id.radio53){
                    score+=1;
                }
                else if(id5== R.id.radio54){
                    score+=0;
                }

                id6 = rg6.getCheckedRadioButtonId();
                if(id6==R.id.radio61){
                    score+=1;
                }
                else if(id6== R.id.radio62){
                    score+=0;
                }
                else if(id6 == R.id.radio63){
                    score+=0;
                }
                else if(id6 == R.id.radio64){
                    score+=0;
                }

                id7 = rg7.getCheckedRadioButtonId();
                if(id7==R.id.radio71){
                    score+=0;
                }
                else if(id7== R.id.radio72){
                    score+=0;
                }
                else if(id7 == R.id.radio73){
                    score+=0;
                }
                else if(id7 == R.id.radio74){
                    score+=1;
                }

                id8 = rg8.getCheckedRadioButtonId();
                if(id8==R.id.radio81){
                    score+=0;
                }
                else if(id8== R.id.radio82){
                    score+=0;
                }
                else if(id8 == R.id.radio83){
                    score+=0;
                }
                else if(id8 == R.id.radio84){
                    score+=1;
                }


                edit7 = ed1.getText().toString().trim();
                if(edit7.isEmpty()){
                    Toast.makeText(MainActivity.this, "Please Enter Some Text question 7", Toast.LENGTH_SHORT).show();
                }
                else if(edit7.equalsIgnoreCase(s1)){
                    score+=1;
                }
                else{
                    score+=0;
                }

                edit8 = ed2.getText().toString().trim();
                if(edit8.isEmpty()){
                    Toast.makeText(MainActivity.this, "Please Enter Some Text on question 8", Toast.LENGTH_SHORT).show();
                }
                else if(edit8.equalsIgnoreCase(s2)){
                    score+=1;
                }
                else{
                    score+=0;
                }
                int Finalscore = score;

                Toast.makeText(MainActivity.this,String.valueOf("your final score is:-"+Finalscore), Toast.LENGTH_SHORT).show();



            }
        });
//to reset the application if clicked
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resetactivity = new Intent(MainActivity.this,MainActivity.class);
                int pendingintent = 123456;
                PendingIntent mpending = PendingIntent.getActivity(MainActivity.this,pendingintent,resetactivity,PendingIntent.FLAG_CANCEL_CURRENT);
                AlarmManager manage = (AlarmManager)MainActivity.this.getSystemService(ALARM_SERVICE);
                manage.set(AlarmManager.RTC,System.currentTimeMillis()+100,mpending);
                System.exit(0);
            }
        });


//if checked then only submit button will appear

        cb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonview, boolean isChecked) {

                if(isChecked){
                    Toast.makeText(MainActivity.this,"now you can proceed",Toast.LENGTH_SHORT).show();
                    b1.setEnabled(true);
                }
                else{
                    b1.setEnabled(false);
                }
            }
        });


    }
}
