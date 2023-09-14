package com.codingeznghiaxpes.fullstackbackend.controller;


import com.codingeznghiaxpes.fullstackbackend.model.Status;
import com.codingeznghiaxpes.fullstackbackend.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/status")
public class StatusController {

    @Autowired
    private StatusService statusService;

    @GetMapping
    public List<Status> getAllStatusController(){
        return statusService.getAllStatus();
    }
}
