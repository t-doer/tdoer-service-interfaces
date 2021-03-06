/*
 * Copyright 2017-2019 T-Doer (tdoer.com).
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
 */
package com.tdoer.interfaces.auth.service;

import com.tdoer.bedrock.tenant.BaseUser;
import com.tdoer.springboot.rest.GenericResponseData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Htinker Hu (htinker@163.com)
 * @create 2017-09-19
 */

@FeignClient("tdoer-core-data")
@RequestMapping("/auth/buser")
public interface BEndUserService {

    @GetMapping({"/{tenantId}/{account}"})
    GenericResponseData<BaseUser> findByAccount(
            @PathVariable("tenantId") Long tenantId,
            @PathVariable("account") String account);
}
