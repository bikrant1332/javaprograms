package in.bjena.interviews;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class FindNthLargestElementInArray {
	public static void main(String[] args) {
		// assuming array contains duplicates
		Integer[] arr = { 2, 4, 1, -6, 8, 0, 12, 3, 2, -6, 8, 11 };
		int N = 2; // 2 means second largest 3 means third largest

		getNthLargerUsingStream(arr, N);
		getNthLargestElement(arr, N);

	}

	private static void getNthLargerUsingStream(Integer[] arr, int n) {
		Arrays.stream(arr).distinct() // it will remove the duplicates
				.sorted(Comparator.reverseOrder()) // sort the array in descending order
				.limit(n) // it will limit the input with top N elements
				.skip(n - 1) // it will skip from the N-a elements
				.forEach(a -> System.out.println("stream the " + n + "th largest element : " + a));
	}

	private static void getNthLargestElement(Integer[] arr, int n) {
		// iterate over the arr, put it in the key value pair in map, the count as value
		// in map
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}

		// assign a size of the key set as value to variable, decrease it while
		// iterating
		// the if condition to find the maximum position of the array
		int index = map.keySet().size();
		for (Integer key : map.keySet()) {
			if (index == n) {
				System.out.println("map the " + n + "th largest element : " + key);
				break;
			}
			index--;
		}
	}
}
