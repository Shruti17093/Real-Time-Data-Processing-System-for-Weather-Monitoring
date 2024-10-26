/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
public WeatherData fetchWeatherData(String city) {
    String apiUrl = String.format("https://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s&units=metric", city, apiKey);
    // Make API call and parse JSON response
    // Extract temperature, humidity, wind speed, and weather condition
    JSONObject jsonResponse = //... your JSON parsing logic
    double temperature = jsonResponse.getJSONObject("main").getDouble("temp");
    double humidity = jsonResponse.getJSONObject("main").getDouble("humidity");
    double windSpeed = jsonResponse.getJSONObject("wind").getDouble("speed");
    String condition = jsonResponse.getJSONArray("weather").getJSONObject(0).getString("main");

    return new WeatherData(city, temperature, humidity, windSpeed, condition, new Date());
}











