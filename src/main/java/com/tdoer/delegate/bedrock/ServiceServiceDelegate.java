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
import com.tdoer.bedrock.impl.definition.service.ServiceDefinition;
import com.tdoer.bedrock.impl.definition.service.ServiceMethodDefinition;
import com.tdoer.bedrock.impl.provider.ServiceProvider;
import com.tdoer.interfaces.bedrock.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author Htinker Hu (htinker@163.com)
 * @create 2017-09-19
 */
public class ServiceServiceDelegate implements ServiceProvider {

    @Autowired
    private ServiceService proxy;

    @Override
    public ServiceDefinition getServiceDefinition(Long serviceId) {
        return proxy.getServiceDefinition(serviceId).getData();
    }

    @Override
    public ServiceDefinition getServiceDefinition(String serviceCode) {
        return proxy.getServiceDefinition(serviceCode).getData();
    }

    @Override
    public List<ServiceMethodDefinition> getAllServiceMethodDefinitions(Long serviceId) {
        return proxy.getAllServiceMethodDefinitions(serviceId).getData();
    }

    @Override
    public List<Long> getCustomizedServiceMethodIds(Long serviceId, Long applicationId, Long productId, Long clientId, Long tenantId, String contextPath) {
        return proxy.getCustomizedServiceMethodIds(serviceId, applicationId, productId, clientId, tenantId, contextPath).getData();
    }

    @Override
    public List<Long> getCommonServiceMethodIds(Long serviceId) {
        return proxy.getCommonServiceMethodIds(serviceId).getData();
    }

    @Override
    public List<Long> getRefererClientIds(Long serviceId) {
        return proxy.getRefererClientIds(serviceId).getData();
    }

    @Override
    public List<Long> getRefererApplicationIds(Long serviceId) {
        return proxy.getRefererApplicationIds(serviceId).getData();
    }

    @Override
    public List<Long> getRefererServiceIds(Long serviceId) {
        return proxy.getRefererServiceIds(serviceId).getData();
    }

    @Override
    public List<Long> getRefereeServiceIds(Long serviceId) {
        return proxy.getRefereeServiceIds(serviceId).getData();
    }

}
