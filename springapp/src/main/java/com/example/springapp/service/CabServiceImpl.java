package com.example.springapp.service;

import com.example.springapp.model.Cab;
import com.example.springapp.repository.CabRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CabServiceImpl implements CabService {
    @Autowired
    private CabRepository cabRepository;

    @Override
    public Cab saveCab(Cab cab) {
        return cabRepository.save(cab);
    }

    @Override
    public List<Cab> fetchCabList() {
        return cabRepository.findAll();
    }
}
