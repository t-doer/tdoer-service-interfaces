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
public class ContextServiceDelegate  {

    @Autowired
    ContextService proxy;
//
//    @Override
//    public List<ContextTypeDefinition> getAllContextTypes() {
//
//        return proxy.getAllContextTypes().getData();
//    }
//
//    @Override
//    public List<ContextApplicationDefinition> getContextApplications(ContextPath contextPath, String productId, String clientId, Long tenantId) {
//        return proxy.getContextApplications(contextPath.getAbsoluteValue(), productId, clientId, tenantId).getData();
//    }
//
//    @Override
//    public List<ContextRoleDefinition> getContextRoles(ContextPath contextPath, String productId, String clientId, Long tenantId) {
//        return proxy.getContextRoles(contextPath.getAbsoluteValue(), productId, clientId, tenantId).getData();
//    }
//
//    @Override
//    public List<PublicAuthorityDefinition> getPublicAuthorities(ContextPath contextPath, String productId, String clientId, Long tenantId) {
//        return proxy.getPublicAuthorities(contextPath.getAbsoluteValue(), productId, clientId, tenantId).getData();
//    }
//
//    @Override
//    public List<ContextRoleAuthorityDefinition> getContextRoleAuthorities(ContextPath contextPath, Long roleId) {
//
//        return proxy.getContextRoleAuthorities(contextPath.getAbsoluteValue(), roleId).getData();
//    }
//
//    @Override
//    public ContextInstanceDefinition getContextInstance(ContextPath contextPath) {
//
//        return proxy.getContextInstance(contextPath.getAbsoluteValue()).getData();
//    }
//
//    @Override
//    public List<ContextRoleDefinition> getUserRolesInContext(ContextPath contextPath, Long userId) {
//
//        return proxy.getUserRolesInContext(contextPath.getAbsoluteValue(), userId).getData();
//    }
}
