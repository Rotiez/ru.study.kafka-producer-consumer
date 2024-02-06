package ru.demo.kafkaproducer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KafkaProducerApplication

fun main(args: Array<String>) {
	runApplication<KafkaProducerApplication>(*args)
}
