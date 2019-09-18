package com.remcal.test;

import com.remcal.bean.Clothes;
import com.remcal.utils.ProductsXmlUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;


public class ProductsXmlUtilsTest {

    @Test
    public void test(){
        List<Clothes> clothes = ProductsXmlUtils.parserProductFormXml();
        System.out.println(Arrays.toString(clothes.toArray()));
    }
}
