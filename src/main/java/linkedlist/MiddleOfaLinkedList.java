package linkedlist;

public class MiddleOfaLinkedList {

	public ListNode middleNode(ListNode head) {
            if(head==null)
            	return null;
            
            ListNode slow=head;
            ListNode fast= head;
           /* while(fast.next!=null && fast.next.next!=null) {
            	slow=slow.next;
            	fast=fast.next.next;
            }
            
            return fast.next==null?slow:slow.next;
            */
            while(fast!=null && fast.next!=null) {
            	slow=slow.next;
            	fast=fast.next.next;
            }
            return slow;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
