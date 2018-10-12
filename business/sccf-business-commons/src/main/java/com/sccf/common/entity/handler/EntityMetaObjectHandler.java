package com.sccf.common.entity.handler;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

import java.util.Date;

/**
 * @author qianguobing
 * @date 2018-09-12 18:11
 */
public class EntityMetaObjectHandler extends MetaObjectHandler {

    public void insertFill(MetaObject metaObject) {
        Date d = new Date();
        this.setFieldValByName("addTime", d, metaObject);
        this.setFieldValByName("lastUpdateTime", d, metaObject);
        this.setFieldValByName("lastVersion", Integer.valueOf(0), metaObject);
    }

    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("lastUpdateTime", new Date(), metaObject);
    }

}
