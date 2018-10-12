package com.sccf.api.feign;

import com.sccf.api.feign.fallback.UserServiceFallbackImpl;
import com.sccf.api.feign.dto.UserDto;
import com.sccf.core.commons.base.RestResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 用户信息服务调用实现
 */
@FeignClient(name = "sccf-business-admin", fallback = UserServiceFallbackImpl.class)
public interface IUserFeignService {


	/**
	 * 添加用户
	 *
	 * @param userVo
	 * @return Map
	 */
	@PostMapping("/user")
	RestResponse<Boolean> add(@RequestBody UserDto userDto);

	/**
	 * 删除用户
	 *
	 * @param id
	 * @return
	 */
	@DeleteMapping("/user/{id}")
	RestResponse<Boolean> delete(@PathVariable("id") String id);

	/**
	 * 修改用户
	 *
	 * @param userDto
	 * @return
	 */
	@PutMapping("/user")
	RestResponse<Boolean> edit(@RequestBody UserDto userDto);

	/**
	 * 查询获得用户信息最新的版本号
	 *
	 * @param id 用户Id
	 * @return
	 */
	@GetMapping("/user/lastversion/{id}")
	RestResponse<Map<String, Integer>> getLastVersion(@PathVariable("id") String id);
}
