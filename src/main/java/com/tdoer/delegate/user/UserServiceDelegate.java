/*
 * Copyright 2019 T-Doer (tdoer.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.tdoer.delegate.user;

import com.tdoer.bedrock.tenant.BaseUser;
import com.tdoer.interfaces.user.service.UserService;
import com.tdoer.interfaces.user.service.UserServiceFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Htinker Hu (htinker@163.com)
 * @create 2019-11-24
 */
@Service
public class UserServiceDelegate implements UserService {
    @Autowired
    UserServiceFeignClient proxy;

    @Override
    public BaseUser getUserByAccount(Long tenantId, String account) {
        return proxy.findByAccount(tenantId, account).getData();
    }

    @Override
    public BaseUser getUserByGuid(Long tenantId, String guid) {
        return proxy.findByGuid(tenantId, guid).getData();
    }

    @Override
    public BaseUser getUserById(Long tenantId, Long id) {
        return proxy.findById(tenantId, id).getData();
    }
}
