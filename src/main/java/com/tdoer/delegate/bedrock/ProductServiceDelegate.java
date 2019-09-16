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
package com.tdoer.delegate.bedrock;

import com.tdoer.bedrock.impl.definition.product.*;
import com.tdoer.bedrock.impl.provider.ProductProvider;
import com.tdoer.interfaces.bedrock.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Htinker Hu (htinker@163.com)
 * @create 2017-09-19
 */
@Service
public class ProductServiceDelegate implements ProductProvider {

    @Autowired
    ProductService proxy;

    @Override
    public ProductDefinition getProductDefinition(String productId) {

        return proxy.getProductDefinition(productId).getData();
    }

    @Override
    public ClientDefinition getClientDefinition(String clientId) {
        return proxy.getClientDefinition(clientId).getData();
    }

    @Override
    public List<String> getClientIds(String productId) {

        return proxy.getClientIds(productId).getData();
    }

    @Override
    public List<ClientApplicationDefinition> getClientApplicationDefinitions(String productId, String clientId, Long tenantId) {
        return proxy.getClientApplicationDefinitions(productId, clientId, tenantId).getData();
    }

    @Override
    public List<ClientServiceDefinition> getClientServiceDefinitions(String productId, String clientId, Long tenantId) {
        return proxy.getClientServiceDefinitions(productId, clientId, tenantId).getData();
    }

    @Override
    public List<ClientContextDefinition> getClientContextDefinitions(String productId, String clientId, Long tenantId) {
        return proxy.getClientContextDefinitions(productId, clientId, tenantId).getData();
    }

    @Override
    public ClientTokenDefinition getClientTokenDefinition(String clientId, Long tenantId) {

        return proxy.getClientTokenDefinition(clientId, tenantId).getData();
    }
}
