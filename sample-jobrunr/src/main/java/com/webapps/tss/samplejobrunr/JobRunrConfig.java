package com.webapps.tss.samplejobrunr;

import org.jobrunr.jobs.mappers.JobMapper;
import org.jobrunr.storage.StorageProvider;
import org.jobrunr.storage.sql.h2.H2StorageProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class JobRunrConfig {

    private final DataSource dataSource;

    public JobRunrConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public StorageProvider storageProvider(JobMapper jobMapper) {
        // Create a H2 storage provider, mas pode ser qualquer outro.
        // podemos usar injecao de dependencia para o dataSource
        final StorageProvider storageProvider = new H2StorageProvider(dataSource);
        storageProvider.setJobMapper(jobMapper);
        return storageProvider;
    }
}
