package com.spring.rest.systembankpayments.services.Impl;

import com.spring.rest.systembankpayments.entity.DepositAccount;
import com.spring.rest.systembankpayments.repositories.DepositAccountRepository;
import com.spring.rest.systembankpayments.services.DepositAccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class DepositAccountServiceImpl implements DepositAccountService {


    private final DepositAccountRepository depositAccountRepository;

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
    public DepositAccount deleteById(Long id) {
        depositAccountRepository.deleteById(id);
        return null;
    }
}
