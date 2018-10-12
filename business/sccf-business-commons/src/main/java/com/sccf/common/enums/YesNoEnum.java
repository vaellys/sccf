package com.sccf.common.enums;

/**
 * @author qianguobing
 * @date 2018-09-12 18:17
 */
public enum YesNoEnum implements ISccfEnum {
    NO(0, "否"),
    YES(1, "是");

    private int value;
    private String desc;

    private YesNoEnum(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public Integer getValue() {
        return this.value;
    }

    public String getDesc() {
        return this.desc;
    }
}
