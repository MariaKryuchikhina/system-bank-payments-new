package com.spring.rest.systembankpayments.services.Impl;

import com.spring.rest.systembankpayments.entity.MainAccount;
import com.spring.rest.systembankpayments.repositories.MainAccountRepository;
import com.spring.rest.systembankpayments.services.MainAccountService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class MainAccountServiceImpl implements MainAccountService {

    private final MainAccountRepository mainAccountRepository;

    @Override
    @Transactional
    public List<MainAccount> findAll() {
        return mainAccountRepository.findAll();
    }

    @Override
    @Transactional
    public MainAccount findById(Long id) {
        return mainAccountRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public MainAccount save(MainAccount object) {
        return mainAccountRepository.save(object);
    }

    @Override
    @Transactional
    public void delete(MainAccount object) {
        mainAccountRepository.delete(object);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        mainAccountRepository.deleteById(id);
    }
}
