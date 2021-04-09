package LiKouPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Pro39 {

	List<List<Integer>> ans = new ArrayList<>();

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		LinkedList<Integer> l = new LinkedList<>();
		zuhe(target, 0, l, candidates);
		return ans;
	}

	public void zuhe(int target, int kaishi, LinkedList<Integer> list, int n[]) {
		if (target == 0) {
			ans.add(new ArrayList<>(list));
			return;
		}
		for (int i = kaishi; i < n.length; i++) {
			if (target - n[i] < 0) {
				break;
			}
			list.add(n[i]);
			zuhe(target - n[i], i, list, n);
			list.pollLast();
		}
	}

	/*
	 * List<List<Integer>> ans = new ArrayList<>();
	 * 
	 * public static void main(String args[]) { Pro39 p = new Pro39(); int a[] = {
	 * 2, 3, 6, 7 }; System.out.println(p.combinationSum(a, 7)); }
	 * 
	 * public List<List<Integer>> combinationSum(int[] candidates, int target) {
	 * Arrays.sort(candidates); LinkedList<Integer> l = new LinkedList<>();
	 * helper(candidates, target, 0, l); return ans; }
	 * 
	 * private void helper(int[] candidates, int target, int i, LinkedList<Integer>
	 * list) { if (target == 0) { ans.add(new ArrayList<>(list)); return; } if
	 * (target < 0) return; for (int j = i; j < candidates.length; j++) { if (target
	 * < candidates[j]) { break; } list.add(candidates[j]); helper(candidates,
	 * target - candidates[j], j, list); list.pollLast(); } }
	 */
}