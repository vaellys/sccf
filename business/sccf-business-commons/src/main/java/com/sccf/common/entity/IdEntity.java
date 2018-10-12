package com.sccf.common.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * @author qianguobing
 * @date 2018-09-12 18:15
 */
public class IdEntity<T extends IdEntity> extends Model<T> {

    @TableId(
            value = "id",
            type = IdType.UUID
    )
    private String id;

    public IdEntity() {
    }

    protected Serializable pkVal() {
        return this.id;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
