package com.id.tmli.intranet.service;

import com.id.tmli.intranet.model.data.docsubmit.UploadsNewsDtr;
import com.id.tmli.intranet.model.form.UpdateFileAmendment;

/**
 * Created by hito.mario on 9/21/2017.
 */
public interface UploadService {
    public void uploadAmanmendFile(UpdateFileAmendment data) throws RuntimeException;
    public boolean isSpajNoExists(String spajNo);
    public UploadsNewsDtr getBranchNameDocSubmit(String spajNo);
}
