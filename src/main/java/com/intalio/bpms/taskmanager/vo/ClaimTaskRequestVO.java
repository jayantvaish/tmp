package com.intalio.bpms.taskmanager.vo;

public class ClaimTaskRequestVO {	
	private String taskId;
	private String claimerUser;
	private String participantToken;
	
	public ClaimTaskRequestVO() {
		super();
	}

	public ClaimTaskRequestVO(String taskId, String claimerUser,
			String participantToken) {
		super();
		this.taskId = taskId;
		this.claimerUser = claimerUser;
		this.participantToken = participantToken;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getClaimerUser() {
		return claimerUser;
	}

	public void setClaimerUser(String claimerUser) {
		this.claimerUser = claimerUser;
	}

	public String getParticipantToken() {
		return participantToken;
	}

	public void setParticipantToken(String participantToken) {
		this.participantToken = participantToken;
	}

	@Override
	public String toString() {
		return "ClaimTaskRequestVO [taskId=" + taskId + ", claimerUser="
				+ claimerUser + ", participantToken=" + participantToken + "]";
	}	

}
