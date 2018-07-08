package com.company.service.service;

import com.company.service.entity.Param;
import com.company.service.repository.ParamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParamService {

    @Autowired
    ParamRepository paramRepository;

    public Param findParamById(Long id){return paramRepository.findParamById(id);}
    public List<Param> findAllParams(){return  paramRepository.findAll();}
    public void deleteParamById(Long id){paramRepository.deleteParamById(id);}
    public void saveParam(Param param){paramRepository.save(param);}
    public void saveAllParams(List<Param> params){paramRepository.saveAll(params);}
}
