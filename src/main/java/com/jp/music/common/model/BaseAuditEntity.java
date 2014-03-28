package com.jp.music.common.model;

import java.util.Date;


public abstract class BaseAuditEntity extends BaseEntity {
	
	private String createdBy;
	
	private String modifiedBy;
	
	private Date createdOn;
	
	private Date modifiedOn;
}
