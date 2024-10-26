CREATE TABLE DailyWeatherSummary (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    city VARCHAR(50),
    date DATE,
    avg_temperature DOUBLE,
    max_temperature DOUBLE,
    min_temperature DOUBLE,
    dominant_condition VARCHAR(50)
);
