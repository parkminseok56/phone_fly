package com.ezen.phonefly2.dto;


import java.sql.Timestamp;

import lombok.Data;

@Data
public class BannerVO {
	private int bseq;
	private String subject;
	private int order_seq;
	private String useyn;
	private Timestamp indate;
	private String video;
	private String btitle;
	private String btext;
	private String top;
	private String left;
}
