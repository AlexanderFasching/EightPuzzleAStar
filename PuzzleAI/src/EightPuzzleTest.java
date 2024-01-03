import java.util.Random;
public class EightPuzzleTest {

    public static void main(String[] args) {
        long totalNodesVisited = 0;
        long totalRuntime = 0;
        long totalMemoryUsed = 0;

        for (int i = 0; i < 100; i++) {
            int[][] state = generateRandomState();
            EightPuzzle puzzle = new EightPuzzle(state);

            long startTime = System.currentTimeMillis();
            long startMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

            puzzle.solvePuzzle();
            totalNodesVisited += puzzle.getNodesVisited();
            puzzle.resetNodesVisited();

            long endTime = System.currentTimeMillis();
            long endMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

            totalRuntime += (endTime - startTime);
            totalMemoryUsed += (endMemory - startMemory);
        }

        System.out.println("Average nodes visited: " + (totalNodesVisited / 100.0));
        System.out.println("Average runtime: " + (totalRuntime / 100.0) + " ms");
        System.out.println("Average memory used: " + (totalMemoryUsed / 100.0) / (1024.0 * 1024.0) + " MB");
    }

    private static int[][] generateRandomState() {
        Random rand = new Random();
        EightPuzzle puzzle = new EightPuzzle(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 0}});

        int moveCount = 30; // Number of random moves to make

        for (int i = 0; i < moveCount; i++) {
            switch (rand.nextInt(4)) {
                case 0:
                    puzzle.moveUp();
                    break;
                case 1:
                    puzzle.moveDown();
                    break;
                case 2:
                    puzzle.moveToLeft();
                    break;
                case 3:
                    puzzle.moveToRight();
                    break;
            }
        }

        return puzzle.getBoard();
    }
}