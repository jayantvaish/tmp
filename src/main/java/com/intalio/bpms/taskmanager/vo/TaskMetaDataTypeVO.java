package com.intalio.bpms.taskmanager.vo;

import java.net.URI;
import java.util.Date;
import java.util.List;

public class TaskMetaDataTypeVO {
	private String taskId;
	private String taskState;
	private String taskType;
	private String description;
	private String processId;
	private String instanceId;
	private Date creationDate;
	private String userOwner;
	private String roleOwner;
	private AccessControlTypeVO claimAction;
	private AccessControlTypeVO revokeAction;
	private AccessControlTypeVO saveAction;
	private AccessControlTypeVO dismissAction;
	private AccessControlTypeVO completeAction;
	private AccessControlTypeVO deferAction;
	private URI formUrl;
	private String failureCode;
	private String failureReason;
	private int priority;
	private ScheduledActionsVO scheduledActions;	
	private String userEndpoint;
	private String userProcessEndpoint;
	private String userProcessNamespaceURI;
	private String userProcessCompleteSOAPAction;
	private boolean isChainedBefore;
	private String previousTaskId;
	private String nextTaskId;
	private String session;
	private String nextTaskURL;
	private AttachmentVO attachments;  //TODO:What should be the type of attachments, as no type is given in xsd:type
	
	public TaskMetaDataTypeVO() {
		super();
	}
	
