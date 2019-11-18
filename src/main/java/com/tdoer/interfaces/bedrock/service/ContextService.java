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

import java.util.List;

import com.tdoer.bedrock.impl.definition.context.ContextApplicationDefinition;
import com.tdoer.bedrock.impl.definition.context.ContextInstanceDefinition;
import com.tdoer.bedrock.impl.definition.context.ContextPublicMethodDefinition;
import com.tdoer.bedrock.impl.definition.context.ContextPublicResourceDefinition;
import com.tdoer.bedrock.impl.definition.context.ContextRoleDefinition;
import com.tdoer.bedrock.impl.definition.context.ContextRoleMethodDefinition;
import com.tdoer.bedrock.impl.definition.context.ContextRoleResourceDefinition;
import com.tdoer.bedrock.impl.definition.context.ContextTypeDefinition;
import com.tdoer.springboot.rest.GenericResponseData;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Htinker Hu (htinker@163.com)
 * @create 2017-09-19
 */
@FeignClient(value = "tdoer-bedrock-serviceprovider")
@RequestMapping("/bedrock/context")
public interface ContextService {

        @GetMapping("/types")
        public GenericResponseData<List<ContextTypeDefinition>> getAllContextTypes();

        @GetMapping("/{tenantId}/types")
        public GenericResponseData<List<ContextTypeDefinition>> getContextTypes(
                        @PathVariable("tenantId") @NonNull Long tenantId);

        @GetMapping("/{contextPath}/publicMethods")
        public GenericResponseData<List<ContextPublicMethodDefinition>> getContextPublicMethods(
                        @RequestParam("clientId") @NonNull Long clientId,
                        @RequestParam("tenantId") @NonNull Long tenantId,
                        @PathVariable("contextPath") @NonNull String contextPath);

        @GetMapping("/{contextPath}/role/{roleId}/methods")
        public GenericResponseData<List<ContextRoleMethodDefinition>> getContextRoleMethods(
                        @RequestParam("clientId") @NonNull Long clientId,
                        @RequestParam("tenantId") @NonNull Long tenantId,
                        @PathVariable("contextPath") @NonNull String contextPath,
                        @PathVariable("roleId") @NonNull Long roleId);

        @GetMapping("/{contextPath}/user/{userId}/roles")
        public GenericResponseData<List<Long>> getRoleIdsOfUserInContext(
                        @RequestParam("tenantId") @NonNull Long tenantId,
                        @PathVariable("contextPath") @NonNull String contextPath,
                        @PathVariable("userId") @NonNull Long userId);

        @GetMapping("/context/{instanceId}")
        public GenericResponseData<ContextInstanceDefinition> getContextInstance(@RequestParam("tenantId") @NonNull Long tenantId,
                        @RequestParam("contextType") @NonNull Long contextType,
                        @PathVariable("instanceId") @NonNull Long instanceId);

        @GetMapping("/{contextPath}/role/{roleId}/resources")
        public GenericResponseData<List<ContextRoleResourceDefinition>> getContextRoleResources(
                        @RequestParam("clientId") @NonNull Long clientId,
                        @RequestParam("tenantId") @NonNull Long tenantId,
                        @PathVariable("contextPath") @NonNull String contextPath,
                        @PathVariable("roleId") @NonNull Long roleId);

        @GetMapping("/context/byGuid/{guid}")
        public GenericResponseData<ContextInstanceDefinition> getContextInstance(@RequestParam("tenantId") @NonNull Long tenantId,
                        @PathVariable("guid") @NonNull String guid);

        @GetMapping("/{contextPath}/roles")
        public GenericResponseData<List<ContextRoleDefinition>> getContextRoles(
                        @RequestParam("tenantId") @NonNull Long tenantId,
                        @PathVariable("contextPath") @NonNull String contextPath);

        @GetMapping("/{contextPath}/publicResources")
        public GenericResponseData<List<ContextPublicResourceDefinition>> getContextPublicResources(
                        @RequestParam("clientId") @NonNull Long clientId,
                        @RequestParam("tenantId") @NonNull Long tenantId,
                        @PathVariable("contextPath") @NonNull String contextPath);

        @GetMapping("/{contextPath}/applications")
        public GenericResponseData<List<ContextApplicationDefinition>> getContextApplications(
                        @RequestParam("clientId") @NonNull Long clientId,
                        @RequestParam("tenantId") @NonNull Long tenantId,
                        @PathVariable("contextPath") @NonNull String contextPath);

}
