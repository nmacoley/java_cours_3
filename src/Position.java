public class Position {
    public int i;
    public int j;

    public Position(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public Position(Position pos) {
        this.i = pos.i;
        this.j = pos.j;
    }
}
