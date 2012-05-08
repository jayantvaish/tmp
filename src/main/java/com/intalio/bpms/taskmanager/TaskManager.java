package com.intalio.bpms.taskmanager;

import java.util.Calendar;
import java.util.Date;

import org.apache.axiom.om.OMElement;
import org.intalio.tempo.workflow.task.PATask;
import org.intalio.tempo.workflow.tms.TMSException;
import org.intalio.tempo.workflow.tms.server.ITMSServer;
import org.intalio.tempo.workflow.tms.server.dao.ITaskDAOConnection;
import org.intalio.tempo.workflow.tms.server.dao.ITaskDAOConnectionFactory;

import com.intalio.bpms.taskmanager.converter.Convertor;
import com.intalio.bpms.taskmanager.vo.ChainedExecutionVO;
import com.intalio.bpms.taskmanager.vo.CreateTaskRequestVO;
import com.intalio.bpms.taskmanager.vo.ResponseVO;
import com.intalio.bpms.taskmanager.vo.TaskMetaDataTypeVO;

public class TaskManager {
	
	private ITMSServer _tmsServer;
    private ResponseVO _createTaskResponse;
    private ITaskDAOConnection dao;
    private ITaskDAOConnectionFactory _taskDAOFactory; //How we'll get the factory.



	public void createTMSTask(CreateTaskRequestVO createTaskRequest, Calendar creationDate) {
		//TODO: this is test code, clean it.

        createTaskRequest.getTaskMetaData().setCreationDate(new Date(creationDate.getTimeInMillis()));
//        createTaskRequest.getOMElement(com.intalio.www.bpms.workflow.ib4p_20051115.CreateTaskRequest.MY_QNAME,
//                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        String participantToken = createTaskRequest.getParticipantToken();
        TaskMetaDataTypeVO taskMetaDataType = createTaskRequest.getTaskMetaData();
        OMElement taskInputElement = createTaskRequest.getTaskInput();
        
        PATask task = new Convertor().convertToTask(taskMetaDataType, taskInputElement);
        try {
            _tmsServer.create(dao, task, participantToken);
        } catch (TMSException e) { 
        	//TODO: print error message.
        	e.printStackTrace();
        }
        
        if(createTaskRequest.getTaskMetaData().isChainedBefore()){            
            TMP tmpService = new TMP();
            ChainedExecutionVO chainedExecution = new ChainedExecutionVO();
            chainedExecution.setNextTaskId(_createTaskResponse.getTaskMetaData().getTaskId());
            chainedExecution.setNextTaskURL(createTaskRequest.getTaskMetaData().getFormUrl().toString());
            chainedExecution.setPreviousTaskId(createTaskRequest.getTaskMetaData().getPreviousTaskId());
            tmpService.nextTaskReady(chainedExecution);
        }
        
    }

}
