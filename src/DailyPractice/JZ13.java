package DailyPractice;

public class JZ13 {
	/*
	public static void main(String args[]) {
		JZ13 j = new JZ13();
		int[] x = { 1, 2, 3, 4, 5, 6, 7 };
		j.reOrderArray(x);
	}

	public void reOrderArray(int[] array) {
		int m = 0;
		int n = array.length - 1;
		int[] array1 = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			if (array[i] % 2 == 1) {
				array1[m] = array[i];
				m++;
			}
		}
		for (int i = array.length - 1; i >= 0; i--) {
			if (array[i] % 2 == 0) {
				array1[n] = array[i];
				n--;
			}
		}
		for (int i = 0; i < array1.length; i++) {
	array		[i] = array1[i];
		}
	}
	*/
	public void reOrderArray(int[] array) {
		int lastodd=0;
		int temp =0;
		for(int i=0;i<array.length;i++) {
			if(array[i]%2==1) {
				temp=array[i];
				for(int j=i;j>lastodd;j--) {
					array[j]=array[j-1];
				}
				array[lastodd]=temp;
				lastodd++;	
			}
		}
	}
}
