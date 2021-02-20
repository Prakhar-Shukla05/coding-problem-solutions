package linkedlist;

public class ReverseLinkedListII {

	class ListNode {
		      int val;
		      ListNode next;
		      ListNode() {}
		      ListNode(int val) { this.val = val; }
		      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
		  }
	public ListNode reverseBetween(ListNode head, int m, int n) {
       /*        
		ListNode current=head;
		ListNode next=null;
		ListNode dummy=null;
		
		for(int i=1;i<=m;i++) {
			current=current.next;
			dummy= (dummy==null)? head: dummy.next;
		}
		
		for(int i=m;i<n;i++) {
			next=current.next;
			head.next=dummy;
			dummy=head;
			head=next;
		}   
		It was my approach
		
		*/
		/* Nick's approach
		 * 
		 */
		if(head== null) return head;
		
		ListNode prev= null;
		ListNode current=head;
		
		while(m>1) {
			prev=current;
			current=current.next;
			m--;
			n--;
		}
		
		ListNode connect=prev;
		ListNode tail=current;
		
		while(n>0) {
			ListNode next= current.next;
			current.next=prev;
			prev=current;
			current=next;
		}
		
		if(connect!=null) {
			connect.next=prev;
		}
		else {
			head=prev;
		}
		
		tail.next=current;
		
		return head;
	}
}
