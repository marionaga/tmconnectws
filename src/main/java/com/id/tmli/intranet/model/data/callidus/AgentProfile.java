package com.id.tmli.intranet.model.data.callidus;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by hito.mario on 3/20/2017.
 */
@Entity
@Table(name = "TMLI_Agent_Profile")
public class AgentProfile implements Serializable {
    /**
     *
     */
    @Id
    @Column(name = "PAYEEID")
    private String payeeid;

    @Column(name = "LSURNAME")
    private String lsurname;

    @Column(name = "LGIVNAME")
    private String lgivname;

    @Column(name = "CLTSEX")
    private String cltsex;

    @Column(name = "CLTDOB")
    private String cltdob;

    @Column(name = "SECUITYNO")
    private String securityno;

    @Column(name = "EXPDTE")
    private String expdte;

    @Column(name = "SALUTL")
    private String salutl;

    @Column(name = "NATLTY")
    private String natlty;

    @Column(name = "MARRYD")
    private String marryd;

    @Column(name = "BIRTHP")
    private String birthp;

    @Column(name = "ADDRTYPE")
    private String addrtype;

    @Column(name = "CLTADDR01")
    private String cltaddr01;

    @Column(name = "CLTADDR02")
    private String cltaddr02;

    @Column(name = "CLTADDR03")
    private String cltaddr03;

    @Column(name = "CLTADDR04")
    private String cltaddr04;

    @Column(name = "CLTADDR05")
    private String cltaddr05;

    @Column(name = "CLTPCODE")
    private String cltpcode;

    @Column(name = "CTRYCODE")
    private String ctrycode;

    @Column(name = "RINTERNET")
    private String rinternet;

    @Column(name = "RMBLPHONE")
    private String rmblphone;

    @Column(name = "CLTPHONE01")
    private String cltphone01;

    @Column(name = "CLTPHONE02")
    private String cltphone02;

    @Column(name = "XREFNO")
    private String xrefno;

    @Column(name = "ZEDUCATN")
    private String zeducatn;

    @Column(name = "ZRELIGN")
    private String zrelign;

    @Column(name = "AGNTNUM")
    private String agntnum;

    @Column(name = "DTEAPP")
    private String dteapp;

    @Column(name = "DTETRM")
    private String dtetrm;

    @Column(name = "AGTYPE")
    private String agtype;

    @Column(name = "ARACDE")
    private String aracde;

    @Column(name = "TSALESUNT")
    private String tsalesunt;

    @Column(name = "ZRECRUIT")
    private String zrecruit;

    @Column(name = "REPORTAG")
    private String reportag;

    @Column(name = "TLAGLICNO")
    private String tlaglicno;

    @Column(name = "TLICEXPDT")
    private String tlicexpdt;

    @Column(name = "PAYMTH")
    private String paymth;

    @Column(name = "PAYFRQ")
    private String payfrq;

    @Column(name = "CURRCODE")
    private String currcode;

    @Column(name = "TAXMETH")
    private String taxmeth;

    @Column(name = "BANKKEY")
    private String bankkey;

    @Column(name = "BANKACOUNT")
    private String bankacount;

    @Column(name = "DATEFROM")
    private String datefrom;

    @Column(name = "BANKACCDSC")
    private String bankaccdsc;

