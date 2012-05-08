package com.intalio.bpms.taskmanager;



import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;

import org.apache.axiom.om.OMElement;
import org.apache.axis2.databinding.types.Duration;
import org.intalio.tempo.workflow.util.xml.OMElementQueue;
import org.intalio.tempo.workflow.util.xml.OMUnmarshaller;

import com.intalio.bpms.taskmanager.common.TMPXMLConstants;
import com.intalio.bpms.taskmanager.vo.AccessControlTypeVO;
import com.intalio.bpms.taskmanager.vo.AttachmentMetadataVO;
import com.intalio.bpms.taskmanager.vo.AttachmentVO;
import com.intalio.bpms.taskmanager.vo.ScheduledActionsDetailsVO;
import com.intalio.bpms.taskmanager.vo.ScheduledActionsVO;
import com.intalio.bpms.taskmanager.vo.TaskMetaDataTypeVO;

public class TaskMetaDataUnmarshaller extends OMUnmarshaller {

	protected TaskMetaDataUnmarshaller() {
		super(TMPXMLConstants.TMP_NAMESPACE, TMPXMLConstants.TMP_NAMESPACE_PREFIX);
	}
	
	public TaskMetaDataTypeVO unmarshallTask(OMElement taskElement){
		System.out.println(">>> taskElement is: " + taskElement);		
		OMElementQueue taskElementQueue = new OMElementQueue(taskElement);
		String taskId = requireElementValue(taskElementQueue, "taskId");
		String taskState = requireElementValue(taskElementQueue, "taskState");
		String taskType = requireElementValue(taskElementQueue, "taskType");
		String description = requireElementValue(taskElementQueue, "description");
		String processId = requireElementValue(taskElementQueue, "processId");
		String instanceId = requireElementValue(taskElementQueue, "instanceId");
		
		String creationDateInString = requireElementValue(taskElementQueue, "creationDate"); //TODO:Convert this in Date.
		System.out.println(">> creationDateInString: " + creationDateInString);
		Date creationDate = null;
		
		String userOwner = requireElementValue(taskElementQueue, "userOwner");
		String roleOwner = requireElementValue(taskElementQueue, "roleOwner");
		
		OMElement claimActionElement = requireElement(taskElementQueue, "claimAction");
		AccessControlTypeVO claimAction = unmarshallAccessControl(claimActionElement);
		
		OMElement revokeActionElement = requireElement(taskElementQueue, "revokeAction");
		AccessControlTypeVO revokeAction = unmarshallAccessControl(revokeActionElement);
		
		OMElement saveActionElement = requireElement(taskElementQueue, "saveAction");
		AccessControlTypeVO saveAction = unmarshallAccessControl(saveActionElement);
		
		OMElement dismissActionElement = requireElement(taskElementQueue, "dismissAction");
		AccessControlTypeVO dismissAction = unmarshallAccessControl(dismissActionElement);
		
		OMElement completeActionElement = requireElement(taskElementQueue, "completeAction");
		AccessControlTypeVO completeAction = unmarshallAccessControl(completeActionElement);
		
		OMElement deferActionElement = requireElement(taskElementQueue, "deferAction");
		AccessControlTypeVO deferAction = unmarshallAccessControl(deferActionElement);
		
		String formUrlInString = requireElementValue(taskElementQueue, "formUrl"); 
		URI formUrl = null;
		try {
			formUrl = new URI(formUrlInString);
		} catch (URISyntaxException e) {
			//TODO: Add exception message.
			e.printStackTrace();
		}
		
		String failureCode = requireElementValue(taskElementQueue, "failureCode");
		String failureReason = requireElementValue(taskElementQueue, "failureReason");
		
		String priorityInString = requireElementValue(taskElementQueue, "priority"); 
		int priority = Integer.parseInt(priorityInString);
		
		OMElement scheduledActionsElement = requireElement(taskElementQueue, "scheduledActions");
		ScheduledActionsVO scheduledActions = unmarshallScheduledActions(scheduledActionsElement);
		
		String userEndpoint = requireElementValue(taskElementQueue, "userEndpoint");
		String userProcessEndpoint = requireElementValue(taskElementQueue, "userProcessEndpoint");
		String userProcessNamespaceURI = requireElementValue(taskElementQueue, "userProcessNamespaceURI");
		String userProcessCompleteSOAPAction = requireElementValue(taskElementQueue, "userProcessCompleteSOAPAction");
		
		String isChainedBeforeInString = requireElementValue(taskElementQueue, "isChainedBefore"); 
		boolean isChainedBefore = Boolean.parseBoolean(isChainedBeforeInString);
		
		String previousTaskId = requireElementValue(taskElementQueue, "previousTaskId");
		String nextTaskId = requireElementValue(taskElementQueue, "nextTaskId");
		String session = requireElementValue(taskElementQueue, "session");
		String nextTaskURL = requireElementValue(taskElementQueue, "nextTaskURL");
		
		OMElement attachmentsElement = requireElement(taskElementQueue, "attachments");
		AttachmentVO attachments = unmarshallAttachments(attachmentsElement); 
		
		TaskMetaDataTypeVO taskMetaData = new TaskMetaDataTypeVO(taskId, taskState, taskType, 
				description, processId, instanceId, creationDate, userOwner, roleOwner, 
				claimAction, revokeAction, saveAction, dismissAction, completeAction, deferAction, 
				formUrl, failureCode, failureReason, priority, scheduledActions, userEndpoint, 
				userProcessEndpoint, userProcessNamespaceURI, userProcessCompleteSOAPAction, isChainedBefore, 
				previousTaskId, nextTaskId, 
				session, nextTaskURL, attachments); 
		System.out.println(">>> taskMetaData: " + taskMetaData);
		return taskMetaData;
	}
	
