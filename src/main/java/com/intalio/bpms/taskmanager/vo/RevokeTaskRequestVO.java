package com.intalio.bpms.taskmanager.vo;

public class RevokeTaskRequestVO {
	private String taskId;
	private String participantToken;
	
	public RevokeTaskRequestVO(String taskId, String participantToken) {
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
		return "RevokeTaskRequestVO [taskId=" + taskId + ", participantToken="
				+ participantToken + "]";
	}	
}
