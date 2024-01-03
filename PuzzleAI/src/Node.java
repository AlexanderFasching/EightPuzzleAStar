
public class Node implements Comparable <Node>{
    public int cost;
    public EightPuzzle puzzle;
    public Node(int cost, EightPuzzle puzzle) {
        this.cost = cost;
        this.puzzle = puzzle;
    }
@Override
//method to compare the cost of two different nodes
    public int compareTo(Node other) {
        return Integer.compare(this.cost, other.cost);
    }
}
