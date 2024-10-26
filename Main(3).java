/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
public class SystemSetupTest {
    public static void main(String[] args) {
        String apiKey = "YourAPIKey"; // Replace with your actual API key
        WeatherMonitoringSystem weatherSystem = new WeatherMonitoringSystem(apiKey);
        boolean isConnected = weatherSystem.testConnection();
        assert isConnected : "Failed to connect to OpenWeatherMap API";
        System.out.println("System setup verified: Successfully connected to OpenWeatherMap API.");
    }
}





