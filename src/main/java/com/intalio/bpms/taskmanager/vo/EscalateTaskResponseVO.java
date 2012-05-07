package com.intalio.bpms.taskmanager.vo;

public class EscalateTaskResponseVO {
	private String status;

	public EscalateTaskResponseVO() {
		super();
	}

	public EscalateTaskResponseVO(String status) {
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
		return "EscalateTaskResponseVO [status=" + status + "]";
	}
	
	
}
