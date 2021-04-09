package LiKouPractice;
public class Pro1109 {
	public static void main(String args[]) {
		int[][] a = { { 1, 2, 10 }, { 2, 3, 20 }, { 2, 5, 25 } };
		Pro1109 p = new Pro1109();
		System.out.println(p.corpFlightBookings(a, 5));
	}

	// 普通解法：超时
	/*
	 * public int[] corpFlightBookings(int[][] bookings, int n) { int[] answer = new
	 * int[n]; int flag = 0; Arrays.sort(bookings, new Comparator<int[]>() {
	 * 
	 * @Override public int compare(int[] o1, int[] o2) { if (o1[0] == o2[0]) {
	 * return o1[1] - o2[1]; } else { return o1[0] - o2[0]; } } });
	 * 
	 * for (int i = 0; i < bookings.length; i++) { for (int j = flag; j < n; j++) {
	 * if (bookings[i][1] < j + 1) break; else if (bookings[i][0] <= j + 1 &&
	 * bookings[i][1] >= j + 1) answer[j] += bookings[i][2]; else if (bookings[i][0]
	 * > flag + 1) { flag++; } } } return answer; }
	 */
	// 我是个憨批
	public int[] corpFlightBookings(int[][] bookings, int n) {
		int answer[] = new int[n];
		for (int[] booking : bookings) {
			answer[booking[0] - 1] += booking[2];
			if (booking[1] < n)
				answer[booking[1]] -= booking[2];
		}
		for(int i=1;i<answer.length;i++) {
			answer[i]+=answer[i-1];
		}
		return answer;
	}
}
