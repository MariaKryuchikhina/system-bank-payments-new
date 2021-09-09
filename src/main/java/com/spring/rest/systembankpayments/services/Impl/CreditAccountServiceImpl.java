package com.spring.rest.systembankpayments.services.Impl;

import com.spring.rest.systembankpayments.entity.CreditAccount;
import com.spring.rest.systembankpayments.repositories.CreditAccountRepository;
import com.spring.rest.systembankpayments.services.CreditAccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CreditAccountServiceImpl implements CreditAccountService {

    private final CreditAccountRepository creditAccountRepository;

    public CreditAccountServiceImpl(CreditAccountRepository creditAccountRepository) {
        this.creditAccountRepository = creditAccountRepository;
    }

    @Override
    @Transactional
    public List<CreditAccount> findAll() {
        return creditAccountRepository.findAll();
    }

    @Override
    @Transactional
    public CreditAccount findById(Long id) {
        return creditAccountRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public CreditAccount save(CreditAccount object) {
        return creditAccountRepository.save(object);
    }

    @Override
    @Transactional
    public void delete(CreditAccount object) {
        creditAccountRepository.delete(object);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        creditAccountRepository.deleteById(id);
    }
}
