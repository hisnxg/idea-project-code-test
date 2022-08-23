package com.nxg.rabbitmq.enumType;

/**
 * @author nxg
 * date 2022/3/26
 * @apiNote  价格星级
 */
public enum star {

    /**
     * 经济
     * 三星/舒适
     * 四星/高档
     * 五星/豪华
     */
    ECONOMY(1,"经济"),
    THREE_STARS_COMFORT(2,"三星/舒适"),
    FOUR_STAR_PREMIUM(5,"四星/高档"),
    FIVE_STAR_DELUXE(4,"五星/豪华");


    private int code;
    private String  message;

    star(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
