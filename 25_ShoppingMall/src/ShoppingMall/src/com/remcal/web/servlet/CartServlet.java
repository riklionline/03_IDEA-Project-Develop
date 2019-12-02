package com.remcal.web.servlet;

import com.remcal.domain.Cart;
import com.remcal.domain.Goods;
import com.remcal.domain.User;
import com.remcal.service.CartService;
import com.remcal.service.GoodsService;
import com.remcal.service.impl.CartServiceImpl;
import com.remcal.service.impl.GoodsServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;

/**
 * @ClassName: test
 * @Descirption:
 * @Version: V1.01
 * @Author: FAT-Remcal
 * @DateTime: 11/11/2019 6:26 PM
 * @Signature: “闲庭书阁飞玉箫，Coding诗酒醉年华。”
 */
@WebServlet(name = "CartServlet" ,value = "/cartservlet")
public class CartServlet extends BaseServlet {
    public String addCart(HttpServletRequest request, HttpServletResponse response){

        //cartservlet?method=addCart&goodsId=4&number=1
        String goodsId = request.getParameter("goodsId");
        String number = request.getParameter("number");
        //判断是否登录
        User user = (User) request.getSession().getAttribute("user");
        if(user==null){
            return "redirect:/login.jsp";
        }
        //需要查询购物车表
        CartService cartService=new CartServiceImpl();
        Cart cart=cartService.findByGoodsIdAndUser(Integer.parseInt(goodsId),user.getId());
        GoodsService goodsService=new GoodsServiceImpl();
        Goods goods = goodsService.findById(Integer.parseInt(goodsId));
        if(cart==null){//添加一条数据
            //计算金额
            BigDecimal money = goods.getPrice().multiply(new BigDecimal(Integer.parseInt(number)));
            cart=new Cart(user.getId(),Integer.parseInt(goodsId),Integer.parseInt(number),money);
            cartService.add(cart);

        }else{//更新数据
            //更新数量和金额
            Integer num = cart.getNum();
            cart.setNum(num+Integer.parseInt(number));
            BigDecimal money = goods.getPrice().multiply(new BigDecimal(cart.getNum()));
            cart.setMoney(money);
            cartService.update(cart);
        }
        return "redirect:/cartSuccess.jsp";

    }

    /*public String getCart(HttpServletRequest request, HttpServletResponse response){
        String goodsId = request.getParameter("goodsId");
        String number = request.getParameter("number");
        //判断是否登录
        User user = (User) request.getSession().getAttribute("user");
        if(user==null){
            return "redirect:/login.jsp";
        }

        Integer goodsId_N = 0;

        if (goodsId==null || goodsId.trim().length()==0) {
            goodsId_N = 12;
        } else {
            goodsId_N = Integer.parseInt(goodsId);// String --> Integer
        }


        //查询购物车表
        CartService cartService=new CartServiceImpl();
        Cart cart = cartService.findByGoodsIdAndUser(goodsId_N, user.getId());

        request.setAttribute("cart", cart);
        try {
            request.getRequestDispatcher("/cart.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
     return null;
    }*/

}
