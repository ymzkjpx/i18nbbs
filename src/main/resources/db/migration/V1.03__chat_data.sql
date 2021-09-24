INSERT INTO chat.thread (thread_id)
VALUES
((SELECT nextval('chat.thread_id'))) ;

INSERT INTO chat.thread_theme (thread_theme_id, thread_id, title, title_owner)
VALUES
    ((SELECT NEXTVAL('chat.thread_theme_id')), (SELECT CURRVAL('chat.thread_id')), 'スレッドのお題', 'スレッドの設立者名')
;

INSERT INTO chat.response (response_id, thread_id, response_order, response_owner)
VALUES
((SELECT NEXTVAL('chat.response_id')), (SELECT CURRVAL('chat.thread_id')), 1, 'Bob'),
((SELECT NEXTVAL('chat.response_id')), (SELECT CURRVAL('chat.thread_id')), 2, 'Carol'),
((SELECT NEXTVAL('chat.response_id')), (SELECT CURRVAL('chat.thread_id')), 3, 'Dave'),
((SELECT NEXTVAL('chat.response_id')), (SELECT CURRVAL('chat.thread_id')), 4, 'Eve'),
((SELECT NEXTVAL('chat.response_id')), (SELECT CURRVAL('chat.thread_id')), 5, 'Bob'),
((SELECT NEXTVAL('chat.response_id')), (SELECT CURRVAL('chat.thread_id')), 6, 'Carol')
;

INSERT INTO chat.original_message (original_message_id, response_id, original_message)
VALUES
    ('2af6-f9e1-4a31-8c2e-a7c0', 1, '本文1'),
    ('2ef7-9f1c-4762-824a-0aaa', 1, 'dummy text2'),
    ('e54e-4b10-485e-8389-5459', 1, '虚拟文本3'),
    ('3f40-b10b-42fa-97b8-e0d6', 1, '仮文章4'),
    ('f868-7121-4de5-aa84-e537', 1, 'dummy text5'),
    ('bf34-c111-4d60-a9cb-e657', 1, '仮文章6'),
    ('82a4-19a1-46cb-b697-2c3a', 1, '虚拟文本7'),
    ('789f-f427-47f8-8f3f-26d9', 1, 'dummy text8'),
    ('d98b-2395-4764-8490-2d85', 1, '仮文章9'),
    ('3e8c-0be8-4743-aca3-f322', 1, '仮文章10')
;
