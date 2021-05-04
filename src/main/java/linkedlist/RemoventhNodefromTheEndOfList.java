package linkedlist;

//Leetcode
//Problem link- https://leetcode.com/problems/remove-nth-node-from-end-of-list/
//Given the head of a linked list, remove the nth node from the end of the list and return its head.
//Input: head = [1,2,3,4,5], n = 2
//Output: [1,2,3,5]

public class RemoventhNodefromTheEndOfList {

	public ListNode removeNthFromEnd(ListNode head, int n) {
		if(head==null)
			return null;
		
		ListNode temp= new ListNode(0);
		temp.next=head;
		ListNode slow = temp;
		ListNode fast= temp;
		for(int i=1;i<=n;i++)
			fast=fast.next;
		while(fast.next!=null) {
			slow=slow.next;
			fast=fast.next;
		}
		ListNode toDelete= slow.next;
		slow.next=slow.next.next;
		toDelete=null;
		return temp.next;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
