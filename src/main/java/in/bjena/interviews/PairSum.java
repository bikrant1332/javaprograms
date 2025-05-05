package in.bjena.interviews;

import java.util.HashMap;
import java.util.Map;

public class PairSum {
	public static void main(String[] args) {
		// sum 16?  -  { 1, 4, 45, 6, 10, 8 }
		int sum = 16;
		int[] arr = { 1, 4, 4,5, 6, 6, 10, 8, 9, 7 };

		// aproach-1
		// for this approach needed to sort the array
		/*
		 * int low=0; int high=arr.length-1; Arrays.sort(arr); while(low<high) {
		 * 
		 * if(arr[low]+arr[high]==sum) { System.out.println("The pair is : ("+ arr[low]
		 * + ", " + arr[high] + ")"); } if((arr[low]+arr[high])>sum) { high-=1; } else {
		 * low++; } }
		 */

		// aproach-2
		// using hashmap
		int rem = 0;
		int element = 0;
		int count = 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			element = arr[i];
			rem = sum - element;

			// If array contains duplicate then this
			if (map.containsKey(rem)) {
				count = map.get(rem);
				for (int j = 0; j < count; j++) {
					System.out.println("The pairs are : " + rem + "," + element);
				}
			}

			// if array not have any duplicates
			/*
			 * if(map.containsKey(rem)) {
			 * System.out.println("The pairs are : "+rem+","+element); }
			 */

			if (map.containsKey(element)) {
				map.put(element, map.get(element) + 1);
			} else {
				map.put(element, 1);
			}

		}
	}
}
