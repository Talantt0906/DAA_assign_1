package main.java.talant_work;

import java.util.Arrays;
import java.util.Comparator;

public class ClosestPair {

    public static class Point {
        public double x, y;
        public Point(double x, double y) { this.x = x; this.y = y; }
    }

    public static class Result {
        public Point p1, p2;
        public double dist;
        public Result(Point p1, Point p2, double dist) { this.p1 = p1; this.p2 = p2; this.dist = dist; }
    }

    public static Result closestPair(Point[] points) {
        Point[] px = points.clone();
        Point[] py = points.clone();
        Arrays.sort(px, Comparator.comparingDouble(p -> p.x));
        Arrays.sort(py, Comparator.comparingDouble(p -> p.y));
        return closestPairRec(px, py);
    }

    private static Result closestPairRec(Point[] px, Point[] py) {
        int n = px.length;
        if (n <= 3) return bruteForce(px);

        int mid = n / 2;
        Point midPoint = px[mid];

        Point[] Qx = Arrays.copyOfRange(px, 0, mid);
        Point[] Rx = Arrays.copyOfRange(px, mid, n);

        Point[] Qy = Arrays.stream(py).filter(p -> p.x <= midPoint.x).toArray(Point[]::new);
        Point[] Ry = Arrays.stream(py).filter(p -> p.x > midPoint.x).toArray(Point[]::new);

        Result left = closestPairRec(Qx, Qy);
        Result right = closestPairRec(Rx, Ry);

        Result best = left.dist < right.dist ? left : right;

        // Build strip (lambda 不修改 best)
        Point[] strip = Arrays.stream(py)
                              .filter(p -> Math.abs(p.x - midPoint.x) < best.dist)
                              .toArray(Point[]::new);

        // 用普通循环更新 best
        Result stripBest = best;
        for (int i = 0; i < strip.length; i++) {
            for (int j = i + 1; j < strip.length && (strip[j].y - strip[i].y) < stripBest.dist; j++) {
                double d = distance(strip[i], strip[j]);
                if (d < stripBest.dist) stripBest = new Result(strip[i], strip[j], d);
            }
        }

        return stripBest;
    }

    private static Result bruteForce(Point[] points) {
        double minDist = Double.POSITIVE_INFINITY;
        Point p1 = null, p2 = null;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                double d = distance(points[i], points[j]);
                if (d < minDist) {
                    minDist = d;
                    p1 = points[i];
                    p2 = points[j];
                }
            }
        }
        return new Result(p1, p2, minDist);
    }

    private static double distance(Point a, Point b) {
        double dx = a.x - b.x, dy = a.y - b.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
}

