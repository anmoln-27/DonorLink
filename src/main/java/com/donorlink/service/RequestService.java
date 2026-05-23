package com.donorlink.service;

import com.donorlink.model.Request;
import com.donorlink.repository.RequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RequestService {

    private final RequestRepository repo;

    public void addRequest(Request request){
        repo.save(request);
    }

    public List<Request> getAll(){
        return repo.findAll();
    }
}
