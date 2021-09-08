import com.google.common.collect.Lists;

import java.util.List;
import java.util.Stack;

/***
 *
 * 可能输出是其它. 这里保存的是node. 而不是直接的方向数组.
 *
 * qiunet
 * 2021/9/6 10:03
 **/
public class FinalPath {

    private final Stack<GridNode> paths = new Stack<>();

    public static FinalPath valueOf(GridNode end) {
        FinalPath finalPath = new FinalPath();
        finalPath.add(end);

        GridNode p = end;
        while ((p = p.getParent()) != null) {
            // 起点的parent 为null
            if (p.getParent() != null) {
                finalPath.add(p);
            }
        }
        return finalPath;
    }

    public void add(GridNode node) {
        paths.add(node);
    }

    /**
     * 获取最终从起点到终点的每一步走向
     * @return list
     */
    public List<DirectionEnum> buildPath() {
        List<DirectionEnum> finalPath = Lists.newArrayListWithCapacity(paths.size());
        while (! paths.isEmpty()) {
            finalPath.add(paths.pop().getDir());
        }
        return  finalPath;
    }
}
