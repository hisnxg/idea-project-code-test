package com.nxg.rabbitmq.enumType;

/**
 * @author nxg
 * date 2022/3/26
 * @apiNote
 */
public enum ThemeRecommendation {

    /**
     * 上榜酒店
     * 地铁周边
     * 电竞酒店
     * 情侣约会
     * 亲子酒店
     * 展览周边
     */
    TOP_HOTELS(1,"上榜酒店"),
    AROUND_THE_METRO(2,"地铁周边"),
    GAMING_HOTELS(3,"电竞酒店"),
    COUPLES_DATING(4,"情侣约会"),
    PARENT_CHILD_HOTELS(5,"亲子酒店"),
    AROUND_THE_EXHIBITION(6,"展览周边");

    private int code;
    private String  message;

    ThemeRecommendation(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
