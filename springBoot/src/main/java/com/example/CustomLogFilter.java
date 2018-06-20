package com.example;

import org.slf4j.MDC;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import javax.servlet.*;
import java.io.IOException;

public class CustomLogFilter implements Filter {

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		
		if(SecurityContextHolder.getContext() != null 
			&& SecurityContextHolder.getContext().getAuthentication() != null
			&& SecurityContextHolder.getContext().getAuthentication().getPrincipal() != null) {
		
			MDC.put("username", ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername());
		}

		if(arg2 != null) {
			arg2.doFilter(arg0, arg1);
		}
	}

	@Override
	public void destroy() {
		MDC.remove("username");
	}
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}
}