import java.util.Scanner;

public class HumanPlayer implements Player {
	public void play(TicTacToeGame game) {
		CellValue[] board = new CellValue[game.lines*game.columns];
		boolean flag = true;
		while (flag == true){
			Scanner scanNum = new Scanner(System.in);
			System.out.print(game.nextCellValue()+" to play: ");
			int position = scanNum.nextInt();
			if (position < 1 || position > board.length) {
				System.out.println("This value should between 1 and "+board.length);
			}else if (game.valueAt(position-1) != CellValue.EMPTY){
				System.out.println("This cell has been played");
			}else{
				game.play(position-1);
				flag = false;
			}
		}		
	}
}