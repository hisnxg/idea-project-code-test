package com.nxg.rabbitmq.enumType;

/**
 * @author nxg
 * date 2022/3/26
 * @apiNote 特殊要求
 */
public enum SpecialRequirements {
    /**
     *
     * 免费取消
     * 同程直销
     * 立即确认
     * 含礼包
     * 酒店套餐
     * 接待宾客
     * 可开专票
     * 预约发票
     */

    FREE_CANCELLATION(1,"免费取消"),
    DIRECT_SALES(2,"同程直销"),
    CONFIRM_NOW(3,"立即确认"),
    INCLUSIVE_PACKAGE(4,"含礼包"),
    HOTEL_PACKAGES(5,"酒店套餐"),
    HOSPITALITY(6,"接待宾客"),
    INVOICING_AVAILABLE(7,"可开专票"),
    RESERVATION_INVOICE(8,"预约发票");

    private int code;
    private String  message;

    SpecialRequirements(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
