package linkedlist;

//Leetcode 2
public class AddTwoNumbers {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		ListNode dummy = new ListNode();
		ListNode temp = dummy;
		int s = 0;
		int c = 0;
		while (l1 != null || l2 != null || c > 0) {

			s = 0;
			if (l1 != null) {
				s += l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				s += l2.val;
				l2 = l2.next;

			}

			s += c;
			c = s / 10;
			s = s % 10;
			ListNode node = new ListNode(s);
			temp.next = node;
			temp = node;
		}
		return dummy.next;
	}

	public static void main(String[] args) {

	}
}
