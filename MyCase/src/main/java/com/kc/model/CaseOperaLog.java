package com.kc.model;

import java.util.Date;

public class CaseOperaLog {
    private Integer id;

    private Integer caseId;

    private String logDesc;

    private Date createDate;

    private Long userId;

    public CaseStatus getNextState() {
		return nextState;
	}

	public void setNextState(CaseStatus nextState) {
		this.nextState = nextState;
	  }
	public CaseStatus getPreState() {
		return preState;
	}

	public void setPreState(CaseStatus preState) {
		this.preState = preState;
	}

	private Byte nextStatus;//下一个状态ID
    
    private CaseStatus nextState;

    private Byte preStatus;
    
    private CaseStatus preState;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCaseId() {
        return caseId;
    }

    public void setCaseId(Integer caseId) {
        this.caseId = caseId;
    }

    public String getLogDesc() {
        return logDesc;
    }

    public void setLogDesc(String logDesc) {
        this.logDesc = logDesc == null ? null : logDesc.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Byte getNextStatus() {
        return nextStatus;
    }

    public void setNextStatus(Byte nextStatus) {
        this.nextStatus = nextStatus;
    }

    public Byte getPreStatus() {
        return preStatus;
    }

    public void setPreStatus(Byte preStatus) {
        this.preStatus = preStatus;
    }
}