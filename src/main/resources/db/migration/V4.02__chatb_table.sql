DROP TABLE if EXISTS original_language, thread;

DROP SEQUENCE if EXISTS chatd.thread_id;

CREATE TABLE if NOT EXISTS chatd.original_language
(
    lang VARCHAR (30) PRIMARY KEY
);

CREATE SEQUENCE chatd.thread_id;

CREATE TABLE if NOT EXISTS chatd.thread (
    thread_id INTEGER PRIMARY KEY
    , thred_title VARCHAR (100) NOT NULL
    , title_lang VARCHAR (30) NOT NULL REFERENCES chatd.original_language (lang)
    , comment VARCHAR(2048) NOT NULL
    , comment_lang VARCHAR(30) NOT NULL REFERENCES chatd.original_language (lang)
    , created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);