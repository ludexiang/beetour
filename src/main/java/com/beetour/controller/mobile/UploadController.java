package com.beetour.controller.mobile;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.beetour.util.UploadUtil;

@Controller
public class UploadController {

	/**
	 * 获取七牛上传token
	 * {"uptoken": "0MLvWPnyya1WtPnXFy9KLyGHyFPNdZceomL..."}
	 * @return
	 */
	@RequestMapping(value =  "uptoken",produces = MediaType.APPLICATION_JSON_UTF8_VALUE,method = RequestMethod.GET)
	@ResponseBody
	public String token(){		
		String upToken = "{\"uptoken\": \"" + UploadUtil.getUpToken() + "\"}";
		return upToken;
	}
}
