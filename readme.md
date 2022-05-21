[![Build Status](https://app.travis-ci.com/velesov7493/job4j_discovery.svg?branch=master)](https://app.travis-ci.com/velesov7493/job4j_discovery)
## Описание ##
Демо проект.
Сервер и клиент Spring Discovery (Эврика).
Пример технологии Client Side Discovery.
#### Сервер ####
+ Регистрирует клиентов при обращении. 
+ Хранит и управляет регистром клиентов (сведениями о расположении клиентов системы).
#### Клиент ####
+ Регистрируется на сервере. 
+ Получает от сервера сведения о расположении клиентов системы.
+ Может отправить сообщение любому клиенту.
+ Может получить и сохранить сообщения от других клиентов.
#### Описание запросов к клиенту ####
+ Список имен всех клиентов системы:
```
curl --location --request GET 'АДРЕС_КЛИЕНТА:ПОРТ_КЛИЕНТА/services'
``` 
+ Отправить сообщение другому клиенту:
```
curl --location --request POST 'localhost:8081/messages/send/ИМЯ_КЛИЕНТА_ПОЛУЧАТЕЛЯ' \
--header 'Content-Type: application/json' \
--data-raw '{
    "message": "ТЕКСТ_СООБЩЕНИЯ"    
}'
```
+ Получить все сообщения клиента:
```
curl --location --request GET 'АДРЕС_КЛИЕНТА:ПОРТ_КЛИЕНТА/messages'
```
+ Получить полные сведения о другом клиенте системы:
```
curl --location --request GET 'АДРЕС_КЛИЕНТА:ПОРТ_КЛИЕНТА/services/ИМЯ_ДРУГОГО_КЛИЕНТА'
```
#### Технологии проекта ####
![badge](https://img.shields.io/badge/Java-14-green)
![badge](https://img.shields.io/badge/Maven-3.6-green)
![badge](https://img.shields.io/badge/SpringBot-2.5-yellow)