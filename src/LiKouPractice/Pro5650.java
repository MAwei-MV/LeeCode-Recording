package LiKouPractice;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Pro5650 {
	// 输入：source = [5,1,2,4,3], target = [1,5,4,2,3],
	// allowedSwaps = [[0,4],[4,2],[1,3],[1,4]]

	public static void main(String args[]) {
		Pro5650 p = new Pro5650();
		int source[] = { 1, 2, 3, 4 };
		int target[] = { 1, 3, 2, 4 };
		int all[][] = {};
		System.out.println(p.minimumHammingDistance(source, target, all));
	}

	public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
		int ans = 0, n = source.length;
		UnionFind unionFind = new UnionFind(n);
		for (int[] swap : allowedSwaps) {
			unionFind.union(swap[0], swap[1]);
		}
		// put在放入数据时，如果放入数据的key已经存在与Map中，最后放入的数据会覆盖之前存在的数据，
		// 而putIfAbsent在放入数据时，如果存在重复的key，那么putIfAbsent不会放入值。
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			map.putIfAbsent(target[i], new LinkedList<>());
			map.get(target[i]).add(i);
		}

		for (int i = 0; i < n; i++) {
			if (!map.containsKey(source[i])) {
				ans++;
				continue;
			}

			List<Integer> list = map.get(source[i]);
			Iterator<Integer> iterator = list.iterator();
			boolean flag = false;
			while (iterator.hasNext()) {
				Integer index = iterator.next();
				if (unionFind.connected(i, index)) {
					// java中的集合使用迭代器边遍历边删除时
					// 是需要使用迭代器中的方法的
					iterator.remove();
					// list.remove(index);
					flag = true;
					break;
				}
			}
			if (!flag)
				ans++;
		}
		return ans;
	}

	private static class UnionFind {
		private int[] parent;
		private int[] rank;
		private int count;

		public UnionFind(int n) {
			count = n;
			parent = new int[n];
			for (int i = 0; i < n; i++) {
				parent[i] = i;
			}
			rank = new int[n];
		}

		// 路径压缩
		public int find(int x) {
			if (parent[x] == x) {
				return x;
			}

			return parent[x] = find(parent[x]);
		}

		// 按秩合并
		public void union(int x, int y) {
			int fx = find(x);
			int fy = find(y);

			if (fx == fy) {
				return;
			}

			if (rank[fx] > rank[fy]) {
				parent[fy] = fx;
			} else {
				parent[fx] = fy;
			}

			if (rank[fx] == rank[fy]) {
				rank[fy]++;
			}
			count--;
		}

		public int count() {
			return count;
		}

		public boolean connected(int x, int y) {
			return find(x) == find(y);
		}
	}
}