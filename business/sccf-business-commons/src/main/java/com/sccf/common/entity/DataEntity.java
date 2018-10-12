package com.sccf.common.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;

import java.util.Date;

/**
 * @author qianguobing
 * @date 2018-09-12 18:14
 */
public abstract class DataEntity<T extends DataEntity> extends BaseEntity<T> {

    @TableField(
            value = "add_time",
            fill = FieldFill.INSERT
    )
    private Date addTime;
    @TableField(
            value = "last_updated_time",
            fill = FieldFill.INSERT_UPDATE
    )
    private Date lastUpdateTime;

    public DataEntity() {
    }

    public Date getAddTime() {
        return this.addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getLastUpdateTime() {
        return this.lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }
}
