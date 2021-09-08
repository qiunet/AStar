import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Sets;

import java.util.PriorityQueue;
import java.util.Set;

/***
 *
 *
 * qiunet
 * 2021/9/4 08:13
 **/
public class OpenSet {
    // 优先分数小的. 分数一样. 优先上下左右方向. 再斜方向
    private final PriorityQueue<GridNode> queue = new PriorityQueue<>(128, (o1, o2) -> ComparisonChain.start().compare(o1.gettScore() , o2.gettScore()).result());
    /**
     * 已经加入过的
     */
    private final Set<Grid> opened = Sets.newHashSet();

    public void add(GridNode grid) {
        this.opened.add(grid.getGrid());
        this.queue.add(grid);
    }

    public boolean contains(Grid grid) {
        return opened.contains(grid);
    }

    public GridNode get(Grid grid) {
        if (! this.contains(grid)) {
            return null;
        }
        for (GridNode gridNode : queue) {
            if (gridNode.getGrid().equals(grid)) {
                return gridNode;
            }
        }
        return null;
    }

    public int size(){
        return queue.size();
    }
    /**
     * 获得最小总值的节点
     */
    public GridNode chooserNode(){
        return this.queue.poll();
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }
}
