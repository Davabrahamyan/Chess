package com.example.misterychess;

import android.util.Log;

public class BasePiece {
    public static boolean isLegalBishopMove(int currentX, int currentY, int destX, int destY) {
        if (Math.abs(destX - currentX) == Math.abs(destY - currentY)) {
            return true;
        } else return false;
    }

    public static boolean isLegalKnightMove(int currentX, int currentY, int destX, int destY) {
        if (Math.abs(currentX - destX) <= 1 && Math.abs(currentY - destY) <= 1) {
            return true;
        } else return false;
    }

    public static boolean isLegalRookMove(int currentX, int currentY, int destX, int destY) {
        if (currentX == destX && currentY != destY ||
                currentX != destX && currentY == destY) {
            return true;
        } else return false;
    }

    public static boolean isLegalKingMove(int currentX, int currentY, int destX, int destY) {

        if (Math.abs(destX - currentX) == 1 && Math.abs(destY - currentY) == 2) {
            return true;
        } else if (Math.abs(destX - currentX) == 2 && Math.abs(destY - currentY) == 1) {
            return true;
        } else return false;
    }

    public static boolean isLegalPawnMove(int[][] chessBoard, int currentX, int currentY, int destX, int destY) {
        if (destY - currentY == 1 && currentX == destX) {
            return true;
        } else if (currentY == 2 && destY == 4 && currentX == destX) {
            return true;
        } else if (chessBoard[destX][destY] != 0 && Math.abs(destX - currentX) == 1 && Math.abs(destY - currentY) == 1) {
            return true;
        } else return false;
    }

    public static void movePiece(int[][] chessBoard, int currentX, int currentY, int destX, int destY) {
        switch (chessBoard[currentX][currentY]) {
            case 1:
                if (isLegalPawnMove(chessBoard, currentX, currentY, destX, destY)) {
                    break;
                } else {
                    Log.d("wrong move", "illegal Pawn move");
                }
            case 3:
                if (isLegalKnightMove(currentX, currentY, destX, destY)) {
                    break;
                } else {
                    Log.d("wrong move", "illegal knight move");
                }
            case 4:
                if (isLegalBishopMove(currentX, currentY, destX, destY)) {
                    break;
                } else {
                    Log.d("wrong move", "illegal Bishop move");
                }
            case 5:
                if (isLegalRookMove(currentX, currentY, destX, destY)) {
                    break;
                } else {
                    Log.d("wrong move", "illegal Rook move");
                }
            case 9:
                if (isLegalRookMove(currentX, currentY, destX, destY) && isLegalBishopMove(currentX, currentY, destX, destY)) {
                    break;
                } else {
                    Log.d("wrong move", "illegal Queen move");
                }
            case 100:
                if (isLegalKingMove(currentX, currentY, destX, destY)) {
                    break;
                } else {
                    Log.d("wrong move", "illegal King move");
                }
            default:
                Log.d("wrong choice", "there is no Piece in the selected square");
        }
            if(chessBoard[currentX][currentY] * chessBoard[currentX][currentY] > 0){
                Log.d("wrong move", "You can not walk on your own pieces");
            }
        chessBoard[destX][destY] = chessBoard[currentX][currentY];
        chessBoard[currentX][currentY] = 0;
    }
}
