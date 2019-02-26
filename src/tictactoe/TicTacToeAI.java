package tictactoe;

import java.util.Scanner;

enum PlayTurn
{
    PLAYER_X('X'),PLAYER_O('O');
    char value;
    PlayTurn(char value)
    {
        this.value = value;
    }
}
enum GameState
{
    DRAW,PLAYING,OVER;
}
enum BoardCell
{
    EMPTY(' '),X('X'),O('O');
    char value;
    BoardCell(char s)
    {
        this.value = s;
    }

}

class Move
{
    static int row;
    static int col;
    Move()
    {
        row = -1;
        col = -1;
    }
    Move(int r, int c)
    {
        this.row = r;
        this.col = c;
    }
    void playerMove(int row, int col)
    {
        this.row = row;
        this.col = col;
    }
}

class Game
{
    final static int ROWS = 3;
    final static int COLS = 3;

    BoardCell[][] initBoard(BoardCell board[][])
    {
        for(int i =0; i<ROWS; i++) {
            for (int j = 0; j < COLS; j++)
                board[i][j]=BoardCell.EMPTY ;
        }
        return board;
    }
    GameState isMoveLeft(BoardCell board[][])
    {
        for(int i =0; i<ROWS; i++) {
            for (int j = 0; j < COLS; j++)
                if(board[i][j] == BoardCell.EMPTY)
                {
                    return GameState.PLAYING;
                }
        }
        return GameState.DRAW;
    }
    boolean isValidMove(BoardCell board[][], Move move)
    {
        if ((board[move.row][move.col] == BoardCell.EMPTY) && (move.row >=0 && move.row<ROWS && move.col>=0 && move.col<COLS))
            return true;
        return false;
    }

    GameState hasWon(BoardCell board[][],PlayTurn player, Move move)
    {
        BoardCell cell = (player == PlayTurn.PLAYER_O)? BoardCell.O:BoardCell.X;
        if((board[move.row][0]== cell && board[move.row][1]==cell && board[move.row][2]==cell ) ||
                (board[0][move.col]==cell && board[1][move.col]==cell && board[2][move.col]==cell ) ||
                (board[0][0]==cell && board[1][1]==cell && board[2][2]==cell ) ||
                (board[2][0]==cell && board[1][1]==cell && board[0][2]==cell )){
            System.out.println("Player '"+player.value +"' has won the game !!" );
            return GameState.OVER;

        }
        else
            return GameState.PLAYING;
    }

    int evaluate(BoardCell board[][])
    {
        // Check for rows
        for (int r = 0; r<ROWS; r++)
        {
            if ((board[r][0]==board[r][1])&&(board[r][1] == board[r][2]))
            {
                if (board[r][0] == BoardCell.X)
                    return 10;
                else if (board[r][0] == BoardCell.O)
                    return -10;
            }
        }
        // Check for column
        for (int c = 0; c<COLS; c++)
        {
            if ((board[0][c] == board[1][c])&&(board[1][c] == board[2][c]))
            {
                if (board[0][c] == BoardCell.X)
                    return 10;
                else if (board[0][c] == BoardCell.O)
                    return -10;
            }
        }
        // Check for Diagonal
        if ((board[0][0]==board[1][1])&&(board[1][1] == board[2][2]))
        {
            if (board[0][0] == BoardCell.X)
                return 10;
            else if (board[0][0] ==BoardCell.O)
                return -10;
        }
        // Check for opposite Diagonal
        if ((board[0][2]==board[1][1])&&(board[1][1] == board[2][0]))
        {
            if (board[0][2] == BoardCell.X)
                return 10;
            else if (board[0][2] == BoardCell.O)
                return -10;
        }
        return 0;
    }
    int minimaxFunction(BoardCell board[][], PlayTurn player, int depth)
    {
        int score = evaluate(board);
        //System.out.println("[minimaxFunction] For player "+player+" , depth "+depth+" score is :"+score);
        if (score == 10)
            return score;
        if (score == -10)
            return score;

        if (isMoveLeft(board) == GameState.DRAW)
            return 0;
        // Player X is maximizing player
        if(player == PlayTurn.PLAYER_X)
        {
            //System.out.println("[minimaxFunction] [MAX] For player "+player+" , depth "+depth+" score is :"+score);
            int MAX = Integer.MIN_VALUE;
            for(int i =0; i<ROWS; i++) {
                for (int j = 0; j < COLS; j++)
                    if(board[i][j]== BoardCell.EMPTY)
                    {
                        board[i][j] = BoardCell.X;

                        MAX = Math.max(MAX, minimaxFunction(board, PlayTurn.PLAYER_O,depth+1));
                        //System.out.println("[minimaxFunction] [MAX] [ "+i+", "+j+"] For player "+player+" max is :"+MAX);
                        //printBoard(board);
                        board[i][j] = BoardCell.EMPTY;

                    }
            }
            //System.out.println("[minimaxFunction] For player "+player+" , depth "+depth+" score is :"+MAX);
            return MAX;
        }
        else {
            //System.out.println("[minimaxFunction] [MIN] For player "+player+" , depth "+depth+" score is :"+score);
            int MIN = Integer.MAX_VALUE;
            for(int i =0; i<ROWS; i++) {
                for (int j = 0; j < COLS; j++)
                    if(board[i][j]== BoardCell.EMPTY)
                    {
                        board[i][j] = BoardCell.O;
                        MIN = Math.min(MIN, minimaxFunction(board, PlayTurn.PLAYER_X,depth+1));
                        //System.out.println("[minimaxFunction] [MIN] [ "+i+", "+j+"] For player "+player+" max is :"+MIN);
                        board[i][j] = BoardCell.EMPTY;
                    }
            }
            return MIN;
        }
    }
    Move bestMove(BoardCell board[][], PlayTurn player)
    {
        int bestscore = Integer.MIN_VALUE;
        Move bestmove = new Move();
        for(int i =0; i<ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (board[i][j] == BoardCell.EMPTY) {
                    board[i][j] = (player == PlayTurn.PLAYER_X)?BoardCell.X:BoardCell.O;
                    int score = minimaxFunction(board, (player == PlayTurn.PLAYER_X)? PlayTurn.PLAYER_O:PlayTurn.PLAYER_X, 0);
                    board[i][j] = BoardCell.EMPTY;
                    //System.out.println("[bestMove] [ "+i+", "+j+"] For player "+player+" score is :"+score);
                    if (score > bestscore) {
                        bestscore = score;
                        bestmove.row = i;
                        bestmove.col = j;
                    }
                }
            }
        }
        //System.out.println("[bestMove] For move "+bestmove.row+" , "+bestmove.col+" score is: "+bestscore);

