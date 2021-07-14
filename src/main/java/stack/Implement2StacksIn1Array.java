package stack;

//GFG
//Problem link-https://practice.geeksforgeeks.org/problems/implement-two-stacks-in-an-array/1

//Your task is to implement  2 stacks in one array efficiently.
//Example 1:
//Input:
//push1(2)
//push1(3)
//push2(4)
//pop1()
//pop2()
//pop2()
//Output:
//3 4 -1
//Explanation:
//push1(2) the stack1 will be {2}
//push1(3) the stack1 will be {2,3}
//push2(4) the stack2 will be {4}
//pop1()   the poped element will be 3 
//from stack1 and stack1 will be {2}
//pop2()   the poped element will be 4 
//from stack2 and now stack2 is empty
//pop2()   the stack2 is now empty hence -1 .

public class Implement2StacksIn1Array {

    static void push1(int x, TwoStack sq)
    {
        sq.arr[++sq.top1]=x;
    }

    //Function to push an integer into the stack2.
    static void push2(int x, TwoStack sq)
    {
    	sq.arr[--sq.top2]=x;
    }

    //Function to remove an element from top of the stack1.
    static int pop1(TwoStack sq)
    {
        if(sq.top1==-1)
        	return -1;
        return sq.arr[sq.top1--];
    }

    //Function to remove an element from top of the stack2.
    static  int pop2(TwoStack sq)
    {
        if(sq.top2==sq.size)
        	return -1;
        return sq.arr[sq.top2++];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TwoStack tq= new TwoStack();
		push1(2,tq);
		push1(3,tq);
		push2(4,tq);
		System.out.println(pop1(tq));
		System.out.println(pop2(tq));
		System.out.println(pop2(tq));
		System.out.println(pop1(tq));
		System.out.println(pop1(tq));
	}

}
class TwoStack
{

	int size;
	int top1,top2;
	int arr[] = new int[100];

	TwoStack()
	{
		size = 100;
		top1 = -1;
		top2 = size;
	}
}
