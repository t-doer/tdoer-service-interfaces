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
package com.tdoer.interfaces.config;

import com.tdoer.bedrock.CloudEnvironment;
import com.tdoer.bedrock.CloudEnvironmentHolder;
import com.tdoer.bedrock.PlatformConstants;
import com.tdoer.security.oauth2.OAuth2Constants;
import com.tdoer.security.oauth2.common.AccessTokenThreadLocalHolder;
import feign.Feign;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * @author Htinker Hu (htinker@163.com)
 * @create 2017-09-19
 */
@Configuration
@AutoConfigureBefore(FeignAutoConfiguration.class)
@ConditionalOnClass({Feign.class})
public class FeignClientAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public Feign.Builder builder() {
        return Feign.builder().requestInterceptor((template) -> {
            CloudEnvironment env = CloudEnvironmentHolder.getEnvironment();
            if (env != null) {
                template.header(PlatformConstants.ENVIRONMENT_DIGEST,
                        env.getDigest().toDigestString());
            }
            OAuth2AccessToken accessToken = AccessTokenThreadLocalHolder.getAccessToken();
            if(accessToken != null){
                template.header(OAuth2Constants.AUTH_TOKEN, accessToken.getValue());
            }
        });
    }

    @Bean
    public WebMvcRegistrations feignWebRegistrations() {
        return new WebMvcRegistrations() {
            @Override
            public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
                return new FeignFilterRequestMappingHandlerMapping();
            }
        };
    }

    private static class FeignFilterRequestMappingHandlerMapping extends RequestMappingHandlerMapping {
        @Override
        protected boolean isHandler(Class<?> beanType) {
            return super.isHandler(beanType) && (AnnotationUtils.findAnnotation(beanType, FeignClient.class) == null);
        }
    }
}