package com.ERS.model;

import javax.persistence.*;



@Entity
@Table(name="reimbursements")
public class Reimbursement {

    @Column
    public int id;
    @Column
    public int authorid;
    @Column
    public int resolverid;
    @Column
    public String type;
    @Column
    public String amount;
    @Column
    public String description;
    @Column
    public String submittime;
    @Column
    public String resolvetime; 
    @Column
    public String status;
    @Column
    public String accepted;
   
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAuthorid() {
		return authorid;
	}
	public void setAuthorid(int authorid) {
		this.authorid = authorid;
	}
	public int getResolverid() {
		return resolverid;
	}
	public void setResolverid(int resolverid) {
		this.resolverid = resolverid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSubmittime() {
		return submittime;
	}
	public void setSubmittime(String submittime) {
		this.submittime = submittime;
	}
	public String getResolvetime() {
		return resolvetime;
	}
	public void setResolvetime(String resolvetime) {
		this.resolvetime = resolvetime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAccepted() {
		return accepted;
	}
	public void setAccepted(String accepted) {
		this.accepted = accepted;
	}
	
	
	public Reimbursement(int id, int authorid, int resolverid, String type, String string, String description,
			String submittime, String resolvetime, String status, String accepted) {
		super();
		this.id = id;
		this.authorid = authorid;
		this.resolverid = resolverid;
		this.type = type;
		this.amount = string;
		this.description = description;
		this.submittime = submittime;
		this.resolvetime = resolvetime;
		this.status = status;
		this.accepted = accepted;
		
	}
	public Reimbursement() {
		super();
	}
	@Override
	public String toString() {
		return "Reimbursement [id=" + id + ", authorid=" + authorid + ", resolverid=" + resolverid + ", type=" + type
				+ ", amount=" + amount + ", description=" + description + ", submittime=" + submittime
				+ ", resolvetime=" + resolvetime + ", status=" + status + ", accepted=" + accepted + "]";
	}

	
}
