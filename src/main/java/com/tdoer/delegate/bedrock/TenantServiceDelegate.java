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

import com.tdoer.bedrock.impl.definition.tenant.TenantClientDefinition;
import com.tdoer.bedrock.impl.definition.tenant.TenantDefinition;
import com.tdoer.bedrock.impl.definition.tenant.TenantProductDefinition;
import com.tdoer.bedrock.impl.provider.TenantProvider;
import com.tdoer.interfaces.bedrock.service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
/**
 * @author Htinker Hu (htinker@163.com)
 * @create 2017-09-19
 */
public class TenantServiceDelegate implements TenantProvider {

    @Autowired
    TenantService proxy;

    @Override
    public List<TenantDefinition> getTenantDefinitions() {

        return proxy.getTenantDefinitions().getData();
    }

    @Override
    public TenantDefinition getTenantDefinition(Long tenantId) {

        return proxy.getTenantDefinition(tenantId).getData();
    }

    @Override
    public TenantDefinition getTenantDefinition(String tenantCode) {

        return proxy.getTenantDefinition(tenantCode).getData();
    }

    @Override
    public List<TenantProductDefinition> getTenantProductDefinitions(Long tenantId) {

        return proxy.getTenantProductDefinitions(tenantId).getData();
    }

    @Override
    public TenantProductDefinition getTenantProductDefinition(String productId, Long tenantId) {

        return proxy.getTenantProductDefinition(productId, tenantId).getData();
    }

    @Override
    public TenantClientDefinition getTenantClientDefinition(String host) {

        return proxy.getTenantClientDefinition(host).getData();
    }

    @Override
    public TenantClientDefinition getTenantClientDefinition(String clientId, Long tenantId) {

        return proxy.getTenantClientDefinition(clientId, tenantId).getData();
    }

    @Override
    public List<String> getProductIds(Long tenantId) {

        return proxy.getProductIds(tenantId).getData();
    }

    @Override
    public List<String> getClientIds(Long tenantId) {

        return proxy.getClientIds(tenantId).getData();
    }
}
