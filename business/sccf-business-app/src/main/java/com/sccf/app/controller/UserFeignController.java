package com.sccf.app.controller;


import com.sccf.api.feign.dto.UserDto;
import com.sccf.app.entity.TSysUser;
import com.sccf.app.service.ITSysUserService;
import com.sccf.core.commons.base.RestBaseController;
import com.sccf.core.commons.base.RestResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author qianguobing
 * @date 2018-09-15 17:07
 */

@RequestMapping("/user")
@RestController
public class UserFeignController extends RestBaseController {

    @Autowired
    private ITSysUserService tSysUserService;

    /**
     * 删除
     * @param id ID
     * @return success/false
     */
    @DeleteMapping("/{id}")
    public RestResponse<Boolean> delete(@PathVariable String id) {
        return wrap(tSysUserService.deleteById(id));
    }

    @PostMapping
    public RestResponse<Boolean> add(@RequestBody UserDto userVo) {
        TSysUser tSysUser = new TSysUser();
        BeanUtils.copyProperties(userVo, tSysUser);
        boolean result = tSysUserService.insert(tSysUser);
        return wrap(result);

    }

}
