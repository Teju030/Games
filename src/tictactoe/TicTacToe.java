package tictactoe;
import java.util.Scanner;

public class TicTacToe{
    // Cell state on board
    public static final char EMPTY = ' ';
    public static final char CROSS = 'X';
    public static final char NOUGHT = 'O';

    // state of game
    public static final int PLAYING = 0;
    public static final int DRAW = 1;
    public static final int GAMEOVER = 2;
    public static final char NOONE = '?';

    // board dimensions
    public static final int ROWS = 3;
    public static final int COLS = 3;

    public static char turn ;
    public static char board[][] = new char[ROWS][COLS];
    public static int currentRow;
    public static int currentCol;
    public static int currentGameState = PLAYING;

    public static Scanner sc = new Scanner(System.in);

    public static void initGame()
    {
        for(int i =0; i<ROWS; i++) {
            for (int j = 0; j < COLS; j++)
                board[i][j] = EMPTY;

        }
        turn = 'X';
    }

    public static void printBoard()
    {
        System.out.println("\n____________");
        for(int i =0; i<ROWS; i++){
            System.out.print("| ");
            for (int j = 0; j<COLS; j++){
                System.out.print(board[i][j]+" | ");
            }
            System.out.println("\n|___|___|___|");
        }
    }
    public static void updateBoard()
    {
        board[currentRow][currentCol] = turn;
    }
    public static void main(String []args)
    {
        initGame();
        char winner = '-';
        boolean validInput = false;
        do {
            System.out.println("Let the game begin ...!");
            System.out.print("Turn of Player  : "+turn);
            printBoard();
            System.out.println("Enter tictactoe.Move : (row:[1,3]  and col:[1,3])");
            do {

                currentRow = sc.nextInt()-1;
                currentCol = sc.nextInt()-1;
                validInput = validMove();
                if (!validInput)
                {
                    System.out.println("Not a valid move. Enter your move again.");
                }

            } while (!validInput);
            updateBoard();
            winner = hasWon();
            turn = (turn == 'X')?'O':'X';
            isDraw();
        }while (currentGameState==PLAYING);
        System.out.println("tictactoe.Game Result: "+winner);
    }

    public static boolean isDraw()
    {
        for(int i =0; i<ROWS; i++){
            for (int j = 0; j<COLS; j++) {
                if (board[i][j] == EMPTY)
                    return false;
            }
        }
        currentGameState = DRAW;
        return true;
    }
    public static char hasWon() {

        if((board[currentRow][0]==turn && board[currentRow][1]==turn && board[currentRow][2]==turn ) ||
                (board[0][currentCol]==turn && board[1][currentCol]==turn && board[2][currentCol]==turn ) ||
                (board[0][0]==turn && board[1][1]==turn && board[2][2]==turn ) ||
                (board[2][0]==turn && board[1][1]==turn && board[0][2]==turn )){
            currentGameState = GAMEOVER;
            return turn;

        }
        else
            return NOONE;
    }

    private static boolean validMove() {
        if ((currentCol<0 || currentCol >=COLS)|| (currentRow<0 || currentRow>=ROWS) ||board[currentRow][currentCol]!=EMPTY)
        {
            return false;
        }
        else
            return true;
    }
}