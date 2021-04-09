package DailyPractice;

import java.util.Scanner;

public class JZ7 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		JZ7 j = new JZ7();
		System.out.println(j.fibonacci(x));
	}

//递归时间复杂度太高
	public int fibonacci(int n) {
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else {
			return fibonacci(n - 1) + fibonacci(n - 2);
		}
	}
}
