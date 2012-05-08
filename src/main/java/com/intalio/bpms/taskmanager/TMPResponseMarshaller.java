package com.intalio.bpms.taskmanager;

import org.apache.axiom.om.OMFactory;
import org.intalio.tempo.workflow.util.xml.OMMarshaller;

import com.intalio.bpms.taskmanager.common.TMPXMLConstants;

public abstract class TMPResponseMarshaller extends OMMarshaller {
    public TMPResponseMarshaller(OMFactory omFactory) {
        super(omFactory, omFactory.createOMNamespace(TMPXMLConstants.TMP_NAMESPACE, TMPXMLConstants.TMP_NAMESPACE_PREFIX));
    }
}
