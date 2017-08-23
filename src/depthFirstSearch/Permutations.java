package depthFirstSearch;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a list of numbers, return all possible permutations.
 * There is no duplicate numbers in the list.
 * 
 * Example
 * For nums = [1,2,3], the permutations are:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */

public class Permutations {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        
        if (nums == null) {
            return results;
        }
        
        if (nums.length == 0) {
            results.add(new ArrayList<Integer>());
            return results;
        }
        
        List<Integer> list = new ArrayList<Integer>();
        helper(results, list, nums);
        return results;
    }
    
    public void helper(List<List<Integer>> results, List<Integer> list, int[] nums) {
        if (list.size() == nums.length) {
            results.add(new ArrayList<Integer>(list));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) {
                continue;
            }
            list.add(nums[i]);
            helper(results, list, nums);
            list.remove(list.size() - 1);
        }
    }
}
