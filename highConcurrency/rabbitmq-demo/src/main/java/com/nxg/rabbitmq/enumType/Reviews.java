package com.nxg.rabbitmq.enumType;

/**
 * @author nxg
 * date 2022/3/26
 * @apiNote 点评
 */
public enum Reviews {
    NO_LIMIT(0,"不限"),
    LOW(20,"3.5分以上"),
    MEDIUM(50,"4.0分以上"),
    HIGH(100,"4.5分以上"),
    HIGHER(200,"4.8分以上");

    private int code;
    private String  message;

    Reviews(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