        return bestmove;
    }
    void updateBoard(BoardCell board[][], PlayTurn player,Move move)
    {
        board[move.row][move.col] = (player == PlayTurn.PLAYER_X)?BoardCell.X:BoardCell.O;
    }
    void printBoard(BoardCell board[][])
    {
        System.out.println("\n____________");
        for(int i =0; i<ROWS; i++){
            System.out.print("| ");
            for (int j = 0; j<COLS; j++){
                System.out.print(board[i][j].value+" | ");
            }
            System.out.println("\n|___|___|___|");
        }
    }


}

// Driver main function
public class TicTacToeAI{
    public static void main(String[] args)
    {
        Game game = new Game();
        GameState gameState = GameState.PLAYING;
        BoardCell board[][] = new BoardCell[Game.ROWS][Game.COLS];
        board = game.initBoard(board);
        game.printBoard(board);
        System.out.println("Let the game begin");
        game.updateBoard(board, PlayTurn.PLAYER_O,new Move(1,1));
        PlayTurn player = PlayTurn.PLAYER_X;
        Move move = new Move();
        Scanner sc = new Scanner(System.in);
        while (gameState == GameState.PLAYING)
        {
            System.out.println("Computers Turn : "+player);
            move =  game.bestMove(board, player);
            game.updateBoard(board, player,move);
            if (game.hasWon(board, player, move)== GameState.OVER || game.isMoveLeft(board)== GameState.DRAW) {
                if (gameState == GameState.DRAW)
                {
                    System.out.println("It's a DRAW ..!! ");
                }
                break;
            }
            game.printBoard(board);
            player = PlayTurn.PLAYER_O;
            System.out.println("Your turn : "+player);
            boolean validmove = false;
            System.out.println("Enter row and col :");
            while (!validmove)
            {
                move.row = sc.nextInt();
                move.col = sc.nextInt();
                validmove = game.isValidMove(board, move);
                if (!validmove)
                {
                    System.out.println("Not valid move row[0:2] and col[0:2] \n Enter again:\n");
                }
            }
            game.updateBoard(board, player, move);
            if (game.hasWon(board, player, move)== GameState.OVER || game.isMoveLeft(board)== GameState.DRAW) {
                if (gameState == GameState.DRAW)
                {
                    System.out.println("It's a DRAW ..!! ");
                }
                break;
            }
            game.printBoard(board);
            System.out.println(gameState);
            player = PlayTurn.PLAYER_X;
        }
    }

}