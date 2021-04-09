package DailyPractice;

//分治，合并链表
public class JZ16 {
	public ListNode Merge(ListNode list1, ListNode list2) {
		ListNode resultList = null;
		if (list1 == null) {
			return list2;
		} else if (list2 == null) {
			return list1;
		} else if (list1.val < list2.val) {
			resultList = list1;
			list1.next = Merge(list1.next, list2);
		} else {
			resultList = list2;
			list2.next = Merge(list1, list2.next);
		}
		return resultList;
	}
}
