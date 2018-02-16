# Bookshelf

## Краткое описание

Сервис для работы с книжной полкой. Реализована регистрация и авторизация пользователя. На данный момент можно просмотреть книги, полки, пользователей. Залить книгу.

## Начало работы
Для управления базой данных импользуется MySQL. Базу данных "bookshelf" нужно создать отдельно в MySQL Workbench. При возникновении проблемы с временной зоной, нужно вручную запустить set_time_zone.sql

Запуск сервиса:

```shell
mvn spring-boot:run
http://localhost:8080/
http://localhost:8080/book
http://localhost:8080/shelf
```

При нажатии кнопок происходит вывод соответствующей информации.

## Разработка

Чтобы продолжить разрабатывать данный проект:

```shell
git clone https://github.com/pauzholis/BookShelf
cd BookShelf/
```