package com.kioskspring.service;

import com.kioskspring.domain.ResponseMenu;
import com.kioskspring.response_menu.ResponseMenuRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class ResponseMenuService {
    private final ResponseMenuRepository responseMenuRepository;


    public ResponseMenuService(ResponseMenuRepository responseMenuRepository) {
        this.responseMenuRepository = responseMenuRepository;
    }

    public List<ResponseMenu> findResponse(int age, String gender){
        return responseMenuRepository.getResponse(age,gender);
    }
}
