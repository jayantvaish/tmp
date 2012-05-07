package com.intalio.bpms.taskmanager.vo;

import java.util.Date;

public class AttachmentMetadataVO {
	private String mimeType;
	private String fileName;
	private String title;
	private String description;
	private Date creationDate;
	
	public AttachmentMetadataVO() {
		super();
	}

	public AttachmentMetadataVO(String mimeType, String fileName, String title,
			String description, Date creationDate) {
		super();
		this.mimeType = mimeType;
		this.fileName = fileName;
		this.title = title;
		this.description = description;
		this.creationDate = creationDate;
	}

	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@Override
	public String toString() {
		return "AttachmentMetadataVO [mimeType=" + mimeType + ", fileName="
				+ fileName + ", title=" + title + ", description="
				+ description + ", creationDate=" + creationDate + "]";
	}
	
	

}
