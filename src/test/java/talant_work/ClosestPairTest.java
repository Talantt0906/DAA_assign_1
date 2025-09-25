package test.java.talant_work;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClosestPairTest {

    @Test
    public void testSmallSet() {
        ClosestPair.Point[] points = {
            new ClosestPair.Point(0, 0),
            new ClosestPair.Point(1, 1),
            new ClosestPair.Point(2, 2)
        };
        ClosestPair.Result result = ClosestPair.closestPair(points);
        assertNotNull(result);
        assertEquals(1.4142135623730951, result.dist, 1e-9); // sqrt(2)
    }

    @Test
    public void testTwoPoints() {
        ClosestPair.Point[] points = {
            new ClosestPair.Point(-1, -1),
            new ClosestPair.Point(2, 3)
        };
        ClosestPair.Result result = ClosestPair.closestPair(points);
        assertNotNull(result);
        assertEquals(Math.sqrt(25), result.dist, 1e-9);
    }

    @Test
    public void testDuplicatePoints() {
        ClosestPair.Point[] points = {
            new ClosestPair.Point(1, 1),
            new ClosestPair.Point(1, 1),
            new ClosestPair.Point(2, 2)
        };
        ClosestPair.Result result = ClosestPair.closestPair(points);
        assertNotNull(result);
        assertEquals(0.0, result.dist, 1e-9);
    }

    @Test
    public void testRandomPoints() {
        ClosestPair.Point[] points = {
            new ClosestPair.Point(0, 0),
            new ClosestPair.Point(5, 4),
            new ClosestPair.Point(3, 1),
            new ClosestPair.Point(6, 1),
            new ClosestPair.Point(3, 2)
        };
        ClosestPair.Result result = ClosestPair.closestPair(points);
        assertNotNull(result);
        assertEquals(Math.sqrt(2), result.dist, 1e-9);
    }
}

