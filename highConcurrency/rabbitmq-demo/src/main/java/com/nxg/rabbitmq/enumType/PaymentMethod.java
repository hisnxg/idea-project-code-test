package com.nxg.rabbitmq.enumType;

/**
 * @author nxg
 * date 2022/3/26
 * @apiNote 支付方式
 */
public enum PaymentMethod {
    /**
     * 支付方式
     * 在线付
     * 到店付
     * 先住后付
     * 免担保金
     */
    PAY_ONLINE(1,"在线付"),
    IN_STORE(2,"到店付"),
    STAY_AND_PAY_LATER(3,"先住后付"),
    NO_SECURITY_DEPOSIT(4,"免担保金");


    private int code;
    private String  message;

    PaymentMethod(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
