package com.intellibucket.onnetwork.company.domain.core.command.exception;

import az.rock.lib.jexception.JDomainException;
import az.rock.lib.jexception.JRuntimeException;

public class HiringStatusUnchangedException extends JRuntimeException {
    public HiringStatusUnchangedException() {
        super("F0000000008");
    }
}