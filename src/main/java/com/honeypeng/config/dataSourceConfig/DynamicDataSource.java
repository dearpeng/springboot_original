package com.honeypeng.config.dataSourceConfig;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * Created by PengWX on 2020/11/25.
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceHolder.getDataSource();
    }
}
