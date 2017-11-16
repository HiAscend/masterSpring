package com.smart.chapter11.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * UserService
 *
 * @author ascend
 * @date 2017/11/16 9:00.
 */
@Service
public class UserService {
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void addCredits(){}
}
