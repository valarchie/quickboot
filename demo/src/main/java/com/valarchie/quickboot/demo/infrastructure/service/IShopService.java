package com.valarchie.quickboot.demo.infrastructure.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.valarchie.quickboot.demo.infrastructure.entity.Shop;
import com.valarchie.quickboot.demo.infrastructure.entity.db.ShopUser;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author valarchie
 * @since 2020-05-22
 */
public interface IShopService extends IService<Shop> {

    List<ShopUser> getShopUserList();

}
