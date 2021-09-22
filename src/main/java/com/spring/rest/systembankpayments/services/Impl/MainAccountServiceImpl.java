package com.spring.rest.systembankpayments.services.Impl;

import com.spring.rest.systembankpayments.dto.MainAccountDto;
import com.spring.rest.systembankpayments.entity.Client;
import com.spring.rest.systembankpayments.entity.MainAccount;
import com.spring.rest.systembankpayments.mapper.ClientMapper;
import com.spring.rest.systembankpayments.repositories.MainAccountRepository;
import com.spring.rest.systembankpayments.services.MainAccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class MainAccountServiceImpl implements MainAccountService {

    private final MainAccountRepository mainAccountRepository;
    private final ClientMapper clientMapper;

    @Override
    @Transactional
    public List<MainAccountDto> findAll() {
        return clientMapper.mainAccountsDto(mainAccountRepository.findAll());
    }

    @Override
    @Transactional
    public MainAccountDto findById(Long id) {
        return clientMapper.mainAccountToClientDto(mainAccountRepository.findById(id).orElse(null));
    }

    @Override
    @Transactional
    public MainAccountDto save(MainAccountDto object) {
        return clientMapper.mainAccountToClientDto(mainAccountRepository.save(clientMapper.mainAccountDtoToMainAccount(object)));
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        mainAccountRepository.deleteById(id);
    }
}
