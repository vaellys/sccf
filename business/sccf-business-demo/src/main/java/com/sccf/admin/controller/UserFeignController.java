package com.sccf.admin.controller;

import com.sccf.admin.service.ITSysUserService;
import com.sccf.core.commons.base.RestBaseController;
import com.sccf.core.commons.base.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
