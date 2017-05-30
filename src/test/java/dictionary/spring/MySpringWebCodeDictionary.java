package dictionary.spring;

import org.junit.Ignore;
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
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.FrameworkServlet;
import org.springframework.web.servlet.ResourceServlet;
import org.springframework.web.servlet.config.*;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.mvc.method.RequestMappingInfoHandlerMethodMappingNamingStrategy;
import org.springframework.web.servlet.resource.CachingResourceResolver;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;
import org.springframework.web.servlet.support.RequestContext;
import org.springframework.web.servlet.support.WebContentGenerator;
import org.springframework.web.servlet.tags.BindErrorsTag;
import org.springframework.web.servlet.tags.BindTag;
import org.springframework.web.servlet.tags.MessageTag;
import org.springframework.web.servlet.tags.NestedPathTag;
import org.springframework.web.servlet.tags.form.*;
import org.springframework.web.servlet.theme.AbstractThemeResolver;
import org.springframework.web.servlet.theme.CookieThemeResolver;
import org.springframework.web.servlet.theme.ThemeChangeInterceptor;
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
    @Ignore
    // @Test
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

    /*
    webmvc包
     */
    @Test
    public void webmvc() {
        // DispatcherServlet
        System.out.println(DispatcherServlet.MULTIPART_RESOLVER_BEAN_NAME); // multipartResolver
        System.out.println(DispatcherServlet.LOCALE_RESOLVER_BEAN_NAME); // localeResolver
        System.out.println(FrameworkServlet.DEFAULT_NAMESPACE_SUFFIX); // -servlet
        System.out.println(ResourceServlet.RESOURCE_PARAM_NAME); // resource
        System.out.println(FreeMarkerConfigurerBeanDefinitionParser.BEAN_NAME); // mvcFreeMarkerConfigurer
        System.out.println(GroovyMarkupConfigurerBeanDefinitionParser.BEAN_NAME); // mvcGroovyMarkupConfigurer
        System.out.println(ScriptTemplateConfigurerBeanDefinitionParser.BEAN_NAME); // mvcScriptTemplateConfigurer
        System.out.println(TilesConfigurerBeanDefinitionParser.BEAN_NAME); // mvcTilesConfigurer
        System.out.println(VelocityConfigurerBeanDefinitionParser.BEAN_NAME); // mvcVelocityConfigurer
        System.out.println(ViewResolversBeanDefinitionParser.VIEW_RESOLVER_BEAN_NAME); // mvcViewResolver
        System.out.println(SimpleMappingExceptionResolver.DEFAULT_EXCEPTION_ATTRIBUTE); // exception
        System.out.println(LocaleChangeInterceptor.DEFAULT_PARAM_NAME); // locale
        System.out.println(RequestMappingInfoHandlerMethodMappingNamingStrategy.SEPARATOR); // #
        System.out.println(CachingResourceResolver.RESOLVED_RESOURCE_CACHE_KEY_PREFIX); // resolvedResource:
        System.out.println(CachingResourceResolver.RESOLVED_URL_PATH_CACHE_KEY_PREFIX); // resolvedUrlPath:
        System.out.println(AbstractDispatcherServletInitializer.DEFAULT_SERVLET_NAME); // dispatcher
        System.out.println(RequestContext.DEFAULT_THEME_NAME); // theme
        System.out.println(WebContentGenerator.METHOD_GET); // GET
        System.out.println(WebContentGenerator.METHOD_HEAD); // HEAD
        System.out.println(WebContentGenerator.METHOD_POST); // POST
        System.out.println(BindErrorsTag.ERRORS_VARIABLE_NAME); // errors
        System.out.println(BindTag.STATUS_VARIABLE_NAME); // status
        System.out.println(MessageTag.DEFAULT_ARGUMENT_SEPARATOR); // ","
        System.out.println(NestedPathTag.NESTED_PATH_VARIABLE_NAME); // nestedPath
        // AbstractHtmlElementTag
        System.out.println(AbstractHtmlElementTag.CLASS_ATTRIBUTE); // class
        System.out.println(AbstractHtmlElementTag.DIR_ATTRIBUTE); // dir
        System.out.println(AbstractHtmlElementTag.LANG_ATTRIBUTE); // lang
        System.out.println(AbstractHtmlElementTag.ONCLICK_ATTRIBUTE); // onclick
        System.out.println(AbstractHtmlElementTag.ONDBLCLICK_ATTRIBUTE);
        System.out.println(AbstractHtmlElementTag.ONKEYDOWN_ATTRIBUTE); // onkeydown
        System.out.println(AbstractHtmlElementTag.ONKEYPRESS_ATTRIBUTE); // onkeypress
        System.out.println(AbstractHtmlElementTag.ONMOUSEDOWN_ATTRIBUTE); // onmousedown
        System.out.println(AbstractHtmlElementTag.STYLE_ATTRIBUTE); // style
        System.out.println(AbstractHtmlElementTag.TITLE_ATTRIBUTE); // title
        System.out.println(AbstractHtmlInputElementTag.ACCESSKEY_ATTRIBUTE); // accesskey
        System.out.println(AbstractHtmlInputElementTag.DISABLED_ATTRIBUTE); // disabled
        System.out.println(AbstractHtmlInputElementTag.ONBLUR_ATTRIBUTE); // onblur
        System.out.println(AbstractHtmlInputElementTag.ONCHANGE_ATTRIBUTE); // onchange
        System.out.println(AbstractHtmlInputElementTag.READONLY_ATTRIBUTE); // readonly
        System.out.println(ButtonTag.DISABLED_ATTRIBUTE); // disabled
        System.out.println(FormTag.DEFAULT_COMMAND_NAME); // command
        System.out.println(HiddenInputTag.DISABLED_ATTRIBUTE);
        // InputTag
        System.out.println(InputTag.ALT_ATTRIBUTE); // alt
        System.out.println(InputTag.AUTOCOMPLETE_ATTRIBUTE); // autocomplete
        System.out.println(InputTag.MAXLENGTH_ATTRIBUTE); // maxlength
        System.out.println(InputTag.ONSELECT_ATTRIBUTE); // onselect
        System.out.println(OptionTag.DISPLAY_VALUE_VARIABLE_NAME); // displayValue
        System.out.println(OptionTag.VALUE_VARIABLE_NAME); // value
        System.out.println(TextareaTag.COLS_ATTRIBUTE); // cols
        System.out.println(TextareaTag.ROWS_ATTRIBUTE); // rows
        System.out.println(TextareaTag.ONSELECT_ATTRIBUTE); // onselect
        System.out.println(TextareaTag.READONLY_ATTRIBUTE); // readonly
        System.out.println(AbstractThemeResolver.ORIGINAL_DEFAULT_THEME_NAME); //theme
        System.out.println(CookieThemeResolver.ORIGINAL_DEFAULT_THEME_NAME); // theme
        System.out.println(ThemeChangeInterceptor.DEFAULT_PARAM_NAME); // theme
        // TODO, spring-webmvc-4.3.5.RELEASE.jar!\org\springframework\web\servlet\view

    }

}
