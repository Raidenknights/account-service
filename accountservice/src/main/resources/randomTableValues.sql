INSERT INTO account (username, password, first_name, last_name, number)
SELECT 
    'user' || i AS username,
    md5(random()::text) AS password,
    INITCAP(md5(random()::text)) AS first_name,
    INITCAP(md5(random()::text)) AS last_name,
    '9' || LPAD((TRUNC(random() * 999999999)::bigint)::text, 9, '0') AS number
FROM generate_series(1, 1000) AS s(i);
