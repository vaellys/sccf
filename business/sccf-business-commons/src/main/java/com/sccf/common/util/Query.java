package com.sccf.common.util;

import com.baomidou.mybatisplus.plugins.Page;
import org.apache.commons.lang.StringUtils;

import java.util.Map;

/**
 * @author qianguobing
 * @date 2018-09-12 18:23
 */
public class Query<T> extends Page<T> {
    private static final String PAGE = "page";
    private static final String LIMIT = "limit";
    private static final String ORDER_BY_FIELD = "orderByField";
    private static final String IS_ASC = "isAsc";

    public Query(Map<String, Object> params) {
        super(Integer.parseInt(params.getOrDefault("page", Integer.valueOf(1)).toString()), Integer.parseInt(params.getOrDefault("limit", Integer.valueOf(20)).toString()));
        String orderByField = params.getOrDefault("orderByField", "").toString();
        if (StringUtils.isNotEmpty(orderByField)) {
            this.setOrderByField(orderByField);
        }

        Boolean isAsc = Boolean.parseBoolean(params.getOrDefault("isAsc", Boolean.TRUE).toString());
        this.setAsc(isAsc.booleanValue());
        params.remove("page");
        params.remove("limit");
        params.remove("orderByField");
        params.remove("isAsc");
    }
}
