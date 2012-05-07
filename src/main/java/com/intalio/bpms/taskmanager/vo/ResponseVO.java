package com.intalio.bpms.taskmanager.vo;

public class ResponseVO {
	
	private TaskMetaDataTypeVO taskMetaData;
	private String status;
	private String errorCode;
	private String errorReason;
	private boolean isChainedAfter;
	
	public ResponseVO() {
		super();
	}

	public ResponseVO(TaskMetaDataTypeVO taskMetaData, String status,
			String errorCode, String errorReason, boolean isChainedAfter) {
		super();
		this.taskMetaData = taskMetaData;
		this.status = status;
		this.errorCode = errorCode;
		this.errorReason = errorReason;
		this.isChainedAfter = isChainedAfter;
	}

	public TaskMetaDataTypeVO getTaskMetaData() {
		return taskMetaData;
	}

	public void setTaskMetaData(TaskMetaDataTypeVO taskMetaData) {
		this.taskMetaData = taskMetaData;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorReason() {
		return errorReason;
	}

	public void setErrorReason(String errorReason) {
		this.errorReason = errorReason;
	}

	public boolean isChainedAfter() {
		return isChainedAfter;
	}

	public void setChainedAfter(boolean isChainedAfter) {
		this.isChainedAfter = isChainedAfter;
	}

	@Override
	public String toString() {
		return "ResponseVO [taskMetaData=" + taskMetaData + ", status="
				+ status + ", errorCode=" + errorCode + ", errorReason="
				+ errorReason + ", isChainedAfter=" + isChainedAfter + "]";
	}
	
	

}
