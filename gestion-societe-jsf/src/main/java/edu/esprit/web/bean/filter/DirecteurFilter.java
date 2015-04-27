package edu.esprit.web.bean.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tn.esprit.bean.LoginBean;

@WebFilter("/pages/directeur/*")
public class DirecteurFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest reuest, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest servletRequest = (HttpServletRequest) reuest;
		HttpServletResponse servletResponse = (HttpServletResponse) response;
		LoginBean bean = (LoginBean) servletRequest.getSession().getAttribute(
				"loginBean");
		if (bean != null && bean.getRole().equals("Directeur")) {
			chain.doFilter(servletRequest, servletResponse);
		} else
			servletResponse.sendRedirect(servletRequest.getContextPath()
					+ "/public/login.jsf");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
