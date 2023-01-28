/*
 Mountain Array: A mountain array is an array of length at least 3 with elements 
 				 strictly increasing from starting till an index i, and then strictly 
 				 decreasing from index i to last index. More formally 
 				 arr[0] < arr[1] < arr[i] >arr[i+1] > arr[i+2] > arr[N-1]. 
 				 Examples. Input: arr[] = {4, 4, 3, 2, 1} Output: false


 Peak Index: The index of the peak element in an mountain array is an index whose element is 
 			 not smaller than it's neighbours. For example, given an array of {6,7,10,12,9} 12 
 			 is the peak element of the array and 3 is the peak index (0-base index).
 			 
 Algo: To find the peak element, I have used the Binary Search Algorithm. We know that the peak
 	   element at index i (assumed) will have the following criteria:
 	   				
 	   				arr[i - 1] < arr[i] > arr[i + 1]

 	   So we can set three pointers, start = 0, end = (size of array) - 1, mid = (end + start)/2
 	   
 	   while start is less that or equal to end, we check the following conditions
 	   
 	   		if arr[mid] < arr[mid + 1] => start = mid + 1
 	   		if arr[mid] < arr[mid - 1] => end = mid -1 
 	   		else return mid (because both conditions of peak index satisfy)
 	   		
 	   ** Try to do the dry run for various examples to understand the conditions and edge cases


 */




import java.util.ArrayList;
import java.util.Arrays;

public class PeakOfMountainArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Integer> list = new ArrayList<Integer>(
				Arrays.asList(1,2,3,1));
		
		int index = findPeak(list);
		System.out.println("Peak: "+ index);
	}

	static int findPeak(ArrayList<Integer> list) {
		int start = 0;
		int end = list.size()-1;
		int mid = start + (end - start)/2;
		
		while(start <= end){
			
			if(list.get(mid) < list.get(mid+1)){
				start = mid+1;
			}
			else if(list.get(mid) < list.get(mid-1)){
				end = mid;
			}
			else{
				return mid;
			}
			mid = start + (end - start)/2;
		}
		
		return 0;
	}

}