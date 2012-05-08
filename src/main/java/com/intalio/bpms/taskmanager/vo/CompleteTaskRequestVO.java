package com.intalio.bpms.taskmanager.vo;

import org.apache.axiom.om.OMElement;

public class CompleteTaskRequestVO {
	
	private TaskMetaDataTypeVO taskMetaData;
	private String participantToken;
	private String user;
	private OMElement taskOutput; 
	
	public CompleteTaskRequestVO() {
		super();
	}

	public CompleteTaskRequestVO(TaskMetaDataTypeVO taskMetaData,
			String participantToken, String user, OMElement taskOutput) {
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

	public OMElement getTaskOutput() {
		return taskOutput;
	}

	public void setTaskOutput(OMElement taskOutput) {
		this.taskOutput = taskOutput;
	}

	@Override
	public String toString() {
		return "CompleteTaskRequestVO [taskMetaData=" + taskMetaData
				+ ", participantToken=" + participantToken + ", user=" + user
				+ ", taskOutput=" + taskOutput + "]";
	}
	
}
