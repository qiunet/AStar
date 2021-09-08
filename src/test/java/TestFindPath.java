import org.junit.Test;

/***
 *
 *
 * qiunet
 * 2021/9/8 08:58
 **/
public class TestFindPath {
    private static final MapData mapData = new MapData(new int[][]
            {
                    {1,  0,  0,  1,  0,  0,  0,  0,  0,  0},
                    {0,  0,  0,  1,  0,  0,  4,  0,  0,  0},
                    {0,  0,  0,  1,  0,  0,  0,  0,  0,  0},
                    {0,  0,  0,  1,  0,  0,  0,  0,  0,  0},
                    {1,  0,  0,  1,  1,  0,  0,  0,  0,  0},
                    {0,  0,  0,  0,  1,  0,  0,  0,  0,  0},
                    {0,  0,  0,  0,  1,  0,  0,  0,  0,  0},
                    {0,  0,  0,  0,  1,  0,  0,  0,  0,  0},
                    {0,  0,  2,  0,  1,  0,  0,  0,  0,  0},
                    {1,  0,  0,  0,  0,  0,  0,  0,  0,  0},
            });
    @Test
    public void test(){
        FinalPath finalPath = GameMapUtil.findPath(mapData, 2, 1, 6, 8);
        if (finalPath == null) {
            System.out.println("没有合适的路径");
            return;
        }
        for (DirectionEnum directionEnum : finalPath.buildPath()) {
            System.out.print(directionEnum.getDesc()+"\t");
        }
        System.out.println();
    }
}
