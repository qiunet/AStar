import com.google.common.collect.Sets;

import java.util.Set;

/***
 * 游戏地图工具类
 *
 * qiunet
 * 2021/9/6 10:23
 **/
public class GameMapUtil {
    /**
     * 寻找路径
     * @param mapData 地图数据
     * @param fx from x
     * @param fy from y
     * @param tx to x
     * @param ty to y
     */
    public static FinalPath findPath(MapData mapData, int fx, int fy, int tx, int ty) {
        Grid start = mapData.get(fx, fy);
        Grid end = mapData.get(tx, ty);

        OpenSet openSet = new OpenSet();
        Set<Grid> closed = Sets.newHashSet();

        openSet.add(new GridNode(null, start, null, 0, hScore(start, end)));
        while (! openSet.isEmpty()) {
            GridNode gridNode = openSet.chooserNode();
            closed.add(gridNode.getGrid());

            for (DirectionEnum dir : DirectionEnum.values()) {
                Grid next = dir.getNext(mapData, gridNode.getGrid());
                if (next == null) {
                    continue;
                }

                if (closed.contains(next)) {
                    continue;
                }

                if (next.isBlock()) {
                    closed.add(next);
                    continue;
                }

                int currGScore = gridNode.getgScore() + dir.getScore();
                int currHScore = hScore(next, end);
                int currFScore = currGScore + currHScore;
                GridNode existNode = openSet.get(next);
                // 其它节点过来. 如果分数比现有的低. 则继续添加. 可以不移除.
                if (existNode != null && currFScore >= existNode.gettScore()) {
                    continue;
                }

                GridNode nextNode = new GridNode(gridNode, next, dir, currGScore, currHScore);
                if (next.equals(end)) {
                    return FinalPath.valueOf(nextNode);
                }
                openSet.add(nextNode);
            }
        }
        return null;
    }

    /**
     * 计算预估的分数
     * @param fGrid
     * @param tGrid
     * @return
     */
    private static int hScore(Grid fGrid, Grid tGrid){
        /*
         * 可以斜走. 就是等边三角形的腰(两边短的那个). + 差值
         * 这样的计算 比计算斜边长度好点. 都是int的计算. 不涉及浮点数开方.
         */
        int xDiff = Math.abs(tGrid.getX() - fGrid.getX());
        int yDiff = Math.abs(tGrid.getY() - fGrid.getY());
        return Math.min(xDiff, yDiff) * DirectionEnum.LU_LD_RU_RD_LEN
                + Math.abs(xDiff - yDiff) * DirectionEnum.L_R_U_D_LEN;
    }
}
