import java.util.ArrayList;
import java.util.List;

public class ExplorerSearch {

    /**
     * Returns how much land area an explorer can reach on a rectangular island.
     * 
     * The island is represented by a rectangular int[][] that contains
     * ONLY the following nunbers:
     * 
     * '0': represents the starting location of the explorer
     * '1': represents a field the explorer can walk through
     * '2': represents a body of water the explorer cannot cross
     * '3': represents a mountain the explorer cannot cross
     * 
     * The explorer can move one square at a time: up, down, left, or right.
     * They CANNOT move diagonally.
     * They CANNOT move off the edge of the island.
     * They CANNOT move onto a a body of water or mountain.
     * 
     * This method should return the total number of spaces the explorer is able
     * to reach from their starting location. It should include the starting
     * location of the explorer.
     * 
     * For example
     * 
     * @param island the locations on the island
     * @return the number of spaces the explorer can reach
     */
    public static int reachableArea(int[][] island) {
        int[] start = explorerLocation(island);
        boolean[][] visited = new boolean[island.length][island[0].length];
        return areaSearch(island, visited, start[0], start[1]);
    }

    // recursive searching algorithm
    private static int areaSearch(int[][] island, boolean[][] visited, int row, int col) {
        if (!isValid(island, visited, row, col)) return 0;

        visited[row][col] = true;
        int count = 1;

        for (int[] move : possibleMoves(row, col)) {
            count += areaSearch(island, visited, move[0], move[1]);
        }

        return count;
    }

    // checks if the next move is valid (not 2 or 3)
    private static boolean isValid(int[][] island, boolean[][] visited, int row, int col) {
        if (row < 0 || col < 0 || row >= island.length || col >= island[0].length) return false;
        if (visited[row][col]) return false;
        int val = island[row][col];
        return val == 0 || val == 1;
    }

    // tracks all possible moves from a given position
    private static List<int[]> possibleMoves(int row, int col) {
        List<int[]> moves = new ArrayList<>();
        moves.add(new int[]{row - 1, col}); // up
        moves.add(new int[]{row + 1, col}); // down
        moves.add(new int[]{row, col - 1}); // left
        moves.add(new int[]{row, col + 1}); // right
        return moves;
    }

    // finds the explorer location and throws exception if none found
    public static int[] explorerLocation(int[][] island) {
        for (int r = 0; r < island.length; r++) {
            for (int c = 0; c < island[r].length; c++) {
                if (island[r][c] == 0) {
                    return new int[]{r, c};
                }
            }
        }
        throw new IllegalArgumentException("No explorer found.");
    }
}
