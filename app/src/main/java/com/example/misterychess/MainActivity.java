package com.example.misterychess;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    int setDefaultSquareId = 57;
    int counter = 0;
    ChessBoard board = new ChessBoard();
    int currentX;
    int currentY;
    ImageView currentSquare;
    Bitmap currentImage;
    ImageView destSquare;
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridLayout chessBoard = findViewById(R.id.chess_board);

        chessBoard.setRowCount(8);
        chessBoard.setColumnCount(8);

        int lightColor = Color.parseColor("#FFFFFF");
        int darkColor = Color.parseColor("#CCCCCC");

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                ImageView square = new ImageView(this);
                square.setLayoutParams(new GridLayout.LayoutParams(
                        GridLayout.spec(row, 1f),
                        GridLayout.spec(col, 1f)));
                square.setId(setDefaultSquareId++);
                if(setDefaultSquareId == 65 || setDefaultSquareId == 57 || setDefaultSquareId == 49 || setDefaultSquareId == 41 || setDefaultSquareId == 33 || setDefaultSquareId == 25
                        || setDefaultSquareId == 17){
                    setDefaultSquareId -= 16;
                }
                square.setBackgroundColor((row + col) % 2 == 0 ? lightColor : darkColor);
                if(row == 7 && col == 3){
                    Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.white_queen);
                    square.setImageBitmap(bitmap);
                } if(row == 7 && col == 4){
                    Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.white_king);
                    square.setImageBitmap(bitmap);
                } if(row == 7 && col == 0 || row == 7 && col == 7){
                    Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.white_rook);
                    square.setImageBitmap(bitmap);
                } if(row == 7 && col == 2 || row == 7 && col == 5){
                    Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.white_bishop);
                    square.setImageBitmap(bitmap);
                } if(row == 7 && col == 1 || row == 7 && col == 6){
                    Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.white_knight);
                    square.setImageBitmap(bitmap);
                } if (row == 6) {
                    Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.white_pawn);
                    square.setImageBitmap(bitmap);
                } if (row == 0 && col == 4) {
                    Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.black_king);
                    square.setImageBitmap(bitmap);
                }if (row == 0 && col == 3) {
                    Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.black_queen);
                    square.setImageBitmap(bitmap);
                }if (row == 0 && col == 0 || row == 0 && col == 7) {
                    Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.black_rook);
                    square.setImageBitmap(bitmap);
                }if (row == 0 && col == 1 || row == 0 && col == 6) {
                    Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.black_knight);
                    square.setImageBitmap(bitmap);
                }if (row == 0 && col == 2 || row == 0 && col == 5) {
                    Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.black_bishop);
                    square.setImageBitmap(bitmap);
                }if (row == 1) {
                    Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.black_pawn);
                    square.setImageBitmap(bitmap);
                }

                chessBoard.addView(square);

                square.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int squareId = square.getId();
                        counter++;
                        if (counter % 2 == 1) {
                            if(squareId % 8 == 0){
                                currentX = squareId / 8 - 1;
                            }else{
                                currentX = squareId / 8;
                            }
                            currentY = (squareId - 1) % 8;
                            currentSquare = square;
                            if(square.getDrawable() != null){
                                currentImage = ((BitmapDrawable)square.getDrawable()).getBitmap();
                            }
                            Log.d("1 square", "currentX: " + currentX + " currentY: " + currentY + " Id: " + squareId + "currentNumber: " + board.chessBoard[currentX][currentY].currentNumber);
                        } else {
                            int destX;
                            if(squareId % 8 == 0){
                                destX = squareId / 8 - 1;
                            }else{
                                destX = squareId / 8;
                            }
                            int destY = (squareId - 1) % 8;
                            destSquare = square;
                            Log.d("1 square", "destX: " + destX + " destY: " + destY + " Id: " + squareId + "currentNumber: " + board.chessBoard[destX][destY].currentNumber);

                            BasePiece.movePiece(board.chessBoard, currentX, currentY, destX, destY, currentSquare, currentImage, destSquare);
                        }
                    }
                });
            }
        }
    }
}
