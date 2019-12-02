package com.remcal.web.servlet;

import com.remcal.domain.Goods;
import com.remcal.domain.PageBean;
import com.remcal.service.GoodsService;
import com.remcal.service.impl.GoodsServiceImpl;
import com.remcal.utils.StringUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author wgy
 * @version 1.0
 * @date 2019/11/2
 */
@WebServlet(name = "GoodsServlet" ,value = "/goodsservlet")
public class GoodsServlet extends BaseServlet {
    //带条件分页查询
    public String getGoodsListByTypeId(HttpServletRequest request, HttpServletResponse response){
        //getGoodsListByTypeId&typeId=1
        String typeId = request.getParameter("typeId");
        String pageNum = request.getParameter("pageNum");
        String pageSize = request.getParameter("pageSize");
        if(StringUtils.isEmpty(typeId)){
            return "redirect:/index.jsp";
        }
        int pageN=1;
        int pageS=8;
        if(!StringUtils.isEmpty(pageNum)){
            try {
                pageN=Integer.parseInt(pageNum);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        if(!StringUtils.isEmpty(pageSize)){
            try {
                pageS=Integer.parseInt(pageSize);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        String condition="typeId="+typeId;
        GoodsService goodsService=new GoodsServiceImpl();
        PageBean<Goods> pageBean= goodsService.findByWhere(pageN,pageS,condition);
        request.setAttribute("pageBean", pageBean);
        request.setAttribute("typeId", typeId);
        return "/goodsList.jsp";
    }

    //获取商品详情
    public String getGoodsById(HttpServletRequest request,HttpServletResponse response){
        String id = request.getParameter("id");
        GoodsService goodsService=new GoodsServiceImpl();
        Goods goods=goodsService.findById(Integer.parseInt(id));
        request.setAttribute("goods", goods);

        return "/goodsDetail.jsp";
    }

}
