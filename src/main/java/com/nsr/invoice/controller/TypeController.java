package com.nsr.invoice.controller;

import com.nsr.invoice.entity.Type;
import com.nsr.invoice.entity.Vendor;
import com.nsr.invoice.mgr.TypeManager;
import com.nsr.invoice.model.UpdateVendorRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/api/type")
public class TypeController {
    private static final Logger logger = LoggerFactory.getLogger(TypeController.class);
    @Autowired
    TypeManager typeManager;

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping("/")
    public List<Type> getAllType() {
        return typeManager.getAllType();
    }

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping("/{typeId}")
    public Type getTypeById(@PathVariable Integer typeId) {
        return typeManager.getTypeById(typeId);
    }


    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping("/")
    public Type createType(@Valid @RequestBody Type type) {
        logger.info("create type request : "+type);
        return typeManager.createType(type);
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PutMapping("/{typeId}")
    public Type updateType(@RequestBody Type type) {
        return typeManager.updateType(type);
    }

    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping("/{typeId}")
    public void deleteType(@PathVariable Integer typeId) {
        typeManager.deleteTypeById(typeId);

    }
}
