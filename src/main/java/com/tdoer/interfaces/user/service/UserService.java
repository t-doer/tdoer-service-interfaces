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
package com.tdoer.interfaces.user.service;

import com.tdoer.bedrock.tenant.BaseUser;

/**
 * @author Htinker Hu (htinker@163.com)
 * @create 2019-11-24
 */
public interface UserService {
    BaseUser getUserByAccount(Long tenantId, String account);

    BaseUser getUserByGuid(Long tenantId, String guid);

    BaseUser getUserById(Long tenantId, Long id);
}
