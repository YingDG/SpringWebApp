package spring.dictionary;

import org.junit.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;
import org.springframework.remoting.caucho.HessianExporter;
import org.springframework.remoting.httpinvoker.AbstractHttpInvokerRequestExecutor;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;
import org.springframework.web.bind.ServletRequestParameterPropertyValues;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.ConfigurableWebApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.support.GroovyWebApplicationContext;
import org.springframework.web.context.support.StandardServletEnvironment;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.filter.AbstractRequestLoggingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.jsf.DelegatingNavigationHandlerProxy;
import org.springframework.web.jsf.el.WebApplicationContextFacesELResolver;
import org.springframework.web.multipart.support.MultipartFilter;
import org.springframework.web.util.CookieGenerator;
import org.springframework.web.util.Log4jWebConfigurer;
import org.springframework.web.util.TagUtils;
import org.springframework.web.util.WebUtils;

/**
 * Created by yingdg on 2017/5/27.
 */
public class MySpringWebCodeDictionary {

    /*
    web包
     */
    @Test
    public void web() {
        // HttpHeaders
        System.out.println(HttpHeaders.ACCEPT); // accept
        System.out.println(HttpHeaders.SET_COOKIE2); // Set-Cookie2
        // HttpMethod
        System.out.println(HttpMethod.GET); // get
        // HttpStatus
        System.out.println(HttpStatus.NOT_FOUND); // 404
        // MediaType
        System.out.println(MediaType.APPLICATION_JSON_VALUE); // application/json
        System.out.println(ProtobufHttpMessageConverter.X_PROTOBUF_MESSAGE_HEADER); // X-Protobuf-Message
        System.out.println(ProtobufHttpMessageConverter.X_PROTOBUF_SCHEMA_HEADER); // X-Protobuf-Schema
        System.out.println(HessianExporter.CONTENT_TYPE_HESSIAN); // application/x-hessian
        System.out.println(AbstractHttpInvokerRequestExecutor.CONTENT_TYPE_SERIALIZED_OBJECT); // application/x-java-serialized-object
        System.out.println(SimpleJaxWsServiceExporter.DEFAULT_BASE_ADDRESS); // "http://localhost:8080/"
        System.out.println(ServletRequestParameterPropertyValues.DEFAULT_PREFIX_SEPARATOR); // "_"
        // ServletRequestUtils工具类
        System.out.println(WebDataBinder.DEFAULT_AUTO_GROW_COLLECTION_LIMIT); // 256
        System.out.println(WebDataBinder.DEFAULT_OBJECT_NAME); // target
        System.out.println(WebDataBinder.DEFAULT_FIELD_DEFAULT_PREFIX); // "!"
        System.out.println(WebDataBinder.DEFAULT_FIELD_MARKER_PREFIX); // "_"
        // RequestMethod
        System.out.println(RequestMethod.GET); // GET
        System.out.println(ConfigurableWebApplicationContext.APPLICATION_CONTEXT_ID_PREFIX);
        System.out.println(ConfigurableWebApplicationContext.SERVLET_CONFIG_BEAN_NAME);
        System.out.println(WebApplicationContext.CONTEXT_ATTRIBUTES_BEAN_NAME);
        System.out.println(WebApplicationContext.CONTEXT_PARAMETERS_BEAN_NAME);
        System.out.println(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
        System.out.println(WebApplicationContext.SCOPE_APPLICATION);
        System.out.println(WebApplicationContext.SCOPE_GLOBAL_SESSION);
        System.out.println(WebApplicationContext.SCOPE_REQUEST);
        System.out.println(WebApplicationContext.SCOPE_SESSION);
        System.out.println(WebApplicationContext.SERVLET_CONTEXT_BEAN_NAME);
        System.out.println(RequestAttributes.REFERENCE_REQUEST); // request
        System.out.println(RequestAttributes.REFERENCE_SESSION); // session
        System.out.println(RequestAttributes.SCOPE_GLOBAL_SESSION); // 2
        System.out.println(RequestAttributes.SCOPE_REQUEST); // 0
        System.out.println(RequestAttributes.SCOPE_SESSION); // 1
        System.out.println(GroovyWebApplicationContext.DEFAULT_CONFIG_LOCATION); // "/WEB-INF/applicationContext.groovy"
        System.out.println(GroovyWebApplicationContext.DEFAULT_CONFIG_LOCATION_PREFIX); // "/WEB-INF/"
        System.out.println(GroovyWebApplicationContext.DEFAULT_CONFIG_LOCATION_SUFFIX); // .groovy
        System.out.println(StandardServletEnvironment.JNDI_PROPERTY_SOURCE_NAME); // jndiProperties
        System.out.println(StandardServletEnvironment.SERVLET_CONFIG_PROPERTY_SOURCE_NAME);
        System.out.println(StandardServletEnvironment.SERVLET_CONTEXT_PROPERTY_SOURCE_NAME);
        System.out.println(XmlWebApplicationContext.DEFAULT_CONFIG_LOCATION);
        System.out.println(XmlWebApplicationContext.DEFAULT_CONFIG_LOCATION_PREFIX);
        System.out.println(XmlWebApplicationContext.DEFAULT_CONFIG_LOCATION_SUFFIX); // .xml
        System.out.println(CorsConfiguration.ALL); // "*"
        System.out.println(AbstractRequestLoggingFilter.DEFAULT_AFTER_MESSAGE_PREFIX); // After request [
        System.out.println(AbstractRequestLoggingFilter.DEFAULT_AFTER_MESSAGE_SUFFIX); // ]
        System.out.println(AbstractRequestLoggingFilter.DEFAULT_BEFORE_MESSAGE_PREFIX); // Before request [
        System.out.println(AbstractRequestLoggingFilter.DEFAULT_BEFORE_MESSAGE_SUFFIX); // ]
        System.out.println(HiddenHttpMethodFilter.DEFAULT_METHOD_PARAM); // _method
        System.out.println(OncePerRequestFilter.ALREADY_FILTERED_SUFFIX); // .FILTERED
        System.out.println(DelegatingNavigationHandlerProxy.DEFAULT_TARGET_BEAN_NAME); // jsfNavigationHandler
        System.out.println(WebApplicationContextFacesELResolver.RESOLVABLE_AT_DESIGN_TIME); // resolvableAtDesignTime
        System.out.println(WebApplicationContextFacesELResolver.TYPE); // type
        System.out.println(WebApplicationContextFacesELResolver.WEB_APPLICATION_CONTEXT_VARIABLE_NAME); // webApplicationContext
        System.out.println(MultipartFilter.DEFAULT_MULTIPART_RESOLVER_BEAN_NAME); // filterMultipartResolver
        System.out.println(CookieGenerator.DEFAULT_COOKIE_PATH); // "/"
        // HtmlUtils工具类
        // JavaScriptUtils工具类
        System.out.println(Log4jWebConfigurer.CONFIG_LOCATION_PARAM); // log4jConfigLocation
        System.out.println(Log4jWebConfigurer.EXPOSE_WEB_APP_ROOT_PARAM); // log4jExposeWebAppRoot
        System.out.println(Log4jWebConfigurer.REFRESH_INTERVAL_PARAM); // log4jRefreshInterval
        // TagUtils工具类
        System.out.println(TagUtils.SCOPE_APPLICATION); // application
        System.out.println(TagUtils.SCOPE_PAGE); // page
        System.out.println(TagUtils.SCOPE_REQUEST); // request
        System.out.println(TagUtils.SCOPE_SESSION); // session
        System.out.println(WebUtils.DEFAULT_CHARACTER_ENCODING); // ISO-8859-1
    }

}
