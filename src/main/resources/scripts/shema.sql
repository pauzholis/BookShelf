-- Таблица книг
CREATE TABLE book (
  id          INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY
  COMMENT 'Идентификатор книги',
  shelf_id    INT UNSIGNED
  COMMENT 'Идентификатор полки',
  user_id     INT UNSIGNED NOT NULL
  COMMENT 'Идентификатор пользователя дающего доступ',
  file_path   VARCHAR(255) NOT NULL
  COMMENT 'Путь сохранения книги',
  name        VARCHAR(255) NOT NULL
  COMMENT 'Название книги',
  author      VARCHAR(255) NOT NULL
  COMMENT 'Автор книги',
  description LONGTEXT
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
  description LONGTEXT NOT NULL
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
  id      INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY
  COMMENT 'Идентификатор страницы',
  book_id INT UNSIGNED NOT NULL
  COMMENT 'Идентификатор книги',
  number  INT UNSIGNED NOT NULL
  COMMENT 'Номер страницы',
  content LONGTEXT     NOT NULL
  COMMENT 'Содержимое страницы'
);

CREATE TABLE current_page (
  user_id INT UNSIGNED UNIQUE NOT NULL
  COMMENT 'Идентификатор пользователя',
  page_id INT UNSIGNED UNIQUE NOT NULL
  COMMENT 'Идентификатор страницы текущей страницы'
);

CREATE TABLE access_rights (
  book_id     INT UNSIGNED NOT NULL UNIQUE
  COMMENT 'Идентификатор книги',
  user_id     INT UNSIGNED NOT NULL UNIQUE
  COMMENT 'Идентификатор пользователя',
  active_date DATE         NOT NULL
  COMMENT 'Дата окончания действия права доступа к книге'
);

CREATE TABLE user_activation (
  user_id     INT UNSIGNED NOT NULL
  COMMENT 'Идентификатор пользователя',
  hash        VARCHAR(255) NOT NULL
  COMMENT 'Строка активации пользователя',
  create_date DATE         NOT NULL
  COMMENT 'Дата создания строки активации',
  active_date DATE
  COMMENT 'Дата активации учетной записи'
);

CREATE TABLE access_request (
  id      INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY
  COMMENT 'Идентификатор запроса',
  book_id INT UNSIGNED NOT NULL
  COMMENT 'Идентификатор книги',
  user_id INT UNSIGNED NOT NULL
  COMMENT 'Идентификатор пользователя',
  massage VARCHAR(255)
  COMMENT 'Сообщение для запроса доступа'
);

CREATE TABLE notification (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY
  COMMENT 'Идентификатор сообщения',
  channel     ENUM ('EMAIL')
  COMMENT 'Канал для отправки сообщения',
  create_date DATE
  COMMENT 'Дата отправки сообщения',
  adress      VARCHAR(255)
  COMMENT 'Адресс электронной почты',
  massage     VARCHAR(255)
  COMMENT 'Сообщение активации учетной записи'
);

CREATE TABLE access_response (
  request_id       INT UNSIGNED NOT NULL
  COMMENT 'Идентификатор запроса',
  response_massage VARCHAR(255)
  COMMENT 'Ответное сообщение',
  approved         BOOLEAN      NOT NULL
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
ALTER TABLE page
  ADD FOREIGN KEY (book_id) REFERENCES book (id)
  ON DELETE CASCADE
  ON UPDATE CASCADE;
ALTER TABLE book
  ADD FOREIGN KEY (shelf_id) REFERENCES shelf (id)
  ON DELETE CASCADE
  ON UPDATE CASCADE;
ALTER TABLE access_rights
  ADD FOREIGN KEY (book_id) REFERENCES book (id)
  ON DELETE CASCADE
  ON UPDATE CASCADE;
ALTER TABLE access_rights
  ADD FOREIGN KEY (user_id) REFERENCES user (id)
  ON DELETE CASCADE
  ON UPDATE CASCADE;
ALTER TABLE user_activation
  ADD FOREIGN KEY (user_id) REFERENCES user (id)
  ON DELETE CASCADE
  ON UPDATE CASCADE;
ALTER TABLE access_request
  ADD FOREIGN KEY (book_id) REFERENCES book (id)
  ON DELETE CASCADE
  ON UPDATE CASCADE;
ALTER TABLE access_request
  ADD FOREIGN KEY (user_id) REFERENCES user (id)
  ON DELETE CASCADE
  ON UPDATE CASCADE;
ALTER TABLE access_response
  ADD FOREIGN KEY (request_id) REFERENCES access_request (id)
  ON DELETE CASCADE
  ON UPDATE CASCADE;
ALTER TABLE current_page
  ADD FOREIGN KEY (user_id) REFERENCES user (id)
  ON DELETE CASCADE
  ON UPDATE CASCADE;
ALTER TABLE current_page
  ADD FOREIGN KEY (page_id) REFERENCES page (id)
  ON DELETE CASCADE
  ON UPDATE CASCADE;
