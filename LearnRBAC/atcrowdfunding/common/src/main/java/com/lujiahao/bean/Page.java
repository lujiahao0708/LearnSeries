package com.lujiahao.bean;

import lombok.Data;

import java.util.List;

@Data
public class Page<T> {

	private List<T> datas;
	private int pageno;
	private int totalno;
	private int totalsize;

	
}
