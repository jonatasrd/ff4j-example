package com.example.demo.com.example.demo.config

import org.ff4j.FF4j
import org.ff4j.springjdbc.store.EventRepositorySpringJdbc
import org.ff4j.springjdbc.store.FeatureStoreSpringJdbc
import org.ff4j.springjdbc.store.PropertyStoreSpringJdbc
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.transaction.annotation.Transactional
import javax.sql.DataSource


@Configuration
class FF4JConfig {

    @Autowired
    lateinit var dataSource: DataSource

    val fF4j: FF4j
        @Bean
        get() = FF4j().apply {
            this.setFeatureStore(FeatureStoreSpringJdbc(dataSource))
            this.setPropertiesStore(PropertyStoreSpringJdbc(dataSource))
            this.setEventRepository(EventRepositorySpringJdbc(dataSource))
        }


}