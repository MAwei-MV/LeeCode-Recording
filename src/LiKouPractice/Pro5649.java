package LiKouPractice;

public class Pro5649 {
	public static void main(String args[]) {
		Pro5649 p =new Pro5649();
		int a[]= {1,2,3};
		int x=1;
		p.decode(a, 1);
	}
	public int[] decode(int[] encoded, int first) {
		if (encoded.length == 0) {
			int s[] = new int[1];
			s[0] = first;
			return s;
		}
		int res[] = new int[encoded.length + 1];
		res[0] = first;
		for (int i = 1; i < res.length; i++) {
			res[i]=encoded[i-1]^res[i-1];
		}
		return res;
	}
}
