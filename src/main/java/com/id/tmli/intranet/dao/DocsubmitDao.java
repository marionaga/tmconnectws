package com.id.tmli.intranet.dao;

import com.id.tmli.intranet.model.data.docsubmit.UploadsNewsDtr;

/**
 * Created by hito.mario on 9/21/2017.
 */
public interface DocsubmitDao {
    void updateAmanmend(UploadsNewsDtr data);

    int getCountSPAJDocsubmit(String spajNo);

}
