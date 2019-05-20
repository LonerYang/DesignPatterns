package com.ahead.cor;

import java.util.ArrayList;
import java.util.List;

/**
 * 需求：模拟前台添加一条文章，后台对该文章的敏感词或脚本代码进行过滤
 * 		中间可以根据return的boolean决定是否继续过滤
 * @author Yang
 * @version 1.0
 * @time 2019/5/14
 */
public class Main {

	public static void main(String[] args) {
		Article article = new Article("大家好:), <script> 欢迎登录 yangrijian.top, 大家都是996");

		FilterChain filterChain = new FilterChain();

		FilterChain filterChain2 = new FilterChain();
		filterChain2.add(new FaceFilter());
		filterChain2.add(new Sensitive());

		filterChain.add(new HTMLFilter())
				.add(new DomainFilter())
				.add(filterChain2);

		filterChain.doFilter(article);

		System.out.println(article);
	}
}

interface Filter {
	boolean doFilter(Article article);
}

class HTMLFilter implements Filter {

	@Override
	public boolean doFilter(Article article) {
		String msg = article.getMsg();
		msg = msg.replace('<', '[');
		msg = msg.replace('>', ']');
		article.setMsg(msg);
		return true;
	}
}

class DomainFilter implements Filter {

	@Override
	public boolean doFilter(Article article) {
		String msg = article.getMsg();
		msg = msg.replace("yangrijian.top", "http://yangrijian.top");
		article.setMsg(msg);
		//检查完脚本代码就不需要过滤了，直接返回
		return false;
	}
}

class FaceFilter implements Filter {
	@Override
	public boolean doFilter(Article article) {
		String msg = article.getMsg();
		msg = msg.replace(":)", "^_^");
		article.setMsg(msg);
		return true;
	}
}

class Sensitive implements Filter {

	@Override
	public boolean doFilter(Article article) {
		String msg = article.getMsg();
		msg = msg.replace("996", "955");
		article.setMsg(msg);
		return true;
	}
}

/**
 * 拦截器链实现Filter接口，使其可以添加拦截器链
 */
class FilterChain implements Filter {
	List<Filter> filters = new ArrayList<>();

	@Override
	public boolean doFilter(Article article) {
		for (Filter filter : filters) {
			if (!filter.doFilter(article)) {
				return false;
			};
		}
		return true;
	}

	public FilterChain add(Filter filter) {
		filters.add(filter);
		return this;
	}
}
class Article {
	private String name;
	private String msg;

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getMsg() {
		return this.msg;
	}

	public Article(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "Article{" +
				"msg='" + msg + '\'' +
				'}';
	}
}
