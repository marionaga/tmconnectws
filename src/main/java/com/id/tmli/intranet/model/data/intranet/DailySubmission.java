package com.id.tmli.intranet.model.data.intranet;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;
import org.hibernate.validator.constraints.Email;

import com.id.tmli.intranet.common.BaseEntity;


@Entity
@Table(name="T_DAILYSUBMIT")
public class DailySubmission extends BaseEntity {

    /**
     *
     */
    private static final long serialVersionUID = 2880082669931479388L;

    @Column(name="POLICY_HOLDER",length=80)
    private String policyHolder;

    @Column(name="INSURED_NAME",length=80)
    private String insuredName;

    @Column(name="SPAJ_NO",length=20)
    private String spajNo;

    @ManyToOne
    @JoinColumn(name="BRANCH_ID")
    private Branch branch;

    @Column(name="POLICY_NO",length=15)
    private String policyNo;

    @Column(name="PREMIUM")
    private BigDecimal premium;

    @Column(name="TOPUP_REG")
    private BigDecimal topupReguler;

    @Column(name="TOPUP_SING")
    private BigDecimal topupSingle;

    @Temporal(TemporalType.DATE)
    @Column(name="SUBMIT_DATE")
    private Date submitDate;

    @Column(name="SEND_DATE")
    private Date sendDate;

    @Column(name="PAYMODE",length=20)
    private String paymentMode;

    @ManyToOne
    @JoinColumn(name="STATE")
    private StateSpaj state;

    @ManyToOne
    @JoinColumn(name="AGENT_ID")
    private Agent agent;

    @ManyToOne
    @JoinColumn(name="PRODUCT_ID")
    private Product product;

    @Column(name="LASTST_DATE")
    private Date lastStatusDate;

    @Column(name="TOTAL_APE")
    private BigDecimal totalApe;

    @Column(name="CIF")
    private BigInteger cif;

    @Column(name="ACCOUNT_NO")
    private String accNo;

    @Column(name="TYPE_SPAJ")
    private String typeSpaj;

    @Transient
    @OneToMany(mappedBy = "id")
    private List<DailySubmissionLog> dailySubmissionLog;

    /*@ManyToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinTable(name="T_DAILYSUBMIT_REM_MAP", joinColumns={@JoinColumn(name="SUBMIT_ID")},
            inverseJoinColumns={@JoinColumn(name="REMARK_ID")})
    private Set<DailySubmissionRemark> remark = new HashSet<DailySubmissionRemark>();*/

    @Column(name="REMARK_NOTE",length=255)
    private String otherRemark;

    @Column(name="AGENT_RECEIVE_DATE")
    private Date agentReceiveDate;

    @Column(name="CUSTOMER_RECEIVE_DATE")
    private Date customerReceiveDate;

    @Column(name="POLICY_RECEIVER")
    private String policyReceiver;

    @Column(name="POLICY_RECEIVER_IND")
    private String policyReceiverIndi;

    @Column(name="ADMIN_RECEIVE_DATE")
    private Date adminReceiveDate;

    @Column(name="MOBILE_NO")
    private String mobileNo;

    @Column(name="email") @Email(message="Please provide a valid email address")
    private String email;

    @ManyToOne
    @JoinColumn(name="CURRENCY_CODE")
    private Currency currency;

    @Column(name="STATUS_DATE")
    private Date statusDate;

/*    @OneToOne(mappedBy="submission", cascade=CascadeType.ALL)
    private DailySubmissionReceivePolicy dailySubmissionReceivePolicy;*/


    @OneToOne(mappedBy="submission",optional=false, cascade=CascadeType.ALL)
    private DailySubmissionReceivePolicy dailySubmissionReceivePolicy;

    public String getPolicyHolder() {
        return policyHolder;
    }

    public void setPolicyHolder(String policyHolder) {
        this.policyHolder = policyHolder;
    }

    public String getInsuredName() {
        return insuredName;
    }

    public void setInsuredName(String insuredName) {
        this.insuredName = insuredName;
    }

    public String getSpajNo() {
        return spajNo;
    }

    public void setSpajNo(String spajNo) {
        this.spajNo = spajNo;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public BigDecimal getPremium() {
        return premium;
    }

    public void setPremium(BigDecimal premium) {
        this.premium = premium;
    }

    public BigDecimal getTopupReguler() {
        return topupReguler;
    }

    public void setTopupReguler(BigDecimal topupReguler) {
        this.topupReguler = topupReguler;
    }

    public BigDecimal getTopupSingle() {
        return topupSingle;
    }

    public void setTopupSingle(BigDecimal topupSingle) {
        this.topupSingle = topupSingle;
    }

    public Date getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(Date submitDate) {
        this.submitDate = submitDate;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public StateSpaj getState() {
        return state;
    }

    public void setState(StateSpaj state) {
        this.state = state;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Date getLastStatusDate() {
        return lastStatusDate;
    }

    public void setLastStatusDate(Date lastStatusDate) {
        this.lastStatusDate = lastStatusDate;
    }

    public List<DailySubmissionLog> getDailySubmissionLog() {
        return dailySubmissionLog;
    }

    public void setDailySubmissionLog(List<DailySubmissionLog> dailySubmissionLog) {
        this.dailySubmissionLog = dailySubmissionLog;
    }

    /*public Set<DailySubmissionRemark> getRemark() {
        return remark;
    }

    public void setRemark(Set<DailySubmissionRemark> remark) {
        this.remark = remark;
    }*/

    public String getOtherRemark() {
        return otherRemark;
    }

    public void setOtherRemark(String otherRemark) {
        this.otherRemark = otherRemark;
    }

    public Date getAgentReceiveDate() {
        return agentReceiveDate;
    }

    public void setAgentReceiveDate(Date agentReceiveDate) {
        this.agentReceiveDate = agentReceiveDate;
    }

    public Date getCustomerReceiveDate() {
        return customerReceiveDate;
    }

    public void setCustomerReceiveDate(Date customerReceiveDate) {
        this.customerReceiveDate = customerReceiveDate;
    }

    public String getPolicyReceiver() {
        return policyReceiver;
    }

    public void setPolicyReceiver(String policyReceiver) {
        this.policyReceiver = policyReceiver;
    }

    public String getPolicyReceiverIndi() {
        return policyReceiverIndi;
    }

    public void setPolicyReceiverIndi(String policyReceiverIndi) {
        this.policyReceiverIndi = policyReceiverIndi;
    }

    public Date getAdminReceiveDate() {
        return adminReceiveDate;
    }

    public void setAdminReceiveDate(Date adminReceiveDate) {
        this.adminReceiveDate = adminReceiveDate;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public DailySubmissionReceivePolicy getDailySubmissionReceivePolicy() {
        return dailySubmissionReceivePolicy;
    }

    public void setDailySubmissionReceivePolicy(
            DailySubmissionReceivePolicy dailySubmissionReceivePolicy) {
        this.dailySubmissionReceivePolicy = dailySubmissionReceivePolicy;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Date getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(Date statusDate) {
        this.statusDate = statusDate;
    }

    public BigInteger getCif() {
        return cif;
    }

    public void setCif(BigInteger cif) {
        this.cif = cif;
    }

    public String getAccNo() {
        return accNo;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }

    public BigDecimal getTotalApe() {
        return totalApe;
    }

    public void setTotalApe(BigDecimal totalApe) {
        this.totalApe = totalApe;
    }

    public String getTypeSpaj() {
        return typeSpaj;
    }

    public void setTypeSpaj(String typeSpaj) {
        this.typeSpaj = typeSpaj;
    }
}
