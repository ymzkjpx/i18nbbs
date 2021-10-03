DROP TABLE IF EXISTS thread, thread_theme, response, original_message;
DROP SCHEMA IF EXISTS chat CASCADE;
CREATE SCHEMA chat;

DROP SEQUENCE IF EXISTS chat.thread_id;
CREATE SEQUENCE chat.thread_id;
CREATE TABLE IF NOT EXISTS chat.thread
(
    thread_id INTEGER PRIMARY KEY ,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

DROP SEQUENCE IF EXISTS chat.thread_theme_id;
CREATE SEQUENCE chat.thread_theme_id;
CREATE TABLE IF NOT EXISTS chat.thread_theme
(
    thread_theme_id INTEGER PRIMARY KEY ,
    thread_id INTEGER REFERENCES chat.thread (thread_id) ,
    title VARCHAR(100) NOT NULL ,
    title_owner VARCHAR(60) NOT NULL ,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS chat.response
(
    response_id CHAR(36) PRIMARY KEY ,
    thread_id INTEGER REFERENCES chat.thread (thread_id) ,
    response_owner VARCHAR(60) NOT NULL ,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS chat.original_message
(
    original_message_id VARCHAR(24) PRIMARY KEY ,
    response_id CHAR(36) REFERENCES chat.response (response_id) ,
    original_message VARCHAR(1000) NOT NULL ,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);
