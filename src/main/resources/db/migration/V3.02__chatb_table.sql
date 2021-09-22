DROP TABLE if EXISTS original_language, comment, thread;

DROP SEQUENCE if EXISTS chatc.thread_id;

CREATE TABLE if NOT EXISTS chatc.original_language
(
    lang VARCHAR (30) PRIMARY KEY
);

CREATE SEQUENCE chatc.thread_id;

CREATE TABLE if NOT EXISTS chatc.thread (
    thread_id INTEGER PRIMARY KEY
    , title VARCHAR (100) NOT NULL
    , lang VARCHAR (30) NOT NULL REFERENCES chatc.original_language (lang)
    , created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
    );

CREATE TABLE if NOT EXISTS chatc.comment
(
    comment_id VARCHAR (24) PRIMARY KEY
    , thread_id INTEGER REFERENCES chatc.thread (thread_id)
    , message VARCHAR(2048) NOT NULL
    , lang VARCHAR(30) NOT NULL REFERENCES chatc.original_language
    , created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);
