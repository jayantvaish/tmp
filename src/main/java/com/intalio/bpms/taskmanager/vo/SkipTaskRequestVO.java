package com.intalio.bpms.taskmanager.vo;

public class SkipTaskRequestVO {
	private String taskId;
	private String participantToken;	
	
	public SkipTaskRequestVO() {
		super();
	}

	public SkipTaskRequestVO(String taskId, String participantToken) {
		super();
		this.taskId = taskId;
		this.participantToken = participantToken;
	}
	
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	public String getParticipantToken() {
		return participantToken;
	}
	public void setParticipantToken(String participantToken) {
		this.participantToken = participantToken;
	}

	@Override
	public String toString() {
		return "SkipTaskRequestVO [taskId=" + taskId + ", participantToken="
				+ participantToken + "]";
	}
	
	
	
	

}
