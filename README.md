## 动态数据源 
[抄袭](https://github.com/baomidou/dynamic-datasource-spring-boot-starter/wiki/Integration-With-Druid)



在spring ioc的过程中，优先解析@Component，@Service，@Controller注解的类。其次解析配置类，也就是@Configuration标注的类。最后开始解析配置类中定义的bean

# SpringBoot 自动装配类
com/yuntongxun/xwork/dynamic/datasource/spring/boot/autoconfigure/DynamicDataSourceAutoConfiguration.java

依据SpringBoot规范，新建 src/main/resources/META-INF/spring.factories 文件，并配置
SpringBoot 启动时会自动扫描/META-INF/spring.factories 文件，加载并初始化对应配置
```
org.springframework.boot.autoconfigure.EnableAutoConfiguration=\
com.yuntongxun.xwork.dynamic.datasource.spring.boot.autoconfigure.DynamicDataSourceAutoConfiguration
```

DynamicDataSourceAutoConfiguration 加载配置
```
@Slf4j
@Configuration
@AllArgsConstructor
@EnableConfigurationProperties(DynamicDataSourceProperties.class)
@AutoConfigureBefore(DataSourceAutoConfiguration.class)
@Import(value = {DynamicDataSourceCreatorAutoConfiguration.class})
@ConditionalOnProperty(prefix = DynamicDataSourceProperties.PREFIX, name = "enabled", havingValue = "true", matchIfMissing = true)
public class DynamicDataSourceAutoConfiguration {
    ...
}
```








