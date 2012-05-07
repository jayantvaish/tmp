package com.intalio.bpms.taskmanager.vo;

public class RevokeTaskResponseVO {
	private String status;

	public RevokeTaskResponseVO() {
		super();
	}

	public RevokeTaskResponseVO(String status) {
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
		return "RevokeTaskResponseVO [status=" + status + "]";
	}
	
	
}
