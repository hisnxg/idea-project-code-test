package com.nxg.rabbitmq.enumType;

/**
 * @author nxg
 * date 2022/3/26
 * @apiNote
 */
public enum AccommodationType {
    /**
     * 钟点房
     * 民宿房
     * 青年旅社
     * 特色住宿
     * 公寓
     * 农家乐
     * 别墅
     * 客栈
     */
    BELL_ROOM(1,"钟点房"),
    ROOM(2,"民宿房"),
    YOUTH_HOSTEL(3,"青年旅社"),
    SPECIALITY_ACCOMMODATION(4,"特色住宿"),
    FLATS(5,"公寓"),
    FARM_HOUSE(6,"农家乐"),
    COTTAGES(7,"别墅"),
    GUEST_HOUSE(8,"客栈");

    private int code;
    private String  message;

    AccommodationType(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
