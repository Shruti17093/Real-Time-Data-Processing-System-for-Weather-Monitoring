CREATE TABLE weather_aggregates (
    id SERIAL PRIMARY KEY,
    city_name VARCHAR(50),
    time_period VARCHAR(10),  -- 'hourly' or 'daily'
    start_time BIGINT,
    end_time BIGINT,
    avg_temperature FLOAT,
    avg_feels_like FLOAT,
    most_common_condition VARCHAR(50)
);
