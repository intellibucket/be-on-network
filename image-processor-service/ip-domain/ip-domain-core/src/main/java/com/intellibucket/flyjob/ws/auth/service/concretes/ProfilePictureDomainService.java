package com.intellibucket.flyjob.ws.auth.service.concretes;

import com.intellibucket.flyjob.ws.auth.service.abstracts.AbstractProfilePictureDomainService;
import lombok.extern.slf4j.Slf4j;

public class ProfilePictureDomainService implements AbstractProfilePictureDomainService {
    @Override
    public void process() {
        System.out.println("ProfilePictureDomainService.process()");
    }
}

