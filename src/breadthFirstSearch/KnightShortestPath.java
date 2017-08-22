package breadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a knight in a chessboard
 * (a binary matrix with 0 as empty and 1 as barrier) with a source position
 * find the shortest path to a destination position, return the length of the route
 * return -1 if knight can not reached
 * source and destination must be empty, knight can not enter the barrier
 * if the knight is at (x, y), he can get to the following positions in one step
 * (x + 1, y + 2)
 * (x + 1, y - 2)
 * (x - 1, y + 2)
 * (x - 1, y - 2)
 * (x + 2, y + 1)
 * (x + 2, y - 1)
 * (x - 2, y + 1)
 * (x - 2, y - 1)
 * 
 * Example
 * [[0,0,0],
 *  [0,0,0],
 *  [0,0,0]] 
 * source = [2, 0] destination = [2, 2] return 2
 * [[0,1,0],
 *  [0,0,0],
 *  [0,0,0]]
 * source = [2, 0] destination = [2, 2] return 6
 * [[0,1,0],
 *  [0,0,1],
 *  [0,0,0]]
 * source = [2, 0] destination = [2, 2] return -1 
 */

class Point {
	public int x, y;
	public Point() { x = 0; y = 0; }
	public Point(int a, int b) { x = a; y = b; }
}

public class KnightShortestPath {
    int n, m;
    int[] deltaX = {1, 1, 2, 2, -1, -1, -2, -2};
    int[] deltaY = {2, -2, 1, -1, 2, -2, 1, -1};
    /**
     * @param grid a chessboard included 0 (false) and 1 (true)
     * @param source, destination a point
     * @return the shortest path 
     */
    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        
        n = grid.length;
        m = grid[0].length;
        
        Queue<Point> queue = new LinkedList<>();
        queue.offer(source);
        
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point point = queue.poll();
                if (point.x == destination.x && point.y == destination.y) {
                    return steps;
                }
                
                for (int direction = 0; direction < 8; direction++) {
                    Point nextPoint = new Point(
                        point.x + deltaX[direction],
                        point.y + deltaY[direction]
                    );
                    
                    if (!inBound(nextPoint, grid)) {
                        continue;
                    }
                    
                    queue.offer(nextPoint);
                    grid[nextPoint.x][nextPoint.y] = true;
                }
            }
            steps++;
        }
        
        return -1;
    }
    
    private boolean inBound(Point point, boolean[][] grid) {
        if (point.x < 0 || point.x >= n) {
            return false;
        }
        if (point.y < 0 || point.y >= m) {
            return false;
        }
        return (grid[point.x][point.y] == false);
    }
}
