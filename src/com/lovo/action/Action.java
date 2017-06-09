package com.lovo.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 处理用户请求的控制器接口
 * @author 叶玉林
 *
 */
public interface Action {

	public ActionResult execute(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException;
}
