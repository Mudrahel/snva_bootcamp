-- keep info about register users
INSERT INTO users (username, password, email, address, mobile_no, tech_interest)
VALUES
    ('greg', '1234', 'user@example.com', '123 Main St', '1234567890', 'Programming');

-- keeps quiz topics
INSERT INTO topics (topic)
VALUES ('Java'),('Python'),('.Net');

-- question data and topic allegiance
INSERT INTO q_data (question, score, topic_id) VALUES
    ('Which of the following are part of the Java Collection Framework?', 2, 1),
    ('Which of the following collections guarantees the order of elements?', 2, 1),
    ('Which of the following are concurrent collections in Java?', 2, 1),
    ('Which collection class allows duplicate elements?', 2, 1),
    ('What is the difference between HashMap and HashSet?', 2, 1);

-- answer options
INSERT INTO q_option (q_option) VALUES
    ('Arrays'),
    ('ArrayList'),
    ('HashMap'),
    ('String'),

	('LinkedList'),
    ('HashMap'),
    ('LinkedHashSet'),
    ('ArrayList'),

	('ArrayList'),
    ('CopyOnWriteArrayList'),
    ('HashSet'),
    ('ConcurrentHashMap'),

	('HashSet'),
    ('TreeSet'),
    ('ArrayList'),
    ('LinkedHashSet'),

	('HashMap allows null elements'),
    ('HashSet is sorted'),
    ('HashSet allows duplicates'),
    ('HashSet doesn\'t allow duplicates');

-- connection between questions and answer options
INSERT INTO q_data_option (question_id, option_id) VALUES
    (1, 1),
    (1, 2),
    (1, 3),
    (1, 4),
    (2, 5),
    (2, 6),
    (2, 7),
    (2, 8),
    (3, 9),
    (3, 10),
    (3, 11),
    (3, 12),
    (4, 13),
    (4, 14),
    (4, 15),
    (4, 16),
    (5, 17),
    (5, 18),
    (5, 19),
    (5, 20);

-- connection between questions an correct answers
INSERT INTO q_data_answers (question_id, option_id) VALUES
    (1, 2),
    (1, 3),
    (2, 5),
    (2, 7),
    (2, 8),
    (3, 10),
    (3, 12),
    (4, 15),
    (5, 17),
    (5, 20);