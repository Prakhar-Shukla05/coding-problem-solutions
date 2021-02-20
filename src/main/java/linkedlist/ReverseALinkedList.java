package linkedlist;

public class ReverseALinkedList {

	class ListNode {
		     int val;
		     ListNode next;
		     ListNode() {}
		     ListNode(int val) { this.val = val; }
		     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
		 }
	
	public ListNode reverseList(ListNode head) {
		if(head==null)
			return head;
		//ListNode next=head.next;
		ListNode prev=null;
		while(head!=null) {
			ListNode next=head.next;
			head.next=prev;
			prev=head;
			
			head=next;
		}
		return prev;
		
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
