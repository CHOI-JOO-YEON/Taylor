package com.kioskspring.response_menu;

import com.kioskspring.domain.ResponseMenu;

import java.util.List;

public interface ResponseMenuRepository {
    List<ResponseMenu> getResponse(int age, String gender);

}
