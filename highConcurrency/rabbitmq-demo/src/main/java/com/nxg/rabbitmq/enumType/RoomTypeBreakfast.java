package com.nxg.rabbitmq.enumType;

/**
 * @author nxg
 * date 2022/3/26
 * @apiNote
 */
public enum RoomTypeBreakfast {
    /**
     * 房型
     * 双床
     * 大床
     * 圆床
     * 电动床
     * 水床
     * 单人床
     * 多张床
     * 榻榻床
     */
    DOUBLE_BED(1,"双床"),
    KINGSIZE_BED(2,"大床"),
    ROUNDBED(3,"圆床"),
    ELECTRIC_BED(4,"电动床"),
    WATE_BEDS(5,"水床"),
    SINGLE_BEDS(6,"单人床"),
    MULTI_BED(7,"多张床"),
    TATAMI_BED(8,"榻榻床");


    private int code;
    private String  message;

    RoomTypeBreakfast(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
