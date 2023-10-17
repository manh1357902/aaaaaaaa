package com.manh.cuocduakythu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    CheckBox checkBox1, checkBox2, checkBox3;
    SeekBar seekBar1,seekBar2, seekBar3;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getView();
        CountDownTimer countDownTimer = new CountDownTimer(40000, 300) {
            @Override
            public void onTick(long l) {
                Random random = new Random();
                int one = random.nextInt(5);
                int two = random.nextInt(5);
                int three = random.nextInt(5);
                seekBar1.setProgress(seekBar1.getProgress()+one);
                seekBar2.setProgress(seekBar2.getProgress()+two);
                seekBar3.setProgress(seekBar3.getProgress()+three);
                if(seekBar1.getProgress()>=seekBar1.getMax()){
                    Toast.makeText(MainActivity.this, "One thắng", Toast.LENGTH_SHORT).show();
                    btn.setVisibility(View.VISIBLE);
                    this.cancel();
                }
                if(seekBar2.getProgress()>=seekBar2.getMax()){
//                    Toast.makeText(MainActivity.this, "Bạn thắng", Toast.LENGTH_SHORT).show();
                    btn.setVisibility(View.VISIBLE);
                    this.cancel();
                }
                if(seekBar3.getProgress()>=seekBar3.getMax()){
//                    Toast.makeText(MainActivity.this, "Bạn thắng", Toast.LENGTH_SHORT).show();
                    btn.setVisibility(View.VISIBLE);
                    this.cancel();
                }
            }

            @Override
            public void onFinish() {
            }
        };
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                seekBar1.setProgress(0);
                seekBar2.setProgress(0);
                seekBar3.setProgress(0);
                btn.setVisibility(View.INVISIBLE);
                countDownTimer.start();
            }
        });
    }

    void getView(){
        checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
        checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
        checkBox3 = (CheckBox) findViewById(R.id.checkBox3);
        seekBar1 = (SeekBar) findViewById(R.id.seekBar1);
        seekBar2 = (SeekBar) findViewById(R.id.seekBar2);
        seekBar3 = (SeekBar) findViewById(R.id.seekBar3);
        btn = (Button) findViewById(R.id.btnStart);
    }
}