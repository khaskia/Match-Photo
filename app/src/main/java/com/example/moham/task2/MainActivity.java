package com.example.moham.task2;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.Random;


public class MainActivity extends AppCompatActivity {
    ImageButton btv[][] = new ImageButton[4][4];
    TextView txt1 ;
    TextView txt2 ;
    TextView txt3;
    TextView txt4;

    Button btn1 ;


    int ids[][]={
            {R.id.imageButton11,R.id.imageButton12,R.id.imageButton13,R.id.imageButton14},
            {R.id.imageButton21,R.id.imageButton22,R.id.imageButton23,R.id.imageButton24},
            {R.id.imageButton31,R.id.imageButton32,R.id.imageButton33,R.id.imageButton34},
            {R.id.imageButton41,R.id.imageButton42,R.id.imageButton43,R.id.imageButton44}
             };
    int first=0;int second=0;int third=0;int fourth=0;int fifth=0;int six=0;int sev=0;int eig=0;
    int hBuffer;int wBuffer;
    int clicked=0;
    void setOther(){
        first=0;second=0;third=0;fourth=0;fifth=0;six=0;sev=0;eig=0;
    }
    int time=0;
    void setUnvisable(int x1,int y1,int x2,int y2){
       // print("Suceee");
        txt4.setText(Integer.toString(++time));
        btv[x1][y1].setVisibility(View.INVISIBLE);
        btv[x2][y2].setVisibility(View.INVISIBLE);
    }
    void setBufferandOther(int tempW,int tempH){
        txt4.setText(Integer.toString(++time));
        hBuffer=tempH;
        wBuffer=tempW;
        setOther();
    }

    void onclickb(){
        txt1 = (TextView)findViewById(R.id.textView2);
        txt2 = (TextView)findViewById(R.id.textView5);
        btn1 = (Button)findViewById(R.id.button);
        txt3 =(TextView)findViewById(R.id.textView3);
        txt4 =(TextView)findViewById(R.id.textView7);

        for (int width = 0; width <4;width++){
            for (int heigh=0;heigh<4;heigh++){
                final int tempW = width;
                final int tempH = heigh;
               btv[width][heigh]=(ImageButton)findViewById(ids[width][heigh]);

                btv[width][heigh].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(tempW==0 &&tempH==0 || tempW==1 && tempH==1){              //00 11
                            btv[tempW][tempH].setBackgroundResource(R.drawable.algeria);
                            if(first==1){
                                 setUnvisable(0,0,1,1);
                            }else if (first==0){
                                setBufferandOther(tempW,tempH);first++;
                            }
                         }
                        else if(tempW==0 &&tempH==2 || tempW==3 && tempH==1){           // 02 31
                            btv[tempW][tempH].setBackgroundResource(R.drawable.brazil);
                            if(second==1){
                                setUnvisable(0, 2, 3, 1);
                            }else if (second==0){
                                setBufferandOther(tempW, tempH);second++;
                            }
                        }
                        else if(tempW==1 &&tempH==2 || tempW==2 && tempH==3){         //12  24
                            btv[tempW][tempH].setBackgroundResource(R.drawable.egypt);
                            if(third==1){
                                setUnvisable(1, 2, 2, 3);
                            }else if (third==0){
                                setBufferandOther(tempW, tempH);third++;
                            }
                        }
                        else if(tempW==0 &&tempH==3 || tempW==3 && tempH==3){        //02 31
                            btv[tempW][tempH].setBackgroundResource(R.drawable.korea);

                            if(fourth==1){
                                setUnvisable(0, 3, 3, 3);
                            }else if (fourth==0){
                                hBuffer=tempH;
                                wBuffer=tempW;setOther();
                                setBufferandOther(tempW, tempH);fourth++;
                            }
                        }
                        else if(tempW==1 &&tempH==3 || tempW==2 && tempH==2){         //02 31
                            btv[tempW][tempH].setBackgroundResource(R.drawable.saudi);

                            if(fifth==1){
                                setUnvisable(1, 3, 2, 2);
                            }else if (fifth==0){
                                setBufferandOther(tempW, tempH);fifth++;
                            }
                        }
                        else if(tempW==0 &&tempH==1 || tempW==3 && tempH==2){          // 03  32
                            btv[tempW][tempH].setBackgroundResource(R.drawable.spain);

                            if(six==1){
                                setUnvisable(0, 1, 3, 2);
                            }else if (six==0){
                                setBufferandOther(tempW, tempH);six++;
                                ;
                            }
                        }
                        else if(tempW==1 &&tempH==0 || tempW==3 && tempH==0){              //01 22
                            btv[tempW][tempH].setBackgroundResource(R.drawable.united);

                            if(sev==1){
                                setUnvisable(1, 0, 3, 0);
                            }else if (sev==0){
                                setBufferandOther(tempW, tempH);sev++;
                            }
                        }
                        else if(tempW==2 &&tempH==0 || tempW==2 && tempH==1){           //23 14
                            btv[tempW][tempH].setBackgroundResource(R.drawable.morocco);

                            if(eig==1){
                                setUnvisable(2, 0, 2, 1);
                            }else if (eig==0){
                                setBufferandOther(tempW, tempH);eig++;
                            }
                        }
                        int cout=0;
                        for (int w=0;w<4;w++){
                            for (int h=0;h<4;h++){

                                if(btv[w][h].getVisibility()==View.INVISIBLE){
                                    cout++;
                                   txt1.setText(Integer.toString(cout / 2));
                                   txt2.setText(Integer.toString(8-(cout/2)));
                                //    txt4.setText(Integer.toString(time));

                                    if((cout/2)==8) {
                                        btn1.setText("Game Over Click To Start New Game");
                                        btn1.setEnabled(true);
                                        txt3.setVisibility(View.VISIBLE);
                                      //  txt3.setX(50);
                                      //  txt3.setY(50);
                                        if(time>16 && time <=25) txt3.setText("your Memory is very Strong");
                                        else if (time>25 && time <=40) txt3.setText("your Memory is Normal");
                                        else if (time>40) txt3.setText("your Memory is very Bad");

                                    }
                                    //print("unVisable number is"+cout);
                                }
                                if (w==wBuffer && h==hBuffer){
                                }else {

                                    btv[w][h].setBackgroundResource(R.mipmap.ic_launcher);
                                }
                            }
                        }


                    }
                });
            }
        }
    }
        public void newGame(View v){
            Intent i = new Intent(this,MainActivity.class);
            startActivity(i);
            this.finish();
            }

    void shuffle(int[][] a) {
        Random random = new Random();

        for (int i = a.length - 1; i > 0; i--) {
            for (int j = a[i].length - 1; j > 0; j--) {
                int m = random.nextInt(i + 1);
                int n = random.nextInt(j + 1);

                int temp = a[i][j];
                a[i][j] = a[m][n];
                a[m][n] = temp;
            }
        }
    }

    void print(String t){
    Toast.makeText(MainActivity.this,t,Toast.LENGTH_SHORT).show();
}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        shuffle(ids);
        onclickb();
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

