package com.codingeznghiaxpes.fullstackbackend.service.impl;

import com.codingeznghiaxpes.fullstackbackend.model.Status;
import com.codingeznghiaxpes.fullstackbackend.repository.StatusRepository;
import com.codingeznghiaxpes.fullstackbackend.service.StatusService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class StatusServiceImpl implements StatusService {

    @Autowired
    private StatusRepository statusRepository;

    @Override
    public List<Status> getAllStatus() {
        return statusRepository.findAll();
    }
}
