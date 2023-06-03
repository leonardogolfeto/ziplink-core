package com.ziplink.core

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ZipLinkApplication

fun main(args: Array<String>) {
	runApplication<ZipLinkApplication>(*args)
}
