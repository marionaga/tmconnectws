package com.id.tmli.intranet.model.data.intranet;

import com.id.tmli.intranet.common.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by hito.mario on 06/02/2017.
 */
@Entity
@Table(name="T_DAILYSUBMITLOG")
public class DailySubmissionLog extends BaseEntity {

    /**
     *
     */
    private static final long serialVersionUID = 6052843537346449603L;


    @ManyToOne
    @JoinColumn(name="STATE")
    private StateSpaj state;

    @ManyToOne
    @JoinColumn(name="SUBMIT_ID")
    private DailySubmission submission;

    public StateSpaj getState() {
        return state;
    }

    public void setState(StateSpaj state) {
        this.state = state;
    }

    public DailySubmission getSubmission() {
        return submission;
    }

    public void setSubmission(DailySubmission submission) {
        this.submission = submission;
    }

}