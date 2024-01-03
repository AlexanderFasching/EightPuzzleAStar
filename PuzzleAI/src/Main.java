public class Main {
    public static void main(String[] args) {
        // Example initial state
        int[][] initialState = {
                {1, 2, 4},
                {6, 0, 8},
                {5, 7, 3}
        };

        EightPuzzle puzzle = new EightPuzzle(initialState);
        puzzle.printBoard();

        int heuristic = puzzle.calculateManhattanHeuristic();
        System.out.println("Manhattan Heuristic: " + heuristic);


        puzzle.solvePuzzle();

    }

}
