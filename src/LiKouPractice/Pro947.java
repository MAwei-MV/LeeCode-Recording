package LiKouPractice;

import java.util.HashMap;

public class Pro947 {
	public static void main(String args[]) {
		Pro947 pro947 = new Pro947();
		int a[][] = { { 0, 0 }, { 0, 1 }, { 1, 0 }, { 1, 2 }, { 2, 1 }, { 2, 2 } };
		pro947.removeStones(a);
	}

	public int removeStones(int[][] stones) {
		int parent[] = new int[20001];
		int size[] = new int[20001];
		for (int i = 0; i < stones.length; i++) {
			parent[stones[i][0]] = stones[i][0];
			parent[stones[i][1] + 10001] = stones[i][1] + 10001;
			size[stones[i][0]] = 1;
			size[stones[i][1] + 10001] = 1;
		}
		for (int i = 0; i < stones.length; i++) {
			int x = stones[i][0];
			int y = stones[i][1];
			int fx = find(x, parent);
			int fy = find(y + 10001, parent);
			if (fx != fy) {
				if (size[fx] >= size[fy]) {
					parent[fy] = fx;
					size[fx] += size[fy];
				} else {
					parent[fx] = fy;
					size[fy] += size[fx];
				}
			}
		}
		return stones.length - numberOfConnectedComponent(stones, parent);
	}

	private int find(int x, int[] parent) {
		if (parent[x] != x) {
			int father = find(parent[x], parent);
			parent[x] = father;
		}
		return parent[x];
	}

	private int numberOfConnectedComponent(int stones[][], int parent[]) {
		int num = 0;
		HashMap<Integer, Integer> hm = new HashMap<>();
		for (int i = 0; i < stones.length; i++) {
			int father = find(stones[i][0], parent);
			if (father == stones[i][0] && !hm.containsKey(father)) {
				hm.put(father, 0);
				num++;
			}
		}
		return num;
	}

}
