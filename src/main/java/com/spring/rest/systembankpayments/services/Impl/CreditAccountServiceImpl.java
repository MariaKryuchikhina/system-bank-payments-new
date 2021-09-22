package com.spring.rest.systembankpayments.services.Impl;

import com.spring.rest.systembankpayments.dto.CreditAccountDto;
import com.spring.rest.systembankpayments.entity.CreditAccount;
import com.spring.rest.systembankpayments.mapper.ClientMapper;
import com.spring.rest.systembankpayments.repositories.CreditAccountRepository;
import com.spring.rest.systembankpayments.services.CreditAccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class CreditAccountServiceImpl implements CreditAccountService {

    private final CreditAccountRepository creditAccountRepository;
    private final ClientMapper clientMapper;

    @Override
    @Transactional
    public List<CreditAccountDto> findAll() {
        return clientMapper.creditAccountsDto(creditAccountRepository.findAll());
    }

    @Override
    @Transactional
    public CreditAccountDto findById(Long id) {
        return clientMapper.creditAccountToClientDto(creditAccountRepository.findById(id).orElse(null));
    }

    @Override
    @Transactional
    public CreditAccountDto save(CreditAccountDto object) {
        return clientMapper.creditAccountToClientDto(creditAccountRepository.save(clientMapper.creditAccountDtoToCreditAccount(object)));
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        creditAccountRepository.deleteById(id);
    }
}
