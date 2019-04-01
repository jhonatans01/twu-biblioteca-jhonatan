SELECT name FROM member m,
(
    SELECT member_id, COUNT(*) as quantity
    FROM checkout_item 
    GROUP BY member_id
    HAVING quantity > 1
) as members_query
WHERE members_query.member_id = m.id