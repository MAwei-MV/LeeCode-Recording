package DailyPractice;

import java.util.ArrayList;

public class JZ63 {
//ʹ��Insert()������ȡ��������ʹ��GetMedian()������ȡ��ǰ��ȡ���ݵ���λ����
	public static ArrayList<Integer> cache = new ArrayList<>();
	public int flag = 0;
	// public int mid_1 = 0;

	public void Insert(Integer num) {
		/*
		 * 
		 * ���������в��ö��ַ� if (len == 0) { cache.add(num); } else { int i = mid_1; if (num >
		 * cache.get(mid_1)) { while (i < len && num > cache.get(i)) { i++; }
		 * cache.add(i, num); if (len % 2 == 0) { mid_1++; } } else { while (i >= 0 &&
		 * num <= cache.get(i)) { i--; } cache.add(i + 1, num); if (len % 2 == 0) {
		 * mid_1++; } } } len++;
		 */
		// ��������,���ӱ�¿����
		if (flag == 0) {
			cache.add(num);
			flag++;
		} else {
			int i = cache.size() - 1;
			for (; i >= 0 && cache.get(i) > num; i--) {
			}
			cache.add(i + 1, num);
		}
	}

	public Double GetMedian() {
		if (cache.size() % 2 == 1) {
			return cache.get(cache.size() / 2) / 1.0;
		} else {
			return (cache.get(cache.size() / 2) + cache.get(cache.size() / 2 - 1)) / 2.0;
		}
	}
}