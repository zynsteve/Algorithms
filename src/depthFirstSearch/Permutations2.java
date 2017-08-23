package depthFirstSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a list of numbers with duplicate number in it. Find all unique permutations.
 * 
 * Example
 * For numbers [1,2,2] the unique permutations are:
 * [
 *   [1,2,2],
 *   [2,1,2],
 *   [2,2,1]
 * ]
 */

public class Permutations2 {
    /**
     * @param nums: A list of integers.
     * @return: A list of unique permutations.
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
    
        if (nums == null) {
            return results;
        }
    
        if (nums.length == 0) {
            results.add(new ArrayList<Integer>());
            return results;
        }

        Arrays.sort(nums);
        List<Integer> list = new ArrayList<Integer>();
        int[] visited = new int[nums.length];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = 0;
        }
     
        helper(results, list, visited, nums);    
        return results;
    }
    
    public void helper(List<List<Integer>> results, List<Integer> list, int[] visited, int[] nums) {
        if (list.size() == nums.length) {
            results.add(new ArrayList<Integer>(list));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1 || (i != 0 && nums[i] == nums[i - 1] && visited[i - 1] == 0)) {
                continue;
            }
            
            visited[i] = 1;
            list.add(nums[i]);
            helper(results, list, visited, nums);
            list.remove(list.size() - 1);
            visited[i] = 0;
        }
    } 
}
