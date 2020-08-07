-- テーブル作成
CREATE TABLE student_info(
    code VARCHAR(4) PRIMARY KEY,
    last_name VARCHAR(8) NOT NULL,
    first_name VARCHAR(8) NOT NULL,
    grade INTEGER NOT NULL
);

CREATE TABLE midterm_test(
    student_code VARCHAR(4) PRIMARY KEY ,
    score INTEGER NOT NULL ,
    FOREIGN KEY (student_code) REFERENCES STUDENT_INFO(CODE)
);

-- テストデータ
INSERT INTO student_info
VALUES ('D108', 'ムラカミ', 'リエコ', 1),
       ('C012', 'ニシヤマ', 'タケル', 2),
       ('B110', 'ワカモト', 'ハルミ', 3),
       ('A201', 'ツカモト', 'アキヒロ', 3);

INSERT INTO midterm_test
VALUES ('D108', 72),
       ('C012', 81),
       ('A201', 92);