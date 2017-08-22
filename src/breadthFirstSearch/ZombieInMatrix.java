package breadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a 2D grid, each cell is either a wall 2, a zombie 1 or people 0 (the number zero, one, two).
 * Zombies can turn the nearest people(up/down/left/right) into zombies every day, but can not through wall.
 * How long will it take to turn all people into zombies? Return -1 if can not turn all people into zombies.
 * 
 * Example
 * Given a matrix:
 * 0 1 2 0 0
 * 1 0 0 2 1
 * 0 1 0 0 0
 * return 2.k
 */

class coor{
    int x;
    int y;
   public coor(int a, int b) {
       x = a;
       y = b;
   }
}

public class ZombieInMatrix {
    /**
     * @param grid  a 2D integer grid
     * @return an integer
     */
    public int zombie(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int people = 0;
        int[] movex = {0, 1, -1, 0};
        int[] movey = {1, 0, 0, -1};
        Queue<coor> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 0) {
                    people++;
                }
                if(grid[i][j] == 1) {
                    queue.offer(new coor(i,j));
                }
            }
        }
        int day = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                coor temp = queue.poll();
                for(int j = 0; j < movex.length; j++) {
                    coor peopleD = new coor(temp.x + movex[j],temp.y + movey[j]);
                    if(inBound(peopleD, grid) && grid[peopleD.x][peopleD.y] == 0) {
                        grid[peopleD.x][peopleD.y] = 1;
                        queue.offer(peopleD);
                        people--;
                        if(people == 0) {
                            return day;
                        }
                    }
                }
            }
            day++;
        }
        return -1;
    }
    
    public boolean inBound(coor point, int[][] grid) {
        return (0 <= point.x) && point.x < grid.length && 0 <= point.y && point.y < grid[0].length;
    }
}
