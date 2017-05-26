package spring;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.core.OverridingClassLoader;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.core.io.support.LocalizedResourceHelper;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.util.*;
import org.springframework.util.xml.DomUtils;

import java.util.ArrayList;
import java.util.Arrays;

public class MySpringCodeDictionary {
    public static void main(String[] args) throws InterruptedException {
        // Core包
        System.out.println(ApplicationContext.CLASSPATH_ALL_URL_PREFIX); // classpath*:
        System.out.println(ApplicationContext.CLASSPATH_URL_PREFIX); // classpath:
        System.out.println(ApplicationContext.FACTORY_BEAN_PREFIX); // &
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
}
