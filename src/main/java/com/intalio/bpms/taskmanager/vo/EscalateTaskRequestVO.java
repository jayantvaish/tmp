package com.intalio.bpms.taskmanager.vo;

public class EscalateTaskRequestVO {
	
	private String taskId;
	private String userOwner;
	private String roleOwner;	
	
	public EscalateTaskRequestVO(String taskId, String userOwner,
			String roleOwner) {
		super();
		this.taskId = taskId;
		this.userOwner = userOwner;
		this.roleOwner = roleOwner;
	}
	
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	public String getUserOwner() {
		return userOwner;
	}
	public void setUserOwner(String userOwner) {
		this.userOwner = userOwner;
	}
	public String getRoleOwner() {
		return roleOwner;
	}
	public void setRoleOwner(String roleOwner) {
		this.roleOwner = roleOwner;
	}

	@Override
	public String toString() {
		return "EscalateTaskRequestVO [taskId=" + taskId + ", userOwner="
				+ userOwner + ", roleOwner=" + roleOwner + "]";
	}
	

}
