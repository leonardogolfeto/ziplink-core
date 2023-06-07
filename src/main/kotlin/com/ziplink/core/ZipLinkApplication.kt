package com.ziplink.core

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories("com.ziplink.core.repository")
@EntityScan("com.ziplink.core.entity")
class ZipLinkApplication

fun main(args: Array<String>) {
    runApplication<ZipLinkApplication>(*args)
}
