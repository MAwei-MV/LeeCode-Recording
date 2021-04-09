package LiKouPractice;

import java.util.ArrayList;
import java.util.List;

public class Pro228 {
	public List<String> summaryRanges(int[] nums) {
		List<String> res = new ArrayList<>();
		if (nums.length == 0)
			return res;
		int flag = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] - nums[i-1] == 1) {
				continue;
			} else {
				String s;
				if (nums[i-1] == flag)
					s = String.valueOf(flag);
				else {
					s = String.valueOf(flag) + "->" + String.valueOf(nums[i-1]);
				}
				res.add(s);
				flag=nums[i];
			}
		}
		if(nums[nums.length-1]-flag==0) res.add(String.valueOf(flag));
		else {
			res.add(String.valueOf(flag) + "->" + String.valueOf(nums[nums.length-1]));
		}
		return res;
	}
}
