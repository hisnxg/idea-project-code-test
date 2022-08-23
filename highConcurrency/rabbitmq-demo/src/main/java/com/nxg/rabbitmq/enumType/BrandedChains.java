package com.nxg.rabbitmq.enumType;

/**
 * @author nxg
 * date 2022/3/26
 * @apiNote 品牌连锁
 */
public enum BrandedChains {
    POPULAR(1,"热门"), Economy(2,"经济"),
    COMFORT(3,"舒适"),Upscale(4,"高档"),Luxury(5,"豪华");

    private int code;
    private String  message;

    BrandedChains(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
