package com.sam.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by samchu on 2016/12/6.
 */

@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories
@EnableJpaAuditing
public class PersistenceConfig {
}
