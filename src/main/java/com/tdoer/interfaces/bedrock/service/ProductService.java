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

import com.tdoer.bedrock.impl.definition.product.*;
import com.tdoer.springboot.rest.GenericResponseData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author Htinker Hu (htinker@163.com)
 * @create 2017-09-19
 */
@FeignClient(value = "tdoer-core-data")
@RequestMapping("/bedrock/product")
public interface ProductService {

    @GetMapping("/{productId}")
    GenericResponseData<ProductDefinition> getProductDefinition(
            @PathVariable("productId") @NotBlank String productId);

    @GetMapping("/client/{clientId}")
    GenericResponseData<ClientDefinition> getClientDefinition(
            @PathVariable("clientId") @NotBlank String clientId);

    @GetMapping("/{productId}/clientIds")
    GenericResponseData<List<String>> getClientIds(
            @PathVariable("productId") @NotBlank String productId);

    @GetMapping("/{productId}/client/{clientId}/applications")
    GenericResponseData<List<ClientApplicationDefinition>> getClientApplicationDefinitions(
            @PathVariable("productId") @NotBlank String productId,
            @PathVariable("clientId") @NotBlank String clientId,
            @RequestParam("tenantId") Long tenantId);

    @GetMapping("/{productId}/client/{clientId}/services")
    GenericResponseData<List<ClientServiceDefinition>> getClientServiceDefinitions(
            @PathVariable("productId") @NotBlank String productId,
            @PathVariable("clientId") @NotBlank String clientId,
            @RequestParam("tenantId") Long tenantId);

    @GetMapping("/{productId}/client/{clientId}/contexts")
    GenericResponseData<List<ClientContextDefinition>> getClientContextDefinitions(
            @PathVariable("productId") @NotBlank String productId,
            @PathVariable("clientId") @NotBlank String clientId,
            @RequestParam("tenantId") Long tenantId);

    @GetMapping("/client/{clientId}/tenant/{tenantId}/token")
    GenericResponseData<ClientTokenDefinition> getClientTokenDefinition(
            @PathVariable("clientId") @NotBlank String clientId,
            @RequestParam("tenantId") @NotNull Long tenantId);

}
