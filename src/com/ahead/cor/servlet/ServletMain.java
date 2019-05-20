package com.ahead.cor.servlet;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yang
 * @version 1.0
 * @time 2019/5/14
 */
public class ServletMain {
	public static void main(String[] args) {
		FilterChain chain = new FilterChain();
		chain.add(new HTMLFilter()).add(new DomainFilter());
		Request request = new Request();
		Response response = new Response();
		request.str = "大家好:), <script> 欢迎登录 yangrijian.top, 大家都是996";
		response.str = "response";
		chain.doFilter(request, response, chain);

		System.out.println(request.str);
		System.out.println(response.str);
	}
}

interface Filter {
	boolean doFilter(Request request, Response response, FilterChain chain);
}

class HTMLFilter implements Filter {

	@Override
	public boolean doFilter(Request request, Response response, FilterChain chain) {
		System.out.println("HTMLFilter chain.doFilter之前");

		request.str = request.str.replace("<", "[");
		request.str = request.str.replace(">", "]");
		chain.doFilter(request, response, chain);
		response.str += " HTMLFilter ";

		System.out.println("HTMLFilter chain.doFilter之后");
		return true;
	}
}

class DomainFilter implements Filter {

	@Override
	public boolean doFilter(Request request, Response response, FilterChain chain) {
		System.out.println("DomainFilter chain.doFilter之前");

		request.str = request.str.replace("yangrijian.top", "http://yangrijian.top");
		chain.doFilter(request, response, chain);
		response.str += " DomainFilter ";

		System.out.println("DomainFilter chain.doFilter之后");
		return false;
	}
}


/**
 * 拦截器链实现Filter接口，使其可以添加拦截器链
 */
class FilterChain implements Filter {
	List<Filter> filters = new ArrayList<>();
	int i;

	@Override
	public boolean doFilter(Request request, Response response, FilterChain chain) {
		if (i == filters.size()) {
			return false;
		}
		chain.filters.get(i++).doFilter(request, response, chain);
		return true;
	}

	public FilterChain add(Filter filter) {
		filters.add(filter);
		return this;
	}
}

class Request {
	String str;
}

class Response {
	String str;
}

