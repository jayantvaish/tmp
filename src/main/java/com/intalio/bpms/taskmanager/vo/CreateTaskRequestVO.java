package com.intalio.bpms.taskmanager.vo;

public class CreateTaskRequestVO {
	
	private TaskMetaDataTypeVO taskMetaData;
	private String participantToken;
	private String taskInput;
	
	public CreateTaskRequestVO() {
		super();
	}

	public CreateTaskRequestVO(TaskMetaDataTypeVO taskMetaData,
			String participantToken, String taskInput) {
		super();
		this.taskMetaData = taskMetaData;
		this.participantToken = participantToken;
		this.taskInput = taskInput;
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

	public String getTaskInput() {
		return taskInput;
	}

	public void setTaskInput(String taskInput) {
		this.taskInput = taskInput;
	}

	@Override
	public String toString() {
		return "CreateTaskRequestVO [taskMetaData=" + taskMetaData
				+ ", participantToken=" + participantToken + ", taskInput="
				+ taskInput + "]";
	}

}
