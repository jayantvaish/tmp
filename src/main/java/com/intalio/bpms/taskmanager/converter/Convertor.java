package com.intalio.bpms.taskmanager.converter;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.impl.builder.StAXOMBuilder;
import org.apache.axiom.om.impl.dom.DOOMAbstractFactory;
import org.apache.axis2.databinding.types.Duration;
import org.intalio.tempo.workflow.auth.ACL;
import org.intalio.tempo.workflow.auth.AuthIdentifierSet;
import org.intalio.tempo.workflow.task.PATask;
import org.intalio.tempo.workflow.task.TaskState;
import org.intalio.tempo.workflow.task.xml.XmlTooling;
import org.intalio.tempo.workflow.util.RequiredArgumentException;
import org.intalio.tempo.workflow.util.xml.InvalidInputFormatException;
import org.w3c.dom.Document;

import com.intalio.bpms.taskmanager.vo.AccessControlTypeVO;
import com.intalio.bpms.taskmanager.vo.AttachmentVO;
import com.intalio.bpms.taskmanager.vo.TaskMetaDataTypeVO;
//TODO: this is test code, clean it.
public class Convertor {
       
    private static final String[] actions = new String[] { "claim", "revoke", "save", "complete", "dismiss" };
    
    public PATask convertToTask(TaskMetaDataTypeVO taskMetaDataType,
            OMElement taskInputElement) {
        PATask task = null;
        String taskId = taskMetaDataType.getTaskId();
        String taskStateString = null;
        if(taskMetaDataType.getTaskState() != null)
            taskStateString = taskMetaDataType.getTaskState().toString();
        else
            taskStateString = TaskState.READY.toString();
        TaskState taskState = TaskState.valueOf(taskStateString);
        String description = taskMetaDataType.getDescription();
        String instanceId = taskMetaDataType.getInstanceId();
        String processId = taskMetaDataType.getProcessId();
        
        AuthIdentifierSet userOwners = new AuthIdentifierSet(Arrays.asList(taskMetaDataType.getUserOwner()));
        AuthIdentifierSet roleOwners = new AuthIdentifierSet(Arrays.asList(taskMetaDataType.getRoleOwner()));
        Integer priority = taskMetaDataType.getPriority();
        
        String formURLString = taskMetaDataType.getFormUrl().toString();
        URI formURL = null;
        if (formURLString != null) {
            try {
                formURL = new URI(formURLString);
            } catch (URISyntaxException e) {
                throw new InvalidInputFormatException(e);
            }
        } else {
            throw new InvalidInputFormatException("No URL found for form");
        }
        
        String failureCode = taskMetaDataType.getFailureCode();
        String failureReason = taskMetaDataType.getFailureReason();
        String completeSoapAction = taskMetaDataType.getUserProcessCompleteSOAPAction();
        boolean isChainedBefore = taskMetaDataType.isChainedBefore();
        String previousTaskId = taskMetaDataType.getPreviousTaskId();
        taskMetaDataType.getAttachments();
        throwExceptionIfNull(completeSoapAction, "Complete SOAPAction");
        
        task = new PATask(taskId, formURL);
        task.setUserOwners(userOwners);
        task.setRoleOwners(roleOwners);
        task.setDescription(description);
        task.setCreationDate(taskMetaDataType.getCreationDate());
        
        for (String action : actions) {
            ACL acl = readACL(taskMetaDataType, action);
            authorize(task, action, acl);
        }
        
        task.setState(taskState);
        if (task.getState().equals(TaskState.FAILED)) {
            throwExceptionIfNull(failureCode, "failure code");

            task.setFailureCode(failureCode);
            task.setFailureReason(failureReason == null ? "" : failureReason);
        } else {
            throwExcptionIfNotNull(failureCode, "failure code");
            throwExcptionIfNotNull(failureReason, "failure reason");
        }
        
        if(processId != null)
            task.setProcessID(processId);
        if(instanceId != null)
            task.setInstanceId(instanceId);
        task.setCompleteSOAPAction(completeSoapAction);
        AttachmentVO attachments = taskMetaDataType.getAttachments();
        
        if(attachments !=null){
            /*com.intalio.www.bpms.workflow.ib4p_20051115.Attachment[] attachmentsArray = attachments.getAttachment();
            for (int i = 0; i < attachmentsArray.length; i++) {
                com.intalio.www.bpms.workflow.ib4p_20051115.Attachment attachmentElement = attachmentsArray[i];
                com.intalio.www.bpms.workflow.ib4p_20051115.AttachmentMetadata attachmentMetadata = attachmentElement.getAttachmentMetadata();
                AttachmentMetadata metadata = new AttachmentMetadata();
                if(attachmentMetadata != null){                  
                    metadata.setCreationDate(new Date(attachmentMetadata.getCreationDate().getTimeInMillis()));
                    metadata.setDescription(attachmentMetadata.getDescription());
                    metadata.setFileName(attachmentMetadata.getFileName());
                    metadata.setMimeType(attachmentMetadata.getMimeType());
                    metadata.setTitle(attachmentMetadata.getTitle());
                }
                String payloadUrlString = attachmentElement.getPayloadUrl();
                URL payloadURL;
                try {
                    payloadURL = new URL(payloadUrlString);
                } catch (MalformedURLException e) {
                    throw new InvalidInputFormatException(e);
                }
                Attachment attachment = new Attachment(metadata, payloadURL);
                task.addAttachment(attachment);
            }*/
        }
        
        if (isChainedBefore) {
            if (isChainedBefore){
                if (previousTaskId == null) {
                    throw new InvalidInputFormatException("tms:previousTaskId is required " + "if tms:isChainedBefore is true");
                }
                task.setPreviousTaskID(previousTaskId);
                task.setChainedBefore(true);
             }
             else { //Will it reach here??
                if ((previousTaskId != null) && (!"".equals(previousTaskId))) {
                    throw new InvalidInputFormatException("tms:previousTaskId must be empty or not present " + "if tms:isChainedBefore is false");
                }
            }
        } else {
            if (previousTaskId != null)
                throw new InvalidInputFormatException("tms:isChainedBefore is required " + "if tms:previousTaskId is present");
        }
        
        if(taskMetaDataType.getScheduledActions() !=null){
            if(taskMetaDataType.getScheduledActions().getExpiration() !=null){
                if(taskMetaDataType.getScheduledActions().getExpiration().getForDuration() !=null){
                    Duration forDuration = taskMetaDataType.getScheduledActions().getExpiration().getForDuration();
                    Calendar tillDate = forDuration.getAsCalendar();
                    task.setDeadline(new Date(tillDate.getTimeInMillis()));
                }
                else if (taskMetaDataType.getScheduledActions().getExpiration().getUntilDate() !=null){
                    Date tillDate = taskMetaDataType.getScheduledActions().getExpiration().getUntilDate();
                    task.setDeadline(tillDate);
                }
            }
        }
        if(priority !=null)
            task.setPriority(priority);
        
        if(taskInputElement != null){
        
            task.setInput(getDocument(taskInputElement));
            Map<String, String> customMetadata = new HashMap<String, String>();
            Iterator<OMElement> childElements = taskInputElement.getFirstElement().getChildElements();
            while(childElements.hasNext()){
                String key = childElements.next().getLocalName();
                String value = getText(childElements.next());
                customMetadata.put(key, value);
            }
        }
        return task;
    }
    
