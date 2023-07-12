package com.ezen.phonefly2.dto;

import java.sql.Timestamp;
import java.util.List;

import lombok.Data;

@Data
public class ProductVO {
	private Integer pseq;
	private String name;
	private Integer price1;
	private Integer price2;
	private Integer price3;
	private String content;
	private String useyn;
	private String eventyn;
	private String bestyn;
	private Timestamp indate;
	private String mfc;
	private List<ColorVO> colorList;
}
