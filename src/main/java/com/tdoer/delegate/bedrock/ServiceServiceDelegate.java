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
    public ServiceDefinition getServiceDefinition(String serviceId) {
        return proxy.getServiceDefinition(serviceId).getData();
    }

    @Override
    public List<ServiceMethodDefinition> getServiceMethodDefinitions(String serviceId, String productId, String clientId, Long tenantId, ContextPath contextPath) {
        return proxy.getServiceMethodDefinitions(serviceId, productId, clientId, tenantId, contextPath.getAbsoluteValue()).getData();
    }

    @Override
    public ServiceMethodDefinition getServiceMethodDefinition(Long methodId) {
        return proxy.getServiceMethodDefinition(methodId).getData();
    }
}
