package linkedlist;

public class InsertionSortList {

	private ListNode sorted;

	// private ListNode h;
	public ListNode insertionSortList(ListNode head) {
		if (head == null)
			return head;
		if (head.next == null)
			return head;

		// h=head;
		sorted = null;
		ListNode current = head;

		while (current != null) {
			ListNode next = current.next;
			insertInTheRightPlace(current);
			current = next;
		}

		return sorted;
	}

	private void insertInTheRightPlace(ListNode node) {

		if (sorted == null || sorted.val >= node.val) {
			node.next = sorted;
			sorted = node;
			return ;
		}

		ListNode temp = sorted;
		while (temp.next != null && temp.next.val < node.val) {
			temp = temp.next;
		}

		node.next = temp.next;
		temp.next = node;
	}
    
	public static void print(ListNode head) {
		ListNode current=head;
		System.out.print(current.val);
		current=current.next;
		while(current!=null) {
			System.out.print("->"+current.val);
			current=current.next;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
          ListNode head = new ListNode(4);
          head.next= new ListNode(2);
          head.next.next= new ListNode(1);
          head.next.next.next= new ListNode(3);
          
          ListNode newHead= new InsertionSortList().insertionSortList(head);
          print(newHead);
	}

}


  //Definition for singly-linked list.

//  class ListNode {
//      int val;
//    ListNode next;
//      ListNode() {}
//      ListNode(int val) { this.val = val; }
//      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//  }
 
