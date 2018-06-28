package com.hand.hmall.config;

import com.hand.hmall.constants.OauthConstants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * @Title ResourceServerConfiguration
 * @Description 配置资源服务器
 * @author calvin
 * @date: 2018/6/24 下午12:14 
 */

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    @Value("${requestMatcher.content}")
    public String content;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId(OauthConstants.AUTH_RESOURCE_ID).stateless(true);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        String[] strArray = content.split(",");
        // 配置访问控制，必须认证过后才可以访问
        http.authorizeRequests().antMatchers(strArray).authenticated();
    }

}
