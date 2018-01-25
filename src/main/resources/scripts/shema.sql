-- Таблица книг
CREATE TABLE book (
  id          INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY
  COMMENT 'Идентификатор книги',
  shelf_id    INT UNSIGNED
  COMMENT 'Идентификатор полки',
  user_id     INT UNSIGNED NOT NULL
  COMMENT 'Идентификатор пользователя',
  file_path   VARCHAR(255) NOT NULL
  COMMENT 'Путь сохранения книги',
  name        VARCHAR(255) NOT NULL
  COMMENT 'Название книги',
  author      VARCHAR(255) NOT NULL
  COMMENT 'Автор книги',
  description VARCHAR(1000)
  COMMENT 'Описание книги',
  isbn        NUMERIC(13)  NOT NULL
  COMMENT 'ISBN книги'
);
-- Таблица полок
CREATE TABLE shelf (
  id          INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY
  COMMENT 'Идентификатор полки',
  name        VARCHAR(255) NOT NULL
  COMMENT 'Название полки',
  describtion VARCHAR(255) NOT NULL
  COMMENT 'Описание полки'
);
-- Таблица пользователей
CREATE TABLE user (
  id       INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY
  COMMENT 'Идентификатор пользователя',
  email    VARCHAR(255) NOT NULL UNIQUE
  COMMENT 'email пользователя',
  password VARCHAR(255) NOT NULL
  COMMENT 'Пароль пользователя',
  active   BOOLEAN      NOT NULL DEFAULT FALSE
  COMMENT 'Статус регистрации'
);

CREATE TABLE page (
  book_id INT UNSIGNED NOT NULL
  COMMENT 'Идентификатор книги',
  number  INT UNSIGNED NOT NULL
  COMMENT 'Номер страницы',
  content LONGTEXT     NOT NULL
  COMMENT 'Содержимое страницы',
  current INT UNSIGNED NOT NULL
  COMMENT 'Текущая страница'
);

CREATE TABLE access_rights (
  book_id     INT UNSIGNED NOT NULL
  COMMENT 'Идентификатор книги',
  user_id     INT UNSIGNED NOT NULL
  COMMENT 'Идентификатор пользователя',
  acrive_date DATE         NOT NULL
  COMMENT 'Дата окончания действия права достпуа к книге'
);

CREATE TABLE user_activation (
  user_id     INT UNSIGNED NOT NULL
  COMMENT 'Идентификатор пользователя',
  hash        VARCHAR(255) NOT NULL
  COMMENT 'Строка активации пользователя',
  create_date DATE         NOT NULL
  COMMENT 'Дата создания учетной записи',
  active_date DATE         NOT NULL
  COMMENT 'Дата активации учетной записи'
);

CREATE TABLE access_request (
  id      INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY
  COMMENT 'Идентификатор запроса'
  book_id INT UNSIGNED NOT NULL
  COMMENT 'Идентификатор книги',
  user_id INT UNSIGNED NOT NULL
  COMMENT 'Идентификатор пользователя',
  massage VARCHAR(255)
  COMMENT 'Сообщение для запроса доступа'
);

CREATE TABLE notification (
  channel     ENUM ('EMAIL') NOT NULL
  COMMENT 'Канал для отправки сообщения',
  create_date DATE           NOT NULL
  COMMENT 'Дата отправки сообoения',
  active_date DATE           NOT NULL
  COMMENT 'Дата активации',
  adress      VARCHAR(255)   NOT NULL
  COMMENT 'Адресс электронной почты',
  massage     VARCHAR(255)   NOT NULL
  COMMENT 'Сообщение активации учетной записи'
);

CREATE TABLE access_response (
  request_id INT UNSIGNED NOT NULL
  COMMENT 'Идентификатор запроса',
  response_massage VARCHAR(255)
  COMMENT 'Ответное сообщение',
  approved BOOLEAN NOT NULL
  COMMENT 'Статус одобрения'
);

CREATE INDEX ix_book_id
  ON book (id);

CREATE INDEX ix_book_name
  ON book (name);

CREATE INDEX ix_book_isbn
  ON book (isbn);

CREATE INDEX ix_user_id
  ON user (id);

CREATE INDEX ix_user_email
  ON user (email);

CREATE INDEX ix_shelf_id
  ON shelf (id);

CREATE INDEX ix_shelf_name
  ON shelf (name);

ALTER TABLE book
  ADD FOREIGN KEY (shelf_id) REFERENCES shelf (id)
  ON DELETE CASCADE
  ON UPDATE CASCADE;
ALTER TABLE book
  ADD FOREIGN KEY (user_id) REFERENCES USER (id)
  ON DELETE CASCADE
  ON UPDATE CASCADE;
