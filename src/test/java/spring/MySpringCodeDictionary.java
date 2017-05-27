package spring;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.aop.config.AopNamespaceUtils;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.framework.autoproxy.target.QuickTargetSourceCreator;
import org.springframework.aop.interceptor.CustomizableTraceInterceptor;
import org.springframework.beans.MethodInvocationException;
import org.springframework.beans.PropertyAccessor;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.config.*;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.AutowireCandidateQualifier;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.beans.factory.wiring.BeanWiringInfo;
import org.springframework.beans.factory.xml.*;
import org.springframework.beans.propertyeditors.CustomBooleanEditor;
import org.springframework.beans.propertyeditors.ResourceBundleEditor;
import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.cache.config.CacheManagementConfigUtils;
import org.springframework.cache.interceptor.DefaultKeyGenerator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.access.ContextJndiBeanFactoryLocator;
import org.springframework.context.annotation.AdviceModeImportSelector;
import org.springframework.context.expression.StandardBeanExpressionResolver;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.LiveBeansView;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.weaving.AspectJWeavingEnabler;
import org.springframework.core.Ordered;
import org.springframework.core.OverridingClassLoader;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.core.io.support.LocalizedResourceHelper;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.instrument.classloading.ShadowingClassLoader;
import org.springframework.jca.context.SpringContextResourceAdapter;
import org.springframework.jdbc.support.DatabaseStartupValidator;
import org.springframework.jmx.support.ConnectorServerFactoryBean;
import org.springframework.jmx.support.JmxUtils;
import org.springframework.jndi.JndiLocatorSupport;
import org.springframework.remoting.rmi.RemoteInvocationSerializingExporter;
import org.springframework.scheduling.annotation.AsyncAnnotationBeanPostProcessor;
import org.springframework.scheduling.annotation.ScheduledAnnotationBeanPostProcessor;
import org.springframework.transaction.HeuristicCompletionException;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.interceptor.RuleBasedTransactionAttribute;
import org.springframework.transaction.jta.JtaTransactionManager;
import org.springframework.transaction.jta.WebSphereUowTransactionManager;
import org.springframework.transaction.support.AbstractPlatformTransactionManager;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.util.*;
import org.springframework.util.xml.DomUtils;
import org.springframework.validation.DataBinder;
import org.springframework.validation.DefaultBindingErrorProcessor;
import org.springframework.validation.Errors;

import java.util.ArrayList;
import java.util.Arrays;

public class MySpringCodeDictionary {

