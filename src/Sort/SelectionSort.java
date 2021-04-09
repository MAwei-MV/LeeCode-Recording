package Sort;

//选择排序
//最好 O(n^2), 最坏O(n^2),平均O(n^2),空间O(1)
public class SelectionSort {
	public static void main(String args[]) {
		int a[]=new int [] {7,5,2,8,4,1,55,31};
		int res[]=selection(a);
		for(int i:res) {
			System.out.println(i);
		}
	}

	public static int[] selection(int[] arr) {
		int len = arr.length;
		for (int i = 0; i < len; i++) {
			int index = i;
			for (int j = i + 1; j < len; j++) {
				if (arr[j] < arr[index]) {
					index = j;
				}
			}
			int temp = arr[index];
			arr[index] = arr[i];
			arr[i] = temp;
		}
		return arr;
	}
}
