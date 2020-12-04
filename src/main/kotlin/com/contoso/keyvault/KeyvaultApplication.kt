package com.contoso.keyvault

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KeyvaultApplication

fun main(args: Array<String>) {
	runApplication<KeyvaultApplication>(*args)
}
