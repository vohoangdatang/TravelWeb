

import com.quanli.controllers.ChuyenXeController;
import com.quanli.pojos.ChuyenXe;
import com.quanli.repository.ChuyenXeRepository;

import com.quanli.service.Impl.ChuyenXeServiceImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AD
 */
@ExtendWith(MockitoExtension.class)
public class chuyenxetest {
 @Mock
 private ChuyenXeRepository chuyenXeRepository;
 @InjectMocks
 private ChuyenXeServiceImpl chuyenXeServiceImpl;
 
   
 
  
    @Test
    public void testgetallchuyenxe()
    {
      // 1. create mock data
	List<ChuyenXe> mockCX = new ArrayList<>();
	for(int i = 0; i < 5; i++) {
		mockCX.add(new ChuyenXe());
	}
	// 2. define behavior of Repository
	when(chuyenXeRepository.getKS()).thenReturn(mockCX);
	       System.out.println(mockCX.toString());
	// 3. call service method
	List<ChuyenXe> actualBooks = chuyenXeServiceImpl.getKS();
		      System.out.println(actualBooks.toString());
	// 4. assert the result
        Assertions.assertEquals(actualBooks.size(), mockCX.size());
    }
   
}
