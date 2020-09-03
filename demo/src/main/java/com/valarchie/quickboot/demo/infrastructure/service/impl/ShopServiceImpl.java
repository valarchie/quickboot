package com.valarchie.quickboot.demo.infrastructure.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.valarchie.quickboot.demo.infrastructure.entity.Shop;
import com.valarchie.quickboot.demo.infrastructure.entity.db.ShopUser;
import com.valarchie.quickboot.demo.infrastructure.mapper.ShopMapper;
import com.valarchie.quickboot.demo.infrastructure.service.IShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author valarchie
 * @since 2020-05-22
 */
@Service
public class ShopServiceImpl extends ServiceImpl<ShopMapper, Shop> implements IShopService {

    @Autowired
    private ShopMapper shopMapper;

    @Override
    public List<ShopUser> getShopUserList(){
       return shopMapper.getShopUserList();
    }

}
