package com.kc.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Case {
    private Long id;

    private String title;//标题

    private String name;//名字

    private String customerName;

    private String debtorName;

    private String customerLinkmanName;

    private String customerLinkmanTel;

    private String debtorUserName;

    private String debtorLinkmanName;

    private String debtorLinkmanTel;

    private String address;

    private BigDecimal brokerage;

    private BigDecimal brokerageRate;

    private String brokerageDesc;

    private BigDecimal brokeragePaid;

    private BigDecimal invoice;

    private Date contractBeginDate;

    private Date contractEndDate;

    private BigDecimal contractMoney;

    private BigDecimal contractPaidMoney;

    private String salesman;

    private Byte status;
    
    private CaseStatus caseStatus;

    private Byte type;

    private Long handleUser;

    private Long handleManager;

    private Date createDate;

    private Date updatedDate;
    
    private List<CaseOperaLog> caseOperaLog;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName == null ? null : customerName.trim();
    }

    public String getDebtorName() {
        return debtorName;
    }

    public void setDebtorName(String debtorName) {
        this.debtorName = debtorName == null ? null : debtorName.trim();
    }

    public String getCustomerLinkmanName() {
        return customerLinkmanName;
    }

    public void setCustomerLinkmanName(String customerLinkmanName) {
        this.customerLinkmanName = customerLinkmanName == null ? null : customerLinkmanName.trim();
    }

    public String getCustomerLinkmanTel() {
        return customerLinkmanTel;
    }

    public void setCustomerLinkmanTel(String customerLinkmanTel) {
        this.customerLinkmanTel = customerLinkmanTel == null ? null : customerLinkmanTel.trim();
    }

    public String getDebtorUserName() {
        return debtorUserName;
    }

    public void setDebtorUserName(String debtorUserName) {
        this.debtorUserName = debtorUserName == null ? null : debtorUserName.trim();
    }

    public String getDebtorLinkmanName() {
        return debtorLinkmanName;
    }

    public void setDebtorLinkmanName(String debtorLinkmanName) {
        this.debtorLinkmanName = debtorLinkmanName == null ? null : debtorLinkmanName.trim();
    }

    public String getDebtorLinkmanTel() {
        return debtorLinkmanTel;
    }

    public void setDebtorLinkmanTel(String debtorLinkmanTel) {
        this.debtorLinkmanTel = debtorLinkmanTel == null ? null : debtorLinkmanTel.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public BigDecimal getBrokerage() {
        return brokerage;
    }

    public void setBrokerage(BigDecimal brokerage) {
        this.brokerage = brokerage;
    }

    public BigDecimal getBrokerageRate() {
        return brokerageRate;
    }

    public void setBrokerageRate(BigDecimal brokerageRate) {
        this.brokerageRate = brokerageRate;
    }

    public String getBrokerageDesc() {
        return brokerageDesc;
    }

    public void setBrokerageDesc(String brokerageDesc) {
        this.brokerageDesc = brokerageDesc == null ? null : brokerageDesc.trim();
    }

    public BigDecimal getBrokeragePaid() {
        return brokeragePaid;
    }

    public void setBrokeragePaid(BigDecimal brokeragePaid) {
        this.brokeragePaid = brokeragePaid;
    }

    public BigDecimal getInvoice() {
        return invoice;
    }

    public void setInvoice(BigDecimal invoice) {
        this.invoice = invoice;
    }

    public Date getContractBeginDate() {
        return contractBeginDate;
    }

    public void setContractBeginDate(Date contractBeginDate) {
        this.contractBeginDate = contractBeginDate;
    }

    public Date getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(Date contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public BigDecimal getContractMoney() {
        return contractMoney;
    }

    public void setContractMoney(BigDecimal contractMoney) {
        this.contractMoney = contractMoney;
    }

    public BigDecimal getContractPaidMoney() {
        return contractPaidMoney;
    }

    public void setContractPaidMoney(BigDecimal contractPaidMoney) {
        this.contractPaidMoney = contractPaidMoney;
    }

    public String getSalesman() {
        return salesman;
    }

    public void setSalesman(String salesman) {
        this.salesman = salesman == null ? null : salesman.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Long getHandleUser() {
        return handleUser;
    }

    public void setHandleUser(Long handleUser) {
        this.handleUser = handleUser;
    }

    public Long getHandleManager() {
        return handleManager;
    }

    public void setHandleManager(Long handleManager) {
        this.handleManager = handleManager;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

	public CaseStatus getCaseStatus() {
		return caseStatus;
	}

	public void setCaseStatus(CaseStatus caseStatus) {
		this.caseStatus = caseStatus;
	}

	public List<CaseOperaLog> getCaseOperaLog() {
		return caseOperaLog;
	}

	public void setCaseOperaLog(List<CaseOperaLog> caseOperaLog) {
		this.caseOperaLog = caseOperaLog;
	}
}