package LiKouPractice;

public class Pro200 {
	// 方法一 DFS
	/*
	 * int sum = 0;
	 * 
	 * public static void main(String args[]) { char[][] x = { { 1, 1 }, { 1, 0 } };
	 * }
	 * 
	 * public int numIslands(char[][] grid) { int flag[][] = new
	 * int[grid.length][grid[0].length]; for (int i = 0; i < grid.length; i++) { for
	 * (int j = 0; j < grid[0].length; j++) { if (grid[i][j] == '1' && flag[i][j] ==
	 * 0) { sum++; helper(grid, flag, i, j); } } } return sum; }
	 * 
	 * private void helper(char[][] grid, int[][] flag, int x, int y) { if (x >=
	 * grid.length || x < 0 || y < 0 || y >= grid[0].length || flag[x][y] == 1 ||
	 * grid[x][y] == '0') return; flag[x][y] = 1; helper(grid, flag, x + 1, y);
	 * helper(grid, flag, x, y + 1); helper(grid, flag, x, y - 1); helper(grid,
	 * flag, x - 1, y); }
	 */
	// 方法二 Union Find
	public int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}
		int nr = grid.length;
		int nc = grid[0].length;
		UnionFind uf = new UnionFind(grid);
		for (int r = 0; r < nr; ++r) {
			for (int c = 0; c < nc; ++c) {
				if (grid[r][c] == '1') {
					grid[r][c] = '0';
					if (r - 1 >= 0 && grid[r - 1][c] == '1') {
						uf.union(r * nc + c, (r - 1) * nc + c);
					}
					if (r + 1 < nr && grid[r + 1][c] == '1') {
						uf.union(r * nc + c, (r + 1) * nc + c);
					}
					if (c - 1 >= 0 && grid[r][c - 1] == '1') {
						uf.union(r * nc + c, r * nc + c - 1);
					}
					if (c + 1 < nc && grid[r][c + 1] == '1') {
						uf.union(r * nc + c, r * nc + c + 1);
					}
				}
			}
		}
		return uf.getCount();
	}
}

class UnionFind {
	int count;
	int[] parent;
	int[] rank;

	public UnionFind(char[][] grid) {
		count = 0;
		int m = grid.length;
		int n = grid[0].length;
		parent = new int[m * n];
		rank = new int[m * n];
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				if (grid[i][j] == '1') {
					parent[i * n + j] = i * n + j;
					++count;
				}
				rank[i * n + j] = 1;
			}
		}
	}

	public int find(int i) {
		if (parent[i] != i)
			parent[i] = find(parent[i]);
		return parent[i];
	}

	public void union(int x, int y) {
		int rootx = find(x);
		int rooty = find(y);
		if (rootx != rooty) {
			if (rank[rootx] > rank[rooty]) {
				parent[rooty] = rootx;
			} else if (rank[rootx] < rank[rooty]) {
				parent[rootx] = rooty;
			} else {
				parent[rooty] = rootx;
				rank[rootx] += 1;
			}
			--count;
		}
	}

	public int getCount() {
		return count;
	}

}
