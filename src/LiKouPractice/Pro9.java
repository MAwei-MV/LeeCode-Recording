package LiKouPractice;

public class Pro9 {
	public static void main(String args[]) {
		Pro9 p = new Pro9();
		System.out.println(p.isPalindrome(121));
	}

	/*
	 * public boolean isPalindrome(int x) { if (x < 0) return false; int highFlag =
	 * 1; while (x / highFlag >= 10) { highFlag *= 10; } while (x > 0) { int high =
	 * x / highFlag; int low = x % 10; if (high != low) return false; x = (x %
	 * highFlag) / 10; highFlag = highFlag / 100; } return true; }
	 */
	public boolean isPalindrome(int x) {
		if (x < 0 || (x > 0 && x % 10 == 0))
			return false;
		int revertedNum = 0;
		while (x > revertedNum) {
			revertedNum = revertedNum * 10 + x % 10;
			x /= 10;
		}
		return x==revertedNum||x==revertedNum/10;
	}

}
