package com.tide.sgbs5.model;

public class UsedCurrentDTO {

	private int seq;
	private String lp_cptr_time;			
	private String lp_cptr_onlydate;	//%Y-%d-%m
	private String lp_cptr_onlytime;	//%H:%i:%s
	private String rcv_act_lp;		// (순방향)유효 누적 전력량	
	private String addr1;			// 세대주 동
	private String addr2;			// 세대주 호
	private String rsd_id;			// 세대주 동호수
	private String lp_act_pwrer;	 // 유효 사용량
	private String act_pwrer;		// 유효 누적 사용량
	private String lp_ract_pwrer;	 // 무효 사용량
	private String ract_pwrer;		// 무효 누적 사용량	
	private String rownum;		// 검색시 시퀀스
	
	
	
	public String getLp_ract_pwrer() {
		return lp_ract_pwrer;
	}
	public void setLp_ract_pwrer(String lp_ract_pwrer) {
		this.lp_ract_pwrer = lp_ract_pwrer;
	}
	public String getRact_pwrer() {
		return ract_pwrer;
	}
	public void setRact_pwrer(String ract_pwrer) {
		this.ract_pwrer = ract_pwrer;
	}
	public String getAct_pwrer() {
		return act_pwrer;
	}
	public void setAct_pwrer(String act_pwrer) {
		this.act_pwrer = act_pwrer;
	}
	public String getRownum() {
		return rownum;
	}
	public void setRownum(String rownum) {
		this.rownum = rownum;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getLp_cptr_time() {
		return lp_cptr_time;
	}
	public void setLp_cptr_time(String lp_cptr_time) {
		this.lp_cptr_time = lp_cptr_time;
	}
	public String getLp_cptr_onlydate() {
		return lp_cptr_onlydate;
	}
	public void setLp_cptr_onlydate(String lp_cptr_onlydate) {
		this.lp_cptr_onlydate = lp_cptr_onlydate;
	}
	public String getLp_cptr_onlytime() {
		return lp_cptr_onlytime;
	}
	public void setLp_cptr_onlytime(String lp_cptr_onlytime) {
		this.lp_cptr_onlytime = lp_cptr_onlytime;
	}
	public String getRcv_act_lp() {
		return rcv_act_lp;
	}
	public void setRcv_act_lp(String rcv_act_lp) {
		this.rcv_act_lp = rcv_act_lp;
	}
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	public String getRsd_id() {
		return rsd_id;
	}
	public void setRsd_id(String rsd_id) {
		this.rsd_id = rsd_id;
	}
	public String getLp_act_pwrer() {
		return lp_act_pwrer;
	}
	public void setLp_act_pwrer(String lp_act_pwrer) {
		this.lp_act_pwrer = lp_act_pwrer;
	}
	
	
}