DROP TABLE if EXISTS original_language, original_message;
DROP SEQUENCE if EXISTS thread_id;
DROP SEQUENCE if EXISTS response_id;
DROP SCHEMA if EXISTS chat CASCADE;
CREATE SCHEMA chat;

CREATE TABLE if NOT EXISTS chat.original_language
(
    lang VARCHAR (30) PRIMARY KEY
);

CREATE SEQUENCE thread_id;
CREATE SEQUENCE response_id;
create SEQUENCE threti_id;

CREATE TABLE if NOT EXISTS chat.original_message
(
    id VARCHAR (24) PRIMARY KEY
    , message VARCHAR(2048) NOT NULL
    , lang VARCHAR(30) NOT NULL REFERENCES chat.original_language
    , created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE if NOT EXISTS chat.thread
(
    thread_id INTEGER PRIMARY KEY
    , created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE table if NOT EXISTS chat.threti
(
    threti_id INTEGER PRIMARY KEY
    , thread_id INTEGER REFERENCES chat.thread
    , title varchar(100) NOT NULL
    , lang VARCHAR (30) NOT NULL REFERENCES chat.original_language
    , created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE if NOT EXISTS chat.response
(
    response_id INTEGER PRIMARY KEY
    , origina_message_id VARCHAR (24) REFERENCES chat.original_message
    , thread_id INTEGER REFERENCES chat.thread
    , threti_id INTEGER REFERENCES chat.threti
    , created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
