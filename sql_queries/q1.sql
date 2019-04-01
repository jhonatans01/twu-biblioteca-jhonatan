SELECT name FROM member m
INNER JOIN checkout_item c ON m.id = c.member_id
INNER JOIN book b ON b.id = c.book_id
WHERE b.title = "The Hobbit";