package com.intalio.bpms.taskmanager.vo;

public class CompleteTaskRequestVO {
	
	private TaskMetaDataTypeVO taskMetaData;
	private String participantToken;
	private String user;
	private String taskOutput; //TODO:What should be the type of taskOutput, as no type is given in xsd:type
	
	public CompleteTaskRequestVO() {
		super();
	}

	public CompleteTaskRequestVO(TaskMetaDataTypeVO taskMetaData,
			String participantToken, String user, String taskOutput) {
		super();
		this.taskMetaData = taskMetaData;
		this.participantToken = participantToken;
		this.user = user;
		this.taskOutput = taskOutput;
	}

	public TaskMetaDataTypeVO getTaskMetaData() {
		return taskMetaData;
	}

	public void setTaskMetaData(TaskMetaDataTypeVO taskMetaData) {
		this.taskMetaData = taskMetaData;
	}

	public String getParticipantToken() {
		return participantToken;
	}

	public void setParticipantToken(String participantToken) {
		this.participantToken = participantToken;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getTaskOutput() {
		return taskOutput;
	}

	public void setTaskOutput(String taskOutput) {
		this.taskOutput = taskOutput;
	}

	@Override
	public String toString() {
		return "CompleteTaskRequestVO [taskMetaData=" + taskMetaData
				+ ", participantToken=" + participantToken + ", user=" + user
				+ ", taskOutput=" + taskOutput + "]";
	}
	
}
