-- keep info about registere users
CREATE TABLE users (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255),
    address VARCHAR(255),
    mobile_no CHAR(10),
    tech_interest VARCHAR(255)
);
INSERT INTO users (username, password, email, address, mobile_no, tech_interest)
VALUES
    ('example_user', 'secretpassword', 'user@example.com', '123 Main St', '1234567890', 'Programming');

-- keeps quiz topics
CREATE TABLE topics (
    id INT PRIMARY KEY AUTO_INCREMENT,
    topic VARCHAR(255) NOT NULL
);
INSERT INTO topics (topic)
VALUES ('Java'),('Python'),('.Net');

-- question data and topic allegiance
CREATE TABLE q_data (
    id INT PRIMARY KEY AUTO_INCREMENT,
    question VARCHAR(255) NOT NULL,
    score TINYINT UNSIGNED NOT NULL,
    topic_id INT NOT NULL,

    FOREIGN KEY (topic_id) REFERENCES topics(id)
);

-- answer options
CREATE TABLE q_option (
    id INT PRIMARY KEY AUTO_INCREMENT,
    q_option VARCHAR(255) NOT NULL
);

-- connection between questions and answer options
CREATE TABLE q_data_option(
    question_id INT NOt NULL,
    option_id INT NOT NULL,
    FOREIGN KEY (question_id) REFERENCES q_data(id),
    FOREIGN KEY (option_id) REFERENCES q_option(id)
);

-- connection between questions an correct answers
CREATE TABLE q_data_answers(
    question_id INT NOt NULL,
    option_id INT NOT NULL,
    FOREIGN KEY (question_id) REFERENCES q_data(id),
    FOREIGN KEY (option_id) REFERENCES q_option(id)
);