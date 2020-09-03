package com.valarchie.quickboot.demo.infrastructure.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.valarchie.quickboot.demo.infrastructure.entity.Shop;
import com.valarchie.quickboot.demo.infrastructure.entity.db.ShopUser;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author valarchie
 * @since 2020-05-22
 */
@Component
public interface ShopMapper extends BaseMapper<Shop> {

    List<ShopUser> getShopUserList();

}
