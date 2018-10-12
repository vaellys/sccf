package com.sccf.common.enums;

/**
 * @author qianguobing
 * @date 2018-09-20 14:50
 */
public enum ValidRecordEnum implements ISccfEnum {

    DISABLED(0, "保留(弃用)"),
    NORMAL(1, "有效(启用)"),
    DELETE(9, "无效(删除)");

    private int value;
    private String desc;

    ValidRecordEnum(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public Integer getValue() {
        return Integer.valueOf(this.value);
    }

    public String getDesc() {
        return this.desc;
    }
}