    /*
    Core包
     */
    @Ignore
    // @Test
    public void core() throws InterruptedException {
        System.out.println(ConfigurableBeanFactory.SCOPE_PROTOTYPE); // prototype
        System.out.println(ConfigurableBeanFactory.SCOPE_SINGLETON); // singleton
        System.out.println(ConfigurableBeanFactory.FACTORY_BEAN_PREFIX); // &
        System.out.println(StandardEnvironment.SYSTEM_ENVIRONMENT_PROPERTY_SOURCE_NAME);
        System.out.println(StandardEnvironment.SYSTEM_PROPERTIES_PROPERTY_SOURCE_NAME);
        System.out.println(StandardEnvironment.ACTIVE_PROFILES_PROPERTY_NAME);
        System.out.println(StandardEnvironment.DEFAULT_PROFILES_PROPERTY_NAME);
        System.out.println(LocalizedResourceHelper.DEFAULT_SEPARATOR); // "_"
        System.out.println(CachingMetadataReaderFactory.DEFAULT_CACHE_LIMIT); // 256
        System.out.println(Ordered.HIGHEST_PRECEDENCE);
        System.out.println(Ordered.LOWEST_PRECEDENCE);
        System.out.println(Arrays.toString(OverridingClassLoader.DEFAULT_EXCLUDED_PACKAGES)); // [java., javax., sun., oracle., javassist., org.aspectj., net.sf.cglib.]
        // IdGenerator接口实现类
        System.out.println(new AlternativeJdkIdGenerator().generateId()); // Spring4.UUID
        System.out.println(new JdkIdGenerator().generateId()); // JDK.UUID.randomUUID()
        System.out.println(new SimpleIdGenerator().generateId());// 同一实例ID自增，00000000-0000-0000-0000-000000000001
        System.out.println(AntPathMatcher.DEFAULT_PATH_SEPARATOR); // "/"
        Assert.isNull(null, "null!");
        System.out.println(ClassUtils.ARRAY_SUFFIX); // "[]"
        System.out.println(ClassUtils.CGLIB_CLASS_SEPARATOR); // "$$"
        System.out.println(ClassUtils.CLASS_FILE_SUFFIX); // .class
        System.out.println(ClassUtils.getPackageName(String.class)); // 类所在包名
        System.out.println(CollectionUtils.isEmpty(new ArrayList<>())); // 类包含将数组转为集合，properties转为map
        // System.out.println(DomUtils.getChildElements(null));
        System.out.println(FileCopyUtils.BUFFER_SIZE); // 4096
        System.out.println(Log4jConfigurer.XML_FILE_EXTENSION); // .xml
        System.out.println(MimeTypeUtils.ALL_VALUE); // */*
        System.out.println(MimeTypeUtils.APPLICATION_FORM_URLENCODED_VALUE); // application/x-www-form-urlencoded
        System.out.println(MimeTypeUtils.APPLICATION_JSON_VALUE); // application/json
        System.out.println(MimeTypeUtils.APPLICATION_XHTML_XML_VALUE); // application/xhtml+xml
        System.out.println(MimeTypeUtils.APPLICATION_XML_VALUE); // application/xml
        System.out.println(MimeTypeUtils.IMAGE_GIF_VALUE); // image/gif
        System.out.println(MimeTypeUtils.IMAGE_JPEG_VALUE); // image/jpeg
        System.out.println(MimeTypeUtils.IMAGE_PNG_VALUE); // image/png
        System.out.println(MimeTypeUtils.MULTIPART_FORM_DATA_VALUE); // multipart/form-data
        System.out.println(MimeTypeUtils.TEXT_HTML_VALUE); // text/html
        System.out.println(MimeTypeUtils.TEXT_PLAIN_VALUE); // text/plain
        System.out.println(MimeTypeUtils.TEXT_XML_VALUE); // text/xml
        System.out.println(ObjectUtils.isEmpty(new Object())); // 注意new Object()结果为false
        System.out.println(ReflectionUtils.findMethod(Object.class, "toString").getReturnType());
        System.out.println(ResourceUtils.FILE_URL_PREFIX); // file:
        System.out.println(ResourceUtils.URL_PROTOCOL_FILE); // file
        System.out.println(ResourceUtils.JAR_FILE_EXTENSION); // .jar
        System.out.println(ResourceUtils.JAR_URL_PREFIX); // jar:
        System.out.println(ResourceUtils.URL_PROTOCOL_JAR); // jar
        System.out.println(ResourceUtils.URL_PROTOCOL_ZIP); // zip
        System.out.println(ResourceUtils.WAR_URL_PREFIX); // war:
        String spring = "spring";
        byte[] serialize = SerializationUtils.serialize(spring);
        System.out.println(SerializationUtils.deserialize(serialize));
        System.out.println(SocketUtils.PORT_RANGE_MIN); // 1024
        System.out.println(SocketUtils.PORT_RANGE_MAX); // 65535
        // 计时器
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Thread.sleep(1000);
        stopWatch.stop();
        System.out.println(stopWatch.getTotalTimeSeconds());
        System.out.println(StreamUtils.BUFFER_SIZE); // 4096
        System.out.println(StreamUtils.emptyInput()); // 可以转换流
        System.out.println(StringUtils.capitalize("abcd")); // 首字母大写
        System.out.println(StringUtils.containsWhitespace(" a c"));
        System.out.println(StringUtils.trimAllWhitespace("s p r i n g"));
        System.out.println(SystemPropertyUtils.PLACEHOLDER_PREFIX); // "${"
        System.out.println(SystemPropertyUtils.PLACEHOLDER_SUFFIX); // "}"
        System.out.println(SystemPropertyUtils.VALUE_SEPARATOR); // ":"
    }

