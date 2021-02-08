package com.edutech.controller;

import com.edutech.dto.MenuDTO;
import com.edutech.dto.MenuDetailsDTO;
import com.edutech.dto.ResponseDTO;
import com.edutech.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/menu")
@RestController
public class MenuController {

    @Autowired
    MenuService menuService;

    @RequestMapping(value = "/save",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ResponseDTO<String>> create(@RequestBody MenuDTO menuDTO) {
        return ResponseEntity.ok(menuService.save(menuDTO));
    }

    @RequestMapping(value = "/",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ResponseDTO<List<MenuDetailsDTO>>> fetchMenu() {
        return ResponseEntity.ok(menuService.fetchMenu());
    }

    @RequestMapping(value = "/update",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ResponseDTO<String>> update(@RequestBody MenuDTO menuDTO) {
        return ResponseEntity.ok(menuService.update(menuDTO));
    }
    
    
}

