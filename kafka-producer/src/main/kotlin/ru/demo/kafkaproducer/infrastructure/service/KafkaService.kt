package ru.demo.kafkaproducer.infrastructure.service

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.support.SendResult
import org.springframework.stereotype.Service
import ru.demo.kafkaproducer.model.KafkaMessageData
import java.util.concurrent.CompletableFuture

@Service
class KafkaService(
    private val kafkaTemplate: KafkaTemplate<String, String>,
) {

    private val logger: Logger = LoggerFactory.getLogger(KafkaService::class.java)

    fun sendMessage(data: KafkaMessageData) {
        if (data.key == null) {
            val future: CompletableFuture<SendResult<String, String>> = kafkaTemplate.send(data.topic, data.message)
            onSend(future, data.message)
        } else {
            val future: CompletableFuture<SendResult<String, String>> = kafkaTemplate.send(data.topic, data.key, data.message)
            onSend(future, data.message)
        }
    }

    private fun onSend(future: CompletableFuture<SendResult<String, String>>, msg: String) {
        future.whenComplete{ result, ex ->
            if (ex == null) {
                logger.atInfo().log("Successfully sent message=[$msg] with offset=[${result.recordMetadata.offset()}]")
            } else {
                logger.atError().log("Unable to send message=[$msg] due to: ${ex.message}")
            }
        }

    }

}