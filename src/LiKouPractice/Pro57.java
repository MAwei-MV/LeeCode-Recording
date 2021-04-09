package LiKouPractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
//Ì«Âé·³ÁË
public class Pro57 {
	public static void main(String ags[]) {
		Pro57 p = new Pro57();
		int a[][] = new int[][] {{3,4},{5,6}};
		int newInterval[] = new int[] { 1, 2 };
		System.out.println(p.insert(a, newInterval));
	}

	public int[][] insert(int[][] intervals, int[] newInterval) {
		if (intervals.length == 0) {
			int[][] a = new int[1][2];
			a[0][0] = newInterval[0];
			a[0][1] = newInterval[1];
			return a;
		}
		if (intervals[intervals.length-1][1]<newInterval[0]){
		int [][]a=new int [intervals.length+1][2];
		for(int i=0;i<a.length;i++) {
			if(i==a.length-1){
				a[i][0]=newInterval[0];
				a[i][1]=newInterval[1];
			}
			else {
				a[i][0]=intervals[i][0];
				a[i][1]=intervals[i][1];
			}
		}
		return a;
		}
		int start1 = 0, start2, end1, end2 = 0;
		ArrayList<Couple> list = new ArrayList<>();
		for (int i = 0; i < intervals.length; i++) {
			if (intervals[i][1] >= newInterval[0]) {
				start1 = intervals[i][0];
				end1 = intervals[i][1];
				break;
			}
			Couple c = new Couple(intervals[i][0], intervals[i][1]);
			list.add(c);
		}
		for (int j = intervals.length - 1; j >= 0; j--) {
			if (intervals[j][0] <= newInterval[1]) {
				start2 = intervals[j][0];
				end2 = intervals[j][1];
				break;
			}
			list.add(new Couple(intervals[j][0], intervals[j][1]));
		}
		int start, end;
		if (start1 >= newInterval[0]) {
			start = newInterval[0];
		} else {
			start = start1;
		}
		if (end2 <= newInterval[1])
			end = newInterval[1];
		else {
			end = end2;
		}
		list.add(new Couple(start, end));

		Collections.sort(list, new Comparator<Couple>() {
			public int compare(Couple o1, Couple o2) {
				return o1.start - o2.start;
			}
		});
		int newS[][] = new int[list.size()][2];
		for (int i = 0; i < list.size(); i++) {
			newS[i][0] = list.get(i).start;
			newS[i][1] = list.get(i).end;
		}
		return newS;
	}

	class Couple {
		int start;
		int end;

		Couple(int x, int y) {
			start = x;
			end = y;
		}
	}
}