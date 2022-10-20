package com.lazyboyprod

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.multipart.support.StandardServletMultipartResolver


@SpringBootApplication
@Configuration
class SpringKotlinExcelUploaderApplication {
//	@Bean
//	fun multipartResolver(): StandardServletMultipartResolver? {
//		return StandardServletMultipartResolver()
//	}
}

fun main(args: Array<String>) {
	runApplication<SpringKotlinExcelUploaderApplication>(*args)
}


