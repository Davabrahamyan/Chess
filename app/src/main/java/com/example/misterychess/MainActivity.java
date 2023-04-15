package com.example.misterychess;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
/*    WhiteRook whiteRook = new WhiteRook(this);
    GridLayout.LayoutParams params = new GridLayout.LayoutParams(
            GridLayout.spec(0, 1f),
            GridLayout.spec(0, 1f));*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) GridLayout chessBoard = findViewById(R.id.chess_board);

        chessBoard.setRowCount(8);
        chessBoard.setColumnCount(8);

        int lightColor = Color.parseColor("#FFFFFF");
        int darkColor = Color.parseColor("#CCCCCC");

        // Create and add each chess board square to the GridLayout
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                TextView square = new TextView(this);
                square.setWidth(0);
                square.setHeight(0);
                square.setGravity(Gravity.CENTER);
                square.setLayoutParams(new GridLayout.LayoutParams(
                        GridLayout.spec(row, 1f),
                        GridLayout.spec(col, 1f)));
                square.setId(View.generateViewId());
                square.setBackgroundColor((row + col) % 2 == 0 ? lightColor : darkColor);
                chessBoard.addView(square);

                /*if(row == 0 && (col == 0 || col == 7)){
                    whiteRook.setLayoutParams(params);
                    chessBoard.addView(whiteRook);
                    whiteRook.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                        }
                    });
                }*/
            }
        }
    }
}
