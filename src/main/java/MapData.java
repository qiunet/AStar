/***
 * 地图设定数据.
 * 以左下角为原点
 *
 * qiunet
 * 2021/9/4 08:13
 **/
public class MapData {

    private final Grid [][] data;

    public MapData(int [][] mapDatas) {
        // 一般是正方形. 长方形. 不会是奇形怪状
        data = new Grid[mapDatas.length][mapDatas[0].length];
        for (int i = 0; i < mapDatas.length; i++) {
            int[] mapData = mapDatas[i];
            for (int x = 0; x < mapData.length; x++) {
                int y = mapDatas.length - 1 - i;
                data[x][y] = new Grid(x, y, mapData[x]);
            }
        }
    }

    public Grid get(int x, int y) {
        if (x < 0 || x >= data.length) {
            return null;
        }
        if (y < 0 || y >= data[0].length) {
            return null;
        }
        return data[x][y];
    }
}
