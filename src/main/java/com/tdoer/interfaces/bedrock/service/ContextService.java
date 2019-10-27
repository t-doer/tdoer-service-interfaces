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

import com.tdoer.bedrock.impl.definition.context.*;
import com.tdoer.springboot.rest.GenericResponseData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author Htinker Hu (htinker@163.com)
 * @create 2017-09-19
 */
@FeignClient(value = "tdoer-core-data")
@RequestMapping("/bedrock/context")
public interface ContextService {

    @GetMapping("/types")
    GenericResponseData<List<ContextTypeDefinition>> getAllContextTypes();

    @GetMapping("/{contextPath}/applications")
    GenericResponseData<List<ContextApplicationDefinition>> getContextApplications(
            @PathVariable("contextPath") @NotBlank String contextPath,
            @RequestParam("productId") String productId,
            @RequestParam("clientId") String clientId,
            @RequestParam("tenantId") Long tenantId);

    @GetMapping("/{contextPath}/roles")
    GenericResponseData<List<ContextRoleDefinition>> getContextRoles(
            @PathVariable("contextPath") @NotBlank String contextPath,
            @RequestParam("productId") String productId,
            @RequestParam("clientId") String clientId,
            @RequestParam("tenantId") Long tenantId);

    @GetMapping("/{contextPath}/instance")
    GenericResponseData<ContextInstanceDefinition> getContextInstance(
            @PathVariable("contextPath") @NotBlank String contextPath);

    @GetMapping("/{contextPath}/user/{userId}/roles")
    GenericResponseData<List<ContextRoleDefinition>> getUserRolesInContext(
            @PathVariable("contextPath") @NotBlank String contextPath,
            @PathVariable("userId") @NotNull Long userId);

}
