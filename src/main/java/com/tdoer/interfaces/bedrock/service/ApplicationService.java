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

import com.tdoer.bedrock.impl.definition.application.*;
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
@FeignClient("tdoer-bedrock-serviceprovider")
@RequestMapping("/bedrock/application")
public interface ApplicationService {


    @GetMapping("/definition/byId/{applicationId}")
    GenericResponseData<ApplicationDefinition> getApplicationDefinitionById(
            @PathVariable("applicationId") @NotNull Long applicationId);


    @GetMapping("/definition/byCode/{applicationCode}")
    GenericResponseData<ApplicationDefinition> getApplicationDefinitionByCode(
            @PathVariable("applicationCode") @NotBlank String applicationCode);

    @GetMapping("/{applicationId}/pageDefinitions")
    GenericResponseData<List<PageDefinition>> getAllPageDefinitions(
            @PathVariable("applicationId") @NotNull Long applicationId);

    @GetMapping("/{applicationId}/customizedPageIds")
    GenericResponseData<List<Long>> getCustomizedPageIds(
            @PathVariable("applicationId") @NotNull Long applicationId,
            @RequestParam("productId") @NotNull Long productId,
            @RequestParam("clientId") @NotNull Long clientId,
            @RequestParam("tenantId") @NotNull Long tenantId,
            @RequestParam("contextPath") @NotNull String contextPath);

    @GetMapping("/{applicationId}/commonPageIds")
    GenericResponseData<List<Long>> getCommonPageIds(
            @PathVariable("applicationId") @NotNull Long applicationId);

    @GetMapping("{pageId}/actionDefinitions")
    GenericResponseData<List<ActionDefinition>> getAllActionDefinitions(
            @PathVariable("pageId") @NotNull Long pageId);

    @GetMapping("/{pageId}/customizedActionIds")
    GenericResponseData<List<ActionDefinition>> getCustomizedActionIds(
            @PathVariable("pageId") @NotNull String pageId,
            @RequestParam("productId") @NotNull Long productId,
            @RequestParam("clientId") @NotNull Long clientId,
            @RequestParam("tenantId") @NotNull Long tenantId,
            @RequestParam("contextPath") @NotNull String contextPath);

    @GetMapping("{pageId}/commonActionIds")
    GenericResponseData<List<Long>> getCommonActionIds(
            @PathVariable("pageId") @NotNull Long pageId);


    @GetMapping("{applicationId}/customizedRefereeServiceIds")
    GenericResponseData<List<Long>> getCustomizedRefereeServiceIds(
            @PathVariable("applicationId") @NotNull Long applicationId,
            @RequestParam("productId") @NotNull Long productId,
            @RequestParam("clientId") @NotNull Long clientId,
            @RequestParam("tenantId") @NotNull Long tenantId,
            @RequestParam("contextPath") @NotBlank String contextPath);

    @GetMapping("{applicationId}/commonRefereeServiceIds")
    GenericResponseData<List<Long>> getCommonRefereeServiceIds(
            @PathVariable("applicationId") @NotNull Long applicationId);

    @GetMapping("{applicationId}/refereeServiceIds")
    GenericResponseData<List<Long>> getAllRefereeServiceIds(
            @PathVariable("applicationId") @NotNull Long applicationId);

    @GetMapping("{pageId}/pageMethodDefinitions")
    GenericResponseData<List<PageMethodDefinition>> getPageMethodDefinitions(
            @PathVariable("pageId") @NotNull Long pageId);

    @GetMapping("{actionId}/actionMethodDefinitions")
    GenericResponseData<List<ActionMethodDefinition>> getActionMethodDefinitions(
            @PathVariable("actionId") @NotNull Long actionId);
}
