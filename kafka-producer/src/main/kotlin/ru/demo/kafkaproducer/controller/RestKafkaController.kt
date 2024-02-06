package ru.demo.kafkaproducer.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.demo.kafkaproducer.infrastructure.service.KafkaService
import ru.demo.kafkaproducer.model.KafkaMessageData

@RestController
@RequestMapping("/kafka")
class RestKafkaController(
    private val kafkaService: KafkaService,
) {

    @PostMapping("/send")
    fun sendMessage(@RequestBody data: KafkaMessageData) {
        kafkaService.sendMessage(data)
    }
}