/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
public class DailyWeatherSummaryTest {
    public static void main(String[] args) {
        List<WeatherData> weatherDataList = new ArrayList<>();
        // Simulate weather updates over several days
        weatherDataList.add(new WeatherData("Delhi", 30.0, "Clear", new Date()));
        weatherDataList.add(new WeatherData("Delhi", 32.0, "Cloudy", new Date()));
        weatherDataList.add(new WeatherData("Delhi", 28.0, "Rain", new Date()));
        
        DailySummary summary = WeatherRollup.calculateDailySummary(weatherDataList);
        
        assert Math.abs(summary.avgTemperature - 30.0) < 0.01 : "Average temperature calculation failed.";
        assert summary.maxTemperature == 32.0 : "Maximum temperature calculation failed.";
        assert summary.minTemperature == 28.0 : "Minimum temperature calculation failed.";
        assert summary.dominantCondition.equals("Clear") : "Dominant condition calculation failed.";
        
        System.out.println("Daily weather summary verified: Summary values are correct.");
    }
}








