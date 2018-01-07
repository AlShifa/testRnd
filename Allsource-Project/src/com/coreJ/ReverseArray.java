package com.coreJ;

public class ReverseArray {
	public static void main(String[] args) {
		int[] arry = {3, 1, 4, 1, 5, 9};
		int[] retrunArry = swapEnds(arry);
		System.out.println("print returnArry");
		 for(int i : retrunArry)
		    	System.out.print(i);

		
	}


public static int[] swapEnds(int[] nums) {
  return reverse(nums,nums.length-1);
}

static int[] reverse(int[] nums , int y)
{
	
	 for(int i : nums)
	    	System.out.print(i);
	 
	 System.out.println("\\n");

	int x=0;
    while(x<y)
    {
       int temp = nums[x];
       nums[x]= nums[y];
       nums[y]=temp;
        x++;y--;       
    }
    
    for(int j : nums)
    	System.out.print(j);

    
    return nums;
    
     
}

}
