package com.valarchie.quickboot.demo.interfaces.controller;


import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.valarchie.quickboot.core.common.api.ResponseResult;
import com.valarchie.quickboot.demo.infrastructure.entity.Shop;
import com.valarchie.quickboot.demo.infrastructure.entity.db.ShopUser;
import com.valarchie.quickboot.demo.infrastructure.mapper.ShopMapper;
import com.valarchie.quickboot.demo.infrastructure.service.IShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author valarchie
 * @since 2020-05-22
 */
@RestController
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private IShopService shopService;

    @Autowired
    private ShopMapper shopMapper;


    @RequestMapping("/addShop")
    @ResponseBody
    public ResponseResult addShop() {

        Shop shop = new Shop();
        shop.setShop("商店" + UUID.randomUUID().toString().substring(1, 4));
        shop.setProductType((int) (DateUtil.currentSeconds() % 10));
        shop.setShopMan("店长" + UUID.randomUUID().toString().substring(4, 8));

//        shopService.save(shop);
        shopMapper.insert(shop);

        return ResponseResult.success();

    }

    @RequestMapping("/updateShop")
    @ResponseBody
    public ResponseResult updateShop() {

        Shop shop = new Shop();
        shop.setId(4L);
        shop.setShop("商店4" + "修改1");
//        shopMapper.updateById(shop);
        shopService.updateById(shop);

        return ResponseResult.success();

    }


    @RequestMapping("/deleteShop")
    @ResponseBody
    public ResponseResult deleteShop() {

        shopService.removeById(5L);

        return ResponseResult.success();

    }

    @RequestMapping("/getShop")
    @ResponseBody
    public ResponseResult getShop() {

        Shop shopById = shopService.getById(4L);

        return ResponseResult.success().data("shop", shopById);

    }

    @RequestMapping("/getShopList")
    @ResponseBody
    public ResponseResult getShopList() {

        QueryWrapper<Shop> queryWrapper = new QueryWrapper<>();

        queryWrapper.lambda().eq(Shop::getProductType, 5).ge(Shop::getId, 4).and(shopLambdaQueryWrapper ->
                shopLambdaQueryWrapper.eq(Shop::getId, 6).like(Shop::getShopMan, "ec97"));

        List<Shop> list = shopService.list(queryWrapper);

        return ResponseResult.success().data("shopList", list);

    }


    @RequestMapping("/getShopListByPage")
    @ResponseBody
    public ResponseResult getShopListByPage() {

        IPage<Shop> page = new Page<>(0,1,true);

        IPage<Shop> shopPage = shopService.page(page);

        return ResponseResult.success().data("shopList", shopPage.getRecords()).data("row", shopPage.getTotal());

    }



    @RequestMapping("/getShopUserList")
    @ResponseBody
    public ResponseResult getShopUserList() {

        List<ShopUser> shopUserList = shopService.getShopUserList();

        return ResponseResult.success().data("userShopList", shopUserList);

    }


}