    /*
    Beans包
     */
    @Ignore
    // @Test
    public void beans() {
        System.out.println(MethodInvocationException.ERROR_CODE); // methodInvocation
        System.out.println(PropertyAccessor.NESTED_PROPERTY_SEPARATOR); // "."
        System.out.println(PropertyAccessor.NESTED_PROPERTY_SEPARATOR_CHAR); // '.'
        System.out.println(PropertyAccessor.PROPERTY_KEY_PREFIX); // "["
        System.out.println(PropertyAccessor.PROPERTY_KEY_PREFIX_CHAR); // '['
        System.out.println(PropertyAccessor.PROPERTY_KEY_SUFFIX); // "]"
        System.out.println(PropertyAccessor.PROPERTY_KEY_SUFFIX_CHAR); // ']'
        System.out.println(TypeMismatchException.ERROR_CODE); // typeMismatch
        System.out.println(PagedListHolder.DEFAULT_MAX_LINKED_PAGES); // 10
        System.out.println(PagedListHolder.DEFAULT_PAGE_SIZE); // 10
        System.out.println(CustomBooleanEditor.VALUE_0); // "0"
        System.out.println(CustomBooleanEditor.VALUE_1); // "1"
        System.out.println(CustomBooleanEditor.VALUE_FALSE); // "false"
        System.out.println(CustomBooleanEditor.VALUE_TRUE); // 'true"
        System.out.println(CustomBooleanEditor.VALUE_NO); // no
        System.out.println(CustomBooleanEditor.VALUE_YES); // yes
        System.out.println(CustomBooleanEditor.VALUE_OFF); // off
        System.out.println(CustomBooleanEditor.VALUE_ON); // on
        System.out.println(ResourceBundleEditor.BASE_NAME_SEPARATOR); // "_"
        System.out.println(StringArrayPropertyEditor.DEFAULT_SEPARATOR); // ","
        System.out.println(BeanFactoryUtils.GENERATED_BEAN_NAME_SEPARATOR); // #
        System.out.println(BeanDefinition.ROLE_APPLICATION); // 0
        System.out.println(BeanDefinition.ROLE_INFRASTRUCTURE); // 2
        System.out.println(BeanDefinition.ROLE_SUPPORT); // 1
        System.out.println(BeanDefinition.SCOPE_PROTOTYPE);
        System.out.println(BeanDefinition.SCOPE_SINGLETON);
        System.out.println(PropertyOverrideConfigurer.DEFAULT_BEAN_NAME_SEPARATOR); // "."
        System.out.println(AbstractBeanDefinition.SCOPE_DEFAULT); // ""
        System.out.println(AbstractBeanDefinition.AUTOWIRE_CONSTRUCTOR); // 3
        System.out.println(AutowireCandidateQualifier.VALUE_KEY); // value
        System.out.println(BeanDefinitionReaderUtils.GENERATED_BEAN_NAME_SEPARATOR); // "#"
        System.out.println(PropertiesBeanDefinitionReader.ABSTRACT_KEY); // (abstract)
        System.out.println(PropertiesBeanDefinitionReader.CLASS_KEY); // (class)
        System.out.println(PropertiesBeanDefinitionReader.CONSTRUCTOR_ARG_PREFIX); // "$"
        System.out.println(PropertiesBeanDefinitionReader.LAZY_INIT_KEY); // (lazy-init)
        System.out.println(PropertiesBeanDefinitionReader.PARENT_KEY); // (parent)
        System.out.println(PropertiesBeanDefinitionReader.REF_PREFIX); // "*"
        System.out.println(PropertiesBeanDefinitionReader.REF_SUFFIX); // (ref)
        System.out.println(PropertiesBeanDefinitionReader.SCOPE_KEY); // (scope)
        System.out.println(PropertiesBeanDefinitionReader.SEPARATOR); // "."
        System.out.println(PropertiesBeanDefinitionReader.SINGLETON_KEY); // (singleton)
        System.out.println(PropertiesBeanDefinitionReader.TRUE_VALUE); // "true"
        System.out.println(BeanWiringInfo.AUTOWIRE_BY_NAME); // 1
        System.out.println(BeanWiringInfo.AUTOWIRE_BY_TYPE); // 2
        System.out.println(AbstractBeanDefinitionParser.ID_ATTRIBUTE); // id
        System.out.println(AbstractBeanDefinitionParser.NAME_ATTRIBUTE); // name
        System.out.println(DefaultBeanDefinitionDocumentReader.ALIAS_ATTRIBUTE); //alias
        System.out.println(DefaultBeanDefinitionDocumentReader.ALIAS_ELEMENT); // alias
        System.out.println(DefaultBeanDefinitionDocumentReader.BEAN_ELEMENT); // bean
        System.out.println(DefaultBeanDefinitionDocumentReader.IMPORT_ELEMENT); // import
        System.out.println(DefaultBeanDefinitionDocumentReader.NAME_ATTRIBUTE); // name
        System.out.println(DefaultBeanDefinitionDocumentReader.NESTED_BEANS_ELEMENT); // beans
        System.out.println(DefaultBeanDefinitionDocumentReader.PROFILE_ATTRIBUTE); // profile
        System.out.println(DefaultBeanDefinitionDocumentReader.RESOURCE_ATTRIBUTE); // resource
        System.out.println(DefaultNamespaceHandlerResolver.DEFAULT_HANDLER_MAPPINGS_LOCATION); // META-INF/spring.handlers
        System.out.println(DelegatingEntityResolver.DTD_SUFFIX); // .dtd
        System.out.println(DelegatingEntityResolver.XSD_SUFFIX); // .xsd
        System.out.println(PluggableSchemaResolver.DEFAULT_SCHEMA_MAPPINGS_LOCATION); // META-INF/spring.schemas
    }

