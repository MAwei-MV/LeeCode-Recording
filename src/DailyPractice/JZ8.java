package DailyPractice;

import java.util.Scanner;

public class JZ8 {
	/*
	 * ตÝน้ public int JumpFloor(int target) { if(target == 1) { return 1; } else
	 * if(target == 2) { return 2; } else if(target <=1){ return 0; } else { return
	 * JumpFloor(target-1)+JumpFloor(target-2); } }
	 */
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int[] floor = new int[40];
		floor[0] = 0;
		floor[1] = 1;
		floor[2] = 2;
		for (int i = 3; i <= x; i++) {
			floor[i] = floor[i - 1] + floor[i - 2];
		}
		System.out.println(floor[x]);
	}
}
