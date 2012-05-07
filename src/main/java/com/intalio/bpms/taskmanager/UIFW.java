package com.intalio.bpms.taskmanager;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.intalio.tempo.workflow.util.xml.OMElementQueue;
import org.intalio.tempo.workflow.util.xml.OMUnmarshaller;

import com.intalio.bpms.taskmanager.common.TMPXMLConstants;
import com.intalio.bpms.taskmanager.vo.ClaimTaskRequestVO;
import com.intalio.bpms.taskmanager.vo.RevokeTaskRequestVO;
import com.intalio.bpms.taskmanager.vo.SkipTaskRequestVO;

public class UIFW extends OMUnmarshaller {
	
	private static final OMFactory OM_FACTORY = OMAbstractFactory.getOMFactory();
	
	public SkipTaskRequestVO _skipTaskRequest;
	public RevokeTaskRequestVO _revokeTaskRequest;
	public ClaimTaskRequestVO _claimTaskRequest;
	
	public UIFW() {
		super(TMPXMLConstants.TMP_NAMESPACE, TMPXMLConstants.TMP_NAMESPACE_PREFIX);
	}	

	public OMElement revokeTask(OMElement requestElement) {
		System.out.println(">>> Request received...");
		
		OMElementQueue rootQueue = new OMElementQueue(requestElement);
		String taskId = requireElementValue(rootQueue, "taskId");
		String participantToken = requireElementValue(rootQueue, "participantToken");
		_revokeTaskRequest = new RevokeTaskRequestVO(taskId, participantToken);
		
		System.out.println("taskId: " + _revokeTaskRequest.getTaskId());
		System.out.println("participantToken: " + _revokeTaskRequest.getParticipantToken());
		
		return null;
	}

	public OMElement claimTask(OMElement requestElement) {
		System.out.println(">>> Request received...");
		
		OMElementQueue rootQueue = new OMElementQueue(requestElement);
		String taskId = requireElementValue(rootQueue, "taskId");
		String claimerUser = requireElementValue(rootQueue, "claimerUser");
		String participantToken = requireElementValue(rootQueue, "participantToken");
		_claimTaskRequest = new ClaimTaskRequestVO(taskId, claimerUser, participantToken);
		
		System.out.println("taskId: " + _claimTaskRequest.getTaskId());
		System.out.println("claimerUser: " + _claimTaskRequest.getClaimerUser());
		System.out.println("participantToken: " + _claimTaskRequest.getParticipantToken());
		
		return null;
	}

	public OMElement completeTask(OMElement requestElement) {
		System.out.println(">>> Request received...");
		// TODO: Now here we will unmarshall the request.
		return null;
	}

	public OMElement skipTask(OMElement requestElement) {
		System.out.println(">>> Request received...");
		
		OMElementQueue rootQueue = new OMElementQueue(requestElement);
		String taskId = requireElementValue(rootQueue, "taskId");
		String participantToken = requireElementValue(rootQueue, "participantToken");
		_skipTaskRequest = new SkipTaskRequestVO(taskId, participantToken);
		
		System.out.println("taskId: " + _skipTaskRequest.getTaskId());
		System.out.println("participantToken: " + _skipTaskRequest.getParticipantToken());
		
		return null;
	}

}
