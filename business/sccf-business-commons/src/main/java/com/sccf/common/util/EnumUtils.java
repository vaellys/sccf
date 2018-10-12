package com.sccf.common.util;

import com.baomidou.mybatisplus.enums.IEnum;
import com.sccf.common.enums.ISccfEnum;

/**
 * @author qianguobing
 * @date 2018-09-12 18:18
 */
public class EnumUtils {

    public static <T extends Enum<?> & ISccfEnum> T valueOf(Class<T> enumClass, Object value) {
        T[] es = enumClass.getEnumConstants();
        int len = es.length;

        for (int i = 0; i < len; ++i) {
            T e = es[i];
            if (((IEnum) e).getValue() == value) {
                return e;
            }

            if (value instanceof Number) {
                if (((IEnum) e).getValue() instanceof Number && ((Number) value).doubleValue() == ((Number) ((IEnum) e).getValue()).doubleValue()) {
                    return e;
                }
            } else if (String.valueOf(value).equals(String.valueOf(((IEnum) e).getValue()))) {
                return e;
            }
        }

        return null;
    }

    public static <T extends Enum<?> & ISccfEnum> String getEnumDesc(Class<T> enumClass, Object value) {
        ISccfEnum e = (ISccfEnum) valueOf(enumClass, value);
        return e == null ? null : e.getDesc();
    }
}
