/**
 * JBoss, Home of Professional Open Source
 * Copyright Red Hat, Inc., and individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.wessendorf.proxy;

import io.fabric8.gateway.model.HttpProxyRuleBase;
import io.fabric8.gateway.servlet.ProxyServlet;
import io.fabric8.gateway.support.JsonRuleBaseReader;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

public class UnifiedPushProxyServlet extends ProxyServlet {

    private static final long serialVersionUID = 1L;
    private static final String GATEWAY_CONFIG = "/WEB-INF/ups-proxy-config.json";

    @Override
    protected void loadRuleBase(ServletConfig servletConfig, HttpProxyRuleBase ruleBase) throws ServletException {
        ruleBase.setMappingRules(JsonRuleBaseReader.parseJson(servletConfig.getServletContext().getResourceAsStream(GATEWAY_CONFIG)));
    }
}