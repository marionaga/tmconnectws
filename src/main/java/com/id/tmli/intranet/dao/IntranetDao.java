package com.id.tmli.intranet.dao;

import com.id.tmli.intranet.model.data.docsubmit.UploadsNewsDtr;
import com.id.tmli.intranet.model.data.intranet.*;
import com.id.tmli.intranet.model.form.DailySubmissionForm;

/**
 * Created by hito.mario on 9/21/2017.
 */
public interface IntranetDao {
    public String addSubmissionDao(DailySubmission dailySubmission, UploadsNewsDtr uploadDTR, NumberAppSpaj generateNumberSpaj, DailySubmissionForm bean) throws Exception;

    public void addSMSBroadcastPhone(TSmsBroadcast sms);

    public int getCountSpajDailySubmit(String spajNo);

    public Product getProductFromProductCode(String productCode);

    public TBranchTMConnect getBranchCode(String officeCode);

    public Branch getBranchFromBranchId(String branchCode);

    public Currency getCurrencyFromCurrencyCode(String currencyCode);

    public Long getIdTmConnect();

    public int getCountNumberApplication(String spajNo);

    public Agent getAgentFromAgentCode(String agentCode);
}
