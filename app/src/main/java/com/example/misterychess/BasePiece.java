package com.example.misterychess;

import android.graphics.Bitmap;
import android.util.Log;
import android.widget.ImageView;

public class BasePiece {
    public static boolean isLegalBishopMove(int currentX, int currentY, int destX, int destY) {
        if (Math.abs(destX - currentX) == Math.abs(destY - currentY)) {
            return true;
        } else return false;
    }

    public static boolean isLegalKingMove(int currentX, int currentY, int destX, int destY) {
        if (Math.abs(currentX - destX) <= 1 && Math.abs(currentY - destY) <= 1) {
            return true;
        } else return false;
    }

    public static boolean isLegalRookMove(ChessBoard[][] chessBoard, int currentX, int currentY, int destX, int destY) {
        if (currentX == destX && currentY != destY ||
                currentX != destX && currentY == destY) {
            if(currentX == destX){
                for(int i = Math.min(currentY, destY) + 1; i < Math.max(currentY, destY); i++){
                    if(chessBoard[currentX][i].currentNumber != 0){
                        return false;
                    }
                }
            } else{
                for(int i = Math.min(currentX, destX) + 1; i < Math.max(currentX, destX); i++){
                    if(chessBoard[i][destY].currentNumber != 0){
                        return false;
                    }
                }
            }
            return true;
        } else return false;
    }

    public static boolean isLegalKnightMove(int currentX, int currentY, int destX, int destY) {

        if (Math.abs(destX - currentX) == 1 && Math.abs(destY - currentY) == 2) {
            return true;
        } else if (Math.abs(destX - currentX) == 2 && Math.abs(destY - currentY) == 1) {
            return true;
        } else return false;
    }

    public static boolean isLegalPawnMove(ChessBoard[][] chessBoard, int currentX, int currentY, int destX, int destY) {
        if (destX - currentX == 1 && currentY == destY && chessBoard[destX][destY].currentNumber == 0) {
            return true;
        } else if (currentX == 1 && destX == 3 && currentY == destY) {
            return true;
        } else return chessBoard[destX][destY].currentNumber != 0 && Math.abs(destY - currentY) == 1 && Math.abs(destX - currentX) == 1;
    }

    public static void movePiece(ChessBoard[][] chessBoard, int currentX, int currentY, int destX, int destY,
                                 ImageView currentSquare, Bitmap currentImage, ImageView destSquare) {
        boolean isLegalMove = false;
        switch (chessBoard[currentX][currentY].currentNumber) {
            case -1:
            case 1:
                isLegalMove = isLegalPawnMove(chessBoard, currentX, currentY, destX, destY);
                if (!isLegalMove) {
                    Log.d("wrong move", "illegal Pawn move");
                }
                break;
            case -3:
            case 3:
                isLegalMove = isLegalKnightMove(currentX, currentY, destX, destY);
                if (!isLegalMove) {
                    Log.d("wrong move", "illegal knight move");
                }
                break;
            case -4:
            case 4:
                isLegalMove = isLegalBishopMove(currentX, currentY, destX, destY);
                if (!isLegalMove) {
                    Log.d("wrong move", "illegal Bishop move");
                }
                break;
            case -5:
            case 5:
                isLegalMove = isLegalRookMove(chessBoard, currentX, currentY, destX, destY);
                if (!isLegalMove) {
                    Log.d("wrong move", "illegal Rook move");
                }
                break;
            case -9:
            case 9:
                isLegalMove = isLegalRookMove(chessBoard, currentX, currentY, destX, destY) || isLegalBishopMove(currentX, currentY, destX, destY);
                if (!isLegalMove) {
                    Log.d("wrong move", "illegal Queen move");
                }
                break;
            case -100:
            case 100:
                isLegalMove = isLegalKingMove(currentX, currentY, destX, destY);
                if (!isLegalMove) {
                    Log.d("wrong move", "illegal King move");
                }
                break;
            default:
                Log.d("wrong choice", "there is no Piece in the selected square");
                break;
        }
        if (chessBoard[currentX][currentY].currentNumber * chessBoard[destX][destY].currentNumber > 0) {
            isLegalMove = false;
            Log.d("wrong move", "You can not walk on your own pieces");
        }

        if (isLegalMove) {
            chessBoard[destX][destY].currentNumber = chessBoard[currentX][currentY].currentNumber;
            chessBoard[destX][destY].realNumber = chessBoard[currentX][currentY].realNumber;
            destSquare.setImageBitmap(currentImage);
            currentSquare.setImageResource(0);
            chessBoard[currentX][currentY].currentNumber = 0;
            chessBoard[currentX][currentY].realNumber = 0;
        }
    }
}
