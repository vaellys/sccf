package com.sccf.admin.controller;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.sccf.admin.entity.TSysUser;
import com.sccf.admin.service.ITSysUserService;
import com.sccf.api.feign.IUserFeignService;
import com.sccf.api.feign.dto.UserDto;
import com.sccf.common.util.Query;
import com.sccf.core.commons.base.RestBaseController;
import com.sccf.core.commons.base.RestResponse;
import com.sccf.core.commons.constants.GlobalConstant;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Map;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author SCCF
 * @since 2018-09-20
 */
@Api(value = "tSysUser", tags = "用户表")
@RestController
@RequestMapping("/demo")
public class TSysUserController extends RestBaseController {
    @Autowired private ITSysUserService tSysUserService;

    @Autowired
    IUserFeignService userFeignService;

    /**
    * 通过ID查询
    *
    * @param id ID
    * @return TSysUser
    */
    @ApiOperation(value = "通过ID查询", notes = "通过ID查询用户表")
    @ApiImplicitParam(name = "id", value = "Id", required = true, dataType = "String", paramType = "path")
    @GetMapping("/{id}")
    public RestResponse<Map<String, String>> get(@PathVariable String id) {
        UserDto userVo = new UserDto();
        userVo.setId(88);
        userVo.setUsername("zhangsafaf");
        userVo.setPassword("123456");
        RestResponse<Boolean> restResponse = userFeignService.add(userVo);
        if(HttpStatus.OK.value() != restResponse.getStatus()) {
            return wrap(HttpStatus.valueOf(restResponse.getStatus()), restResponse.getMessage());
        }
        return wrap(HttpStatus.OK, "添加成功");
    }


    /**
    * 分页查询信息
    *
    * @param params 分页对象
    * @return 分页对象
    */
    @ApiOperation(value = "分页查询", notes = "分页查询用户表")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "page", value = "页号", paramType = "query", dataType = "int", defaultValue = GlobalConstant.DEFAULT_PAGE_NUMBER_STRING),
            @ApiImplicitParam(name = "limit", value = "每页显示条数", paramType = "query", dataType = "int", defaultValue = GlobalConstant.DEFAULT_PAGE_SIZE_STRING),
            @ApiImplicitParam(name = "orderByField", value = "排序字段", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "isAsc", value = "是否为升序", paramType = "query", dataType = "Boolean"),
            @ApiImplicitParam(name = "userId", value = "主键ID", paramType = "query"),
            @ApiImplicitParam(name = "username", value = "用户名", paramType = "query"),
            @ApiImplicitParam(name = "password", value = "", paramType = "query"),
            @ApiImplicitParam(name = "openId", value = "openid", paramType = "query"),
            @ApiImplicitParam(name = "mobile", value = "手机号码", paramType = "query"),
            @ApiImplicitParam(name = "picUrl", value = "头像", paramType = "query"),
            @ApiImplicitParam(name = "statu", value = "0-正常，1-删除", paramType = "query"),
            @ApiImplicitParam(name = "deptId", value = "部门id", paramType = "query"),
            @ApiImplicitParam(name = "createTime", value = "创建时间", paramType = "query"),
            @ApiImplicitParam(name = "updateTime", value = "修改时间", paramType = "query"),
    })
    @GetMapping("/page")
    public RestResponse<Page<TSysUser>> page(@ApiIgnore @RequestParam Map<String, Object> params, @ApiIgnore TSysUser tSysUser) {
        return wrap(tSysUserService.selectPage(new Query<>(params), new EntityWrapper<>(tSysUser)));
    }

    /**
     * 添加
     * @param  tSysUser  实体
     * @return success/false
     */
    @ApiOperation(value = "添加", notes = "添加用户表")
    @ApiImplicitParams(value = {
        @ApiImplicitParam(name = "userId", value = "主键ID", dataType = "String", paramType = "query"),
        @ApiImplicitParam(name = "username", value = "用户名", dataType = "String", paramType = "query"),
        @ApiImplicitParam(name = "password", value = "", dataType = "String", paramType = "query"),
        @ApiImplicitParam(name = "openId", value = "openid", dataType = "String", paramType = "query"),
        @ApiImplicitParam(name = "mobile", value = "手机号码", dataType = "String", paramType = "query"),
        @ApiImplicitParam(name = "picUrl", value = "头像", dataType = "String", paramType = "query"),
        @ApiImplicitParam(name = "statu", value = "0-正常，1-删除", dataType = "String", paramType = "query"),
        @ApiImplicitParam(name = "deptId", value = "部门id", dataType = "String", paramType = "query"),
        @ApiImplicitParam(name = "createTime", value = "创建时间", dataType = "String", paramType = "query"),
        @ApiImplicitParam(name = "updateTime", value = "修改时间", dataType = "String", paramType = "query"),
    })
    @PostMapping
    public RestResponse<Boolean> add(@ApiIgnore @RequestBody TSysUser tSysUser) {
        return wrap(tSysUserService.insert(tSysUser));
    }

    /**
     * 删除
     * @param id ID
     * @return success/false
     */
    @ApiOperation(value = "删除", notes = "删除用户表")
    @ApiImplicitParam(name = "id", value = "用户表Id", required = true, dataType = "String", paramType = "path")
    @DeleteMapping("/{id}")
    public RestResponse<Boolean> delete(@PathVariable String id) {
        return wrap(tSysUserService.deleteById(id));
    }

    /**
     * 编辑
     * @param  tSysUser  实体
     * @return success/false
     */
    @ApiOperation(value = "编辑", notes = "编辑用户表")
    @ApiImplicitParams(value = {
        @ApiImplicitParam(name = "userId", value = "主键ID", dataType = "String", paramType = "query"),
        @ApiImplicitParam(name = "username", value = "用户名", dataType = "String", paramType = "query"),
        @ApiImplicitParam(name = "password", value = "", dataType = "String", paramType = "query"),
        @ApiImplicitParam(name = "openId", value = "openid", dataType = "String", paramType = "query"),
        @ApiImplicitParam(name = "mobile", value = "手机号码", dataType = "String", paramType = "query"),
        @ApiImplicitParam(name = "picUrl", value = "头像", dataType = "String", paramType = "query"),
        @ApiImplicitParam(name = "statu", value = "0-正常，1-删除", dataType = "String", paramType = "query"),
        @ApiImplicitParam(name = "deptId", value = "部门id", dataType = "String", paramType = "query"),
        @ApiImplicitParam(name = "createTime", value = "创建时间", dataType = "String", paramType = "query"),
        @ApiImplicitParam(name = "updateTime", value = "修改时间", dataType = "String", paramType = "query"),
    })
    @PutMapping
    public RestResponse<Boolean> edit(@ApiIgnore @RequestBody TSysUser tSysUser) {
        return wrap(tSysUserService.updateById(tSysUser));
    }
}
