package linkedlist;

public class PalindromeLinkedList {

	class ListNode {
		      int val;
		      ListNode next;
		      ListNode() {}
		      ListNode(int val) { this.val = val; }
		      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
		 }
		 	
		 
		public boolean isPalindrome(ListNode head) {
	         if(head==null)
	        	 return true;
	        ListNode fast= head;
	        ListNode slow= head;
	        
	        while(fast.next!=null && fast.next.next!=null) {
	        	fast=fast.next.next;
	        	slow=slow.next;
	        }
	        
	        ListNode secondHead= reverse(slow.next);
	        ListNode firstHead= head;
	        
	        while(firstHead!=null && secondHead!=null) {
	        	if(firstHead.val!=secondHead.val)
	        		return false;
	        }
	        
	        return true;
	        
	        
		}
		
		private ListNode reverse(ListNode head) {
			ListNode prev=null;
			ListNode current= head;
			
			while(head!=null) {
				ListNode next= current.next;
				head.next=prev;
				prev=head;
				head=next;
			}
			
			return prev;
		}

}
