import java.util.Objects;

/***
 * 地图设定的格子.
 * 加载上的. 不再变动
 *
 * qiunet
 * 2021/9/4 08:13
 **/
public class Grid {

    /**
     * 不可走
     */
    private static final int block = 1;

    private final int x;
    private final int y;

    private final byte status;

    public Grid(int x, int y, int status) {
        this.x = x;
        this.y = y;
        this.status = (byte) status;
    }

    public boolean isBlock(){
        return (status & block) == block;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "("+x+", "+y+")["+status+"]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grid grid = (Grid) o;
        return x == grid.x && y == grid.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
