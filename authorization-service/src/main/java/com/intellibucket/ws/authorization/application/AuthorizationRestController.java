package com.intellibucket.ws.authorization.application;

import com.intellibucket.lib.client.abstracts.AuthorizationApi;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authorization/1.0/private/context-holder")
public class AuthorizationRestController implements AuthorizationApi {
}
