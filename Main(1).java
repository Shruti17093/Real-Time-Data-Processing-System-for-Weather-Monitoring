/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;

class WeatherData {
    String city;
    double temperature;
    String condition;
    Date timestamp;

    public WeatherData(String city, double temperature, String condition, Date timestamp) {
        this.city = city;
        this.temperature = temperature;
        this.condition = condition;
        this.timestamp = timestamp;
    }
}

class DailySummary {
    String city;
    double avgTemperature;
    double maxTemperature;
    double minTemperature;
    String dominantCondition;

    public DailySummary(String city, double avgTemperature, double maxTemperature, double minTemperature, String dominantCondition) {
        this.city = city;
        this.avgTemperature = avgTemperature;
        this.maxTemperature = maxTemperature;
        this.minTemperature = minTemperature;
        this.dominantCondition = dominantCondition;
    }
}

public class WeatherRollup {
    public static DailySummary calculateDailySummary(List<WeatherData> dailyWeatherData) {
        double totalTemp = 0;
        double maxTemp = Double.MIN_VALUE;
        double minTemp = Double.MAX_VALUE;
        Map<String, Integer> conditionCount = new HashMap<>();

        for (WeatherData data : dailyWeatherData) {
            // Update temperature totals
            totalTemp += data.temperature;
            maxTemp = Math.max(maxTemp, data.temperature);
            minTemp = Math.min(minTemp, data.temperature);

            // Count occurrences of weather conditions
            conditionCount.put(data.condition, conditionCount.getOrDefault(data.condition, 0) + 1);
        }

        // Calculate averages
        double avgTemp = totalTemp / dailyWeatherData.size();

        // Determine the dominant weather condition
        String dominantCondition = conditionCount.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .get()
                .getKey();

        // Create the daily summary
        return new DailySummary(dailyWeatherData.get(0).city, avgTemp, maxTemp, minTemp, dominantCondition);
    }
}



