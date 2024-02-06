package ru.demo.kafkaconsumer.infrastructure.service

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class KafkaConsumerService {

    private val logger: Logger = LoggerFactory.getLogger(KafkaConsumerService::class.java)

    @KafkaListener(topics = ["baeldung"], groupId = "kafka-consumers")
    fun listenGroupFoo(message: String) {
        logger.atInfo().log("Received Message in group kafka-consumers: $message")
    }
}