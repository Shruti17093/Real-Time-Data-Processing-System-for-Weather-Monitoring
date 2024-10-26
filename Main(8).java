/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
class WeatherData {
    String city;
    double temperature;
    double humidity; // New field
    double windSpeed; // New field
    String condition;
    Date timestamp;

    public WeatherData(String city, double temperature, double humidity, double windSpeed, String condition, Date timestamp) {
        this.city = city;
        this.temperature = temperature;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.condition = condition;
        this.timestamp = timestamp;
    }
}










