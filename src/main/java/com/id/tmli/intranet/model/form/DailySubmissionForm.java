package com.id.tmli.intranet.model.form;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.math.BigInteger;

/**
 * Created by hito.mario on 07/02/2017.
 */
public class DailySubmissionForm {

    private String branch_id;
    private String user_upload;
    private String agent_code;
    private String policy_holder;
    private String insured;
    private String phone_no;
    private String email;
    private String spaj_no;
    private String paymode;
    private String product_id;
//    private String product_id_basic;
    private String currency;
    private String premium;
    private String top_reg;
    private String top_sekaligus;
    private String spaj_a1;
    private String spaj_a2;
    private String spaj_a3;
    private String spaj_a4;
    private String spaj_a5;
    private String spaj_a6;
    private String spaj_a7;
    private String spaj_a8;
    private String spaj_a9;
    private String spaj_a10;
    private String spaj_b1;
    private String spaj_b2;
    private String spaj_b3;
    private String spaj_b4;
    private String spaj_b5;
    private String spaj_b6;
    private String spaj_b7;
    private String spaj_b8;
    private String spaj_b9;
    private String spaj_b10;
    private String birth_date_user;
    private String ilustration_no;
    private String type_va;
    private String va_number;

    public String getSpaj_no() {
        return spaj_no;
    }

    public void setSpaj_no(String spaj_no) {
        this.spaj_no = spaj_no;
    }

    public String getPremium() {
        return premium;
    }

    public void setPremium(String premium) {
        this.premium = premium;
    }

    public String getTop_reg() {
        return top_reg;
    }

    public void setTop_reg(String top_reg) {
        this.top_reg = top_reg;
    }

    public String getTop_sekaligus() {
        return top_sekaligus;
    }

    public void setTop_sekaligus(String top_sekaligus) {
        this.top_sekaligus = top_sekaligus;
    }

    public String getSpaj_a1() {
        return spaj_a1;
    }

    public void setSpaj_a1(String spaj_a1) {
        this.spaj_a1 = spaj_a1;
    }

    public String getSpaj_a2() {
        return spaj_a2;
    }

    public void setSpaj_a2(String spaj_a2) {
        this.spaj_a2 = spaj_a2;
    }

    public String getSpaj_a3() {
        return spaj_a3;
    }

    public void setSpaj_a3(String spaj_a3) {
        this.spaj_a3 = spaj_a3;
    }

    public String getSpaj_a4() {
        return spaj_a4;
    }

    public void setSpaj_a4(String spaj_a4) {
        this.spaj_a4 = spaj_a4;
    }

    public String getSpaj_a5() {
        return spaj_a5;
    }

    public void setSpaj_a5(String spaj_a5) {
        this.spaj_a5 = spaj_a5;
    }

    public String getSpaj_b1() {
        return spaj_b1;
    }

    public void setSpaj_b1(String spaj_b1) {
        this.spaj_b1 = spaj_b1;
    }

    public String getSpaj_b2() {
        return spaj_b2;
    }

    public void setSpaj_b2(String spaj_b2) {
        this.spaj_b2 = spaj_b2;
    }

    public String getSpaj_b3() {
        return spaj_b3;
    }

    public void setSpaj_b3(String spaj_b3) {
        this.spaj_b3 = spaj_b3;
    }

    public String getSpaj_b4() {
        return spaj_b4;
    }

    public void setSpaj_b4(String spaj_b4) {
        this.spaj_b4 = spaj_b4;
    }

    public String getSpaj_b5() {
        return spaj_b5;
    }

    public void setSpaj_b5(String spaj_b5) {
        this.spaj_b5 = spaj_b5;
    }

    public String getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(String branch_id) {
        this.branch_id = branch_id;
    }

    public String getAgent_code() {
        return agent_code;
    }

    public void setAgent_code(String agent_code) {
        this.agent_code = agent_code;
    }

    public String getPolicy_holder() {
        return policy_holder;
    }

    public void setPolicy_holder(String policy_holder) {
        this.policy_holder = policy_holder;
    }

    public String getInsured() {
        return insured;
    }

    public void setInsured(String insured) {
        this.insured = insured;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPaymode() {
        return paymode;
    }

    public void setPaymode(String paymode) {
        this.paymode = paymode;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getUser_upload() {
        return user_upload;
    }

    public void setUser_upload(String user_upload) {
        this.user_upload = user_upload;
    }

    public String getBirth_date_user() {
        return birth_date_user;
    }

    public void setBirth_date_user(String birth_date_user) {
        this.birth_date_user = birth_date_user;
    }

    public String getIlustration_no() {
        return ilustration_no;
    }

    public void setIlustration_no(String ilustration_no) {
        this.ilustration_no = ilustration_no;
    }

    public String getType_va() {
        return type_va;
    }

    public void setType_va(String type_va) {
        this.type_va = type_va;
    }

    public String getVa_number() {
        return va_number;
    }

    public void setVa_number(String va_number) {
        this.va_number = va_number;
    }

    /*public String getProduct_id_basic() {
        return product_id_basic;
    }

    public void setProduct_id_basic(String product_id_basic) {
        this.product_id_basic = product_id_basic;
    }*/

    public String getSpaj_a6() {
        return spaj_a6;
    }

    public void setSpaj_a6(String spaj_a6) {
        this.spaj_a6 = spaj_a6;
    }

    public String getSpaj_a7() {
        return spaj_a7;
    }

    public void setSpaj_a7(String spaj_a7) {
        this.spaj_a7 = spaj_a7;
    }

    public String getSpaj_a8() {
        return spaj_a8;
    }

    public void setSpaj_a8(String spaj_a8) {
        this.spaj_a8 = spaj_a8;
    }

    public String getSpaj_a9() {
        return spaj_a9;
    }

    public void setSpaj_a9(String spaj_a9) {
        this.spaj_a9 = spaj_a9;
    }

    public String getSpaj_a10() {
        return spaj_a10;
    }

    public void setSpaj_a10(String spaj_a10) {
        this.spaj_a10 = spaj_a10;
    }

    public String getSpaj_b6() {
        return spaj_b6;
    }

    public void setSpaj_b6(String spaj_b6) {
        this.spaj_b6 = spaj_b6;
    }

    public String getSpaj_b7() {
        return spaj_b7;
    }

    public void setSpaj_b7(String spaj_b7) {
        this.spaj_b7 = spaj_b7;
    }

    public String getSpaj_b8() {
        return spaj_b8;
    }

    public void setSpaj_b8(String spaj_b8) {
        this.spaj_b8 = spaj_b8;
    }

    public String getSpaj_b9() {
        return spaj_b9;
    }

    public void setSpaj_b9(String spaj_b9) {
        this.spaj_b9 = spaj_b9;
    }

    public String getSpaj_b10() {
        return spaj_b10;
    }

    public void setSpaj_b10(String spaj_b10) {
        this.spaj_b10 = spaj_b10;
    }
}
