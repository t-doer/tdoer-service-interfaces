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

import com.tdoer.bedrock.context.ContextPath;
import com.tdoer.bedrock.impl.definition.application.ActionDefinition;
import com.tdoer.bedrock.impl.definition.application.ApplicationDefinition;
import com.tdoer.bedrock.impl.definition.application.ApplicationServiceDefinition;
import com.tdoer.bedrock.impl.definition.application.PageDefinition;
import com.tdoer.bedrock.impl.provider.ApplicationProvider;
import com.tdoer.interfaces.bedrock.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Htinker Hu (htinker@163.com)
 * @create 2017-09-19
 */
@Service
public class ApplicationServiceDelegate implements ApplicationProvider {

    @Autowired
    ApplicationService proxy;

    @Override
    public ApplicationDefinition getApplicationDefinition(String applicationId) {
        return proxy.getApplicationDefinition(applicationId).getData();
    }

    @Override
    public List<PageDefinition> getPageDefinitions(String applicationId, String productId, String clientId, Long tenantId, ContextPath contextPath) {
        return proxy.getPageDefinitions(applicationId, productId, clientId, tenantId, contextPath.getAbsoluteValue()).getData();
    }

    @Override
    public List<ActionDefinition> getActionDefinitions(String applicationId, String productId, String clientId, Long tenantId, ContextPath contextPath) {
        return proxy.getActionDefinitions(applicationId, productId, clientId, tenantId, contextPath.getAbsoluteValue()).getData();
    }

    @Override
    public List<ApplicationServiceDefinition> getApplicationServiceDefinitions(String applicationId, String productId, String clientId, Long tenantId, ContextPath contextPath) {
        return proxy.getApplicationServiceDefinitions(applicationId, productId, clientId, tenantId, contextPath.getAbsoluteValue()).getData();
    }

    @Override
    public List<Long> getServiceMethodIdsOfPage(String applicationId, Long pageId) {
        return proxy.getServiceMethodIdsOfPage(applicationId, pageId).getData();
    }

    @Override
    public List<Long> getServiceMethodIdsOfAction(String applicationId, Long pageId, Long actionId) {
        return proxy.getServiceMethodIdsOfAction(applicationId, pageId, actionId).getData();
    }
}
