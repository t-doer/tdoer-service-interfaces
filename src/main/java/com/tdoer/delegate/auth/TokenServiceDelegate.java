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
package com.tdoer.delegate.auth;

import com.tdoer.interfaces.auth.service.TokenService;
import com.tdoer.oauth2.provider.token.ResourceServerRefreshTokenServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2RefreshToken;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.oauth2.provider.OAuth2Authentication;

/**
 * @author Htinker Hu (htinker@163.com)
 * @create 2017-09-19
 */
public class TokenServiceDelegate implements ResourceServerRefreshTokenServices {
    @Autowired
    TokenService proxy;

    @Override
    public OAuth2RefreshToken readRefreshTokenForToken(String accessToken) {
        return proxy.readRefreshTokenForToken(accessToken).getData();
    }

    @Override
    public OAuth2Authentication loadAuthentication(String accessToken) throws AuthenticationException, InvalidTokenException {
        return proxy.loadAuthentication(accessToken).getData();
    }

    @Override
    public OAuth2AccessToken readAccessToken(String accessToken) {
        return proxy.readAccessToken(accessToken).getData();
    }
}
