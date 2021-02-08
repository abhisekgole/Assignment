package com.edutech.dto;

import java.io.Serializable;
import java.util.Set;

import com.edutech.entity.Menu;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuDetailsDTO implements Serializable{

    Long id;
    String name;
    String url;
    Set<Menu> subMenus;

    public MenuDetailsDTO(Menu menu) {
        this.id = menu.getId();
        this.name = menu.getName();
        this.url = menu.getUrl();
        this.subMenus = menu.getSubMenus();
    }
}
