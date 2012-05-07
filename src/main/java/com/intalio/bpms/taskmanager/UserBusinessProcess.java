package com.intalio.bpms.taskmanager;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axis2.databinding.ADBException;
import org.intalio.tempo.workflow.util.xml.OMElementQueue;
import org.intalio.tempo.workflow.util.xml.OMUnmarshaller;

import com.intalio.bpms.taskmanager.common.TMPXMLConstants;
import com.intalio.bpms.taskmanager.vo.EscalateTaskRequestVO;
import com.intalio.bpms.taskmanager.vo.SkipTaskRequestVO;

public class UserBusinessProcess extends OMUnmarshaller {

	private static final OMFactory OM_FACTORY = OMAbstractFactory.getOMFactory();
	
	public EscalateTaskRequestVO _escalateTaskRequest;
	public SkipTaskRequestVO _skipTaskRequest;

	public UserBusinessProcess() {
		super(TMPXMLConstants.TMP_NAMESPACE, TMPXMLConstants.TMP_NAMESPACE_PREFIX);
	}

	public OMElement escalateTask(OMElement requestElement) {
		System.out.println(">>> Request received...");

		OMElementQueue rootQueue = new OMElementQueue(requestElement);
		String taskId = requireElementValue(rootQueue, "taskId");
		String userOwner = requireElementValue(rootQueue, "userOwner");
		String roleOwner = requireElementValue(rootQueue, "roleOwner");
		_escalateTaskRequest = new EscalateTaskRequestVO(taskId, userOwner, roleOwner);

		System.out.println("taskId: " + _escalateTaskRequest.getTaskId());
		System.out.println("userOwner: " + _escalateTaskRequest.getUserOwner());
		System.out.println("roleOwner: " + _escalateTaskRequest.getRoleOwner());

		// Now doing some test by sending response back (it is just an example, how our ws will work.).
		OMElement response = OM_FACTORY.createOMElement("status", OM_FACTORY.createOMNamespace(TMPXMLConstants.TMP_NAMESPACE, TMPXMLConstants.TMP_NAMESPACE_PREFIX));
		response.addChild(OM_FACTORY.createOMText("Request send ok."));
		//If we want to send any object as a response then we may need to create it's xmlObject.
		
		return response;
	}
	
	

	public OMElement createTask(OMElement requestElement) {
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