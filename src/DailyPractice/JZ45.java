package DailyPractice;

import java.util.Arrays;

public class JZ45 {
	public boolean isContinuous(int[] numbers) {
		if(numbers.length==0 || numbers==null) return false;
		Arrays.sort(numbers);
		int x = 0;
		int start = 0;
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] == 0) {
				x++;
			} else {
				if (start != 0)
					x -= numbers[i] - start - 1;
				if (start == numbers[i])
					return false;
				start = numbers[i];
			}
		}
		if (x < 0)
			return false;
		else
			return true;
	}
}
