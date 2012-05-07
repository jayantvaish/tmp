package com.intalio.bpms.taskmanager;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.intalio.tempo.workflow.util.xml.OMElementQueue;
import org.intalio.tempo.workflow.util.xml.OMUnmarshaller;

import com.intalio.bpms.taskmanager.common.TMPXMLConstants;
import com.intalio.bpms.taskmanager.vo.ClaimTaskRequestVO;
import com.intalio.bpms.taskmanager.vo.ClaimTaskResponseVO;
import com.intalio.bpms.taskmanager.vo.CompleteTaskRequestVO;
import com.intalio.bpms.taskmanager.vo.CreateTaskRequestVO;
import com.intalio.bpms.taskmanager.vo.ResponseVO;
import com.intalio.bpms.taskmanager.vo.RevokeTaskRequestVO;
import com.intalio.bpms.taskmanager.vo.RevokeTaskResponseVO;
import com.intalio.bpms.taskmanager.vo.SkipTaskRequestVO;
import com.intalio.bpms.taskmanager.vo.TaskMetaDataTypeVO;

public class UIFW extends OMUnmarshaller {
	
	private static final OMFactory OM_FACTORY = OMAbstractFactory.getOMFactory();
	
	public SkipTaskRequestVO _skipTaskRequest;
	public RevokeTaskRequestVO _revokeTaskRequest;
	public ClaimTaskRequestVO _claimTaskRequest;
	public CompleteTaskRequestVO _completeTaskRequest;
	
	public UIFW() {
		super(TMPXMLConstants.TMP_NAMESPACE, TMPXMLConstants.TMP_NAMESPACE_PREFIX);
	}	

	public OMElement revokeTask(OMElement requestElement) {
		System.out.println(">>> Request received...");
		RevokeTaskResponseVO revokeTaskResponse = new RevokeTaskResponseVO();
		
		OMElementQueue rootQueue = new OMElementQueue(requestElement);
		String taskId = requireElementValue(rootQueue, "taskId");
		String participantToken = requireElementValue(rootQueue, "participantToken");
		_revokeTaskRequest = new RevokeTaskRequestVO(taskId, participantToken);
		
		System.out.println("taskId: " + _revokeTaskRequest.getTaskId());
		System.out.println("participantToken: " + _revokeTaskRequest.getParticipantToken());
		//TODO: Insert logic here.
		
		
		//TODO: Marshall the revokeTaskResponse and return.
		return null;
	}

	public OMElement claimTask(OMElement requestElement) {
		System.out.println(">>> Request received...");
		ClaimTaskResponseVO claimTaskResponse = new ClaimTaskResponseVO();
		
		OMElementQueue rootQueue = new OMElementQueue(requestElement);
		String taskId = requireElementValue(rootQueue, "taskId");
		String claimerUser = requireElementValue(rootQueue, "claimerUser");
		String participantToken = requireElementValue(rootQueue, "participantToken");
		_claimTaskRequest = new ClaimTaskRequestVO(taskId, claimerUser, participantToken);
		
		System.out.println("taskId: " + _claimTaskRequest.getTaskId());
		System.out.println("claimerUser: " + _claimTaskRequest.getClaimerUser());
		System.out.println("participantToken: " + _claimTaskRequest.getParticipantToken());
		//TODO: Insert logic here.
		
		
		//TODO: Marshall the claimTaskResponse and return.
		return null;
	}

	public OMElement completeTask(OMElement requestElement) {
		System.out.println(">>> Request received...");
		ResponseVO response = new ResponseVO();
		
		OMElementQueue rootQueue = new OMElementQueue(requestElement);		
		OMElement taskElement = requireElement(rootQueue, "taskMetaData");
		TaskMetaDataTypeVO taskMetaData = new TaskMetaDataUnmarshaller().unmarshallTask(taskElement);
		String participantToken = requireElementValue(rootQueue, "participantToken");
		String user = requireElementValue(rootQueue, "user");
		String taskInput = requireElementValue(rootQueue, "taskInput");		
		_completeTaskRequest = new CompleteTaskRequestVO(taskMetaData, participantToken, user, taskInput);
		//TODO: Insert logic here.
		
		
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
