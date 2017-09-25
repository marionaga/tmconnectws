package com.id.tmli.intranet.util;

/**
 * @author adi.gatot
 *
 */
public enum DailySubmitState {

//oki begin 2016-05-09	
//	SUBMIT("Submit"), RETURN("Return"), ACCEPT("Accept"), SETTLED("Settled"),
//	SEND("Send"),RESUBMIT("Resubmit"), RECIEVE("Recieve"), ISSUED("Issue");
	
	SUBMIT("Submit"), RETURN("Return"), ACCEPT("Accept"), SETTLED("Settled"),
	SEND("Send"),RESUBMIT("Resubmit"), RECIEVE("Recieve"), ISSUED("Issue"), 
	DECLINED("Declined"), WITHDRAWN("Withdrawn"), POSTPONED("Postponed"), APPROVED("Approved");
//oki end 2016-05-09
	
	private String label;
	private DailySubmitState(String label) {
		// TODO Auto-generated constructor stub
		this.label = label;
	}
	public String getLabel() {
		return label;
	}
}
