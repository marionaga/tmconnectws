package com.id.tmli.intranet.dao;

import com.id.tmli.intranet.model.data.callidus.AgentProfile;

/**
 * Created by hito.mario on 9/21/2017.
 */
public interface CallidusDao {
    AgentProfile getAgentCallidusFromAgentCode(String agentCode);
}
