package com.contoso.keyvault.secrets

import com.fasterxml.jackson.databind.ObjectMapper
import io.dapr.client.DaprClientBuilder

class SecretClient {

    private val SECRET_STORE_NAME = "kotlinkv"

    /**
     * JSON Serializer to print output.
     */
    private val JSON_SERIALIZER = ObjectMapper()


    /**
     * Client to read a secret.
     *
     * @param args Unused arguments.
     */
    @Throws
    fun secret(args: Array<String>) {
        require(args.size == 1) { "Use one argument: secret's key to be retrieved." }
        val secretKey = args[0]
        DaprClientBuilder().build().use { client ->
            var secret = client.getSecret(SECRET_STORE_NAME, secretKey).block()
            println(JSON_SERIALIZER.writeValueAsString(secret))
            try {
                secret = client.getSecret(SECRET_STORE_NAME, "connectionStringtest").block()
                println(JSON_SERIALIZER.writeValueAsString(secret))
            } catch (ex: Exception) {
                println(ex.message)
            }
        }
    }
}