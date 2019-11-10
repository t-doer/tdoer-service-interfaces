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

import com.tdoer.interfaces.bedrock.service.ContextService;
import com.tdoer.bedrock.context.ContextInstance;
import com.tdoer.bedrock.context.ContextPath;
import com.tdoer.bedrock.impl.definition.context.*;
import com.tdoer.bedrock.impl.provider.ContextProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Htinker Hu (htinker@163.com)
 * @create 2017-09-19
 */
@Service
public class ContextServiceDelegate  implements ContextProvider {

    @Autowired
    ContextService proxy;

    @Override
    public List<ContextTypeDefinition> getContextTypes(Long tenantId) {
        return proxy.getContextTypes(tenantId).getData();
    }

    @Override
    public List<ContextPublicMethodDefinition> getContextPublicMethods(Long clientId, Long tenantId,
            ContextPath contextPath) {
        return proxy.getContextPublicMethods(clientId, tenantId, contextPath.getAbsoluteValue()).getData();
    }

    @Override
    public List<ContextRoleMethodDefinition> getContextRoleMethods(Long clientId, Long tenantId,
            ContextPath contextPath, Long roleId) {
        return proxy.getContextRoleMethods(clientId, tenantId, contextPath.getAbsoluteValue(), roleId).getData();
    }

    @Override
    public List<Long> getRoleIdsOfUserInContext(Long tenantId, ContextPath contextPath, Long userId) {
        return proxy.getRoleIdsOfUserInContext(tenantId, contextPath.getAbsoluteValue(), userId).getData();
    }

    @Override
    public ContextInstance getContextInstance(Long tenantId, Long instanceId) {
        return proxy.getContextInstance(tenantId, instanceId).getData();
    }

    @Override
    public List<ContextRoleResourceDefinition> getContextRoleResources(Long clientId, Long tenantId,
            ContextPath contextPath, Long roleId) {
        return proxy.getContextRoleResources(clientId, tenantId, contextPath.getAbsoluteValue(), roleId).getData();
    }

    @Override
    public ContextInstance getContextInstance(Long tenantId, String guid) {
        return proxy.getContextInstance(tenantId, guid).getData();
    }

    @Override
    public List<ContextRoleDefinition> getContextRoles(Long tenantId, ContextPath contextPath) {
        return proxy.getContextRoles(tenantId, contextPath.getAbsoluteValue()).getData();
    }

    @Override
    public List<ContextPublicResourceDefinition> getContextPublicResources(Long clientId, Long tenantId,
            ContextPath contextPath) {
        return proxy.getContextPublicResources(clientId, tenantId, contextPath.getAbsoluteValue()).getData();
    }

    @Override
    public List<ContextApplicationDefinition> getContextApplications(Long clientId, Long tenantId,
            ContextPath contextPath) {
        return proxy.getContextApplications(clientId, tenantId, contextPath.getAbsoluteValue()).getData();
    }
}