    /*
    Context包
     */
    @Ignore
    // @Test
    public void context() {
        System.out.println(ApplicationContext.CLASSPATH_ALL_URL_PREFIX); // classpath*:
        System.out.println(ApplicationContext.CLASSPATH_URL_PREFIX); // classpath:
        System.out.println(ApplicationContext.FACTORY_BEAN_PREFIX); // &
        System.out.println(CacheManagementConfigUtils.CACHE_ADVISOR_BEAN_NAME); // org.springframework.cache.config.internalCacheAdvisor
        System.out.println(DefaultKeyGenerator.NO_PARAM_KEY); // 0
        System.out.println(DefaultKeyGenerator.NULL_PARAM_KEY); // 53
        System.out.println(ConfigurableApplicationContext.CONFIG_LOCATION_DELIMITERS); // ",; \t\n"
        System.out.println(ConfigurableApplicationContext.CONVERSION_SERVICE_BEAN_NAME); // conversionService
        System.out.println(ConfigurableApplicationContext.ENVIRONMENT_BEAN_NAME); // environment
        System.out.println(ConfigurableApplicationContext.LOAD_TIME_WEAVER_BEAN_NAME); // loadTimeWeaver
        System.out.println(ConfigurableApplicationContext.SYSTEM_ENVIRONMENT_BEAN_NAME); // systemEnvironment
        System.out.println(ContextJndiBeanFactoryLocator.BEAN_FACTORY_PATH_DELIMITERS); // ",; \t\n"
        System.out.println(ContextJndiBeanFactoryLocator.CONTAINER_PREFIX); // "java:comp/env/"
        System.out.println(AdviceModeImportSelector.DEFAULT_ADVICE_MODE_ATTRIBUTE_NAME); // mode
        System.out.println(StandardBeanExpressionResolver.DEFAULT_EXPRESSION_PREFIX); // "#{"
        System.out.println(StandardBeanExpressionResolver.DEFAULT_EXPRESSION_SUFFIX); // "}"
        System.out.println(AbstractApplicationContext.APPLICATION_EVENT_MULTICASTER_BEAN_NAME); //applicationEventMulticaster
        System.out.println(AbstractApplicationContext.LIFECYCLE_PROCESSOR_BEAN_NAME); // lifecycleProcessor
        System.out.println(AbstractApplicationContext.MESSAGE_SOURCE_BEAN_NAME); // messageSource
        System.out.println(LiveBeansView.MBEAN_APPLICATION_KEY); // application
        System.out.println(PropertySourcesPlaceholderConfigurer.ENVIRONMENT_PROPERTIES_PROPERTY_SOURCE_NAME); // environmentProperties
        System.out.println(PropertySourcesPlaceholderConfigurer.LOCAL_PROPERTIES_PROPERTY_SOURCE_NAME); // localProperties
        System.out.println(AspectJWeavingEnabler.ASPECTJ_AOP_XML_RESOURCE); // META-INF/aop.xml
        System.out.println(ShadowingClassLoader.DEFAULT_EXCLUDED_PACKAGES); // "java.", "javax.", "sun.", "oracle.", "com.sun.", "com.ibm.", "COM.ibm.", "org.w3c.", "org.xml.", "org.dom4j.", "org.eclipse", "org.aspectj.", "net.sf.cglib", "org.springframework.cglib", "org.apache.xerces.", "org.apache.commons.logging."
        System.out.println(ConnectorServerFactoryBean.DEFAULT_SERVICE_URL); // service:jmx:jmxmp://localhost:9875
        System.out.println(JmxUtils.IDENTITY_OBJECT_NAME_KEY); // identity
        System.out.println(JndiLocatorSupport.CONTAINER_PREFIX); // "java/comp/env"
        System.out.println(RemoteInvocationSerializingExporter.CONTENT_TYPE_SERIALIZED_OBJECT); // application/x-java-serialized-object
        System.out.println(AsyncAnnotationBeanPostProcessor.DEFAULT_TASK_EXECUTOR_BEAN_NAME); // taskExecutor
        System.out.println(ScheduledAnnotationBeanPostProcessor.DEFAULT_TASK_SCHEDULER_BEAN_NAME); // taskScheduler
        System.out.println(DataBinder.DEFAULT_OBJECT_NAME); // target
        System.out.println(DataBinder.DEFAULT_AUTO_GROW_COLLECTION_LIMIT); // 256
        System.out.println(DefaultBindingErrorProcessor.MISSING_FIELD_ERROR_CODE); // required
        System.out.println(Errors.NESTED_PATH_SEPARATOR); // "."
    }

