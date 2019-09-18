package com.remcal.service.impl;

import com.remcal.bean.Clothes;
import com.remcal.service.ClothesService;
import com.remcal.utils.BusinessException;
import com.remcal.utils.ClothesIO;

import java.util.List;


public class ClothesServiceImpl implements ClothesService {

    private ClothesIO clothesIO = new ClothesIO();
    @Override
    public List<Clothes> list() throws BusinessException {
        return clothesIO.list();
    }

    @Override
    public Clothes findById(String cid) throws BusinessException {
        return clothesIO.findById(cid);
    }

    public void update()throws BusinessException{
        clothesIO.update();
    }
}
