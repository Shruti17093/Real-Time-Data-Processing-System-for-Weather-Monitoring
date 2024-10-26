CREATE TABLE weather_data (
    id SERIAL PRIMARY KEY,
    city_name VARCHAR(50),
    main_condition VARCHAR(50),
    temperature FLOAT,
    feels_like FLOAT,
    data_timestamp BIGINT
);
