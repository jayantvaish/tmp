package com.intalio.bpms.taskmanager.vo;

import java.util.Date;

import org.apache.axis2.databinding.types.Duration;

public class ScheduledActionsDetailsVO {
	
	private Date untilDate;
	private Duration forDuration;
	
	public ScheduledActionsDetailsVO() {
		super();
	}

	public ScheduledActionsDetailsVO(Date untilDate, Duration forDuration) {
		super();
		this.untilDate = untilDate;
		this.forDuration = forDuration;
	}

	public Date getUntilDate() {
		return untilDate;
	}

	public void setUntilDate(Date untilDate) {
		this.untilDate = untilDate;
	}

	public Duration getForDuration() {
		return forDuration;
	}

	public void setForDuration(Duration forDuration) {
		this.forDuration = forDuration;
	}

	@Override
	public String toString() {
		return "ScheduledActionsDetailsVO [untilDate=" + untilDate
				+ ", forDuration=" + forDuration + "]";
	}

}
