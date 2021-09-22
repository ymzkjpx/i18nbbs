DROP TABLE if EXISTS original_language, comment, thread, response;

DROP SEQUENCE if EXISTS chatb.thread_id;
DROP SEQUENCE if EXISTS chatb.response_id;

CREATE TABLE if NOT EXISTS chatb.original_language
(
    lang VARCHAR (30) PRIMARY KEY
);

CREATE SEQUENCE chatb.thread_id;
CREATE SEQUENCE chatb.response_id;

CREATE TABLE if NOT EXISTS chatb.comment
(
    comment_id VARCHAR (24) PRIMARY KEY
    , message VARCHAR(2048) NOT NULL
    , lang VARCHAR(30) NOT NULL REFERENCES chatb.original_language
    , created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE if NOT EXISTS chatb.thread
(
    thread_id INTEGER PRIMARY KEY
    , title VARCHAR (100) NOT NULL
    , lang VARCHAR (30) NOT NULL REFERENCES chatb.original_language (lang)
    , created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE if NOT EXISTS chatb.response
(
    response_id INTEGER PRIMARY KEY
    , comment_id VARCHAR (24) REFERENCES chatb.comment
    , thread_id INTEGER REFERENCES chatb.thread (thread_id)
    , created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);
