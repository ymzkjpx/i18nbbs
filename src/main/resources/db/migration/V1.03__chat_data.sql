INSERT INTO chat.original_message (id, message, lang)
VALUES
('2af6-f9e1-4a31-8c2e-a7c0', 'ダミースレッド1のスレッドタイトル本文', 'JAPANESE'),
('2ef7-9f1c-4762-824a-0aaa', 'dummy text2', 'ENGLISH'),
('e54e-4b10-485e-8389-5459', '虚拟文本3', 'CHINESE'),
('3f40-b10b-42fa-97b8-e0d6', '仮文章4', 'JAPANESE'),
('f868-7121-4de5-aa84-e537', 'dummy text5', 'ENGLISH'),
('bf34-c111-4d60-a9cb-e657', '仮文章6', 'CHINESE'),
('82a4-19a1-46cb-b697-2c3a', '虚拟文本7', 'JAPANESE'),
('789f-f427-47f8-8f3f-26d9', 'dummy text8', 'ENGLISH'),
('d98b-2395-4764-8490-2d85', '仮文章9', 'JAPANESE'),
('3e8c-0be8-4743-aca3-f322', '仮文章10', 'JAPANESE')
;

INSERT INTO chat.thread (thread_id)
VALUES
((SELECT nextval('chat.thread_id'))) ;

INSERT INTO chat.threti (threti_id, thread_id, title, lang)
VALUES
    ((SELECT NEXTVAL('chat.threti_id')), (SELECT CURRVAL('chat.thread_id')), 'ダミースレッドタイトル1', 'JAPANESE')
;

INSERT INTO chat.response (response_id, original_message_id, thread_id, threti_id)
VALUES
((SELECT NEXTVAL('chat.response_id')), '2af6-f9e1-4a31-8c2e-a7c0', (SELECT CURRVAL('chat.thread_id')), (SELECT CURRVAL('chat.threti_id')))
  ,((SELECT NEXTVAL('chat.response_id')), '2ef7-9f1c-4762-824a-0aaa', (SELECT CURRVAL('chat.thread_id')), (SELECT CURRVAL('chat.threti_id')))
  ,((SELECT NEXTVAL('chat.response_id')), 'e54e-4b10-485e-8389-5459', (SELECT CURRVAL('chat.thread_id')), (SELECT CURRVAL('chat.threti_id')))
  ,((SELECT NEXTVAL('chat.response_id')), '3f40-b10b-42fa-97b8-e0d6', (SELECT CURRVAL('chat.thread_id')), (SELECT CURRVAL('chat.threti_id')))
  ,((SELECT NEXTVAL('chat.response_id')), 'f868-7121-4de5-aa84-e537', (SELECT CURRVAL('chat.thread_id')), (SELECT CURRVAL('chat.threti_id')))
  ,((SELECT NEXTVAL('chat.response_id')), 'bf34-c111-4d60-a9cb-e657', (SELECT CURRVAL('chat.thread_id')), (SELECT CURRVAL('chat.threti_id')))
;
