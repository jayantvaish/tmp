package com.intalio.bpms.taskmanager;

import org.apache.axiom.om.OMElement;
import org.intalio.tempo.workflow.util.xml.OMUnmarshaller;

import com.intalio.bpms.taskmanager.common.TMPXMLConstants;
import com.intalio.bpms.taskmanager.vo.TaskMetaDataTypeVO;

public class TaskMetaDataUnmarshaller extends OMUnmarshaller {

	protected TaskMetaDataUnmarshaller() {
		super(TMPXMLConstants.TMP_NAMESPACE, TMPXMLConstants.TMP_NAMESPACE_PREFIX);
	}
	
	public TaskMetaDataTypeVO unmarshallTask(OMElement taskElement){
		//TODO: create TaskMetaDataTypeVO from xml element.
		System.out.println(">>> taskElement is: " + taskElement);
		return null;
	}

}
