package com.xiaoyu.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;

import javax.sql.DataSource;

/**
 * @Author: xiaoyu
 * @Descripstion:
 * @Date:Created in 2018/2/23 9:31
 * @Modified By:
 */
@Configuration
public class Oauth2ServerConfig {

    private static final String DEMO_RESOURCE_ID = "order";


    /**
     * 配置资源服务器
     */
    @Configuration
    @EnableResourceServer
    @EnableGlobalMethodSecurity(prePostEnabled = true)
    protected static class ResourceServerConfiguration  extends ResourceServerConfigurerAdapter {

        @Override
        public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
            resources.resourceId(DEMO_RESOURCE_ID).stateless(true);
        }

        @Override
        public void configure(HttpSecurity http) throws Exception {
            http.headers().frameOptions().disable();
            http
                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                    .and()
                    //.authorizeRequests().anyRequest().authenticated()
                    .requestMatchers().anyRequest()
                    //.requestMatchers().antMatchers("/order/**")
                    .and()
                    .anonymous()
                    .and()
                    .authorizeRequests()
                    //.antMatchers("/product/**").access("#oauth2.hasScope('read') and hasRole('ROLE_USER')")
                    .antMatchers("/product/**").access("#oauth2.hasScope('read')")
                    .antMatchers("/order/**","/learn/**").authenticated();//配置order访问控制，必须认证过后才可以访问

        }
    }

    /**
     * 配置认证服务器
     */
    @Configuration
    @EnableAuthorizationServer
    protected static class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

        @Autowired
        AuthenticationManager authenticationManager;

        @Autowired
        RedisConnectionFactory redisConnectionFactory;

        @Qualifier("dataSource")
        @Autowired
        DataSource dataSource;

        JdbcClientDetailsService jdbcClientDetailsService;

       /* private ClientDetailsService clientDetailsService() {
            return new ClientDetailsService() {
                @Override
                public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
                    BaseClientDetails details = new BaseClientDetails();
                    if (clientId.equals("client_1")) {
                        details.setAuthorizedGrantTypes(Arrays.asList("client_credentials", "refresh_token"));
                    } else if (clientId.equals("client_2")) {
                        details.setAuthorizedGrantTypes(Arrays.asList("password", "refresh_token"));
                    }
                    details.setClientId(clientId);
                    details.setResourceIds(Arrays.asList(DEMO_RESOURCE_ID));
                    details.setScope(Arrays.asList("select"));
                    details.setClientSecret("123456");
                    Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
                    authorities.add(new SimpleGrantedAuthority("client"));
                    details.setAuthorities(authorities);
                    return details;
                }
            };
        }*/

        /**
         * 配置AuthorizationServer安全认证的相关信息，创建ClientCredentialsTokenEndpointFilter核心过滤器
         */
        @Override
        public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
            security.allowFormAuthenticationForClients();
        }

        /**
         * 配置OAuth2的客户端相关信息
         */
        @Override
        public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
            clients.withClientDetails(clientDetailsService());
            //clients.jdbc(dataSource);
        }

        @Bean
        public ClientDetailsService clientDetailsService() {
            jdbcClientDetailsService=new JdbcClientDetailsService(dataSource);
            /*BaseClientDetails details = new BaseClientDetails();
            //if (clientId.equals("client_1")) {
                //details.setAuthorizedGrantTypes(Arrays.asList("client_credentials", "refresh_token"));
            details.setAuthorizedGrantTypes(Arrays.asList("password", "refresh_token"));
            *//*} else if (clientId.equals("client_2")) {

            }*//*
            details.setClientId("client_2");
            details.setResourceIds(Arrays.asList(DEMO_RESOURCE_ID));
            details.setScope(Arrays.asList("select"));
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            //request.setPassword(encoder.encode(rawPassword));
            details.setClientSecret(encoder.encode("123456"));
            Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
            authorities.add(new SimpleGrantedAuthority("client"));
            details.setAuthorities(authorities);
            jdbcClientDetailsService.addClientDetails(details);*/
            return jdbcClientDetailsService;
        }

        /**
         * 配置AuthorizationServerEndpointsConfigurer众多相关类，包括配置身份认证器，配置认证方式，TokenStore，TokenGranter，OAuth2RequestFactory
         */
        @Override
        public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
            endpoints.tokenStore(new MyRedisTokenStore(redisConnectionFactory)).authenticationManager(authenticationManager).allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST);
        }
    }
}
