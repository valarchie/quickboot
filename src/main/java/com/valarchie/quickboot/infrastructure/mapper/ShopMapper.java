package com.valarchie.quickboot.infrastructure.mapper;

import com.valarchie.quickboot.infrastructure.entity.Shop;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.valarchie.quickboot.infrastructure.entity.db.ShopUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

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
