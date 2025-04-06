import static org.junit.Assert.*;
import org.junit.Test;

public class ExplorerSearchTest {
    @Test
    public void testReachableArea_someUnreachable() {
        int[][] island = {
            {1,1,1,3,1,1},
            {3,2,3,1,3,1},
            {1,1,1,1,3,3},
            {3,1,2,1,0,1},
            {1,1,1,2,1,1},
        };
        assertEquals(14, ExplorerSearch.reachableArea(island));
    }

    @Test
    public void testReachableArea_onlyStart() {
        int[][] island = {
            {2,2,2},
            {2,0,2},
            {2,2,2},
        };
        assertEquals(1, ExplorerSearch.reachableArea(island));
    }

    @Test
    public void testReachableArea_allOpen() {
        int[][] island = {
            {0,1,1},
            {1,1,1},
            {1,1,1},
        };
        assertEquals(9, ExplorerSearch.reachableArea(island));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNoExplorerFound_throws() {
        int[][] island = {
            {1,1,1},
            {1,1,1},
        };
        ExplorerSearch.reachableArea(island);
    }

    @Test
    public void testReachableArea_blocked() {
        int[][] island = {
            {1,1,1,2,1},
            {1,1,1,2,1},
            {0,1,1,2,1}
        };
        assertEquals(9, ExplorerSearch.reachableArea(island));
    }
}
