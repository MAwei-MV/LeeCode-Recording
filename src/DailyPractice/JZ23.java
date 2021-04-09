package DailyPractice;

public class JZ23 {
	public boolean VerifySquenceOfBST(int[] sequence) {
		if(sequence==null || sequence.length == 0) {
			return false;
		}
		return Verify(sequence,0,sequence.length-1);
	}
	
		
	public boolean Verify(int[] arr,int start,int end) {
		if(start >=end) {
			return true;
		}
		for (int i = 0; i < end; i++) {
			if (arr[i] > arr[end]) {
				for (int j = i; j < end; j++) {
					if (arr[j] <= arr[end]) {
						return false;
					}
				}
				if (i == 0) {
					end--;
				} else{
					 start= i - 1;
					 end--;
				}
				break;
			}
			else if(arr[i] < arr[end] && i==end-1) {
				start=end-1;
				end=-1;
			}
		}
		if(end==-1)
		return Verify(arr,0,start);
		else if(start == -1)
			return Verify(arr,0,end);
		else
			return Verify(arr,0,start) &&Verify(arr,start+1,end);
	}
}	
//用while更好啊。算法不太行
		
		
		/*int m = -1;
		int n = sequence.length - 1;
		for (int i = 0; i < n; i++) {
			if (sequence[i] > sequence[n]) {
				for (int j = i; j < n; j++) {
					if (sequence[j] <= sequence[n]) {
						return false;
					}
				}
				if (i == 0) {
					n--;
				} else {
					m = i - 1;
					n--;
				}
				break;
			}
			else if(sequence[i] < sequence[n] && i==n-1) {
				m=n-1;
				n=-1;
			}
		}
		sequence.
	}
}
*/