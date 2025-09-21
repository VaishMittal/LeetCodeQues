-- select u.product_id,round(sum(p.price *u.units)/if(sum(u.units))=0,1,sum(u.units)),2) as average_price from UnitsSold as u right join Prices as p
-- on p.product_id=u.product_id and (u.purchase_date  between p.start_date and p.end_date) group by u.product_id;

SELECT p.product_id,
       ifnull(ROUND(
         SUM(p.price * u.units) / NULLIF(SUM(u.units), 0),
         2
       ),0) AS average_price
FROM Prices AS p
LEFT JOIN UnitsSold AS u
  ON p.product_id = u.product_id
 AND u.purchase_date BETWEEN p.start_date AND p.end_date
GROUP BY p.product_id;

