package com.ajopaul.pojos;

public class ProgramBean {
	String programName;
	int priority;
	String clients;
	
	
	public ProgramBean(String programName,int priority,String clients){
		this.programName = programName;
		this.priority = priority;
		this.clients = clients;
	}
	
	
	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public String getClients() {
		return clients;
	}
	public void setClients(String clients) {
		this.clients = clients;
	}
	
}
