drop table if exists;
drop SEQUENCE if EXISTS thread_id;
drop SEQUENCE if EXISTS response_id;
drop schema if exists chat CASCADE ;
create schema chat;

CREATE table if not EXISTS chat.original
(
    original_id VARCHAR (24) PRIMARY KEY

)
CREATE TABLE IF NOT EXISTS `product_menbers` (