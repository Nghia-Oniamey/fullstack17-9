package com.codingeznghiaxpes.fullstackbackend.service;

import com.codingeznghiaxpes.fullstackbackend.model.Status;

import java.util.List;

public interface StatusService {

    List<Status> getAllStatus();

    Status getStatusById(Long id);

}
