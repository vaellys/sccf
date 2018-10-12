package com.sccf.core.commons;

import com.sccf.core.commons.constants.RConstant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 响应信息主体
 *
 * @author liuweijw
 */
@Data
@ToString
@ApiModel(description = "请求返回封装")
public class R<T> implements Serializable {

	private static final long	serialVersionUID	= -6043162591645086533L;

	@ApiModelProperty(value = "返回提示语信息，默认'success'")
	private String				msg					= RConstant.SUCCESS_MSG;

	@ApiModelProperty(value = "返回编码：0 成功")
	private int					code				= RConstant.SUCCESS;

	@ApiModelProperty(value = "返回业务数据")
	private T					data;

	public R() {
		super();
	}

	public R<T> success() {
		this.code = RConstant.SUCCESS;
		return this;
	}

	public R<T> success(String msg) {
		this.code = RConstant.SUCCESS;
		this.msg = msg;
		return this;
	}

	public R<T> failure() {
		this.code = RConstant.FAIL;
		return this;
	}

	public R<T> failure(String msg) {
		this.code = RConstant.FAIL;
		this.msg = msg;
		return this;
	}

	public R<T> failure(Throwable e) {
		this.msg = e.getMessage();
		this.code = RConstant.FAIL;
		return this;
	}

	public R<T> code(int code) {
		this.code = code;
		return this;
	}

	public R<T> data(T data) {
		this.data = data;
		return this;
	}

	public static R<String> of(final String msg, final int code) {
		return new R<String>().code(code).failure(msg);
	}

}
