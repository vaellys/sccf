package com.sccf.common.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.Version;
import com.baomidou.mybatisplus.enums.FieldFill;

import java.io.Serializable;

/**
 * @author qianguobing
 * @date 2018-09-12 18:11
 */
public abstract class BaseEntity<T extends BaseEntity> extends Model<T> {

    @Version
    @TableField(
            value = "last_version",
            fill = FieldFill.INSERT
    )
    private Integer lastVersion;

    public BaseEntity() {
    }

    public abstract <T> T getId();

    protected Serializable pkVal() {
        return (Serializable) this.getId();
    }

    public Integer getLastVersion() {
        return this.lastVersion;
    }

    public void setLastVersion(Integer lastVersion) {
        this.lastVersion = lastVersion;
    }

}
