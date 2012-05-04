package com.intalio.bpms.taskmanager;

import org.apache.axiom.om.OMElement;
import org.intalio.tempo.workflow.util.xml.OMElementQueue;
import org.intalio.tempo.workflow.util.xml.OMUnmarshaller;

import com.intalio.bpms.taskmanager.common.TMPXMLConstants;

public class TMP extends OMUnmarshaller {
	
	public TMP(){
		super(TMPXMLConstants.TMP_NAMESPACE, TMPXMLConstants.TMP_NAMESPACE_PREFIX);
	}

    public void nextTaskReady(OMElement requestElement) {
    	System.out.println(">>> Request received...");
    	
    	OMElementQueue rootQueue = new OMElementQueue(requestElement);
    	String previousTaskId = requireElementValue(rootQueue, "previousTaskId");
    	String nextTaskId = requireElementValue(rootQueue, "nextTaskId");
    	String nextTaskURL = requireElementValue(rootQueue, "nextTaskURL");
    	
    	System.out.println("previousTaskId: " + previousTaskId);
    	System.out.println("nextTaskId: " + nextTaskId);
    	System.out.println("nextTaskURL: " + nextTaskURL);
    }
    
    
    

}
