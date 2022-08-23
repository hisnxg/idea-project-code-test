package com.nxg.rabbitmq.enumType;

/**
 * @author nxg
 * date 2022/3/26
 * @apiNote 住客印象
 */
public enum GuestImpressions {
    /**
     * 服务态度好
     * 早餐好
     * 性价比高
     * 位置好
     * 去机场方便
     * 隔音效果好
     */

    GOOD_SERVICE(1,"服务态度好"),
    GOOD_BREAKFAST(2,"早餐好"),
    GOOD_VALUE_FOR_MONEY(3,"性价比高"),
    GOOD_LOCATION(4,"位置好"),
    EASY_ACCESS_TO_THE_AIRPORT(5,"去机场方便"),
    GOOD_SOUND_INSULATION(6,"隔音效果好");

    private int code;
    private String  message;

    GuestImpressions(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
