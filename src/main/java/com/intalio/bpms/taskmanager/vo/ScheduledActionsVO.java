package com.intalio.bpms.taskmanager.vo;

public class ScheduledActionsVO {
	
	private ScheduledActionsDetailsVO expiration;
	private ScheduledActionsDetailsVO deferActivation;
	
	public ScheduledActionsVO() {
		super();
	}

	public ScheduledActionsVO(ScheduledActionsDetailsVO expiration,
			ScheduledActionsDetailsVO deferActivation) {
		super();
		this.expiration = expiration;
		this.deferActivation = deferActivation;
	}

	public ScheduledActionsDetailsVO getExpiration() {
		return expiration;
	}

	public void setExpiration(ScheduledActionsDetailsVO expiration) {
		this.expiration = expiration;
	}

	public ScheduledActionsDetailsVO getDeferActivation() {
		return deferActivation;
	}

	public void setDeferActivation(ScheduledActionsDetailsVO deferActivation) {
		this.deferActivation = deferActivation;
	}

	@Override
	public String toString() {
		return "scheduledActionsVO [expiration=" + expiration
				+ ", deferActivation=" + deferActivation + "]";
	}

}