    @Column(name = "BNKACTYP")
    private String bankactyp;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "UPDATEDATE")
    private String updatedate;

    @Column(name = "TLICEXPDT_S")
    private String tlicexpdt_s;

    @Column(name = "TLAGLICNO_S")
    private String tlaglicno_s;

    @Column(name = "PAYEESEQ")
    private String payeeseq;

    @Column(name = "LICENSESEQ")
    private String licenceseq;

    @Column(name = "OFFICE_CODE")
    private String office_code;

    @Column(name = "OFFICE_TYPE")
    private String office_type;

    @Column(name = "OFFICE_NAME")
    private String office_name;

    @Column(name = "emailPersonal")
    private String emailPersonal;

    public String getPayeeid() {
        return payeeid;
    }

    public void setPayeeid(String payeeid) {
        this.payeeid = payeeid;
    }

    public String getLsurname() {
        return lsurname;
    }

    public void setLsurname(String lsurname) {
        this.lsurname = lsurname;
    }

    public String getLgivname() {
        return lgivname;
    }

    public void setLgivname(String lgivname) {
        this.lgivname = lgivname;
    }

    public String getCltsex() {
        return cltsex;
    }

    public void setCltsex(String cltsex) {
        this.cltsex = cltsex;
    }

    public String getCltdob() {
        return cltdob;
    }

    public void setCltdob(String cltdob) {
        this.cltdob = cltdob;
    }

    public String getSecurityno() {
        return securityno;
    }

    public void setSecurityno(String securityno) {
        this.securityno = securityno;
    }

    public String getExpdte() {
        return expdte;
    }

    public void setExpdte(String expdte) {
        this.expdte = expdte;
    }

    public String getSalutl() {
        return salutl;
    }

    public void setSalutl(String salutl) {
        this.salutl = salutl;
    }

    public String getNatlty() {
        return natlty;
    }

    public void setNatlty(String natlty) {
        this.natlty = natlty;
    }

    public String getMarryd() {
        return marryd;
    }

    public void setMarryd(String marryd) {
        this.marryd = marryd;
    }

    public String getBirthp() {
        return birthp;
    }

    public void setBirthp(String birthp) {
        this.birthp = birthp;
    }

    public String getAddrtype() {
        return addrtype;
    }

    public void setAddrtype(String addrtype) {
        this.addrtype = addrtype;
    }

    public String getCltaddr01() {
        return cltaddr01;
    }

    public void setCltaddr01(String cltaddr01) {
        this.cltaddr01 = cltaddr01;
    }

    public String getCltaddr02() {
        return cltaddr02;
    }

    public void setCltaddr02(String cltaddr02) {
        this.cltaddr02 = cltaddr02;
    }

    public String getCltaddr03() {
        return cltaddr03;
    }

    public void setCltaddr03(String cltaddr03) {
        this.cltaddr03 = cltaddr03;
    }

    public String getCltaddr04() {
        return cltaddr04;
    }

    public void setCltaddr04(String cltaddr04) {
        this.cltaddr04 = cltaddr04;
    }

    public String getCltaddr05() {
        return cltaddr05;
    }

    public void setCltaddr05(String cltaddr05) {
        this.cltaddr05 = cltaddr05;
    }

    public String getCltpcode() {
        return cltpcode;
    }

    public void setCltpcode(String cltpcode) {
        this.cltpcode = cltpcode;
    }

    public String getCtrycode() {
        return ctrycode;
    }

    public void setCtrycode(String ctrycode) {
        this.ctrycode = ctrycode;
    }

    public String getRinternet() {
        return rinternet;
    }

    public void setRinternet(String rinternet) {
        this.rinternet = rinternet;
    }

    public String getRmblphone() {
        return rmblphone;
    }

    public void setRmblphone(String rmblphone) {
        this.rmblphone = rmblphone;
    }

    public String getCltphone01() {
        return cltphone01;
    }

    public void setCltphone01(String cltphone01) {
        this.cltphone01 = cltphone01;
    }

    public String getCltphone02() {
        return cltphone02;
    }

    public void setCltphone02(String cltphone02) {
        this.cltphone02 = cltphone02;
    }

    public String getXrefno() {
        return xrefno;
    }

    public void setXrefno(String xrefno) {
        this.xrefno = xrefno;
    }

    public String getZeducatn() {
        return zeducatn;
    }

    public void setZeducatn(String zeducatn) {
        this.zeducatn = zeducatn;
    }

    public String getZrelign() {
        return zrelign;
    }

    public void setZrelign(String zrelign) {
        this.zrelign = zrelign;
    }

    public String getAgntnum() {
        return agntnum;
    }

    public void setAgntnum(String agntnum) {
        this.agntnum = agntnum;
    }

    public String getDteapp() {
        return dteapp;
    }

    public void setDteapp(String dteapp) {
        this.dteapp = dteapp;
    }

    public String getDtetrm() {
        return dtetrm;
    }

    public void setDtetrm(String dtetrm) {
        this.dtetrm = dtetrm;
    }

    public String getAgtype() {
        return agtype;
    }

    public void setAgtype(String agtype) {
        this.agtype = agtype;
    }

    public String getAracde() {
        return aracde;
    }

    public void setAracde(String aracde) {
        this.aracde = aracde;
    }

    public String getTsalesunt() {
        return tsalesunt;
    }

    public void setTsalesunt(String tsalesunt) {
        this.tsalesunt = tsalesunt;
    }

    public String getZrecruit() {
        return zrecruit;
    }

    public void setZrecruit(String zrecruit) {
        this.zrecruit = zrecruit;
    }

    public String getReportag() {
        return reportag;
    }

    public void setReportag(String reportag) {
        this.reportag = reportag;
    }

    public String getTlaglicno() {
        return tlaglicno;
    }

    public void setTlaglicno(String tlaglicno) {
        this.tlaglicno = tlaglicno;
    }

    public String getTlicexpdt() {
        return tlicexpdt;
    }

    public void setTlicexpdt(String tlicexpdt) {
        this.tlicexpdt = tlicexpdt;
    }

    public String getPaymth() {
        return paymth;
    }

    public void setPaymth(String paymth) {
        this.paymth = paymth;
    }

    public String getPayfrq() {
        return payfrq;
    }

    public void setPayfrq(String payfrq) {
        this.payfrq = payfrq;
    }

    public String getCurrcode() {
        return currcode;
    }

    public void setCurrcode(String currcode) {
        this.currcode = currcode;
    }

    public String getTaxmeth() {
        return taxmeth;
    }

    public void setTaxmeth(String taxmeth) {
        this.taxmeth = taxmeth;
    }

    public String getBankkey() {
        return bankkey;
    }

    public void setBankkey(String bankkey) {
        this.bankkey = bankkey;
    }

    public String getBankacount() {
        return bankacount;
    }

    public void setBankacount(String bankacount) {
        this.bankacount = bankacount;
    }

    public String getDatefrom() {
        return datefrom;
    }

    public void setDatefrom(String datefrom) {
        this.datefrom = datefrom;
    }

    public String getBankaccdsc() {
        return bankaccdsc;
    }

    public void setBankaccdsc(String bankaccdsc) {
        this.bankaccdsc = bankaccdsc;
    }

    public String getBankactyp() {
        return bankactyp;
    }

    public void setBankactyp(String bankactyp) {
        this.bankactyp = bankactyp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(String updatedate) {
        this.updatedate = updatedate;
    }

    public String getTlicexpdt_s() {
        return tlicexpdt_s;
    }

    public void setTlicexpdt_s(String tlicexpdt_s) {
        this.tlicexpdt_s = tlicexpdt_s;
    }

    public String getTlaglicno_s() {
        return tlaglicno_s;
    }

    public void setTlaglicno_s(String tlaglicno_s) {
        this.tlaglicno_s = tlaglicno_s;
    }

    public String getPayeeseq() {
        return payeeseq;
    }

    public void setPayeeseq(String payeeseq) {
        this.payeeseq = payeeseq;
    }

    public String getLicenceseq() {
        return licenceseq;
    }

    public void setLicenceseq(String licenceseq) {
        this.licenceseq = licenceseq;
    }

    public String getOffice_code() {
        return office_code;
    }

    public void setOffice_code(String office_code) {
        this.office_code = office_code;
    }

    public String getOffice_type() {
        return office_type;
    }

    public void setOffice_type(String office_type) {
        this.office_type = office_type;
    }

    public String getOffice_name() {
        return office_name;
    }

    public void setOffice_name(String office_name) {
        this.office_name = office_name;
    }

    public String getEmailPersonal() {
        return emailPersonal;
    }

    public void setEmailPersonal(String emailPersonal) {
        this.emailPersonal = emailPersonal;
    }
}
