package com.lmeng.config;

import com.lmeng.filter.ShiroUserFilter;
import com.lmeng.properties.LmengProperties;
import com.lmeng.shiro.LmengiShiroAdminRealm;
import com.lmeng.shiro.LmengiShiroRealm;
import com.lmeng.shiro.ShiroKit;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.mgt.RememberMeManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.Cookie;
import org.apache.shiro.web.servlet.ShiroHttpSession;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.servlet.Filter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * shiro权限管理的配置
 * @author lsk
 */

@Configuration
public class ShiroConfig {

    @Value("${lmeng.session-invalidate-time}")
    private int sessionInvalidateTime;
    @Value("${lmeng.session-validation-interval}")
    private int sessionValidationInterval;

    /**
     * @remark shiro 安全管理器
     * @function securityManager
     */
    @Bean
    public SecurityManager  securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //自定义realm 管理
        //ArrayList<Realm> realms = new ArrayList<Realm>();
        //securityManager.setRealm(lmengiShiroRealm());
        //realms.add(lmengiShiroRealm());
        //realms.add(lmengiShiroAdminRealm());

        securityManager.setRealm(lmengiShiroAdminRealm());
        // 自定义session管理 使用EhCache  或者redis
        securityManager.setSessionManager(defaultWebSessionManager());
        // 自定义缓存实现 使用EhCache 或者redis
        securityManager.setCacheManager(cacheManager());
        //自定义rememberMe时间期限
        securityManager.setRememberMeManager(rememberMeManager());
        return securityManager;
    }

    /**
     * @remark shiro Session 管理器
     * @function securityManager
     */
    @Bean
    //@ConditionalOnProperty(name = "spring-session-open", havingValue = "false")
    public DefaultWebSessionManager defaultWebSessionManager() {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setCacheManager(cacheManager());
        sessionManager.setSessionValidationInterval(sessionInvalidateTime * 1000);
        sessionManager.setGlobalSessionTimeout(sessionValidationInterval * 1000);
        sessionManager.setDeleteInvalidSessions(true);
        sessionManager.setSessionValidationSchedulerEnabled(true);
        Cookie cookie = new SimpleCookie(ShiroHttpSession.DEFAULT_SESSION_ID_NAME);
        cookie.setName("lmengiCookie");
        cookie.setHttpOnly(true);
        sessionManager.setSessionIdCookie(cookie);
        return sessionManager;
    }

    /**
     * @remark 缓存管理器 使用Ehcache实现
     * @function cacheManager
     */
    @Bean
    public CacheManager cacheManager() {
        EhCacheManager ehCacheManager = new EhCacheManager();
        EhCacheManagerFactoryBean ehCacheManagerFactoryBean = new EhCacheManagerFactoryBean();
        ehCacheManagerFactoryBean.setConfigLocation(new ClassPathResource("ehcache.xml"));
        ehCacheManager.setCacheManager( ehCacheManagerFactoryBean.getObject());
        return ehCacheManager;
    }

    /**
     * @remark 设置shiro匹配器
     * @function hashedCredentialsMatcher
     */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName(ShiroKit.hashAlgorithmName);//散列算法:这里使用MD5算法;
        hashedCredentialsMatcher.setHashIterations(ShiroKit.hashIterations);//散列的次数，比如散列两次，相当于 md5(md5(""));
        return hashedCredentialsMatcher;
    }

    /**
     * @remark 自定义realm,试用前端的用户登录
     * @function lmengiShiroRealm
     */
    @Bean
    public LmengiShiroRealm lmengiShiroRealm(){
        LmengiShiroRealm lmengiRealm = new LmengiShiroRealm();
        lmengiRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return lmengiRealm;
    }

    /**
     * @remark 自定义realm,试用前端的用户登录
     * @function lmengiShiroRealm
     */
    @Bean
    public LmengiShiroAdminRealm lmengiShiroAdminRealm(){
        LmengiShiroAdminRealm lmengiAdminRealm = new LmengiShiroAdminRealm();
        lmengiAdminRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return lmengiAdminRealm;
    }

    /**
     * @remark 自定义rememberMe，使用Cookie
     * @function rememberMeManager
     */
    @Bean
    public RememberMeManager rememberMeManager() {
        CookieRememberMeManager manager = new CookieRememberMeManager();
        manager.setCipherKey(Base64.decode("Z3VucwAAAAAAAAAAAAAAAA=="));
        manager.setCookie(rememberMeCookie());
        return manager;
    }

    /**
     * @remark 设置当前记住密码时长
     * @function rememberMeCookie
     */
    @Bean
    public SimpleCookie rememberMeCookie() {
        SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
        simpleCookie.setHttpOnly(true);
        simpleCookie.setMaxAge(7 * 24 * 60 * 60);//7天
        return simpleCookie;
    }

    /**
     * @remark 在方法中 注入 securityManager,进行代理控制
     * @function authorizationAttributeSourceAdvisor
     */
//    @Bean
//    public MethodInvokingFactoryBean methodInvokingFactoryBean(SecurityManager securityManager) {
//        MethodInvokingFactoryBean bean = new MethodInvokingFactoryBean();
//        bean.setStaticMethod("org.apache.shiro.SecurityUtils.setSecurityManager");
//        bean.setArguments(new Object[]{securityManager});
//        return bean;
//    }

    /**
     * @remark Shiro生命周期处理器:
     * @function lifecycleBeanPostProcessor
     */
    @Bean
    public static LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    /**
     * @remark 启用shrio授权注解拦截方式，AOP式方法级权限检查
     * @function authorizationAttributeSourceAdvisor
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    /**
     * Shiro的过滤器链
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
        shiroFilter.setSecurityManager(securityManager);
        /**
         * 默认的登陆访问url
         */
        shiroFilter.setLoginUrl("/login");
        /**
         * 登陆成功后跳转的url
         */
        shiroFilter.setSuccessUrl("/");
        /**
         * 没有权限跳转的url
         */
        shiroFilter.setUnauthorizedUrl("/global/error");

        /**
         * 覆盖默认的user拦截器(默认拦截器解决不了ajax请求 session超时的问题,若有更好的办法请及时反馈作者)
         */
        HashMap<String, Filter> myFilters = new HashMap<>();
        myFilters.put("user", new ShiroUserFilter());
        shiroFilter.setFilters(myFilters);

        /**
         * 配置shiro拦截器链
         * anon  不需要认证
         * authc 需要认证
         * user  验证通过或RememberMe登录的都可以
         * 当应用开启了rememberMe时,用户下次访问时可以是一个user,但不会是authc,因为authc是需要重新认证的
         * 顺序从上到下,优先级依次降低
         * api开头的接口，走rest api鉴权，不走shiro鉴权
         */
        Map<String, String> hashMap = new LinkedHashMap<>();
        hashMap.put("/static/**", "anon");
        hashMap.put("/lmengiApi/**", "anon");
        hashMap.put("/admin/**", "roles[admin]");
        hashMap.put("/login", "anon");
        hashMap.put("/error", "anon");
        hashMap.put("/kaptcha", "anon");
        hashMap.put("/logout", "anon");
        //hashMap.put("/**", "user");
        shiroFilter.setFilterChainDefinitionMap(hashMap);
        return shiroFilter;
    }
}
