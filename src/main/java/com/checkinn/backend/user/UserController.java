package com.checkinn.backend.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/agent")
public class UserController {

    @GetMapping
    public long getCurrentAgentId(){return 2;}


}
