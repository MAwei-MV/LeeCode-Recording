package DailyPractice;

public class JZ47 {
	 public int Sum_Solution(int n) {
	        int sum = n;
	        boolean stop= (sum!=0)&&((sum+=Sum_Solution(n-1))!=0);
	        return sum;
	    }
}
