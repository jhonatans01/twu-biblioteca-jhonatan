SELECT title FROM book
WHERE id NOT IN (
    SELECT book_id FROM checkout_item c
    INNER JOIN book b ON b.id = c.book_id
)

UNION ALL

SELECT title FROM movie
WHERE id NOT IN (
    SELECT movie_id FROM checkout_item c
    INNER JOIN movie m ON m.id = c.movie_id
)