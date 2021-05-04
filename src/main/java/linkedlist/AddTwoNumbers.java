package linkedlist;

//Leetcode 
//Problem link-https://leetcode.com/problems/add-two-numbers/
//
//You are given two non-empty linked lists representing two non-negative integers. 
//The digits are stored in reverse order, and each of their nodes contains a single digit. 
//Add the two numbers and return the sum as a linked list.
//You may assume the two numbers do not contain any leading zero, except the number 0 itself.
//Input: l1 = [2,4,3], l2 = [5,6,4]
//Output: [7,0,8]
//Explanation: 342 + 465 = 807.

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
