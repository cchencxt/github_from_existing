import java.util.Random;
import java.util.Scanner;

public class TicTacToe{

   /**
     * <b>main</b> of the application. Creates the instance of  GameController 
     * and starts the game. If two parameters line  and column
     * are passed, they are used. 
     * Otherwise, a default value is used. Defaults values are also
     * used if the paramters are too small (less than 2).
     * 
     * @param args
     *            command line parameters
     */
     public static void main(String[] args) {

        StudentInfo.display();

        TicTacToeGame game;
        int lines = 3;
        int columns = 3;
        int win = 3;

   
        try{
            if (args.length >= 2) {
                lines = Integer.parseInt(args[0]);
                if(lines<2){
                    System.out.println("Invalid argument, using default...");
                    lines = 3;
                }
                columns = Integer.parseInt(args[1]);
                if(columns<2){
                    System.out.println("Invalid argument, using default...");
                    columns = 3;
                }
            }
            if (args.length >= 3){
                win = Integer.parseInt(args[2]);
                if(win<2){
                    System.out.println("Invalid argument, using default...");
                    win = 3;
                }
            } 
            if (args.length > 3){
                System.out.println("Too many arguments. Only the first 3 are used.");
            } 

        } catch(NumberFormatException e){
            System.out.println("Invalid argument, using default...");
            lines   = 3;
            columns  = 3;
            win = 3;
        }
        
        Player[] players = new Player[2];

        // YOUR CODE HERE
        HumanPlayer player1 = new HumanPlayer();
        ComputerRandomPlayer player2 = new ComputerRandomPlayer();
        Random rnd = new Random();
        String answer = "Y";
        while (answer.equals("Y")){
            game = new TicTacToeGame(lines,columns,win);
            CellValue[] board = new CellValue[lines*columns];
            int first = rnd.nextInt(2);
            if(first != 0){
                players[0] = player2;
                players[1] = player1;
            }else{
                players[0] = player1;
                players[1] = player2;
            }

            if(players[0] == player1){
                System.out.println("Player 1's turn.");
                for (int i = 0; i<board.length; i++) {
                    if (i%2 == 0){
                        if(i != 0){
                            System.out.println("Player 1's turn.");
                        }
                        System.out.println(game.toString());
                        player1.play(game);
                    }else{
                        System.out.println("Player 2's turn.");
                        player2.play(game);
                    }
                    if (game.getGameState() != GameState.PLAYING){
                        System.out.println("Game over");
                        System.out.println("Result: "+game.getGameState());
                        break;
                    }
                }
            }else{
                System.out.println("Player 2's turn.");
                for (int i = 0; i<board.length; i++) {
                    if (i%2 == 0){
                        if (i != 0){
                            System.out.println("Player 2's turn.");
                        }
                        player2.play(game);
                    }else{
                        System.out.println("Player 1's turn.");
                        System.out.println(game.toString());
                        player1.play(game);
                    }
                    if (game.getGameState() != GameState.PLAYING){
                        System.out.println("Game over");
                        System.out.println(game.toString());
                        System.out.println("Result: "+game.getGameState());
                        break;
                    }
                }
            }
            Scanner scanAnswer = new Scanner(System.in);
            System.out.println("Play again (Y)?: ");
            answer = scanAnswer.nextLine().toUpperCase();
        }        
    }

}