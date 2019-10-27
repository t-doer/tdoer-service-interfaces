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

import com.tdoer.bedrock.impl.definition.service.ServiceDefinition;
import com.tdoer.bedrock.impl.definition.service.ServiceMethodDefinition;
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
@RequestMapping("/bedrock/service")
public interface ServiceService {

    @GetMapping("/definition/byId/{serviceId}")
    GenericResponseData<ServiceDefinition> getServiceDefinition(
            @PathVariable("serviceId") Long serviceId);

    @GetMapping("/definition/byCode/{serviceId}")
    GenericResponseData<ServiceDefinition> getServiceDefinition(
            @PathVariable("serviceCode") String serviceCode);

    @GetMapping("/{serviceId}/methods")
    GenericResponseData<List<ServiceMethodDefinition>> getAllServiceMethodDefinitions(
            @PathVariable("serviceId") Long serviceId);


    @GetMapping("/{serviceId}/customizedMethodIds")
    GenericResponseData<List<Long>> getCustomizedServiceMethodIds(
            @PathVariable("serviceId") @NotNull Long serviceId,
            @RequestParam("applicationId") @NotNull Long applicationId,
            @RequestParam("productId") @NotNull Long productId,
            @RequestParam("clientId") @NotNull Long clientId,
            @RequestParam("tenantId") @NotNull Long tenantId,
            @RequestParam("contextPath")  String contextPath);

    @GetMapping("{serviceId}/commonMethodIds")
    GenericResponseData<List<Long>> getCommonServiceMethodIds(
            @PathVariable("serviceId") @NotNull Long serviceId);


    @GetMapping("{serviceId}/refererClientIds")
    GenericResponseData<List<Long>> getRefererClientIds(Long serviceId);

    @GetMapping("{serviceId}/refererApplicationIds")
    GenericResponseData<List<Long>> getRefererApplicationIds(Long serviceId);

    @GetMapping("{serviceId}/refererServiceIds")
    GenericResponseData<List<Long>> getRefererServiceIds(Long serviceId);

    @GetMapping("{serviceId}/refereeServiceIds")
    GenericResponseData<List<Long>> getRefereeServiceIds(Long serviceId);
}
