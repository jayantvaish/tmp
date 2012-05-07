package com.intalio.bpms.taskmanager.vo;

public class ClaimTaskResponseVO {
	private String status;

	public ClaimTaskResponseVO() {
		super();
	}

	public ClaimTaskResponseVO(String status) {
		super();
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ClaimTaskResponseVO [status=" + status + "]";
	}
	
}
