package com.intellibucket.onnetwork.vacancy.presentation.command.ports.input.service.query.abstracts;


import az.rock.lib.annotation.InputPort;
import org.springframework.transaction.annotation.Transactional;

@InputPort
@Transactional(readOnly = true)
public interface AbstractVacancyCommandPrivateController {

}
