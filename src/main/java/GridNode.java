/***
 *
 *
 * qiunet
 * 2021/9/6 09:46
 **/
public class GridNode {
    /**
     * 父节点. 溯源用.
     */
    private final GridNode parent;

    private final Grid grid;
    /**
     * 距离起点的距离
     */
    private final int gScore;
    /**
     * 总分
     */
    private final int tScore;
    /**
     * 父类对它的朝向.
     */
    private final DirectionEnum dir;

    public GridNode(GridNode parent, Grid grid, DirectionEnum dir, int gScore, int hScore) {
        this.dir = dir;
        this.grid = grid;
        this.parent = parent;
        this.gScore = gScore;
        this.tScore = gScore + hScore;
    }

    public DirectionEnum getDir() {
        return dir;
    }

    public GridNode getParent() {
        return parent;
    }

    public Grid getGrid() {
        return grid;
    }

    public int getgScore() {
        return gScore;
    }

    public int gettScore() {
        return tScore;
    }

    @Override
    public String toString() {
        return grid.toString();
    }
}
