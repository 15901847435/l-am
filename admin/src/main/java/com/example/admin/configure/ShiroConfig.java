package com.example.admin.configure;

import org.springframework.context.annotation.Configuration;

/**
 * Create by gutongwei
 * 2018/4/24
 */
@Configuration
public class ShiroConfig {

//    @Value("${spring.redis.host}")
//    private String host;
//
//    @Value("${spring.redis.port}")
//    private int port;
//
//    @Value("${spring.redis.timeout}")
//    private int timeout;
//
//    @Bean
//    public static LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
//        return new LifecycleBeanPostProcessor();
//    }
//
//    /**
//     * spring session管理器（多机环境）
//     */
//    @Bean
//    @ConditionalOnProperty(prefix = "admin", name = "spring-session-open", havingValue = "true")
//    public ServletContainerSessionManager servletContainerSessionManager() {
//        return new ServletContainerSessionManager();
//    }
//
//    /**
//     * ShiroFilterFactoryBean 处理拦截资源文件问题。
//     * 注意：单独一个ShiroFilterFactoryBean配置是或报错的，因为在
//     * 初始化ShiroFilterFactoryBean的时候需要注入：SecurityManager
//     *
//     Filter Chain定义说明
//     1、一个URL可以配置多个Filter，使用逗号分隔
//     2、当设置多个过滤器时，全部验证通过，才视为通过
//     3、部分过滤器可指定参数，如perms，roles
//     *
//     */
//    @Bean
//    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager){
//        System.out.println("ShiroConfiguration.shirFilter()");
//        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
//        shiroFilter.setSecurityManager(securityManager);
//        /**
//         * 默认的登陆访问url
//         */
//        shiroFilter.setLoginUrl("/login");
//        /**
//         * 登陆成功后跳转的url
//         */
//        shiroFilter.setSuccessUrl("/welcome");
//        /**
//         * 没有权限跳转的url
//         */
//        shiroFilter.setUnauthorizedUrl("/global/error");
//        /**
//         * 配置shiro拦截器链
//         *
//         * anon  不需要认证
//         * authc 需要认证
//         * user  验证通过或RememberMe登录的都可以
//         *
//         * 当应用开启了rememberMe时,用户下次访问时可以是一个user,但不会是authc,因为authc是需要重新认证的
//         *
//         * 顺序从上到下,优先级依次降低
//         *
//         */
//        Map<String, String> hashMap = new LinkedHashMap<>();
//
//        hashMap.put("/login", "anon");
//        hashMap.put("/admin/login", "anon");
//        hashMap.put("/work/login", "anon");
//        hashMap.put("/company/login", "anon");
//        hashMap.put("/company/register", "anon");
//
//        hashMap.put("/media/login", "anon");
//        hashMap.put("/media/register", "anon");
//
//        hashMap.put("/static/**", "anon");
////        hashMap.put("/ueditor/**", "anon");
//        hashMap.put("/h5/**", "anon");
//        hashMap.put("/login", "anon");
//        hashMap.put("/global/sessionError", "anon");
//        hashMap.put("/kaptcha", "anon");
//        hashMap.put("/**", "user");
//        shiroFilter.setFilterChainDefinitionMap(hashMap);
//        return shiroFilter;
//    }
//
//
//    @Bean
//    public SecurityManager securityManager(){
//        DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();
//        //设置realm.
//        securityManager.setRealm(shiroDbRealm());
//        // 自定义缓存实现 使用redis
//        //securityManager.setCacheManager(cacheManager());
//        // 自定义session管理 使用redis
//        securityManager.setSessionManager(sessionManager());
//        return securityManager;
//    }
//
//    @Bean
//    public ShiroDbRealm shiroDbRealm() {
//        ShiroDbRealm shiroDbRealm = new ShiroDbRealm();
////    	shiroDbRealm.setCredentialsMatcher(hashedCredentialsMatcher());
//        return shiroDbRealm;
//    }
//
//
//    /**
//     * 凭证匹配器
//     * （由于我们的密码校验交给Shiro的SimpleAuthenticationInfo进行处理了
//     *  所以我们需要修改下doGetAuthenticationInfo中的代码;
//     * ）
//     * @return
//     */
//    @Bean
//    public HashedCredentialsMatcher hashedCredentialsMatcher(){
//        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
//
//        hashedCredentialsMatcher.setHashAlgorithmName("md5");//散列算法:这里使用MD5算法;
//        hashedCredentialsMatcher.setHashIterations(2);//散列的次数，比如散列两次，相当于 md5(md5(""));
//
//        return hashedCredentialsMatcher;
//    }
//
//
//    /**
//     *  开启shiro aop注解支持.
//     *  使用代理方式;所以需要开启代码支持;
//     * @param securityManager
//     * @return
//     */
//    @Bean
//    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager){
//        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
//        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
//        return authorizationAttributeSourceAdvisor;
//    }
//
//    /**
//     * 配置shiro redisManager
//     * 使用的是shiro-redis开源插件
//     * @return
//     */
//    public RedisManager redisManager() {
//        RedisManager redisManager = new RedisManager();
//        redisManager.setHost(host);
//        redisManager.setPort(port);
////        redisManager.setExpire(3600);// 配置缓存过期时间
//        redisManager.setTimeout(timeout);
//        // redisManager.setPassword(password);
//        return redisManager;
//    }
//
//    /**
//     * cacheManager 缓存 redis实现
//     * 使用的是shiro-redis开源插件
//     * @return
//     */
//    public RedisCacheManager cacheManager() {
//        RedisCacheManager redisCacheManager = new RedisCacheManager();
//        redisCacheManager.setRedisManager(redisManager());
//        return redisCacheManager;
//    }
//
//
//    /**
//     * RedisSessionDAO shiro sessionDao层的实现 通过redis
//     * 使用的是shiro-redis开源插件
//     */
//    @Bean
//    public RedisSessionDAO redisSessionDAO() {
//        RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
//        redisSessionDAO.setRedisManager(redisManager());
//        return redisSessionDAO;
//    }
//
//    /**
//     * shiro session的管理
//     */
//    @Bean
//    public DefaultWebSessionManager sessionManager() {
//        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
//        sessionManager.setSessionDAO(redisSessionDAO());
//        return sessionManager;
//    }

}
