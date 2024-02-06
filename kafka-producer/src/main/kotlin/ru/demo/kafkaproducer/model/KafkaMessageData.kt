package ru.demo.kafkaproducer.model

data class KafkaMessageData(
    val topic: String,
    val key: String?,
    val message: String,
)