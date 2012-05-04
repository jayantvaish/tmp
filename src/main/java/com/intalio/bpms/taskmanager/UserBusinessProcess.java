package com.intalio.bpms.taskmanager;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.intalio.tempo.workflow.util.xml.OMElementQueue;
import org.intalio.tempo.workflow.util.xml.OMUnmarshaller;

import com.intalio.bpms.taskmanager.common.TMPXMLConstants;

public class UserBusinessProcess extends OMUnmarshaller {

	private static final OMFactory OM_FACTORY = OMAbstractFactory.getOMFactory();

	public UserBusinessProcess() {
		super(TMPXMLConstants.TMP_NAMESPACE, TMPXMLConstants.TMP_NAMESPACE_PREFIX);
	}

	public OMElement escalateTask(OMElement requestElement) {
		System.out.println(">>> Request received...");

		OMElementQueue rootQueue = new OMElementQueue(requestElement);
		String taskId = requireElementValue(rootQueue, "taskId");
		String userOwner = requireElementValue(rootQueue,
				"userOwner");
		String roleOwner = requireElementValue(rootQueue,
				"roleOwner");

		System.out.println("taskId: " + taskId);
		System.out.println("userOwner: " + userOwner);
		System.out.println("roleOwner: " + roleOwner);

		// Now doing some test by sending response back.
		OMElement response = OM_FACTORY.createOMElement("status", OM_FACTORY.createOMNamespace(TMPXMLConstants.TMP_NAMESPACE, TMPXMLConstants.TMP_NAMESPACE_PREFIX));
		return response;
	}
	
	
	
	

//	public OMElement createTask(OMElement request) throws InterruptedException,
//			ADBException {
//		System.out.println(">>> Request received...");
//		// TODO: Now here we will unmarshall the request.
//		return null;
//	}
//
//	public OMElement skipTask(OMElement request) {
//		System.out.println(">>> Request received...");
//		// TODO: Now here we will unmarshall the request.
//		return null;
//	}

}
