package binaryTreeAndDivideConquer;

/**
 * Flatten a binary tree to a fake "linked list" in pre-order traversal.
 * Here we use the right pointer in TreeNode as the next pointer in ListNode.
 * 
 * Example
 *                 1
 *                  \
 *        1          2
 *       / \          \
 *      2   5    =>    3
 *     / \   \          \
 *    3   4   6          4
 *                        \
 *                         5
 *                          \
 *                           6
 */

public class FlattenBinaryTreeToLinkedList {
	/**
	 * @param root: a TreeNode, the root of the binary tree
	 * @return: nothing
	 */
	private TreeNode lastNode = null;
	
	public void flatten(TreeNode root) {
		if (root == null) {
			return;
		}
		
		if (lastNode != null) {
			lastNode.left = null;
			lastNode.right = root;
		}
		
		lastNode = root;
		TreeNode right = root.right;
		flatten(root.left);
		flatten(right);
	}
}
