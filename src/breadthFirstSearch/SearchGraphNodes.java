package breadthFirstSearch;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Given a undirected graph, a node and a target
 * return the nearest node to given node which value of it is target
 * return NULL if you can't find
 * there is a mapping store the nodes' values in the given parameters
 * 
 * Example
 * 2-----3  5
 *  \    |  | 
 *   \   |  |
 *    \  |  |
 *     \ |  |
 *      1 --4
 * give a node 1, target is 50
 * there a hash named values which is [3,4,10,50,50], represent
 * value of node 1 is 3
 * value of node 2 is 4
 * value of node 3 is 10
 * value of node 4 is 50
 * value of node 5 is 50
 * return node 4
 */

class UndirectedGraphNode {
	int label;
	ArrayList<UndirectedGraphNode> neighbors;
	UndirectedGraphNode(int x) { 
		label = x; neighbors = new ArrayList<UndirectedGraphNode>(); 
	}
}

public class SearchGraphNodes {
    /**
     * @param graph a list of Undirected graph node
     * @param values a hash mapping, <UndirectedGraphNode, (int)value>
     * @param node an Undirected graph node
     * @param target an integer
     * @return the a node
     */
    public UndirectedGraphNode searchNode(ArrayList<UndirectedGraphNode> graph,
                                          Map<UndirectedGraphNode, Integer>  values,
                                          UndirectedGraphNode node,
                                          int target) {
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        Set<UndirectedGraphNode> hash = new HashSet<UndirectedGraphNode>();
        
        queue.offer(node);
        hash.add(node);
        
        while (!queue.isEmpty()) {
            UndirectedGraphNode head = queue.poll();
            if (values.get(head) == target) {
                return head;
            }
            for (UndirectedGraphNode nei : head.neighbors) {
                if (!hash.contains(nei)) {
                    queue.offer(nei);
                    hash.add(nei);
                }
            }
        }
        return null;
    }
}