    private String getText(OMElement next) {
        Iterator<OMElement> childElements = next.getChildElements();
        
        while(!childElements.hasNext()){
            return childElements.next().getText();
        }
        return next.getText();
    }

    private Document getDocument(OMElement element){
        OMFactory omFactory = DOOMAbstractFactory.getOMFactory();
        StAXOMBuilder axomBuilder = new StAXOMBuilder(omFactory, element.getXMLStreamReader());
        return (Document) axomBuilder.getDocument();
    }

    private void authorize(PATask task, String action, ACL acl) {
        for (String user : acl.getUserOwners()) {
            task.authorizeActionForUser(action, user);
        }
        for (String role : acl.getRoleOwners()) {
            task.authorizeActionForRole(action, role);
        }
        
    }

    private ACL readACL(TaskMetaDataTypeVO taskMetaDataType, String action) {
        ACL acl = new ACL();
        AccessControlTypeVO access = null;
        if("claim".equalsIgnoreCase(action))
             access = taskMetaDataType.getClaimAction();
        else if ("revoke".equalsIgnoreCase(action))
            access = taskMetaDataType.getRevokeAction();
        else if("save".equalsIgnoreCase(action))
            access = taskMetaDataType.getSaveAction();
        else if("complete".equalsIgnoreCase(action))
            access = taskMetaDataType.getCompleteAction();
        else if ("dismiss".equalsIgnoreCase(action))
            access = taskMetaDataType.getDismissAction();

        
        if (access!= null) {
            acl.getUserOwners().addAll(Arrays.asList(access.getUser()));
            acl.getRoleOwners().addAll(Arrays.asList(access.getRole()));
        }
        return acl;
    }
    
    public void throwExceptionIfNull(Object parameter, String name)
            throws InvalidInputFormatException {
        if (parameter == null) {
            throw new InvalidInputFormatException(
                    "Required parameter was not specified: " + name);
        }
    }
    
    public void throwExcptionIfNotNull(Object parameter, String name)
            throws InvalidInputFormatException {
        if (parameter != null) {
            throw new InvalidInputFormatException(
                    "Required parameter was not specified: " + name);
        }     
    }
    
    private Document unmarshalTaskPayload(OMElement containerElement) throws InvalidInputFormatException {
        if (containerElement == null) {
            throw new RequiredArgumentException("containerElement");
        }
        Iterator<OMElement> it = containerElement.getChildElements();
        if (!it.hasNext()) {
            throw new InvalidInputFormatException("Payload container element must contain exactly one child element");
        }
        Document result = null;
        OMElement firstPayloadElement = it.next();
        if (it.hasNext()) {
            throw new InvalidInputFormatException("Task payload must consist of exactly one element.");
        } else {
            result = new XmlTooling().convertOMToDOM(firstPayloadElement);
        }
        return result;
    }
    
    public Document unmarshalTaskOutput(OMElement outputContainerElement) throws InvalidInputFormatException {
        return unmarshalTaskPayload(outputContainerElement);
    }
}
