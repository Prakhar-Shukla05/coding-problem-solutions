package linkedlist;


public class BinarytoInteger {

	public int getDecimalValue(ListNode head) {
//        List<Integer> list = new ArrayList();
//        while(head!=null){
//            list.add(head.val);
//            head=head.next;
//        }
//        
//        int num=0;
//        Collections.reverse(list);
//        for(int i=0;i<list.size();i++) {
//        	num+=list.get(i)*(Math.pow(2,i));
//        }
//        return num;
		int num=head.val;    //Faster and space efficient
        head=head.next;
        while(head!=null){
            num=num<<1 | head.val;
            head=head.next;
        }
        
        return num;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
