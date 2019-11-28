package com.carter.common;

import java.util.HashMap;
import java.util.List;


public class ResponseBo extends HashMap<String, Object>{

	private static final long serialVersionUID = -8713837118340960775L;

	// 成功
	private static final Integer SUCCESS = 200;
	// 警告
	private static final Integer WARN = 1;
	// 异常 失败
	private static final Integer FAIL = 500;

	public ResponseBo() {
		put("code", SUCCESS);
		put("message", "操作成功");
	}

	public static ResponseBo success(Integer code, Object message, Object data){
		ResponseBo responseBo = new ResponseBo();
		responseBo.put("code", code);
		responseBo.put("message", message);
		responseBo.put("data", data);
		return responseBo;
	}

	public static ResponseBo error(Integer code, Object message) {
		ResponseBo responseBo = new ResponseBo();
		responseBo.put("code", code);
		responseBo.put("message", message);
		return responseBo;
	}

	public static ResponseBo list(Integer code, Object message, long total, List<?> data) {
		ResponseBo responseBo = new ResponseBo();
		responseBo.put("code", code);
		responseBo.put("message", message);
		responseBo.put("total", total);
		responseBo.put("data", data);
		return responseBo;
	}

	@Override
	public ResponseBo put(String key, Object value) {
		super.put(key, value);
		return this;
	}
}
