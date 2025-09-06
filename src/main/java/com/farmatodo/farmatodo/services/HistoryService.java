package com.farmatodo.farmatodo.services;

import com.farmatodo.farmatodo.models.entities.History;
import com.farmatodo.farmatodo.models.entities.User;
import com.farmatodo.farmatodo.repositories.HistoryRepository;
import com.farmatodo.farmatodo.repositories.UserRepository;
import org.hibernate.grammars.hql.HqlParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class HistoryService {

    @Autowired
    private HistoryRepository historyRepository;

    @Async
    public void saveHistory(String name, String reference, BigDecimal quantity){

        History history = History.builder()
                .name(name)
                .reference(reference)
                .quantity(quantity)
                .date(LocalDateTime.now())
                .build();

        historyRepository.save(history);
    }
}