	private AttachmentVO unmarshallAttachments(OMElement element){
		OMElementQueue elementQueue = new OMElementQueue(element);
		OMElement attachmentElement = expectElementAnyNS(elementQueue, "attachment");
		AttachmentVO attachment = unmarshallAttachment(attachmentElement);
		return attachment;
	}
	
	private AttachmentVO unmarshallAttachment(OMElement element){
		OMElementQueue elementQueue = new OMElementQueue(element);
		OMElement attachmentMetadataElement = expectElementAnyNS(elementQueue, "attachmentMetadata");
		AttachmentMetadataVO attachmentMetadata = unmarshallAttachmentMetadata(attachmentMetadataElement);
		String payloadUrl = expectElementValue(elementQueue, "payloadUrl");
		AttachmentVO attachment = new AttachmentVO(attachmentMetadata, payloadUrl);
		return attachment;
	}
	
	private AttachmentMetadataVO unmarshallAttachmentMetadata(OMElement element){
		OMElementQueue elementQueue = new OMElementQueue(element);
		String mimeType = expectElementValue(elementQueue, "mimeType");
		String fileName = expectElementValue(elementQueue, "fileName");
		String title = expectElementValue(elementQueue, "title");
		String description = expectElementValue(elementQueue, "description");
		
		String creationDateInString = expectElementValue(elementQueue, "creationDate"); //TODO: convert to java.util.Date
		System.out.println("creationDateInString: " + creationDateInString);
		Date creationDate = null; 
		
		AttachmentMetadataVO attachmentMetadata = new AttachmentMetadataVO(mimeType, fileName, 
				title, description, creationDate); 
		return attachmentMetadata;
	}
	
	
	private AccessControlTypeVO unmarshallAccessControl(OMElement element){
		OMElementQueue elementQueue = new OMElementQueue(element);
		String user = requireElementValue(elementQueue, "user");
		String role = requireElementValue(elementQueue, "role");
		AccessControlTypeVO accessControl = new AccessControlTypeVO(user, role);
		return accessControl;
	}
	
	private ScheduledActionsVO unmarshallScheduledActions(OMElement element){
		OMElementQueue elementQueue = new OMElementQueue(element);
		OMElement expirationElement = requireElement(elementQueue, "expiration");
		ScheduledActionsDetailsVO expiration = unmarshallScheduledActionsDetails(expirationElement);
		OMElement deferActivationElement = requireElement(elementQueue, "deferActivation");
		ScheduledActionsDetailsVO deferActivation = unmarshallScheduledActionsDetails(deferActivationElement);
		ScheduledActionsVO scheduledActions = new ScheduledActionsVO(expiration, deferActivation);
		return scheduledActions;
	}
	
	private ScheduledActionsDetailsVO unmarshallScheduledActionsDetails(OMElement element){
		OMElementQueue elementQueue = new OMElementQueue(element);
		String untilDateInString = requireElementValue(elementQueue, "until"); //TODO: convert to java.util.Date
		System.out.println("untilDateInString: " + untilDateInString);
		Date untilDate = null;
		
		String forDurationInString = requireElementValue(elementQueue, "for"); //TODO: convert to org.apache.axis2.databinding.types.Duration
		System.out.println("forDurationInString: " + forDurationInString);
		Duration forDuration = null;
		
		ScheduledActionsDetailsVO scheduledActionsDetails = new ScheduledActionsDetailsVO(untilDate, forDuration); 
		return scheduledActionsDetails;
	}

}
