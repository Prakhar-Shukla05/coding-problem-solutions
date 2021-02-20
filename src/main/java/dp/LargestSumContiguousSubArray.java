package dp;

public class LargestSumContiguousSubArray {

	    int maxSubarraySum(int arr[], int n){
	        
	    	int maxSofar=0;
	    	int maxEndingHere=0;
	    	
	    	for(int x: arr) {
	    		maxEndingHere+=x;
	    		if(maxSofar<maxEndingHere)
	    			maxSofar=maxEndingHere;
	    		
	    		if(maxEndingHere<0)
	    			maxEndingHere=0;
	    		
	    		
	    	}
	    	return maxSofar;
	        
	        
	    }
	    
}


