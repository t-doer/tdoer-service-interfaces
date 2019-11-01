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
package com.tdoer.interfaces.bedrock.service;

import com.tdoer.bedrock.impl.definition.tenant.TenantClientDefinition;
import com.tdoer.bedrock.impl.definition.tenant.TenantDefinition;
import com.tdoer.bedrock.impl.definition.tenant.TenantProductDefinition;
import com.tdoer.springboot.rest.GenericResponseData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author Htinker Hu (htinker@163.com)
 * @create 2017-09-19
 */
@FeignClient(value = "tdoer-bedrock-serviceprovider")
@RequestMapping("/bedrock/tenant")
public interface TenantService {

    @GetMapping("／definition/byId/{tenantId}")
    GenericResponseData<TenantDefinition> getTenantDefinitionById(
            @PathVariable("tenantId") @NotNull Long tenantId);

    @GetMapping("/definition/byCode/{tenantCode}")
    GenericResponseData<TenantDefinition> getTenantDefinitionByCode(
            @PathVariable("tenantCode") @NotBlank String tenantCode);


    @GetMapping("/definition/byGuid/{guid}")
    GenericResponseData<TenantDefinition> getTenantDefinitionByGuid(
            @PathVariable("guid") @NotBlank String guid);

    @GetMapping("/{tenantId}/products")
    GenericResponseData<List<TenantProductDefinition>> getTenantProductDefinitions(
            @PathVariable("tenantId") @NotNull Long tenantId);

    @GetMapping("/{tenantId}/clients")
    GenericResponseData<List<TenantClientDefinition>> getTenantClientDefinitions(
            @PathVariable("tenantId") @NotNull Long tenantId);

    @GetMapping("/clientByHost/{host}")
    GenericResponseData<TenantClientDefinition> getTenantClientDefinition(
            @PathVariable("host") @NotBlank String host);

}
