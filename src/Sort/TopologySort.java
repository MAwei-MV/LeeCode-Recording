package Sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologySort {
	/*
	 * 以课程表为例，有N门课，记为0到n-1 给定一个数组prerequisites[][],其中的值形式为[i,j],表示，要想学完课程i，必须先完成课程j
	 * 求是否存在这样的学习顺序，使得所有课程修完？ 存在的话返回结果数组，不存在返回空数组
	 */
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		// 结果数组
		int res[] = new int[numCourses];
		// 判空
		if (numCourses == 0) {
			return res;
		}
		// 入度数组
		int indegree[] = new int[numCourses];
		// 创建 邻接表
		List<List<Integer>> adjacency = new ArrayList<>();
		for (int i = 0; i < numCourses; i++) {
			adjacency.add(new ArrayList<Integer>());
		}
		// 将[i,j]转化为有向无环图j->i
		for (int[] cource : prerequisites) {
			indegree[cource[0]]++;
			adjacency.get(cource[1]).add(cource[0]);
		}
		Queue<Integer> queue = new LinkedList<>();
		// 初始时加入入度为0的课程（表示没有任何先决条件）
		for (int i=0;i<numCourses;i++) {
			if (indegree[i] == 0)
				queue.add(i);
		}
		int flag = 0;
		while (!queue.isEmpty()) {
			int temp = queue.poll();
			res[flag] = temp;
			flag++;
			for (int l : adjacency.get(temp)) {
				if (--indegree[l] == 0)
					queue.add(l);
			}
		}
		// 如果结果数组中不含所有课程，表示存在环，返回空数组
		if (flag != numCourses) {
			int empty[] = new int[0];
			return empty;
		}

		return res;
	}
}
