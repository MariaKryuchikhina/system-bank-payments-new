package com.spring.rest.systembankpayments.services.Impl;

import com.spring.rest.systembankpayments.entity.DepositAccount;
import com.spring.rest.systembankpayments.repositories.DepositAccountRepository;
import com.spring.rest.systembankpayments.services.DepositAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DepositAccountServiceImpl implements DepositAccountService {

    @Autowired
    private DepositAccountRepository depositAccountRepository;

    @Override
    @Transactional
    public List<DepositAccount> findAll() {
        return depositAccountRepository.findAll();
    }

    @Override
    @Transactional
    public DepositAccount findById(Long id) {
        return depositAccountRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public DepositAccount save(DepositAccount object) {
        return depositAccountRepository.save(object);
    }

    @Override
    @Transactional
    public void delete(DepositAccount object) {
        depositAccountRepository.delete(object);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        depositAccountRepository.deleteById(id);
    }
}
