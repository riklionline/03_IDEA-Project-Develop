package com.remcal.web.servlet;

import com.alibaba.fastjson.JSON;
import com.remcal.domain.GoodsType;
import com.remcal.service.GoodsTypeService;
import com.remcal.service.impl.GoodsTypeServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author wgy
 * @version 1.0
 * @date 2019/11/2
 */
@WebServlet(name = "GoodsTypeServlet",value = "/goodstypeservlet")
public class GoodsTypeServlet extends BaseServlet {
    public String goodstypelist(HttpServletRequest request, HttpServletResponse response) throws Exception{
        GoodsTypeService goodsTypeService=new GoodsTypeServiceImpl();
        response.setContentType("application/json;charset=utf-8");
        List<GoodsType> goodsTypeList=goodsTypeService.getGoodsTypeByLevel(1);
        if(goodsTypeList!=null){
            String json = JSON.toJSONString(goodsTypeList);
            response.getWriter().write(json);
        }
        return null;
    }
}
