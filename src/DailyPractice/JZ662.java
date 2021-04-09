package DailyPractice;

import java.util.LinkedList;
import java.util.Queue;

//BFS
public class JZ662 {
	private final int dx[] = { -1, 1, 0, 0 };
	private final int dy[] = { 0, 0, -1, 1 };

	public int movingCount(int threshold, int rows, int cols) {
		if (threshold <= 0 || rows <= 0 || cols <= 0) {
			return 0;
		}
		int ans = 0;
		boolean[][] vis = new boolean[rows + 1][cols + 1];
		Queue<Path> queue = new LinkedList<>();
		queue.add(new Path(0, 0));
		vis[0][0] = true;
		while (!queue.isEmpty()) {
			Path p = queue.poll();
			int x = p.getX();
			int y = p.getY();
			for (int i = 0; i < 4; i++) {
				int xx = x + dx[i];
				int yy = y + dy[i];
				if (xx >= 0 && xx < rows && yy >= 0 && yy < cols && !vis[xx][yy] && (sum(xx) + sum(yy) <= threshold)) {
					ans++;
					vis[xx][yy] = true;
					queue.add(new Path(xx, yy));
				}
			}
		}
		return ans + 1;
	}

	public int sum(int x) {
		int ans = 0;
		while (x != 0) {
			ans += (x % 10);
			x /= 10;
		}
		return ans;
	}
}

class Path {
	private int x;
	private int y;

	public Path(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}