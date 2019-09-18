package com.remcal.service;

import com.remcal.bean.Clothes;
import com.remcal.utils.BusinessException;

import java.util.List;


public interface ClothesService {
    public List<Clothes> list()throws BusinessException;
    public Clothes findById(String cid)throws BusinessException;
    public void update()throws BusinessException;
}
