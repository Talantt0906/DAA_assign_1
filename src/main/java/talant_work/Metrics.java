package talant_work;

public class Metrics {
    public static long comparisons = 0;    
    public static int currentDepth = 0;    
    public static int maxDepth = 0;        

    
    public static void reset() {
        comparisons = 0;
        currentDepth = 0;
        maxDepth = 0;
    }

    
    public static void enterRecursion() {
        currentDepth++;
        if (currentDepth > maxDepth) {
            maxDepth = currentDepth;
        }
    }

    
    public static void exitRecursion() {
        currentDepth--;
    }
}

