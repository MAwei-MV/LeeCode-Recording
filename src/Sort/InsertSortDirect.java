package Sort;

public class InsertSortDirect {
	//����������Ȳ���
	//��� O(n), �O(n^2),ƽ��O(n^2),�ռ�O(1)
	public static void main(String args[]) {
		int []a = {1,4,7,2,6,0,3,8,5};
		InsertSortDirect i=new InsertSortDirect();
		i.InsertSort(a,a.length);
		for(int m=0;m<a.length;m++) {
			System.out.print(a[m]+",");
		}
	}

	void InsertSort(int[] arr, int len) {
		int tmp;
		int i;
		int j;
		for (i = 1; i < len; i++) {
			tmp = arr[i];
			for (j = i - 1; j >= 0 && arr[j] > tmp; j--) {
				arr[j + 1] = arr[j];
			}
			arr[j + 1] = tmp;
		}
	}
}
