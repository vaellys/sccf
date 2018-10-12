package com.sccf.admin.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.sccf.common.entity.DataEntity;
import com.sccf.core.commons.validator.group.AddGroup;
import com.sccf.core.commons.validator.group.UpdateGroup;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.NotBlank;

import java.util.Date;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author SCCF
 * @since 2018-09-20
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_sys_user")
public class TSysUser extends DataEntity<TSysUser> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.UUID)
    private Integer id;
    /**
     * 用户名
     */
    @NotBlank(message = "姓名不能为空", groups = {AddGroup.class, UpdateGroup.class})
    private String username;
    private String password;
    /**
     * openid
     */
    @TableField("open_id")
    private String openId;
    /**
     * 手机号码
     */
    private String mobile;
    /**
     * 头像
     */
    @TableField("pic_url")
    private String picUrl;
    /**
     * 0-正常，1-删除
     */
    private Integer statu;
    /**
     * 部门id
     */
    @TableField("dept_id")
    private Integer deptId;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;
    /**
     * 修改时间
     */
    @TableField("update_time")
    private Date updateTime;


}
