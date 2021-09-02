package com.spring.rest.systembankpayments.services.Impl;

import com.spring.rest.systembankpayments.entity.ReplenishmentHistory;
import com.spring.rest.systembankpayments.repositories.ReplenishmentHistoryRepository;
import com.spring.rest.systembankpayments.services.ReplenishmentHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReplenishmentHistoryServiceImpl implements ReplenishmentHistoryService {

    @Autowired
    private ReplenishmentHistoryRepository history;

    @Override
    @Transactional
    public List<ReplenishmentHistory> findAll() {
        return history.findAll();
    }

    @Override
    @Transactional
    public ReplenishmentHistory findById(Long id) {
        return history.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public ReplenishmentHistory save(ReplenishmentHistory object) {
        return history.save(object);
    }

    @Override
    @Transactional
    public void delete(ReplenishmentHistory object) {
        history.delete(object);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        history.deleteById(id);
    }
}
