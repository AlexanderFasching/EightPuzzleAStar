import java.util.ArrayList;

public class Node implements Comparable <Node>{

    public int cost;

    public EightPuzzle puzzle;

    public Node(int cost, EightPuzzle puzzle) {
        this.cost = cost;
        this.puzzle = puzzle;
    }
@Override
    public int compareTo(Node other) {
        return Integer.compare(this.cost, other.cost);
    }

}
