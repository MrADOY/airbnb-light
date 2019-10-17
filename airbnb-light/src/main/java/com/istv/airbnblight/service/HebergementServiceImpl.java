package com.istv.airbnblight.service;

import com.istv.airbnblight.model.Hebergement;
import com.istv.airbnblight.repository.HebergementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class HebergementServiceImpl implements HebergementService {

    @Autowired
    private HebergementRepository hebergementRepository;

    public List<Hebergement> findAll(){
        return StreamSupport
                .stream(hebergementRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

}