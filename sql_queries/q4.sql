INSERT INTO book VALUES (11, "The Pragmatic Programmer");

INSERT INTO member VALUES(43, "Jhonatan Silva");

INSERT INTO checkout_item (member_id, book_id) VALUES(43, 11);

SELECT name FROM member m
INNER JOIN checkout_item c ON m.id = c.member_id
INNER JOIN book b ON b.id = c.book_id
WHERE b.title = "The Pragmatic Programmer";