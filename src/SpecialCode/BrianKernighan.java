package SpecialCode;
//Brian Kernighan 算法
public class BrianKernighan {
	// 这个算法的意思是，对任何一个数 n
	//n&(n−1)的结果是n的比特位最右端的1变为0的结果。
	//BrianKernighan算法用来统计二进制中“1”的个数；
	static int fun1(int num) {
		int count = 0;
		while (num != 0) {
			//n = 01101，~n 是将n按位取反就是10010，
			//~n + 1 = 10011，最后，n & (~n + 1) = 00001
			num -= num & (~num + 1);
			++count;
		}
		return count;
	}
	public static void main(String args[]) {
		System.out.println(fun1(8));
	}
}
