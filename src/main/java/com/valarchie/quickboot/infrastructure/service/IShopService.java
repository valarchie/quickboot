package com.valarchie.quickboot.infrastructure.service;

import com.valarchie.quickboot.infrastructure.entity.Shop;
import com.baomidou.mybatisplus.extension.service.IService;
import com.valarchie.quickboot.infrastructure.entity.db.ShopUser;
import org.springframework.stereotype.Service;

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
