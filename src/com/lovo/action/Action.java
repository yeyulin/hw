package com.lovo.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * �����û�����Ŀ������ӿ�
 * @author Ҷ����
 *
 */
public interface Action {

	public ActionResult execute(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException;
}
