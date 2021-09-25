INSERT INTO chat.thread (thread_id, created_at)
VALUES
((SELECT nextval('chat.thread_id')), CURRENT_DATE - 8);

INSERT INTO chat.thread_theme (thread_theme_id, thread_id, title, title_owner, created_at)
VALUES
    ((SELECT NEXTVAL('chat.thread_theme_id')), (SELECT CURRVAL('chat.thread_id')), '日本一美味しいお味噌汁の具材を決定しよう', 'Alice', CURRENT_DATE - 8);
;

INSERT INTO chat.response (response_id, thread_id, response_order, response_owner, created_at)
VALUES
((SELECT NEXTVAL('chat.response_id')), (SELECT CURRVAL('chat.thread_id')), 1, 'Bob', CURRENT_DATE - 8),
((SELECT NEXTVAL('chat.response_id')), (SELECT CURRVAL('chat.thread_id')), 2, 'Carol', CURRENT_DATE - 7),
((SELECT NEXTVAL('chat.response_id')), (SELECT CURRVAL('chat.thread_id')), 3, 'Dave', CURRENT_DATE - 6),
((SELECT NEXTVAL('chat.response_id')), (SELECT CURRVAL('chat.thread_id')), 4, 'Eve', CURRENT_DATE - 5),
((SELECT NEXTVAL('chat.response_id')), (SELECT CURRVAL('chat.thread_id')), 5, 'Bob', CURRENT_DATE - 5),
((SELECT NEXTVAL('chat.response_id')), (SELECT CURRVAL('chat.thread_id')), 6, 'Carol', CURRENT_DATE - 4)
;

INSERT INTO chat.original_message (original_message_id, response_id, original_message, created_at)
VALUES
    ('2af6-f9e1-4a31-8c2e-a7c0', 1, '本文1', CURRENT_DATE - 8),
    ('2ef7-9f1c-4762-824a-0aaa', 2, 'dummy text2', CURRENT_DATE - 7),
    ('e54e-4b10-485e-8389-5459', 3, '虚拟文本3', CURRENT_DATE - 6),
    ('3f40-b10b-42fa-97b8-e0d6', 4, '仮文章4', CURRENT_DATE - 5),
    ('f868-7121-4de5-aa84-e537', 5, 'dummy text5', CURRENT_DATE - 5),
    ('bf34-c111-4d60-a9cb-e657', 6, '仮文章6', CURRENT_DATE - 4)
;
