package dataStructure;

import java.util.PriorityQueue;
import java.util.Comparator;

/**
 * Given an integer array, find the top k largest numbers in it.
 * 
 * Example
 * Given [3,10,1000,-99,4,100] and k = 3.
 * Return [1000, 100, 10].
 */

public class TopKLargestNumbers {
    /*
     * @param nums an integer array
     * @param k an integer
     * @return the top k largest numbers in array
     */
	public int[] topk(int[] nums, int k) {
		PriorityQueue<Integer> minheap = new PriorityQueue<Integer>();
		
		for (int num : nums) {
			minheap.add(num);
			if (minheap.size() > k) {
				minheap.poll();
			}
		}
		
		int[] result = new int[k];
		for (int i = 0; i < result.length; i++) {
			result[k - i - 1] = minheap.poll();
		}
		return result;
	}
}
