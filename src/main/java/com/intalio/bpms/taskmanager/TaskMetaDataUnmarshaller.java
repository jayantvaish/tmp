package com.intalio.bpms.taskmanager;



import java.net.URI;
import java.net.URISyntaxException;

import org.apache.axiom.om.OMElement;
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
		URI formUrl;
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
		AttachmentVO attachments = unmarshallAttachment(attachmentsElement);
		
		TaskMetaDataTypeVO taskMetaData = null; //TODO: initialize it.		
		return taskMetaData;
	}
	
	private AttachmentVO unmarshallAttachment(OMElement element){
		OMElementQueue elementQueue = new OMElementQueue(element);
		OMElement attachmentElement = requireElement(elementQueue, "attachment");
		AttachmentMetadataVO attachmentMetadata = unmarshallAttachmentMetadata(attachmentElement);
		String payloadUrl = requireElementValue(elementQueue, "payloadUrl");
		AttachmentVO attachment = new AttachmentVO(attachmentMetadata, payloadUrl);
		return attachment;
	}
	
	private AttachmentMetadataVO unmarshallAttachmentMetadata(OMElement element){
		OMElementQueue elementQueue = new OMElementQueue(element);
		String mimeType = requireElementValue(elementQueue, "mimeType");
		String fileName = requireElementValue(elementQueue, "fileName");
		String title = requireElementValue(elementQueue, "title");
		String description = requireElementValue(elementQueue, "role");
		String creationDateInString = requireElementValue(elementQueue, "creationDate");//TODO: convert to java.util.Date
		AttachmentMetadataVO attachmentMetadata = null; //TODO: Initialize it. 
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
		
		
		String forDurationInString = requireElementValue(elementQueue, "for"); //TODO: convert to org.apache.axis2.databinding.types.Duration
		ScheduledActionsDetailsVO scheduledActionsDetails = null; //TODO: Initialize it.
		return scheduledActionsDetails;
	}

}
