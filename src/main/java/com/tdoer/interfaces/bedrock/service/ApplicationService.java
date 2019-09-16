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

import com.tdoer.bedrock.impl.definition.application.ActionDefinition;
import com.tdoer.bedrock.impl.definition.application.ApplicationDefinition;
import com.tdoer.bedrock.impl.definition.application.ApplicationServiceDefinition;
import com.tdoer.bedrock.impl.definition.application.PageDefinition;
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
@FeignClient("tdoer-core-data")
@RequestMapping("/bedrock/application")
public interface ApplicationService {


    @GetMapping("/{applicationId}")
    GenericResponseData<ApplicationDefinition> getApplicationDefinition(
            @PathVariable("applicationId") @NotBlank String applicationId);

    @GetMapping("/{applicationId}/pages")
    GenericResponseData<List<PageDefinition>> getPageDefinitions(
            @PathVariable("applicationId") @NotBlank String applicationId,
            @RequestParam("productId") String productId,
            @RequestParam("clientId") String clientId,
            @RequestParam("tenantId") Long tenantId,
            @RequestParam("contextPath") String contextPath);

    @GetMapping("/{applicationId}/actions")
    GenericResponseData<List<ActionDefinition>> getActionDefinitions(
            @PathVariable("applicationId") @NotBlank String applicationId,
            @RequestParam("productId") String productId,
            @RequestParam("clientId") String clientId,
            @RequestParam("tenantId") Long tenantId,
            @RequestParam("contextPath") String contextPath);

    @GetMapping("/{applicationId}/services")
    GenericResponseData<List<ApplicationServiceDefinition>> getApplicationServiceDefinitions(
            @PathVariable("applicationId") @NotBlank String applicationId,
            @RequestParam("productId") String productId,
            @RequestParam("clientId") String clientId,
            @RequestParam("tenantId") Long tenantId,
            @RequestParam("contextPath") String contextPath);

    @GetMapping("/{applicationId}/page/{pageId}/methodIds")
    GenericResponseData<List<Long>> getServiceMethodIdsOfPage(
            @PathVariable("applicationId") @NotBlank String applicationId,
            @PathVariable("pageId") @NotNull Long pageId);

    @GetMapping("/{applicationId}/page/{pageId}/action/{actionId}/methodIds")
    GenericResponseData<List<Long>> getServiceMethodIdsOfAction(
            @PathVariable("applicationId") @NotBlank String applicationId,
            @PathVariable("pageId") @NotNull Long pageId,
            @PathVariable("actionId") @NotNull Long actionId);

}
