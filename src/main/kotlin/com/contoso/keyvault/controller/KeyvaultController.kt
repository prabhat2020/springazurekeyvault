package com.contoso.keyvault.controller


import com.contoso.keyvault.secrets.SecretClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.env.Environment
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController


@RestController
class KeyvaultController(private val sec: SecretClient) {

   @Autowired
   lateinit var env : Environment



    @RequestMapping("/get", method = [RequestMethod.GET])
    fun get(): String? {

     //return connectionString
       return env.getProperty("cnnc")
    }

    @RequestMapping("/getDapr", method = [RequestMethod.GET])
    fun getFromDapr() {

        var arr = arrayOf("key1","key3")
        //return connectionString
        return sec.secret(arr)
    }

//    @Value("\${connectionStringtest}")
//  val connectionString:String? = null

//    @Throws(Exception::class)
//    fun run(vararg varl: String?) {
//        println(String.format("\nConnection String stored in Azure Key Vault:\n%s\n", connectionString))
//    }

}