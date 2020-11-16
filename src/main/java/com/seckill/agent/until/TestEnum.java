package com.seckill.agent.until;

/**
 * 测试枚举类
 *
 * @author gaoFan
 * @version V1.0
 * @date 2020/11/13 13:51
 */


public enum TestEnum {

    LIVE_STATUS_LIVE("200","直播中"),
    LIVE_STATUS_NOT_BROADCAST("100","待播"),
    LIVE_STATUS_BROADCAST("300","已播"),
    LIVE_STATUS_CANCEL("400","取消"),
    ;

    TestEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private final String code;
    private final String desc;


    public static String value(String typeName) {
        for (TestEnum type : TestEnum.values()) {
            if (type.getCode().equals(typeName)) {
                return type.getDesc();
            }
        }
        return null;
    }


    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
