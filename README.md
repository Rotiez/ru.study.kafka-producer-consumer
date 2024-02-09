# Kafka-producer-consumer
Проект с рективными сервисами kafka-producer и kafka-consumer для записи и чтения сообщений из Kafka топика.

Для запуска двух контейнеров *kafka-producer* и *kafka-consumer*
используйте команду `docker-compose up`.

Docker Compose запустит сервисы *kafka-producer* и *kafka-consumer*, описанные в нем, на портах
`8081` и `8082` соответственно.

Для конфигурации *bootstrap-servers* используйте переменную окружения `KAFKA_BOOTSTRAP_SERVERS`
(По умолчанию сервисы настроены на локальную Kafka, запущеннную в контейнере, 
адрес которой `host.docker.internal:29092`).

С инструкцией как запустить Kafka и Zookeeper локально в контейнерах при помощи docker-compose 
можно ознакомиться по ссылке [kafka-stack-docker-compose](https://github.com/conduktor/kafka-stack-docker-compose).

Каждый сервис логирует сообщения в консоль при отправке или получении сообщений из топика.
По умолчанию *kafka-producer* создает топик `rotiez-topic`, а *kafka-consumer* подписывается на этот топик. 
Для изменения стандартного топика используйте переменную окружения `KAFKA_DEFAULT_TOPIC` для каждого сервиса.

Отправка сообщений в топик происходит через сервис *kafka-producer* с помощью _REST API_, 
c документацией для каждого сервиса можно ознакомиться по
эндпоинту `/swagger-ui.html`. 
- `localhost:8081/swagger-ui.html` для сервиса *kafka-producer*
- `localhost:8082/swagger-ui.html` для сервиса *kafka-consumer*