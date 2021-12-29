public class TestTTT{
	public static void main(String[] args){
		test1();
		test2();
	}

	// Test 3x3
	public static void test1(){
		// Positive Tests
		char[][] test1 = {{'X','X','X'}, {'.','.','.'}, {'.','.','.'}};
		TicTacToeBoard ttt = new TicTacToeBoard( test1 );
		System.out.println(ttt.toString());
		System.out.println(ttt.gameOver());
		ttt.testGameOver();
		System.out.println("-----------------------------------------");

		char[][] test2 = {{'X','.','.'}, {'.','X','.'}, {'.','.','X'}};
		ttt = new TicTacToeBoard( test2 );
		System.out.println(ttt.toString());
		System.out.println(ttt.gameOver());
		ttt.testGameOver();
		System.out.println("-----------------------------------------");

		char[][] test2b = {{'.','.','O'}, {'.','O','.'}, {'O','.','.'}};
		ttt = new TicTacToeBoard( test2b );
		System.out.println(ttt.toString());
		System.out.println(ttt.gameOver());
		ttt.testGameOver();
		System.out.println("-----------------------------------------");

		char[][] test3 = {{'X','.','.'}, {'X','.','.'}, {'X','.','.'}};
		ttt = new TicTacToeBoard( test3 );
		System.out.println(ttt.toString());
		System.out.println(ttt.gameOver());
		ttt.testGameOver();
		
		System.out.println("-----------------------------------------");

		// Negative tests
		char[][] test4 = {{'X','O','X'}, {'.','.','.'}, {'.','.','.'}};
		ttt = new TicTacToeBoard( test4 );
		System.out.println(ttt.toString());
		System.out.println(ttt.gameOver());
		ttt.testGameOver();
		System.out.println("-----------------------------------------");

		char[][] test5 = {{'X','.','.'}, {'X','.','.'}, {'.','.','X'}};
		ttt = new TicTacToeBoard( test5 );
		System.out.println(ttt.toString());
		System.out.println(ttt.gameOver());
		ttt.testGameOver();
		System.out.println("-----------------------------------------");

		char[][] test6 = {{'O','.','.'}, {'.','.','.'}, {'X','.','.'}};
		ttt = new TicTacToeBoard( test6 );
		System.out.println(ttt.toString());
		System.out.println(ttt.gameOver());
		ttt.testGameOver();
		System.out.println("-----------------------------------------");
	}

	public static void test2(){
		char[][] test1 = {{'X','X','X','X'}, {'.','.','.','.'}, {'.','.','.','.'}, {'.','.','.','.'}};
		TicTacToeBoard ttt = new TicTacToeBoard( test1 );
		System.out.println(ttt.toString());
		System.out.println(ttt.gameOver());
		ttt.testGameOver();
		System.out.println("-----------------------------------------");

		char[][] test2 = {{'.','.','.','O'}, {'.','.','O','.'}, {'.','O','.','.'}, {'O','.','.','.'}};
		ttt = new TicTacToeBoard( test2 );
		System.out.println(ttt.toString());
		System.out.println(ttt.gameOver());
		ttt.testGameOver();
		System.out.println("-----------------------------------------");

		char[][] test3 = {{'.','.','.','O'}, {'.','.','.','O'}, {'.','.','.','O'}, {'.','.','.','O'}};
		ttt = new TicTacToeBoard( test3 );
		System.out.println(ttt.toString());
		System.out.println(ttt.gameOver());
		ttt.testGameOver();
		
		System.out.println("-----------------------------------------");

		// False Tests
		char[][] test4 = {{'X','O','X','O'}, {'.','.','.','.'}, {'.','.','.','.'}, {'.','.','.','.'}};
		ttt = new TicTacToeBoard( test4 );
		System.out.println(ttt.toString());
		System.out.println(ttt.gameOver());
		ttt.testGameOver();
		System.out.println("-----------------------------------------");
	}
}