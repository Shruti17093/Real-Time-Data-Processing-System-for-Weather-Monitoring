/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
public class TemperatureConversionTest {
    public static void main(String[] args) {
        double kelvin = 300.0; // Example Kelvin value
        double expectedCelsius = 26.85; // Expected Celsius value
        double expectedFahrenheit = 80.33; // Expected Fahrenheit value
        
        double celsius = WeatherMonitoringSystem.convertTemperature(kelvin, "Celsius");
        double fahrenheit = WeatherMonitoringSystem.convertTemperature(kelvin, "Fahrenheit");

        assert Math.abs(celsius - expectedCelsius) < 0.01 : "Celsius conversion failed.";
        assert Math.abs(fahrenheit - expectedFahrenheit) < 0.01 : "Fahrenheit conversion failed.";
        
        System.out.println("Temperature conversion verified: Celsius and Fahrenheit values are correct.");
    }
}







