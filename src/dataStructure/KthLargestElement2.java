package dataStructure;

import java.util.PriorityQueue;

/**
 * Find K-th largest element in an array. and N is much larger than k.
 * 
 * Example
 * In array [9,3,2,4,8], the 3rd largest element is 4.
 * In array [1,2,3,4,5], the 1st largest element is 5,
 * 2nd largest element is 4, 3rd largest element is 3 and etc.
 */

public class KthLargestElement2 {
    /**
     * @param nums an integer unsorted array
     * @param k an integer from 1 to n
     * @return the kth largest element
     */
    public int kthLargestElement2(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(k);
        for (int num : nums) {
            q.offer(num);
            if (q.size() > k) {
                q.poll();
            }
        }
        return q.peek();
    }
}
