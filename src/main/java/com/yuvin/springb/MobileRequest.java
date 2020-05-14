package com.yuvin.springb;

import com.yuvin.springb.model.Lob;

import lombok.Data;

@Data
public class MobileRequest {
	
	private String name;
	
	private Integer price;
	
	private String status;
	
	private String lob;
	
	private String date;

}
