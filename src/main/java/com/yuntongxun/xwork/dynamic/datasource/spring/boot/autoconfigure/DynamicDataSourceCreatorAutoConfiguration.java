/**
 * Copyright © 2018 organization baomidou
 * <pre>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * <pre/>
 */
package com.yuntongxun.xwork.dynamic.datasource.spring.boot.autoconfigure;

import com.yuntongxun.xwork.dynamic.datasource.creator.BasicDataSourceCreator;
import com.yuntongxun.xwork.dynamic.datasource.creator.DataSourceCreator;
import com.yuntongxun.xwork.dynamic.datasource.creator.HikariDataSourceCreator;
import com.yuntongxun.xwork.dynamic.datasource.creator.JndiDataSourceCreator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liugang
 */
@Slf4j
@Configuration
@AllArgsConstructor
@EnableConfigurationProperties(DynamicDataSourceProperties.class)
public class DynamicDataSourceCreatorAutoConfiguration {

    private final DynamicDataSourceProperties properties;

    @Bean
    @ConditionalOnMissingBean
    public DataSourceCreator dataSourceCreator() {
        DataSourceCreator dataSourceCreator = new DataSourceCreator();
        dataSourceCreator.setBasicDataSourceCreator(basicDataSourceCreator());
        dataSourceCreator.setJndiDataSourceCreator(jndiDataSourceCreator());
        dataSourceCreator.setHikariDataSourceCreator(hikariDataSourceCreator());
        dataSourceCreator.setGlobalPublicKey(properties.getPublicKey());
        return dataSourceCreator;
    }

    @Bean
    @ConditionalOnMissingBean
    public BasicDataSourceCreator basicDataSourceCreator() {
        return new BasicDataSourceCreator();
    }

    @Bean
    @ConditionalOnMissingBean
    public JndiDataSourceCreator jndiDataSourceCreator() {
        return new JndiDataSourceCreator();
    }

    @Bean
    @ConditionalOnMissingBean
    public HikariDataSourceCreator hikariDataSourceCreator() {
        return new HikariDataSourceCreator(properties.getHikari());
    }
}