	public TaskMetaDataTypeVO(String taskId, String taskState, String taskType,
			String description, String processId, String instanceId,
			Date creationDate, String userOwner, String roleOwner,
			AccessControlTypeVO claimAction, AccessControlTypeVO revokeAction,
			AccessControlTypeVO saveAction, AccessControlTypeVO dismissAction,
			AccessControlTypeVO completeAction,
			AccessControlTypeVO deferAction, URI formUrl, String failureCode,
			String failureReason, int priority,
			ScheduledActionsVO scheduledActions, String userEndpoint,
			String userProcessEndpoint, String userProcessNamespaceURI,
			String userProcessCompleteSOAPAction, boolean isChainedBefore,
			String previousTaskId, String nextTaskId, String session,
			String nextTaskURL, AttachmentVO attachments) {
		super();
		this.taskId = taskId;
		this.taskState = taskState;
		this.taskType = taskType;
		this.description = description;
		this.processId = processId;
		this.instanceId = instanceId;
		this.creationDate = creationDate;
		this.userOwner = userOwner;
		this.roleOwner = roleOwner;
		this.claimAction = claimAction;
		this.revokeAction = revokeAction;
		this.saveAction = saveAction;
		this.dismissAction = dismissAction;
		this.completeAction = completeAction;
		this.deferAction = deferAction;
		this.formUrl = formUrl;
		this.failureCode = failureCode;
		this.failureReason = failureReason;
		this.priority = priority;
		this.scheduledActions = scheduledActions;
		this.userEndpoint = userEndpoint;
		this.userProcessEndpoint = userProcessEndpoint;
		this.userProcessNamespaceURI = userProcessNamespaceURI;
		this.userProcessCompleteSOAPAction = userProcessCompleteSOAPAction;
		this.isChainedBefore = isChainedBefore;
		this.previousTaskId = previousTaskId;
		this.nextTaskId = nextTaskId;
		this.session = session;
		this.nextTaskURL = nextTaskURL;
		this.attachments = attachments;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getTaskState() {
		return taskState;
	}

	public void setTaskState(String taskState) {
		this.taskState = taskState;
	}

	public String getTaskType() {
		return taskType;
	}

	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProcessId() {
		return processId;
	}

	public void setProcessId(String processId) {
		this.processId = processId;
	}

	public String getInstanceId() {
		return instanceId;
	}

	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
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

	public AccessControlTypeVO getClaimAction() {
		return claimAction;
	}

	public void setClaimAction(AccessControlTypeVO claimAction) {
		this.claimAction = claimAction;
	}

	public AccessControlTypeVO getRevokeAction() {
		return revokeAction;
	}

	public void setRevokeAction(AccessControlTypeVO revokeAction) {
		this.revokeAction = revokeAction;
	}

	public AccessControlTypeVO getSaveAction() {
		return saveAction;
	}

	public void setSaveAction(AccessControlTypeVO saveAction) {
		this.saveAction = saveAction;
	}

	public AccessControlTypeVO getDismissAction() {
		return dismissAction;
	}

	public void setDismissAction(AccessControlTypeVO dismissAction) {
		this.dismissAction = dismissAction;
	}

	public AccessControlTypeVO getCompleteAction() {
		return completeAction;
	}

	public void setCompleteAction(AccessControlTypeVO completeAction) {
		this.completeAction = completeAction;
	}

	public AccessControlTypeVO getDeferAction() {
		return deferAction;
	}

	public void setDeferAction(AccessControlTypeVO deferAction) {
		this.deferAction = deferAction;
	}

	public URI getFormUrl() {
		return formUrl;
	}

	public void setFormUrl(URI formUrl) {
		this.formUrl = formUrl;
	}

	public String getFailureCode() {
		return failureCode;
	}

	public void setFailureCode(String failureCode) {
		this.failureCode = failureCode;
	}

	public String getFailureReason() {
		return failureReason;
	}

	public void setFailureReason(String failureReason) {
		this.failureReason = failureReason;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public ScheduledActionsVO getScheduledActions() {
		return scheduledActions;
	}

	public void setScheduledActions(ScheduledActionsVO scheduledActions) {
		this.scheduledActions = scheduledActions;
	}

	public String getUserEndpoint() {
		return userEndpoint;
	}

	public void setUserEndpoint(String userEndpoint) {
		this.userEndpoint = userEndpoint;
	}

	public String getUserProcessEndpoint() {
		return userProcessEndpoint;
	}

	public void setUserProcessEndpoint(String userProcessEndpoint) {
		this.userProcessEndpoint = userProcessEndpoint;
	}

	public String getUserProcessNamespaceURI() {
		return userProcessNamespaceURI;
	}

	public void setUserProcessNamespaceURI(String userProcessNamespaceURI) {
		this.userProcessNamespaceURI = userProcessNamespaceURI;
	}

	public String getUserProcessCompleteSOAPAction() {
		return userProcessCompleteSOAPAction;
	}

	public void setUserProcessCompleteSOAPAction(
			String userProcessCompleteSOAPAction) {
		this.userProcessCompleteSOAPAction = userProcessCompleteSOAPAction;
	}

	public boolean isChainedBefore() {
		return isChainedBefore;
	}

	public void setChainedBefore(boolean isChainedBefore) {
		this.isChainedBefore = isChainedBefore;
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

	public String getSession() {
		return session;
	}

	public void setSession(String session) {
		this.session = session;
	}

	public String getNextTaskURL() {
		return nextTaskURL;
	}

	public void setNextTaskURL(String nextTaskURL) {
		this.nextTaskURL = nextTaskURL;
	}

	public AttachmentVO getAttachments() {
		return attachments;
	}

	public void setAttachments(AttachmentVO attachments) {
		this.attachments = attachments;
	}

	@Override
	public String toString() {
		return "TaskMetaDataTypeVO [taskId=" + taskId + ", taskState="
				+ taskState + ", taskType=" + taskType + ", description="
				+ description + ", processId=" + processId + ", instanceId="
				+ instanceId + ", creationDate=" + creationDate
				+ ", userOwner=" + userOwner + ", roleOwner=" + roleOwner
				+ ", claimAction=" + claimAction + ", revokeAction="
				+ revokeAction + ", saveAction=" + saveAction
				+ ", dismissAction=" + dismissAction + ", completeAction="
				+ completeAction + ", deferAction=" + deferAction
				+ ", formUrl=" + formUrl + ", failureCode=" + failureCode
				+ ", failureReason=" + failureReason + ", priority=" + priority
				+ ", scheduledActions=" + scheduledActions + ", userEndpoint="
				+ userEndpoint + ", userProcessEndpoint=" + userProcessEndpoint
				+ ", userProcessNamespaceURI=" + userProcessNamespaceURI
				+ ", userProcessCompleteSOAPAction="
				+ userProcessCompleteSOAPAction + ", isChainedBefore="
				+ isChainedBefore + ", previousTaskId=" + previousTaskId
				+ ", nextTaskId=" + nextTaskId + ", session=" + session
				+ ", nextTaskURL=" + nextTaskURL + ", attachments="
				+ attachments + "]";
	}
	
	
	

}
