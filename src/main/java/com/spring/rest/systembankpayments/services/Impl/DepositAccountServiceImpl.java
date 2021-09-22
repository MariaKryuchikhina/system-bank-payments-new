package com.spring.rest.systembankpayments.services.Impl;

import com.spring.rest.systembankpayments.dto.DepositAccountDto;
import com.spring.rest.systembankpayments.entity.DepositAccount;
import com.spring.rest.systembankpayments.mapper.ClientMapper;
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
    private final ClientMapper clientMapper;

    @Override
    @Transactional
    public List<DepositAccountDto> findAll() {
        return clientMapper.depositAccountsDto(depositAccountRepository.findAll());
    }

    @Override
    @Transactional
    public DepositAccountDto findById(Long id) {
        return clientMapper.depositAccountToClientDto(depositAccountRepository.findById(id).orElse(null));
    }

    @Override
    public DepositAccountDto save(DepositAccountDto object) {
        return clientMapper.depositAccountToClientDto(depositAccountRepository.save(clientMapper.depositAccountDtoToDepositAccount(object)));
    }


    @Override
    @Transactional
    public void deleteById(Long id) {
        depositAccountRepository.deleteById(id);
    }
}
