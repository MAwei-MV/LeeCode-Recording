package LiKouPractice;

import java.util.Arrays;

public class Pro57x2 {
	public int[][] insert(int[][] intervals, int[] newInterval) {
		int[][] res = new int[intervals.length + 1][2];
		int idx = 0;
		// ���������б�
		// ���Ƚ����������������������������
		int i = 0;
		while (i < intervals.length && intervals[i][1] < newInterval[0]) {
			res[idx++] = intervals[i++];
		}
		// �����жϵ�ǰ�����Ƿ����������ص����ص��Ļ��ͽ��кϲ���ֱ����������ǰ��������������ұ������룬
		// �����պϲ�����������������
		while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
			newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
			newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
			i++;
		}
		res[idx++] = newInterval;
		// ����������ұ�������������������
		while (i < intervals.length) {
			res[idx++] = intervals[i++];
		}

		return Arrays.copyOf(res, idx);
	}
}
