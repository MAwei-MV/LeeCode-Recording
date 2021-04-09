package Sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologySort {
	/*
	 * �Կγ̱�Ϊ������N�ſΣ���Ϊ0��n-1 ����һ������prerequisites[][],���е�ֵ��ʽΪ[i,j],��ʾ��Ҫ��ѧ��γ�i����������ɿγ�j
	 * ���Ƿ����������ѧϰ˳��ʹ�����пγ����ꣿ ���ڵĻ����ؽ�����飬�����ڷ��ؿ�����
	 */
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		// �������
		int res[] = new int[numCourses];
		// �п�
		if (numCourses == 0) {
			return res;
		}
		// �������
		int indegree[] = new int[numCourses];
		// ���� �ڽӱ�
		List<List<Integer>> adjacency = new ArrayList<>();
		for (int i = 0; i < numCourses; i++) {
			adjacency.add(new ArrayList<Integer>());
		}
		// ��[i,j]ת��Ϊ�����޻�ͼj->i
		for (int[] cource : prerequisites) {
			indegree[cource[0]]++;
			adjacency.get(cource[1]).add(cource[0]);
		}
		Queue<Integer> queue = new LinkedList<>();
		// ��ʼʱ�������Ϊ0�Ŀγ̣���ʾû���κ��Ⱦ�������
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
		// �����������в������пγ̣���ʾ���ڻ������ؿ�����
		if (flag != numCourses) {
			int empty[] = new int[0];
			return empty;
		}

		return res;
	}
}
