package com.checkinn.backend.agent;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/agent")
public class AgentController {

    @GetMapping
    public long getCurrentAgentId(){return 2;}


}
