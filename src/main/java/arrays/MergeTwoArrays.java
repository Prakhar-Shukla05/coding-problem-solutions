package arrays;

import java.util.Arrays;

public class MergeTwoArrays {

	public void merge(int[] nums1, int m, int[] nums2, int n) {
        /*
        int i=0;
        int j=0;
        int [] result= new int[m+n];
        for(int k=0;k<m+n;k++){
            if(i>=m){
                result[k]=nums2[j++];
            }
            else if(j>=n){
                result[k]=nums1[i++];
            }
            else if(less(nums2[j], nums1[i])){
                result[k]= nums2[j++];
            }
            else{
                result[k]=nums1[i++];
            }
        }
        for(int in=0;in<m+n;in++) {
        	nums1[in]=result[in];
        }
        */
		
		int first = m-1;
		int second = n-1;
		for(int i=m+n-1;i>=0;i--) {
			if(second<0)
				break;
			if(first>=0 && nums1[first]>nums2[second]) {
				nums1[i] = nums1[first];
				first--;
			}
			else {
				nums1[i] = nums2[second];
				second--;
			}
		}
    }
    
    private boolean less(Comparable u, Comparable v){
        return u.compareTo(v)<0;
    }
    
    public static void main(String[] args) {
		int [] nums1= {0};
		int [] nums2= {1};
		new MergeTwoArrays().merge(nums1, 0, nums2, 1);
		for(int i:  nums1) {
			System.out.println(i+" ");
		}
	}
}
