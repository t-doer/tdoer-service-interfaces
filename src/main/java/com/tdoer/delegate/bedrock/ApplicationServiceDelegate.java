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

import com.tdoer.bedrock.impl.definition.application.*;
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
    public ApplicationDefinition getApplicationDefinitionById(Long applicationId) {
        return proxy.getApplicationDefinitionById(applicationId).getData();
    }

    @Override
    public ApplicationDefinition getApplicationDefinitionByCode(String applicationCode) {
        return proxy.getApplicationDefinitionByCode(applicationCode).getData();
    }

    @Override
    public List<PageDefinition> getAllPageDefinitions(Long applicationId) {
        return proxy.getAllPageDefinitions(applicationId).getData();
    }

    @Override
    public List<Long> getCustomizedPageIds(Long applicationId, Long productId, Long clientId, Long tenantId, String contextPath) {
        return proxy.getCustomizedPageIds(applicationId, productId, clientId, tenantId, contextPath).getData();
    }

    @Override
    public List<Long> getCommonPageIds(Long applicationId) {
        return proxy.getCommonPageIds(applicationId).getData();
    }

    @Override
    public List<ActionDefinition> getAllActionDefinitions(Long pageId) {
        return proxy.getAllActionDefinitions(pageId).getData();
    }

    @Override
    public List<Long> getCustomizedActionIds(Long pageId, Long productId, Long clientId, Long tenantId, String contextPath) {
        return proxy.getCustomizedPageIds(pageId, productId, clientId, tenantId, contextPath).getData();
    }

    @Override
    public List<Long> getCommonActionIds(Long pageId) {
        return proxy.getCommonActionIds(pageId).getData();
    }

    @Override
    public List<Long> getCustomizedRefereeServiceIds(Long applicationId, Long productId, Long clientId, Long tenantId, String contextPath) {
        return proxy.getCustomizedRefereeServiceIds(applicationId, productId, clientId, tenantId, contextPath).getData();
    }

    @Override
    public List<Long> getCommonRefereeServiceIds(Long applicationId) {
        return proxy.getCommonRefereeServiceIds(applicationId).getData();
    }

    @Override
    public List<Long> getAllRefereeServiceIds(Long applicationId) {
        return proxy.getAllRefereeServiceIds(applicationId).getData();
    }

    @Override
    public List<PageMethodDefinition> getPageMethodDefinitions(Long pageId) {
        return proxy.getPageMethodDefinitions(pageId).getData();
    }

    @Override
    public List<ActionMethodDefinition> getActionMethodDefinitions(Long actionId) {
        return proxy.getActionMethodDefinitions(actionId).getData();
    }
}
