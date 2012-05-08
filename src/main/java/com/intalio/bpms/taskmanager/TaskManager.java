package com.intalio.bpms.taskmanager;

import java.util.Calendar;

import org.apache.axiom.om.OMElement;
import org.apache.axis2.databinding.ADBException;
import org.intalio.tempo.workflow.task.PATask;
import org.intalio.tempo.workflow.tms.TMSException;
import org.w3c.dom.Document;

import com.intalio.bpms.taskmanager.vo.CreateTaskRequestVO;
import com.intalio.bpms.taskmanager.vo.TaskMetaDataTypeVO;

public class TaskManager {
	
	
	/*public void createTMSTask(CreateTaskRequestVO createTaskRequest, Calendar creationDate) throws ADBException, InterruptedException {

        createTaskRequest.getTaskMetaData().setCreationDate(creationDate);
        createTaskRequest.getOMElement(com.intalio.www.bpms.workflow.ib4p_20051115.CreateTaskRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        String participantToken = createTaskRequest.getParticipantToken();
        TaskMetaDataTypeVO taskMetaDataType = createTaskRequest.getTaskMetaData();
        OMElement taskInputElement = createTaskRequest.getTaskInput();
        
        PATask task = new Convertor().convertToTask(taskMetaDataType, taskInputElement);

        Document inputDocument = null;
        
        try {
            _tmsServer.create(dao, task, participantToken);
        } catch (TMSException e) {
            
            _log.error(e.getMessage(), e);
        }
        
        if(createTaskRequest.getTaskMetaData().getIsChainedBefore()){
            
            TMP tmp = new TMP();
            ChainedExecution chainedExecution = new ChainedExecution();
            chainedExecution.setNextTaskId(_createTaskResponse.getTaskMetaData().getTaskId());
            chainedExecution.setNextTaskURL(createTaskRequest.getTaskMetaData().getFormUrl().toString());
            chainedExecution.setPreviousTaskId(createTaskRequest.getTaskMetaData().getPreviousTaskId());
            tmpServiceSkeleton.nextTaskReady(chainedExecution);
        }
        
    }*/

}
