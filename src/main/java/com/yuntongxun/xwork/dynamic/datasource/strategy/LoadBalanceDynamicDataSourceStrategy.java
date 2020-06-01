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
package com.yuntongxun.xwork.dynamic.datasource.strategy;

import org.springframework.core.NamedThreadLocal;

import javax.sql.DataSource;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * LoadBalance strategy to switch a database
 * @author liugang
 */
public class LoadBalanceDynamicDataSourceStrategy implements DynamicDataSourceStrategy {

    /**
     *  负载均衡计数器
     *  轮询
      */
    private final ThreadLocal<AtomicLong> atomicPositiveInteger = new NamedThreadLocal<AtomicLong>("LoadBalance-Dynamic") {
        @Override
        protected AtomicLong initialValue() {
            return new AtomicLong(0);
        };
    };

    @Override
    public DataSource determineDataSource(List<DataSource> dataSources) {
        return dataSources.get((int)Math.abs(atomicPositiveInteger.get().addAndGet(1L) % dataSources.size()));
    }
}
