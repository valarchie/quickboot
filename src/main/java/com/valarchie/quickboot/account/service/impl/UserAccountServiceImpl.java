package com.valarchie.quickboot.account.service.impl;

import com.valarchie.quickboot.account.entity.UserAccount;
import com.valarchie.quickboot.account.mapper.UserAccountMapper;
import com.valarchie.quickboot.account.service.IUserAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author valarchie
 * @since 2020-04-14
 */
@Service
public class UserAccountServiceImpl extends ServiceImpl<UserAccountMapper, UserAccount> implements IUserAccountService {

}
