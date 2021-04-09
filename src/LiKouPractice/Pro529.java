package LiKouPractice;

public class Pro529 {
	//  'M' 代表一个未挖出的地雷;
	// 'E' 代表一个未挖出的空方块;
	// 'B' 代表没有相邻（上，下，左，右，和所有4个对角线）地雷的已挖出的空白方块，
	// 数字（'1' 到 '8'）表示有多少地雷与这块已挖出的方块相邻;
	// 'X' 则表示一个已挖出的地雷。
	public static void main(String args[]) {
		Pro529 p = new Pro529();
		char[][] board = { { 'E', 'E', 'E', 'E', 'E' }, { 'E', 'E', 'M', 'E', 'E' }, { 'E', 'E', 'E', 'E', 'E' },
				{ 'E', 'E', 'E', 'E', 'E' } };
		int click[] = { 3, 0 };
		System.out.println(p.updateBoard(board, click));
	}

	public char[][] updateBoard(char[][] board, int[] click) {
		// 如果是B，则递归，如果是数字则终止递归并显示，如果是地雷M则终止递归并不显示
		if (board[click[0]][click[1]] == 'M') {
			board[click[0]][click[1]] = 'X';
			return board;
		}
		int flag[][] = new int[board.length][board[0].length];
		helper(board, click, flag);
		return board;
	}

	private void helper(char[][] board, int[] click, int[][] flag) {
		int x = click[0];
		int y = click[1];
		if (x < 0 || x > board.length - 1 || y < 0 || y > board[0].length - 1 || board[x][y] == 'M' || flag[x][y] == 1)
			return;
		flag[x][y] = 1;
		if (board[x][y] == 'E') {
			int temp = 0;
			for (int i = (x - 1 >= 0 ? x - 1 : 0); i <= (x + 1 <= board.length-1 ? x + 1 : board.length-1); i++) {
				for (int j = (y - 1 >= 0 ? y - 1 : 0); j <= (y + 1 <= board.length-1 ? y + 1 : board.length-1); j++) {
					if (board[i][j] == 'M')
						temp++;
				}
			}
			if (temp > 0)
				board[x][y] = (char) (temp+'0');
			else {
				board[x][y] = 'B';
				for (int i = (x - 1 >= 0 ? x - 1 : 0); i <= (x + 1 <= board.length-1 ? x + 1 : board.length-1); i++) {
					for (int j = (y - 1 >= 0 ? y - 1 : 0); j <= (y + 1 <= board.length-1 ? y + 1 : board.length-1); j++) {
						int click1[] = { i, j };
						helper(board, click1, flag);
					}
				}
			}
		}
	}
}