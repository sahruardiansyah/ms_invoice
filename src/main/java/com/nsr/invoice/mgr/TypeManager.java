package com.nsr.invoice.mgr;

import com.nsr.invoice.entity.Type;
import com.nsr.invoice.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeManager {
    @Autowired
    TypeRepository typeRepository;

    public Type createType(Type type){
        return typeRepository.save(type);
    }

    public List<Type>getAllType(){
        return typeRepository.findAll();
    }
    public Type getTypeById(Integer typeId){
        return typeRepository.getOne(typeId);
    }
    public Type updateType(Type type){
        return typeRepository.save(type);
    }
    public void deleteTypeById(Integer typeId){
        typeRepository.deleteById(typeId);
    }
}
