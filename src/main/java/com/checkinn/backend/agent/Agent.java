package com.checkinn.backend.agent;



public class Agent {

    private Long agentId;

    private String userName;
    private String password;



    public Agent(String userName, String password) {
        this.userName = userName;
        this.password = password;

    }


    public Long getAgentId() {
        return agentId;
    }

    public void setAgentId(Long agentId) {
        this.agentId = agentId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }



    public String getPassword() {
        return password;
    }




    public void setPassword(String password) {
        this.password = password;
    }


}
