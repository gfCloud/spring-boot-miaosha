package com.miaosha.agent.controller;

import com.miaosha.agent.entity.GoodsVo;
import com.miaosha.agent.entity.MiaoShaUser;
import com.miaosha.agent.entity.MiaoshaOrder;
import com.miaosha.agent.entity.OrderInfo;
import com.miaosha.agent.result.CodeMsg;
import com.miaosha.agent.service.GoodsService;
import com.miaosha.agent.service.OrderService;
import com.miaosha.agent.service.MiaoshaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @author qixin
 * 秒杀
 */
@Controller
@RequestMapping("/miaosha")
public class MiaoshaController {

    @Autowired
    GoodsService goodsService;

    @Autowired
    OrderService orderService;

    @Autowired
    MiaoshaService miaoshaService;


    @PostMapping("/domiaosha")
    public String list(Model model, MiaoShaUser user, @RequestParam("goodsId") long goodsId, HttpServletRequest request) {
        model.addAttribute("user", user);
        if (user == null) {
            return "login";
        }
        //查询当亲商品库存数量
        GoodsVo goods = goodsService.getGoodsVoByGoodsId(goodsId);
        int stock = goods.getStockCount();
        if (stock <= 0) {
            model.addAttribute("errmsg", CodeMsg.MIAO_SHA_OVER.getMsg());
            new Exception(CodeMsg.MIAO_SHA_OVER.getMsg());
            return "miaosha_fail";
        }

        //查询当前商品是否已经被当前用户秒杀过
        MiaoshaOrder order = orderService.getMiaoshaOrderByUserIdGoodsId(user.getId(), goodsId);
        if (order != null) {
            model.addAttribute("errmsg", CodeMsg.REPETA_MIAOSHA.getMsg());
            return "miaosha/miaosha_fail";
        }

        //减库存 下订单 写入秒杀订单
        //返回生成的订单
        OrderInfo orderinfo = miaoshaService.getmiaosha(user, goods, request);
        model.addAttribute("orderInfo", orderinfo);
        model.addAttribute("goods", goods);
        return "order/order_detail";


    }


}
