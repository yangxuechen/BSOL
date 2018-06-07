package com.bsol.hss.bean;

import java.util.List;

public class Page {
	private int pagenum;//当前页面
	private int pagesize;//页面大小
	private List list;//页面数据
	public int getPagenum() {
		return pagenum;
	}
	public void setPagenum(int pagenum) {
		this.pagenum = pagenum;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	
}
