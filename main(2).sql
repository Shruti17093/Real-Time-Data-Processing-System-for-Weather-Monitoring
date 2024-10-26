CREATE TABLE alerts (
    id SERIAL PRIMARY KEY,
    city_name VARCHAR(50),
    alert_type VARCHAR(50),
    alert_message TEXT,
    alert_timestamp BIGINT
);
