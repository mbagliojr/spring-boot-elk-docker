package com.example;

import org.slf4j.MDC;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import javax.servlet.*;
import java.io.IOException;

public class CustomLogFilter implements Filter {

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		
		MDC.put("username", SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
		MDC.put("password", SecurityContextHolder.getContext().getAuthentication().getCredentials().toString());

		if(arg2 != null) {
			arg2.doFilter(arg0, arg1);
		}
	}

	@Override
	public void destroy() {
		MDC.remove("username");
		MDC.remove("password");
	}
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}
}