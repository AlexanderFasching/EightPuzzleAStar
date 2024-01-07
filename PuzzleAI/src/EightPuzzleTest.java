import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class EightPuzzleTest {
    public static void main(String[] args) {

        System.out.println("100 Puzzles solved using Manhattan Distance:");
        solvePuzzles(Heuristic.MANHATTAN);
        System.out.println();
        System.out.println("100 Puzzles solved using Hamming Distance:");
        solvePuzzles(Heuristic.HAMMING);
    }

    private static void solvePuzzles(Heuristic heuristic) {
        ArrayList<Integer> nodesVisited = new ArrayList<>();
        ArrayList<Double> runtimes = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            int[][] state = generateRandomState(1000);
            EightPuzzle puzzle = new EightPuzzle(state, heuristic);

            double startTime = System.nanoTime() / 1000000.0;

            puzzle.solvePuzzle();

            nodesVisited.add(puzzle.getNodesVisited());
            puzzle.resetNodesVisited();

            double endTime = System.nanoTime() / 1000000.0;

            runtimes.add(endTime - startTime);
        }

        // mean average of nodes visited
        double meanNodes = (double) nodesVisited.stream().mapToInt(Integer::intValue).sum() / nodesVisited.size();

        // standard deviation of number of nodes visited
        double varNodes = 0;
        for (int n : nodesVisited) {
            varNodes += Math.pow(n - meanNodes, 2);
        }
        varNodes /= nodesVisited.size();
        double stdNodes = Math.sqrt(varNodes);

        // mean average of runtime
        double meanRuntime = runtimes.stream().mapToDouble(Double::doubleValue).sum() / runtimes.size();

        // standard deviation of runtime
        double varRuntime = 0;
        for (double n : runtimes) {
            varRuntime += Math.pow(n - meanRuntime, 2);
        }
        varRuntime /= runtimes.size();
        double stdRuntime = Math.sqrt(varRuntime);

        System.out.println("Average nodes visited: " + meanNodes);
        System.out.println("Standard deviation of number of nodes visited: " + stdNodes);
        System.out.println("Average runtime: " + meanRuntime + " ms");
        System.out.println("Standard deviation runtime: " + stdRuntime + " ms");
    }

    //Generate a random State that is actually SOLVABLE:
    private static int[][] generateRandomState(int moves) {
        Random rand = new Random();
        EightPuzzle puzzle = new EightPuzzle(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 0}}, Heuristic.MANHATTAN);

        int moveCount = moves; //Number of random moves to make from the goal position

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