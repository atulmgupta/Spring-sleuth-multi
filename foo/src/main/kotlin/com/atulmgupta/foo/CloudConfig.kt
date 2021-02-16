package com.atulmgupta.foo

import brave.sampler.Sampler
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate

@Configuration
class CloudConfig {
    private val log: Logger = LoggerFactory.getLogger(CloudConfig::class.java)

    @Bean
    fun defaultSampler(): Sampler? {
        return Sampler.ALWAYS_SAMPLE
    }

    @Bean
    fun restTemplate(): RestTemplate? {
        return RestTemplate()
    }
}