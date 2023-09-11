package com.example.springapp.service;

import com.example.springapp.model.Cab;
import java.util.List;

public interface CabService {
    public Cab saveCab(Cab cab);

    public List<Cab> fetchCabList();
}
