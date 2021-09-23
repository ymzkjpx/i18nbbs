DROP TABLE if EXISTS original_language, original_message, thread, thread_title, response;
DROP SEQUENCE if EXISTS chat.thread_id;
DROP SEQUENCE if EXISTS chat.response_id;
DROP SEQUENCE if EXISTS chat.thread_title_id;
DROP SCHEMA if EXISTS chat CASCADE;
CREATE SCHEMA chat;

CREATE SEQUENCE chat.thread_id;
CREATE SEQUENCE chat.response_id;
create SEQUENCE chat.thread_title_id;

CREATE TABLE if NOT EXISTS chat.original_message
(
    id VARCHAR (24) PRIMARY KEY
    , message VARCHAR(2048) NOT NULL
    , created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE if NOT EXISTS chat.thread
(
    thread_id INTEGER PRIMARY KEY
    , created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE table if NOT EXISTS chat.thread_title
(
    thread_title_id INTEGER PRIMARY KEY
    , thread_id INTEGER REFERENCES chat.thread (thread_id)
    , title varchar(100) NOT NULL
    , created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE if NOT EXISTS chat.response
(
    response_id INTEGER PRIMARY KEY
    , original_message_id VARCHAR (24) REFERENCES chat.original_message
    , thread_id INTEGER REFERENCES chat.thread (thread_id)
    , thread_title_id INTEGER REFERENCES chat.thread_title (thread_title_id)
    , created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);