    /*
    aop包
     */
    @Ignore
    // @Test
    public void aop() {
        System.out.println(AopNamespaceUtils.PROXY_TARGET_CLASS_ATTRIBUTE); // proxy-target-class
        System.out.println(ProxyFactoryBean.GLOBAL_SUFFIX); // "*"
        System.out.println(QuickTargetSourceCreator.PREFIX_COMMONS_POOL); // ":"
        System.out.println(QuickTargetSourceCreator.PREFIX_PROTOTYPE); // "!"
        System.out.println(QuickTargetSourceCreator.PREFIX_THREAD_LOCAL); // "%"
        System.out.println(CustomizableTraceInterceptor.PLACEHOLDER_ARGUMENT_TYPES); // $[argumentTypes]

    }

    /*
    jdbc包
     */
    @Ignore
    // @Test
    public void jdbc() {
        System.out.println(DatabaseStartupValidator.DEFAULT_INTERVAL); // 1
        System.out.println(DatabaseStartupValidator.DEFAULT_TIMEOUT); // 60

    }

    /*
    tx包
     */
    @Test
    public void tx() {
        System.out.println(SpringContextResourceAdapter.DEFAULT_CONTEXT_CONFIG_LOCATION); // META-INF/applicationContext.xml
        System.out.println(HeuristicCompletionException.STATE_UNKNOWN); // 0
        System.out.println(HeuristicCompletionException.STATE_COMMITTED); // 1
        System.out.println(HeuristicCompletionException.STATE_ROLLED_BACK); // 2
        System.out.println(HeuristicCompletionException.STATE_MIXED); // 3
        // 用于声明式事务注解中
        System.out.println(TransactionDefinition.ISOLATION_DEFAULT); // -1
        System.out.println(TransactionDefinition.ISOLATION_SERIALIZABLE); // 8
        System.out.println(RuleBasedTransactionAttribute.PREFIX_COMMIT_RULE); // "+"
        System.out.println(RuleBasedTransactionAttribute.PREFIX_ROLLBACK_RULE); // "-"
        System.out.println(JtaTransactionManager.DEFAULT_TRANSACTION_SYNCHRONIZATION_REGISTRY_NAME); // java:comp/TransactionSynchronizationRegistry
        System.out.println(JtaTransactionManager.DEFAULT_USER_TRANSACTION_NAME); // java:comp/UserTransaction
        System.out.println(WebSphereUowTransactionManager.DEFAULT_UOW_MANAGER_NAME); // java:comp/websphere/UOWManager
        System.out.println(AbstractPlatformTransactionManager.SYNCHRONIZATION_ALWAYS); // 0
        System.out.println(AbstractPlatformTransactionManager.SYNCHRONIZATION_ON_ACTUAL_TRANSACTION); // 1
        System.out.println(AbstractPlatformTransactionManager.SYNCHRONIZATION_NEVER); // 2
        System.out.println(DefaultTransactionDefinition.PREFIX_ISOLATION); // ISOLATION_
        System.out.println(DefaultTransactionDefinition.PREFIX_PROPAGATION); // PROPAGATION_
        System.out.println(DefaultTransactionDefinition.PREFIX_TIMEOUT); // timeout_
        System.out.println(DefaultTransactionDefinition.READ_ONLY_MARKER); // readOnly
    }

}
