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
    public TenantDefinition getTenantDefinitionById(Long tenantId) {
        return proxy.getTenantDefinitionById(tenantId).getData();
    }

    @Override
    public TenantDefinition getTenantDefinitionByCode(String tenantCode) {
        return proxy.getTenantDefinitionByCode(tenantCode).getData();
    }

    @Override
    public TenantDefinition getTenantDefinitionByGuid(String guid) {
        return proxy.getTenantDefinitionByGuid(guid).getData();
    }

    @Override
    public List<TenantProductDefinition> getTenantProductDefinitions(Long tenantId) {
        return proxy.getTenantProductDefinitions(tenantId).getData();
    }

    @Override
    public List<TenantClientDefinition> getTenantClientDefinitions(Long tenantId) {
        return proxy.getTenantClientDefinitions(tenantId).getData();
    }

    @Override
    public TenantClientDefinition getTenantClientDefinition(String host) {
        return proxy.getTenantClientDefinition(host).getData();
    }
}
