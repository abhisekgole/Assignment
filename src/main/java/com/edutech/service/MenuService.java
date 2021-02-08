package com.edutech.service;

import com.edutech.dto.MenuDTO;
import com.edutech.dto.MenuDetailsDTO;
import com.edutech.dto.ResponseDTO;
import com.edutech.entity.Menu;
import com.edutech.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MenuService {

	@Autowired
	MenuRepository menuRepository;

	public ResponseDTO<String> save(MenuDTO menuDTO) {
		ResponseDTO<String> responseDTO = new ResponseDTO<>();
		try {
			List<Map<String, Long>> subMenuIdList = menuDTO.getSubMenuIdList();
			Menu menu = new Menu();
			menu.setName(menuDTO.getName());
			menu.setUrl(menuDTO.getUrl());
			menu.setIsLinked(menuDTO.getIsLinked());
			Set<Menu> subMenuSet = new HashSet<>();
			for (Map<String, Long> map : subMenuIdList) {
				subMenuSet.add(menuRepository.getOne(map.get("id")));
			}
			menu.setSubMenus(subMenuSet);
			menuRepository.save(menu);
			responseDTO.setSuccessResponse(null, "Menu has been created");
		} catch (Exception exception) {
			printError(exception);
			responseDTO.setFailureResponse(exception.getMessage());
		}
		return responseDTO;
	}

	public ResponseDTO<List<MenuDetailsDTO>> fetchMenu() {
		ResponseDTO<List<MenuDetailsDTO>> responseDTO = new ResponseDTO<>();
		try {
			List<Menu> menuList = menuRepository.findAll();
			List<MenuDetailsDTO> menuDetailsDTOList = new LinkedList<>();
			for (Menu menu : menuList) {
				if (!menu.getIsLinked()) {
					menuDetailsDTOList.add(new MenuDetailsDTO(menu));
				}
			}
			responseDTO.setSuccessResponse(menuDetailsDTOList, null);
		} catch (Exception exception) {
			printError(exception);
			responseDTO.setFailureResponse(exception.getMessage());
		}
		return responseDTO;
	}

	public ResponseDTO<String> update(MenuDTO menuDTO) {
		ResponseDTO<String> responseDTO = new ResponseDTO<>();
		try {
			List<Map<String, Long>> subMenuIdList = menuDTO.getSubMenuIdList();
			Optional<Menu> updateMenu = menuRepository.findById(menuDTO.getId());
			if (updateMenu.isPresent()) {
				Menu menu = updateMenu.get();
				menu.setName(menuDTO.getName());
				menu.setUrl(menuDTO.getUrl());
				menu.setIsLinked(menuDTO.getIsLinked());
				if (menuDTO.getSubMenuIdList().size() > 0) {
					Set<Menu> subMenuSet = new HashSet<>();
					for (Map<String, Long> map : subMenuIdList) {
						subMenuSet.add(menuRepository.getOne(map.get("id")));
					}
					menu.setSubMenus(subMenuSet);
				}
				menuRepository.save(menu);
				responseDTO.setSuccessResponse(null, "Menu has been updated");
			} else {
				responseDTO.setFailureResponse("No such menu exists");
			}
		} catch (Exception exception) {
			printError(exception);
			responseDTO.setFailureResponse(exception.getMessage());
		}
		return responseDTO;
	}

	private void printError(Exception exception) {
		System.out.println("Exception occurred while creating menu : " + exception.getMessage());
	}

}
