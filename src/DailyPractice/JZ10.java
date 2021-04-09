package DailyPractice;

public class JZ10 {
	public int RectCover(int target) {
		int[] rectangle = new int[40];
		rectangle[0]=0;
		rectangle[1]=1;
		rectangle[2]=2;
		for(int i=4;i<=target;i++) {
			rectangle[i]=rectangle[i-1]+rectangle[i-2];
		}
		return rectangle[target];
	}
}
