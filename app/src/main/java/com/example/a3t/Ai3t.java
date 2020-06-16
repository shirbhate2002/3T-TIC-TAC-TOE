package com.example.a3t;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.Random;

import static com.example.a3t.minmaxAi.findBestMove;

public class Ai3t extends AppCompatActivity {

//    private static   Button[][]buttons=new Button[3][3];
//    Button Reset;
//    static Boolean isp1turn=true;
//    static String p1="x", ai ="o";
//    Vibrator v1;
//    static TextView Xscore,Yscore,Totalscore;
//    static ImageView x,y;
//    static LinearLayout linearLayout;
//    static int xscore=0,yscor=0,totalscore=0,counter=0;
//    static String board[][]={{"_","_","_"},
//            {"_","_","_"},
//            {"_","_","_"}};
//    static Context context;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        v1= (Vibrator) getSystemService(VIBRATOR_SERVICE);
//        //to reset game
//        Reset=findViewById(R.id.Reset);
//        x=findViewById(R.id.Ximg);
//        y=findViewById(R.id.Yimg);
//        Xscore=findViewById(R.id.xscore);
//        Yscore=findViewById(R.id.Yscore);
//        Totalscore=findViewById(R.id.totalscore);
//        linearLayout=findViewById(R.id.main);
//        context=Ai3t.this;
//        Reset.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                totalReset();
//            }
//        });
//
//        for(int i=0;i<3;i++){
//            for(int j=0;j<3;j++){
//                String Buttionid="button"+i+j;
//                int id=getResources().getIdentifier(Buttionid,"id",getPackageName());
//                buttons[i][j]=findViewById(id);
//            }
//        }
//
//
//        {
//            buttons[0][0].setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if (!buttons[0][0].getText().toString().trim().equals("")) {
//                        v1.vibrate(50);
//                        Snackbar.make(v, "invaid move", BaseTransientBottomBar.LENGTH_LONG).show();
//                    } else {
//                        board[0][0] = p1;
//                        buttons[0][0].setText(p1);
//                        isp1turn = !isp1turn;
//                        counter++;
//                        Aimove(board);
//                    }
//                    imagechange(isp1turn);
//                    win(context);
//
//                }
//            });
//            buttons[0][1].setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if (!buttons[0][1].getText().toString().trim().equals("")) {
//                        v1.vibrate(50);
//                        Snackbar.make(v, "invaid move", BaseTransientBottomBar.LENGTH_LONG).show();
//                    } else {
//                        board[0][1] = p1;
//                        buttons[0][1].setText(p1);
//                        isp1turn = !isp1turn;
//                        counter++;
//                        Aimove(board);
//                    }
//                    imagechange(isp1turn);
//                    win(context);
//
//
//                }
//            });
//            buttons[0][2].setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if (!buttons[0][2].getText().toString().trim().equals("")) {
//                        v1.vibrate(50);
//                        Snackbar.make(v, "invaid move", BaseTransientBottomBar.LENGTH_LONG).show();
//                    } else {
//                        board[0][2] = p1;
//                        buttons[0][2].setText(p1);
//                        isp1turn = !isp1turn;
//                        counter++;
//                        Aimove(board);
//                    }
//                    imagechange(isp1turn);
//                    win(context);
//
//                }
//            });
//            buttons[1][0].setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if (!buttons[1][0].getText().toString().trim().equals("")) {
//                        v1.vibrate(50);
//                        Snackbar.make(v, "invaid move", BaseTransientBottomBar.LENGTH_LONG).show();
//                    } else {
//                        board[1][0] = p1;
//                        buttons[1][0].setText(p1);
//                        isp1turn = !isp1turn;
//                        counter++;
//                        Aimove(board);
//                    }
//                    imagechange(isp1turn);
//                    win(context);
//
//                }
//            });
//            buttons[1][1].setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if (!buttons[1][1].getText().toString().trim().equals("")) {
//                        v1.vibrate(50);
//                        Snackbar.make(v, "invaid move", BaseTransientBottomBar.LENGTH_LONG).show();
//                    } else {
//                        board[1][1] = p1;
//                        buttons[1][1].setText(p1);
//                        isp1turn = !isp1turn;
//                        counter++;
//                        Aimove(board);
//
//                    }
//                    imagechange(isp1turn);
//                    win(context);
//
//                }
//            });
//            buttons[1][2].setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if (!buttons[1][2].getText().toString().trim().equals("")) {
//                        v1.vibrate(50);
//                        Snackbar.make(v, "invaid move", BaseTransientBottomBar.LENGTH_LONG).show();
//                    } else {
//                        board[1][2] = p1;
//                        buttons[1][2].setText(p1);
//                        isp1turn = !isp1turn;
//                        counter++;
//                        Aimove(board);
//                    }
//                    imagechange(isp1turn);
//                    win(context);
//
//                }
//            });
//            buttons[2][0].setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if (!buttons[2][0].getText().toString().trim().equals("")) {
//                        v1.vibrate(50);
//                        Snackbar.make(v, "invaid move", BaseTransientBottomBar.LENGTH_LONG).show();
//                    } else {
//                        board[2][0] = p1;
//                        buttons[2][0].setText(p1);
//                        isp1turn = !isp1turn;
//                        counter++;
//                        Aimove(board);
//                    }
//                    imagechange(isp1turn);
//                    win(context);
//
//                }
//            });
//            buttons[2][1].setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if (!buttons[2][1].getText().toString().trim().equals("")) {
//                        v1.vibrate(50);
//                        Snackbar.make(v, "invaid move", BaseTransientBottomBar.LENGTH_LONG).show();
//                    } else {
//                        board[2][1] = p1;
//                        buttons[2][1].setText(p1);
//                        isp1turn = !isp1turn;
//                        counter++;
//                        Aimove(board);
//                    }
//                    imagechange(isp1turn);
//                    win(context);
//
//                }
//            });
//            buttons[2][2].setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if (!buttons[2][2].getText().toString().trim().equals("")) {
//                        v1.vibrate(50);
//                        Snackbar.make(v, "invaid move", BaseTransientBottomBar.LENGTH_LONG).show();
//                    } else {
//                        board[2][2] = p1;
//                        buttons[2][2].setText(p1);
//                        isp1turn = !isp1turn;
//                        counter++;
//                        Aimove(board);
//                    }
//                    imagechange(isp1turn);
//                    win(context);
//                }
//            });
//        }
//
//    }
//    static int evaluate(String b[][]) {
//        // Checking for Rows for X or O victory.
//        for (int row = 0; row < 3; row++)
//        {
//            if (b[row][0] == b[row][1] &&
//                    b[row][1] == b[row][2])
//            {
//                if (b[row][0] == p1)
//                    return +10;
//                else if (b[row][0] == ai)
//                    return -10;
//            }
//        }
//
//        // Checking for Columns for X or O victory.
//        for (int col = 0; col < 3; col++)
//        {
//            if (b[0][col] == b[1][col] &&
//                    b[1][col] == b[2][col])
//            {
//                if (b[0][col] == p1)
//                    return +10;
//
//                else if (b[0][col] == ai)
//                    return -10;
//            }
//        }
//
//        // Checking for Diagonals for X or O victory.
//        if (b[0][0] == b[1][1] && b[1][1] == b[2][2])
//        {
//            if (b[0][0] == p1)
//                return +10;
//            else if (b[0][0] == ai)
//                return -10;
//        }
//
//        if (b[0][2] == b[1][1] && b[1][1] == b[2][0])
//        {
//            if (b[0][2] == p1)
//                return +10;
//            else if (b[0][2] == ai)
//                return -10;
//        }
//        // Else if none of them have won then return 0
//        return 0;
//    }
//    static void reset(){
//        for(int i=0;i<3;i++){
//            for(int j=0;j<3;j++){
//                buttons[i][j].setText("");
//                board[i][j]="_";
//                counter=0;
//            }
//        }
//    }
//    static void win(Context context) {
//        if(counter>=5) {
//            Log.i("win","win called");
//            int score = evaluate(board);
//            if (score == 10) {
//                xscore++;
//                totalscore++;
//                Xscore.setText(String.valueOf(xscore));
//                Toast.makeText(context, "X won", Toast.LENGTH_SHORT).show();
//                isp1turn=true;
//                imagechange(isp1turn);
//                reset();
//            }
//            else if (score ==-10) {
//                yscor++;
//                totalscore++;
//                Yscore.setText(String.valueOf(yscor));
//                Toast.makeText(context, "Ai won", Toast.LENGTH_SHORT).show();
//                isp1turn=false;
//                imagechange(isp1turn);
//                reset();
//                firstai();
//            }
//            Totalscore.setText(totalscore+"/5");
//        }
//        if(counter==9){
//            Toast.makeText(context, "tie", Toast.LENGTH_SHORT).show();
//            totalscore++;
//            Totalscore.setText(String.valueOf(totalscore)+"/5");
//            reset();
//        }
//
//        isgameover(totalscore);
//    }
//    private static void firstai() {
//        Random random=new Random();
//        int row =random.nextInt(3);
//        int col =random.nextInt(3);
//        board[row][col] = ai;
//        buttons[row][col].setText(ai);
//        counter++;
//        isp1turn = !isp1turn;
//    }
//    private static void isgameover(int totalscore) {
//        if(totalscore>=5){
//            AlertDialog.Builder builder=new AlertDialog.Builder(context);
//            builder.setMessage("     ");
//            if(xscore>yscor){
//                builder.setTitle("X won");
//            }
//            else if(yscor==xscore){
//                builder.setTitle("Tie");
//            }
//            else {
//                builder.setTitle("Y won");
//            }
//            builder.create().show();
//            totalReset();
//        }
//    }
//    static void imagechange(Boolean xtern){
//        if(!xtern){
//            y.setImageResource(R.drawable.otrue);
//            x.setImageResource(R.drawable.xzfalse);
//            linearLayout.setBackgroundColor(Color.parseColor("#ffb6b6"));
//        }
//        else {
//            y.setImageResource(R.drawable.ofalse);
//            x.setImageResource(R.drawable.xtrue);
//            linearLayout.setBackgroundColor(Color.parseColor("#aacfcf"));
//        }
//    }
//    static void totalReset(){
//        reset();
//        xscore=0;
//        yscor=0;
//        totalscore=0;
//        isp1turn=true;
//        imagechange(isp1turn);
//        Xscore.setText("0");
//        Yscore.setText("0");
//        Totalscore.setText("0/5");
//    }
//    static void Aimove(final String board[][])
//    {
//        Handler handler=new Handler();
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                if(counter!=9)
//                {
//                    minmaxAi.Move bestMove = findBestMove(board);
//                    board[bestMove.row][bestMove.col] = ai;
//                    buttons[bestMove.row][bestMove.col].setText(ai);
//                    counter++;
//                    isp1turn = !isp1turn;
//                }
//            }
//        },00);
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                win(context);
//            }
//        },2000);
//    }
}