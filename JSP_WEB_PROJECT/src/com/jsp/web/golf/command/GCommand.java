package com.jsp.web.golf.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface GCommand {
	public void execute(HttpServletRequest request, HttpServletResponse response);
}
