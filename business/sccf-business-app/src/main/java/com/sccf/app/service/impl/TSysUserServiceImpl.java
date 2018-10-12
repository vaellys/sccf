package com.sccf.app.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.sccf.app.entity.TSysUser;
import com.sccf.app.mapper.TSysUserMapper;
import com.sccf.app.service.ITSysUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author SCCF
 * @since 2018-09-20
 */
@Service
public class TSysUserServiceImpl extends ServiceImpl<TSysUserMapper, TSysUser> implements ITSysUserService {

}
