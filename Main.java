/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class WeatherMonitoringSystem {
    private static final String API_KEY = "YourAPIKey"; // Replace with your actual API key
    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/weather";
    private static final String[] CITIES = {"Delhi", "Mumbai", "Chennai", "Bangalore", "Kolkata", "Hyderabad"};
    private static final int INTERVAL_MINUTES = 5; // Configurable interval in minutes

    public static void main(String[] args) {
        // Schedule the weather data retrieval task at a fixed interval
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(WeatherMonitoringSystem::fetchAndProcessWeatherData, 0, INTERVAL_MINUTES, TimeUnit.MINUTES);
    }

    public static void fetchAndProcessWeatherData() {
        for (String city : CITIES) {
            String response = getWeatherData(city);
            if (response != null) {
                processWeatherData(response, "Celsius"); // User preference for temperature unit
            } else {
                System.out.println("Failed to retrieve weather data for " + city);
            }
        }
    }

    public static String getWeatherData(String cityName) {
        try {
            // Construct the full API URL
            String urlString = BASE_URL + "?q=" + cityName + "&appid=" + API_KEY;
            URL url = new URL(urlString);

            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Check the response code
            int responseCode = connection.getResponseCode();
            if (responseCode == 200) { // HTTP OK
                // Read the response
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // Return the response as a string
                return response.toString();
            } else {
                System.out.println("GET request failed. Response Code: " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void processWeatherData(String jsonResponse, String temperatureUnit) {
        try {
            // Parse the JSON response (using org.json library or any other JSON parsing library)
            org.json.JSONObject jsonObject = new org.json.JSONObject(jsonResponse);
            double tempInKelvin = jsonObject.getJSONObject("main").getDouble("temp");
            double feelsLikeInKelvin = jsonObject.getJSONObject("main").getDouble("feels_like");
            String weatherCondition = jsonObject.getJSONArray("weather").getJSONObject(0).getString("main");

            // Convert temperatures based on user preference
            double temp = convertTemperature(tempInKelvin, temperatureUnit);
            double feelsLike = convertTemperature(feelsLikeInKelvin, temperatureUnit);

            // Output the processed weather data
            System.out.println("Weather Condition: " + weatherCondition);
            System.out.println("Temperature: " + temp + "° " + temperatureUnit);
            System.out.println("Feels Like: " + feelsLike + "° " + temperatureUnit);
            System.out.println("-----------------------------------");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static double convertTemperature(double tempInKelvin, String unit) {
        switch (unit.toLowerCase()) {
            case "celsius":
                return tempInKelvin - 273.15;
            case "fahrenheit":
                return (tempInKelvin - 273.15) * 9/5 + 32;
            default: // Kelvin
                return tempInKelvin;
        }
    }
}
