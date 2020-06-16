package com.example.a3t;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class twoplayers extends AppCompatActivity {

    public static String [][] board={{"_","_","_"},{"_","_","_"},{"_","_","_"}};
    public static Boolean isplayersturn=true;
    public static Vibrator vibrator;
    public static Context context;
    static ImageView x,y;
    public static String p1="x",p2="o";
    public int p1score,p2score,p1p2totalscore,counter;
    public static TextView p1ScoreText,p2ScoreText,p1p2totalscoretext;
    ArrayList<View> arrayList=new ArrayList<>();
    BottomAppBar appBar;
    FloatingActionButton pause;
    AlertDialog dialog;
    LottieAnimationView play;
    static String colourans;

    public  void getcount (View view){

        ImageView box=(ImageView) view;

        String boxname=box.getTag().toString();

        String[] boxpostition=boxname.split(",");

        if(board[Integer.valueOf(boxpostition[0])][Integer.valueOf(boxpostition[1])].trim().equals("_")){

            arrayList.add(view);

            if (isplayersturn){
                box.setImageResource(R.drawable.xzfalse);
                counter++;
                board[Integer.valueOf(boxpostition[0])][Integer.valueOf(boxpostition[1])]=p1;
                isplayersturn=!isplayersturn;
            }
            else{
                box.setImageResource(R.drawable.ofalse);
                board[Integer.valueOf(boxpostition[0])][Integer.valueOf(boxpostition[1])]=p2;
                isplayersturn=!isplayersturn;
                counter++;
            }
            if (evaluate(board)==10){
                Toast.makeText(context, "X won", Toast.LENGTH_SHORT).show();
                p1score++;
                p1p2totalscore++;
                p1p2totalscoretext.setText(String.valueOf(p1p2totalscore));
                p1ScoreText.setText(String.valueOf(p1score));
                isplayersturn=true;
                setcolour();
                reset();
            }
            else if (evaluate(board)==-10){
                Toast.makeText(context, "O won", Toast.LENGTH_SHORT).show();
                p2score++;
                p1p2totalscore++;
                p1p2totalscoretext.setText(String.valueOf(p1p2totalscore));
                p2ScoreText.setText(String.valueOf(p2score));
                isplayersturn=false;
                setcolour();
                reset();
            }
            imagechange(isplayersturn);
            isgameover(p1p2totalscore);
        }
        else {
            vibrator.vibrate(100);
        }
        if(counter>=9){reset();p1p2totalscore++;p1p2totalscoretext.setText(String.valueOf(p1p2totalscore));}
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.board);

        init();

        appBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id=item.getItemId();
                if(id==R.id.home){
                    Intent gotohome=new Intent(twoplayers.this,palypage.class);
                    startActivity(gotohome);
                    finish();
                }
                else if(id==R.id.replay){
                    totalreset();
                }
                return true;
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder loging=new AlertDialog.Builder(twoplayers.this);
                loging.setView(twoplayers.this.getLayoutInflater().inflate(R.layout.pause_dialog,null));
                dialog=loging.create();
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                dialog.show();
                play=dialog.findViewById(R.id.lottie);
                play.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
            }
        });


    }
    private void init() {
        vibrator= (Vibrator) getSystemService(VIBRATOR_SERVICE);
        context=getApplicationContext();
        x=findViewById(R.id.xplayerpng);
        y=findViewById(R.id.oplayerpng);
        p1ScoreText=findViewById(R.id.p1score);
        p2ScoreText=findViewById(R.id.p2score);
        p1p2totalscoretext = findViewById(R.id.p1p2total);
        appBar=findViewById(R.id.bottomAppAccent);
        pause=findViewById(R.id.pause);
    }
    static void imagechange(Boolean xtern){
        if(!xtern){
            y.setImageResource(R.drawable.otrue);
            x.setImageResource(R.drawable.xzfalse);
        }
        else {
            y.setImageResource(R.drawable.ofalse);
            x.setImageResource(R.drawable.xtrue);
        }
    }
    static int evaluate(String b[][]) {
        // Checking for Rows for X or O victory.
        for (int row = 0; row < 3; row++)
        {
            if (b[row][0] == b[row][1] &&
                    b[row][1] == b[row][2])
            {
                if (b[row][0] == p1)
                    return +10;
                else if (b[row][0] == p2)
                    return -10;
                colourans="row"+String.valueOf(row);
            }
        }

        // Checking for Columns for X or O victory.
        for (int col = 0; col < 3; col++)
        {
            if (b[0][col] == b[1][col] &&
                    b[1][col] == b[2][col])
            {
                if (b[0][col] == p1)
                    return +10;

                else if (b[0][col] == p2)
                    return -10;
                colourans="col"+String.valueOf(col);
            }
        }

        // Checking for Diagonals for X or O victory.
        if (b[0][0] == b[1][1] && b[1][1] == b[2][2])
        {
            if (b[0][0] == p1)
                return +10;
            else if (b[0][0] ==p2)
                return -10;
            colourans="d1";
        }

        if (b[0][2] == b[1][1] && b[1][1] == b[2][0])
        {
            if (b[0][2] == p1)
                return +10;
            else if (b[0][2] == p2)
                return -10;
            colourans="d2";
        }
        // Else if none of them have won then return 0
        return 0;
    }
    private void reset(){
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                board[i][j]="_";
            }
        }
        for (View v:arrayList){
            ImageView box=(ImageView)v;
            box.setImageResource(0);
        }
        counter=0;
    }
    private void isgameover(int totalscore) {
        if(totalscore>=5){
            AlertDialog.Builder builder=new AlertDialog.Builder(twoplayers.this);
            if(p1score>p2score){
                builder.setView(twoplayers.this.getLayoutInflater().inflate(R.layout.xwon,null));
                dialog=builder.create();
            }
            else if(p1score==p2score){
                builder.setView(twoplayers.this.getLayoutInflater().inflate(R.layout.ywon,null));
                dialog=builder.create();
            }
            else {
                builder.setTitle("Y won");
            }
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
            dialog.show();
            totalreset();
        }
    }
    private void totalreset() {
        reset();
        p1score=0;
        p2score=0;
        p1p2totalscore=0;
        isplayersturn=true;
        imagechange(isplayersturn);
        p1ScoreText.setText("0");
        p2ScoreText.setText("0");
        p1p2totalscoretext.setText("0");
    }

    public void setcolour(){
        Log.e("colour",colourans);
    }
}
