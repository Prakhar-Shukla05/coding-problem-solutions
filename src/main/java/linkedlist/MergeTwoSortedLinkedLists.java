package linkedlist;

//Leetcode
//Problem link- https://leetcode.com/problems/merge-two-sorted-lists/
//Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes of the first two lists.
//Input: l1 = [1,2,4], l2 = [1,3,4]
//Output: [1,1,2,3,4,4]

public class MergeTwoSortedLinkedLists {

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		if(l1==null && l2==null)
			return null;
		if(l1==null)
			return l2;
		if(l2==null)
			return l1;
		ListNode temp=new ListNode(0);
		ListNode head=temp;
		while(l1!=null && l2!=null) {
			if(l1.val<=l2.val) {
				temp.next=l1;
				l1=l1.next;
			}
			else {
				temp.next=l2;
				l2=l2.next;
			}
			temp=temp.next;
			
		}
		if(l1!=null)
			temp.next=l1;
		if(l2!=null)
			temp.next=l2;
		
		return head.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
