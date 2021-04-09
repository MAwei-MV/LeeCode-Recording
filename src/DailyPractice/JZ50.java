package DailyPractice;

import java.util.HashMap;
import java.util.HashSet;

public class JZ50 {
	/*
	 * public boolean duplicate(int numbers[], int length, int[] duplication) { if
	 * (numbers == null || numbers.length == 0) return false; HashMap<Integer,
	 * Integer> hm = new HashMap<>(); for (int i = 0; i < numbers.length; i++) { if
	 * (!hm.containsKey(numbers[i])) { hm.put(numbers[i], i); } else {
	 * duplication[0] = numbers[i]; return true; } } return false; }
	 */
	 public boolean duplicate(int numbers[],int length,int [] duplication) {
         HashSet<Integer> set = new HashSet<>();
         set.equals("1");
     for(int i = 0; i < length; i++){
         if(set.contains(numbers[i])){
             duplication[0] = numbers[i];
             return true;
         }else{
             set.add(numbers[i]);
         }
     }
     return false;
 }
}

