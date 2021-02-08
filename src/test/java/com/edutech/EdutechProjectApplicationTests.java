package com.edutech;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.edutech.dto.MenuDTO;
import com.edutech.repository.MenuRepository;
import com.edutech.service.MenuService;

@RunWith(SpringRunner.class)
@SpringBootTest
class EdutechProjectApplicationTests {
	
	@Autowired
	private MenuService menuService;
	
	//Autowired
	//private MenuDTO menuDto;
	
	@MockBean
	private MenuRepository menuRepository;
	
	/*
	 * public void saveMenu() { when(menuRepository.save()).
	 * 
	 * }
	 */
}
