package com.example.springboothttps.config;

import org.apache.catalina.connector.Connector;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {
    @Bean
    public ServletListenerRegistrationBean listenerRegistrationBean() {
        ServletListenerRegistrationBean registration = new ServletListenerRegistrationBean(/*new MyListener()*/);
        return registration;
    }

    /**
     * 编程方式实现springboot的http
     *
     * @return
     */
    /*@Bean
    public TomcatServletWebServerFactory servletContainer() {
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory() {
            @Override
            // 安全约束
            protected void postProcessContext(Context context) {
                SecurityConstraint securityConstraint = new SecurityConstraint();
                securityConstraint.setUserConstraint("CONFIDENTIAL");
                SecurityCollection collection = new SecurityCollection();
                collection.addPattern("/*");
                securityConstraint.addCollection(collection);
                context.addConstraint(securityConstraint);
            }
        };
        tomcat.addAdditionalTomcatConnectors(createHttpConnector());
        return tomcat;
    }*/

    /**
     * 创建http连接器
     *
     * @return
     */
    private Connector createHttpConnector() {
        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
        connector.setScheme("http");
        // 能够访问http端口
        connector.setPort(8080);
        connector.setSecure(false);
        // 访问http端口跳转到https端口
        connector.setRedirectPort(8443);
        return connector;
    }

    /**
     * 编程方式实现springboot的https
     *
     * @return
     */
    /*@Bean
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> containerCustomizer() {
        return new WebServerFactoryCustomizer<ConfigurableWebServerFactory>() {
            @Override
            public void customize(ConfigurableWebServerFactory container) {
                Ssl ssl = new Ssl();
                //服务器私钥和证书
                // server.jks为类路径下的证书
                String path = MyConfig.class.getClassLoader().getResource("server.jks").getPath();
                ssl.setKeyStore(path);
                ssl.setKeyStorePassword("123456");
                ssl.setKeyStoreType("jks"); //通过配置文件读进来 @Value("${}")
                container.setSsl(ssl);
                container.setPort(8443);
            }
        };
    }*/
}
