import java.util.Random;

public class ComputerRandomPlayer implements Player {
	public void play(TicTacToeGame game){
		CellValue[] board = new CellValue[game.lines*game.columns];
		Random rnd = new Random();
		int n = rnd.nextInt(board.length);
		while (game.valueAt(n) != CellValue.EMPTY){
			n = rnd.nextInt(board.length);
		}
		game.play(n);
		
	}
}