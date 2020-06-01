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
package com.yuntongxun.xwork.dynamic.datasource.provider;

import com.yuntongxun.xwork.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

/**
 * jdbc 数据源提供者
 *
 * @author liugang
 */
@Slf4j
public class JdbcDynamicDataSourceProvider extends AbstractJdbcDataSourceProvider implements DynamicDataSourceProvider {

    /**
     * 所有数据源
     */
    private Map<String, DataSourceProperty> dataSourcePropertiesMap;

    public JdbcDynamicDataSourceProvider(String driverClassName, String url, String username, String password) {
        super(driverClassName, url, username, password);
    }

    @Override
    public Map<String, DataSource> loadDataSources() {
        return createDataSourceMap(dataSourcePropertiesMap);
    }

    /**
     * 执行SQL语句获得数据源配置
      * @param statement 语句
     * @return
     * @throws SQLException
     */
    @Override
    protected Map<String, DataSourceProperty> executeStmt(Statement statement) throws SQLException {
        // TODO load jdbc logic...
        return null;
    }
}
