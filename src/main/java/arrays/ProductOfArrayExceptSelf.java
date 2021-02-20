package arrays;

public class ProductOfArrayExceptSelf {

	public int[] productExceptSelfWithoutConstantSpace(int[] nums) {

		int n = nums.length;
		int[] leftProducts = new int[n];
		int[] rightProducts = new int[n];

		int[] res = new int[n];

		leftProducts[0] = 1;
		rightProducts[n - 1] = 1;

		for (int i = 1; i < n; i++) {
			leftProducts[i] = nums[i - 1] * leftProducts[i - 1];
		}

		for (int i = n - 2; i >= 0; i--) {
			rightProducts[i] = nums[i + 1] * rightProducts[i + 1];
		}

		for (int i = 0; i < n; i++) {
			res[i] = leftProducts[i] * rightProducts[i];
		}

		return res;

	}

	public int[] productExceptSelfWithConstantSpace(int[] nums) {
		int n=nums.length;
		int [] res = new int[n];
		
		res[0]=1;
		for(int i=1;i<n;i++) {
			res[i]=nums[i-1]*res[i-1];
		}
		
		int right=1;
		
		for(int i=n-1;i>=0;i--) {
			res[i]=res[i]*right;
			right*=nums[i];
		}
        return res;
	}

	public static void print(int[] a) {

		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] a = { 1, 2, 3, 4 };
		int[] res = new ProductOfArrayExceptSelf().productExceptSelfWithoutConstantSpace(a);
		print(res);
		
		int [] res2= new ProductOfArrayExceptSelf().productExceptSelfWithConstantSpace(a);
		print(res2);
	}

}
