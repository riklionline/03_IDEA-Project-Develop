package com.remcal.test;

import com.remcal.framework.BeanFactory;
import com.remcal.service.ClothesService;
import org.junit.Test;

public class BeanFactoryTest {

    @Test
    public void getBean(){
        BeanFactory beanFactory = BeanFactory.init();
        ClothesService clothesService = (ClothesService)beanFactory.getBean("clothesService");
        System.out.println(clothesService);
    }
}
