package interview;

import java.util.Scanner;

public class AliTest1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int index = 0;
		while (index <= 9) {
			int n = sc.nextInt();
			sc.nextLine();
			String s = sc.nextLine();
			String[] str = s.split("\\s+");
			int[] arr = new int[str.length];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(str[i]);
			}
			System.out.println(helper(arr, n));
			index++;
		}
	}

	// arr�������ܷ��ҵ�ĳЩ���ĺ͸պõ���n��arr[]��һ����������
	public static boolean helper(int arr[], int n) {
		//dp[x]=1��ʾ���ҵ�ĳЩ����ӵõ�x��dp[x]=0��ʾ����
		int dp[] = new int[n + 1];
		dp[0] = 1;
		for (int i = 0; i < arr.length; i++) {
			for (int j = n; j >= 0; j--) {
				if (j >= arr[i] && dp[j - arr[i]] == 1) {
					dp[j] = 1;
				}
			}
		}
		return dp[n] == 1;
	}
}
