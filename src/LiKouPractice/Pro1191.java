package LiKouPractice;

public class Pro1191 {
	public static void main(String args[]) {
		Pro1191 pro1191 = new Pro1191();
		int[] a = { 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000 };
		System.out.println(pro1191.kConcatenationMaxSum(a, 100000));
	}

	public int kConcatenationMaxSum(int[] arr, int k) {
		if (arr.length == 0)
			return 0;
		// 最大前缀和
		int pre = Integer.MIN_VALUE;
		// 最大后缀和
		int suf = Integer.MIN_VALUE;
		int temp = 0;
		for (int i = 0; i < arr.length; i++) {
			temp += arr[i];
			pre = Math.max(pre, temp);
		}
		temp = 0;
		for (int i = arr.length - 1; i >= 0; i--) {
			temp += arr[i];
			suf = Math.max(suf, temp);
		}
		temp = arr[0];
		int tr[] = new int[arr.length];
		tr[0] = arr[0];
		int count = arr[0];
		for (int i = 1; i < arr.length; i++) {
			count += arr[i];
			tr[i] = Math.max(tr[i - 1] + arr[i], arr[i]);
			temp = Math.max(temp, tr[i]);
		}
		if (k == 1)
			return temp;
		int r1 = Math.max(temp, suf + pre);
		long l =  ((long)(k - 2) * count + pre + suf);
		long r2 = Math.max(r1, l);
		return (int) Math.max(0, r2 % 1000000007);
	}
}
