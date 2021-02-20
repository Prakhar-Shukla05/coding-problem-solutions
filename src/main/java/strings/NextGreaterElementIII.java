package strings;

import java.util.Arrays;
import java.util.Scanner;

public class NextGreaterElementIII {

    public int nextGreaterElement(int n) {
        String s= Integer.toString(n);
         char [] ch =s.toCharArray();
         int len = ch.length;
        int index=len;
         int i=len-2;
         for( i=len-2;i>=0;i--){
        	 int pre=ch[i]-'0';
        	 int next= ch[i+1]-'0';
             if((ch[i]-'0')<(ch[i+1]-'0')){
                 index=i;
                 break;
             }
         }
          if(i==-1)
                return i;
     
          int min= i+1;
          for(int j=i+1;j<len;j++){
              if(ch[j]>ch[index] && ch[j]<ch[min]){
                  min=j;
              }
          }
          
          char t= ch[index];
          ch[index]=ch[min];
          ch[min]=t;
          Arrays.sort(ch ,index+1,len);
          long num=0;
          for(char c : ch) {
        	  num= num*10 + Integer.parseInt(String.valueOf(c));
        	  if(num>Integer.MAX_VALUE)
        		  return -1;
          }
          return (int)num;
     }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
         int n;
         n= sc.nextInt();
         sc.close();
         System.out.println(new NextGreaterElementIII().nextGreaterElement(n));
	}

}
