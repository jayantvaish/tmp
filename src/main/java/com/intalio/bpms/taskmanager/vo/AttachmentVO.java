package com.intalio.bpms.taskmanager.vo;

public class AttachmentVO {
	
	private AttachmentMetadataVO attachmentMetadata;
	private String payloadUrl;
	
	public AttachmentVO() {
		super();
	}

	public AttachmentVO(AttachmentMetadataVO attachmentMetadata,
			String payloadUrl) {
		super();
		this.attachmentMetadata = attachmentMetadata;
		this.payloadUrl = payloadUrl;
	}

	public AttachmentMetadataVO getAttachmentMetadata() {
		return attachmentMetadata;
	}

	public void setAttachmentMetadata(AttachmentMetadataVO attachmentMetadata) {
		this.attachmentMetadata = attachmentMetadata;
	}

	public String getPayloadUrl() {
		return payloadUrl;
	}

	public void setPayloadUrl(String payloadUrl) {
		this.payloadUrl = payloadUrl;
	}

	@Override
	public String toString() {
		return "AttachmentVO [attachmentMetadata=" + attachmentMetadata
				+ ", payloadUrl=" + payloadUrl + "]";
	}
	
	

}
