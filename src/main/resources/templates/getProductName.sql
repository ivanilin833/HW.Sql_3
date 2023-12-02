select product_name
from netology.orders
         join netology.customers c on c.id = customer_id
where lower(name) = lower(:firstName);