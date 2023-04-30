package com.example.misterychess;

public class ChessBoard {
    public int currentNumber;
    public int realNumber;
    public ChessBoard[][] chessBoard;

    public ChessBoard(int currentNumber, int realNumber){
        this.currentNumber = currentNumber;
        this.realNumber = realNumber;

    }
    public ChessBoard(){
        this.chessBoard = new ChessBoard[][]{
                {new ChessBoard(5,5), new ChessBoard(3,3),
                        new ChessBoard(4,4), new ChessBoard(9,9),
                        new ChessBoard(100,100), new ChessBoard(4,4),
                        new ChessBoard(3,3), new ChessBoard(5,5) },

                {new ChessBoard(1,1), new ChessBoard(1,1),
                        new ChessBoard(1,1), new ChessBoard(1,1),
                        new ChessBoard(1,1), new ChessBoard(1,1),
                        new ChessBoard(1,1), new ChessBoard(1,1)},

                {new ChessBoard(0,0), new ChessBoard(0,0),
                        new ChessBoard(0,0), new ChessBoard(0,0),
                        new ChessBoard(0,0), new ChessBoard(0,0),
                        new ChessBoard(0,0), new ChessBoard(0,0)},

                {new ChessBoard(0,0), new ChessBoard(0,0),
                        new ChessBoard(0,0), new ChessBoard(0,0),
                        new ChessBoard(0,0), new ChessBoard(0,0),
                        new ChessBoard(0,0), new ChessBoard(0,0)},

                {new ChessBoard(0,0), new ChessBoard(0,0),
                        new ChessBoard(0,0),  new ChessBoard(0,0),
                        new ChessBoard(0,0), new ChessBoard(0,0),
                        new ChessBoard(0,0), new ChessBoard(0,0)},

                {new ChessBoard(0,0), new ChessBoard(0,0),
                        new ChessBoard(0,0), new ChessBoard(0,0),
                        new ChessBoard(0,0), new ChessBoard(0,0),
                        new ChessBoard(0,0), new ChessBoard(0,0)},

                {new ChessBoard(-1,-1), new ChessBoard(-1,-1),
                        new ChessBoard(-1,-1), new ChessBoard(-1,-1),
                        new ChessBoard(-1,-1), new ChessBoard(-1,-1),
                        new ChessBoard(-1,-1), new ChessBoard(-1,-1)},

                {new ChessBoard(-5,-5), new ChessBoard(-3,-3),
                        new ChessBoard(-4,-4), new ChessBoard(-9,-9),
                        new ChessBoard(-100,-100), new ChessBoard(-4,-4),
                        new ChessBoard(-3,-3), new ChessBoard(-5,-5) },
        };
    }
}