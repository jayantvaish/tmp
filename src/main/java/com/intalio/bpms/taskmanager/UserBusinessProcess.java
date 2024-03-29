package com.intalio.bpms.taskmanager;

import java.util.Calendar;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.intalio.tempo.workflow.util.xml.OMElementQueue;
import org.intalio.tempo.workflow.util.xml.OMUnmarshaller;

import com.intalio.bpms.taskmanager.common.TMPXMLConstants;
import com.intalio.bpms.taskmanager.vo.CreateTaskRequestVO;
import com.intalio.bpms.taskmanager.vo.EscalateTaskRequestVO;
import com.intalio.bpms.taskmanager.vo.EscalateTaskResponseVO;
import com.intalio.bpms.taskmanager.vo.ResponseVO;
import com.intalio.bpms.taskmanager.vo.SkipTaskRequestVO;
import com.intalio.bpms.taskmanager.vo.TaskMetaDataTypeVO;

public class UserBusinessProcess extends OMUnmarshaller {

	private static final OMFactory OM_FACTORY = OMAbstractFactory.getOMFactory();
	
	public EscalateTaskRequestVO _escalateTaskRequest;
	public SkipTaskRequestVO _skipTaskRequest;
	public CreateTaskRequestVO _createTaskRequest;
	public TaskManager _taskManager;

	public UserBusinessProcess() {
		super(TMPXMLConstants.TMP_NAMESPACE, TMPXMLConstants.TMP_NAMESPACE_PREFIX);
		_taskManager = new TaskManager();
	}

	public OMElement escalateTask(OMElement requestElement) {
		System.out.println(">>> Request received...");
		EscalateTaskResponseVO escalateTaskResponse = new EscalateTaskResponseVO();

		OMElementQueue rootQueue = new OMElementQueue(requestElement);
		String taskId = requireElementValue(rootQueue, "taskId");
		String userOwner = requireElementValue(rootQueue, "userOwner");
		String roleOwner = requireElementValue(rootQueue, "roleOwner");
		_escalateTaskRequest = new EscalateTaskRequestVO(taskId, userOwner, roleOwner);

		System.out.println("taskId: " + _escalateTaskRequest.getTaskId());
		System.out.println("userOwner: " + _escalateTaskRequest.getUserOwner());
		System.out.println("roleOwner: " + _escalateTaskRequest.getRoleOwner());

		// Now doing some test by sending response back (it is just an example, how our ws will work.).
		//OMElement response = OM_FACTORY.createOMElement("status", OM_FACTORY.createOMNamespace(TMPXMLConstants.TMP_NAMESPACE, TMPXMLConstants.TMP_NAMESPACE_PREFIX));
		//response.addChild(OM_FACTORY.createOMText("Request send ok."));
		//If we want to send any object as a response then we may need to create it's xmlObject.
		
		//TODO: Insert logic here.
		
		
		//TODO: Marshall the escalateTaskResponse and return (Check the output on implementaion).	
		OMElement response = new TMPResponseMarshaller(OM_FACTORY) {
            public OMElement marshalResponse(EscalateTaskResponseVO escalateTaskResponse) {
                OMElement response = createElement("status");
                response.addChild(OM_FACTORY.createOMText(escalateTaskResponse.getStatus()));
                return response;
            }
        }.marshalResponse(escalateTaskResponse);
		return response;
	}
	
	

	public OMElement createTask(OMElement requestElement) {
		System.out.println(">>> Request received...");
		ResponseVO response = new ResponseVO();
		
		OMElementQueue rootQueue = new OMElementQueue(requestElement);		
		OMElement taskElement = requireElement(rootQueue, "taskMetaData");
		TaskMetaDataTypeVO taskMetaData = new TaskMetaDataUnmarshaller().unmarshallTask(taskElement);
		String participantToken = requireElementValue(rootQueue, "participantToken");
		OMElement taskInput = requireElement(rootQueue, "taskInput").getFirstElement();		
		_createTaskRequest = new CreateTaskRequestVO(taskMetaData, participantToken, taskInput);
		System.out.println(">>> _createTaskRequest: " + _createTaskRequest);
		//TODO: Insert logic here.
		
		//creating the tms task //TODO: this is test code, clean it.
		Calendar creationDate = Calendar.getInstance();
		_taskManager.createTMSTask(_createTaskRequest, creationDate);
		
		
		//TODO: Marshall the response and return.		
		return null;
	}

	public OMElement skipTask(OMElement requestElement) {
		System.out.println(">>> Request received...");
		ResponseVO response = new ResponseVO();
		
		OMElementQueue rootQueue = new OMElementQueue(requestElement);
		String taskId = requireElementValue(rootQueue, "taskId");
		String participantToken = requireElementValue(rootQueue, "participantToken");
		_skipTaskRequest = new SkipTaskRequestVO(taskId, participantToken);
		
		System.out.println("taskId: " + _skipTaskRequest.getTaskId());
		System.out.println("participantToken: " + _skipTaskRequest.getParticipantToken());
		
		//TODO: Insert logic here.
		
		
		//TODO: Marshall the response and return.
		return null;
	}

}
