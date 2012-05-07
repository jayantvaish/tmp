package com.intalio.bpms.taskmanager;

import org.apache.axiom.om.OMElement;
import org.intalio.tempo.workflow.util.xml.OMElementQueue;
import org.intalio.tempo.workflow.util.xml.OMUnmarshaller;

import com.intalio.bpms.taskmanager.common.TMPXMLConstants;
import com.intalio.bpms.taskmanager.vo.ChainedExecutionVO;

public class TMP extends OMUnmarshaller {
	
	public ChainedExecutionVO _chainedExecution;
	
	public TMP(){
		super(TMPXMLConstants.TMP_NAMESPACE, TMPXMLConstants.TMP_NAMESPACE_PREFIX);
	}

    public void nextTaskReady(OMElement requestElement) {    	
    	OMElementQueue rootQueue = new OMElementQueue(requestElement);
    	String previousTaskId = requireElementValue(rootQueue, "previousTaskId");
    	String nextTaskId = requireElementValue(rootQueue, "nextTaskId");
    	String nextTaskURL = requireElementValue(rootQueue, "nextTaskURL");
    	_chainedExecution = new ChainedExecutionVO(previousTaskId, nextTaskId, nextTaskURL);
    	
    	System.out.println("previousTaskId: " + _chainedExecution.getPreviousTaskId());
    	System.out.println("nextTaskId: " + _chainedExecution.getNextTaskId());
    	System.out.println("nextTaskURL: " + _chainedExecution.getNextTaskURL());
    }
    
    
    

}
