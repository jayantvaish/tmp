package com.intalio.bpms.taskmanager.vo;

public class ChainedExecutionVO{
	private String previousTaskId;
	private String nextTaskId;
	private String nextTaskURL;
	
	public ChainedExecutionVO() {
		super();
	}

	public ChainedExecutionVO(String previousTaskId, String nextTaskId,
			String nextTaskURL) {
		super();
		this.previousTaskId = previousTaskId;
		this.nextTaskId = nextTaskId;
		this.nextTaskURL = nextTaskURL;
	}
	
	public String getPreviousTaskId() {
		return previousTaskId;
	}
	public void setPreviousTaskId(String previousTaskId) {
		this.previousTaskId = previousTaskId;
	}
	public String getNextTaskId() {
		return nextTaskId;
	}
	public void setNextTaskId(String nextTaskId) {
		this.nextTaskId = nextTaskId;
	}
	public String getNextTaskURL() {
		return nextTaskURL;
	}
	public void setNextTaskURL(String nextTaskURL) {
		this.nextTaskURL = nextTaskURL;
	}	
	
	@Override
	public String toString() {
		return "ChainedExecutionVO [previousTaskId=" + previousTaskId
				+ ", nextTaskId=" + nextTaskId + ", nextTaskURL=" + nextTaskURL
				+ "]";
	}	
	
}
