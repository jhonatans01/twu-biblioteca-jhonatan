SELECT COUNT(*) FROM member m
WHERE m.id NOT IN (
    SELECT c.member_id FROM checkout_item c 
    INNER JOIN book b ON c.book_id = b.id
) AND m.id NOT IN (
    SELECT c.member_id FROM checkout_item c 
    INNER JOIN movie m ON c.movie_id = m.id
)