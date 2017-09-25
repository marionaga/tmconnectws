package com.id.tmli.intranet.service;

import com.id.tmli.intranet.model.form.DailySubmissionForm;

/**
 * Created by hito.mario on 9/21/2017.
 */
public interface DailySubmissionService {
    public void insertDataSubmission(DailySubmissionForm bean) throws RuntimeException;
}
