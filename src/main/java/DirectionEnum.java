/***
 * 八方向
 *
 * qiunet
 * 2021/9/6 10:01
 **/
public enum DirectionEnum {
    L('←', -1, 0, DirectionEnum.L_R_U_D_LEN),
    R('→', 1, 0, DirectionEnum.L_R_U_D_LEN),
    U('↑', 0, 1, DirectionEnum.L_R_U_D_LEN),
    D('↓', 0, -1, DirectionEnum.L_R_U_D_LEN),
    LU('↖', -1, 1, DirectionEnum.LU_LD_RU_RD_LEN),
    LD('↙', -1, -1, DirectionEnum.LU_LD_RU_RD_LEN),
    RU('↗', 1, 1, DirectionEnum.LU_LD_RU_RD_LEN),
    RD('↘', 1, -1, DirectionEnum.LU_LD_RU_RD_LEN),
    ;
    /**
     * 上下左右的方向长度
     */
    public static final int L_R_U_D_LEN = 10;
    /**
     * 斜方向的长度
     */
    public static final int LU_LD_RU_RD_LEN = 14;

    private final char desc;
    private final int xDiff;
    private final int yDiff;
    private final int score;
    DirectionEnum(char desc, int xDiff, int yDiff, int score) {
        this.desc = desc;
        this.xDiff = xDiff;
        this.yDiff = yDiff;
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public char getDesc() {
        return desc;
    }

    public Grid getNext(MapData mapData, Grid grid) {
        return mapData.get(grid.getX() + this.xDiff, grid.getY() + this.yDiff);
    }
}
