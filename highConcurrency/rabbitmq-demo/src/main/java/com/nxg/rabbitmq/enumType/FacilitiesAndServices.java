package com.nxg.rabbitmq.enumType;

/**
 * @author nxg
 * date 2022/3/26
 * @apiNote
 */
public enum FacilitiesAndServices {
    /**
     * 接机服务
     * 穿梭机场班车
     * 每日打扫
     * 代客泊车
     * 洗衣服务
     * 行李寄存
     * 叫醒服务
     */
    AIRPORT_PICK_UP_SERVICE(1,"接机服务"),
    SHUTTLE_BUS_SERVICE_TO_AND_FROM_THE_AIRPORT(2,"穿梭机场班车"),
    DAILY_CLEANING(3,"每日打扫"),
    VALET_PARKING(4,"代客泊车"),
    LAUNDRY_SERVICE(5,"洗衣服务"),
    LUGGAGE_STORAGE(6,"行李寄存"),
    WAKE_UP_CALL_SERVICE(7,"叫醒服务");

    private int code;
    private String  message;

    FacilitiesAndServices(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
