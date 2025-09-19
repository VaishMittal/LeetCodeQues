# Write your MySQL query statement below
-- select s.user_id ,round(count(c.user_id) / count(c.action)),2) as confirmation_rate
--  from Signups as s join confirmations as c
--  on s.user_id=c.user_id;
--  group by c.user_id having c.action="confirmed"; 

SELECT 
    s.user_id,
    ROUND(
        IFNULL(SUM(c.action = 'confirmed'), 0) 
        / GREATEST(COUNT(c.user_id), 1), 2
    ) AS confirmation_rate
FROM signups AS s
LEFT JOIN confirmations AS c
    ON s.user_id = c.user_id
GROUP BY s.user_id;

