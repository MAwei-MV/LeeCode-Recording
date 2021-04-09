package LiKouPractice;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Pro5650 {
	// ���룺source = [5,1,2,4,3], target = [1,5,4,2,3],
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
		// put�ڷ�������ʱ������������ݵ�key�Ѿ�������Map�У�����������ݻḲ��֮ǰ���ڵ����ݣ�
		// ��putIfAbsent�ڷ�������ʱ����������ظ���key����ôputIfAbsent�������ֵ��
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
					// java�еļ���ʹ�õ������߱�����ɾ��ʱ
					// ����Ҫʹ�õ������еķ�����
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

		// ·��ѹ��
		public int find(int x) {
			if (parent[x] == x) {
				return x;
			}

			return parent[x] = find(parent[x]);
		}

		// ���Ⱥϲ�
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