package com.seckill.agent.controller;

import com.seckill.agent.dto.resp.SeckillOrderRespDTO;
import com.seckill.agent.entity.GoodsVo;
import com.seckill.agent.entity.OrderInfo;
import com.seckill.agent.entity.SeckillUser;
import com.seckill.agent.result.CodeMsg;
import com.seckill.agent.service.GoodsService;
import com.seckill.agent.service.OrderService;
import com.seckill.agent.service.SeckillService;
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
@RequestMapping("/seckill")
public class SeckillController {

    private final GoodsService goodsService;

    private final OrderService orderService;

    private final SeckillService seckillService;

    public SeckillController(GoodsService goodsService, OrderService orderService, SeckillService seckillService) {
        this.goodsService = goodsService;
        this.orderService = orderService;
        this.seckillService = seckillService;
    }


    @PostMapping("/doSeckill")
    public String list(Model model, SeckillUser user, @RequestParam("goodsId") long goodsId, HttpServletRequest request) {
        model.addAttribute("user", user);
        if (user == null) {
            return "login";
        }
        //查询当亲商品库存数量
        GoodsVo goods = goodsService.getGoodsVoByGoodsId(goodsId);
        int stock = goods.getStockCount();
        if (stock <= 0) {
            model.addAttribute("errMsg", CodeMsg.MIAO_SHA_OVER.getMsg());
            return "seckill_fail";
        }

        //查询当前商品是否已经被当前用户秒杀过
        SeckillOrderRespDTO order = orderService.getSeckillOrderByUserIdGoodsId(user.getId(), goodsId);
        if (order != null) {
            model.addAttribute("errMsg", CodeMsg.REPETA_MIAOSHA.getMsg());
            return "seckill/seckill_fail";
        }

        //减库存 下订单 写入秒杀订单
        //返回生成的订单
        OrderInfo orderinfo = goodsService.getSeckill(user, goods, request);
        model.addAttribute("orderInfo", orderinfo);
        model.addAttribute("goods", goods);
        return "order/order_detail";


    }


}
