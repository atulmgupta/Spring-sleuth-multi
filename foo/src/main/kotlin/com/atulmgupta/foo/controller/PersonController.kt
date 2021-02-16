package com.atulmgupta.foo.controller

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate
import java.util.concurrent.atomic.AtomicLong

@RequestMapping(value = ["/foo"])
@RestController
class PersonController {
    @Autowired
    private lateinit var restTemplate: RestTemplate
    private val log: Logger = LoggerFactory.getLogger(PersonController::class.java)
    val counter = AtomicLong()

    @GetMapping(value = ["/test"])
    fun test(): String {
        log.info("Bar service called")
        try {
            var result: ResponseEntity<String?>? =
                restTemplate.getForEntity<String>("http://localhost:8084/grpc/test", String::class.java)
            log.info("Foo Service Respose ${result}")
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return "Service is running @ " + System.currentTimeMillis()
    }

}