/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
class DailySummary {
    String city;
    double avgTemperature;
    double maxTemperature;
    double minTemperature;
    double avgHumidity; // New field
    double maxWindSpeed; // New field
    String dominantCondition;

    public DailySummary(String city, double avgTemperature, double maxTemperature, double minTemperature, double avgHumidity, double maxWindSpeed, String dominantCondition) {
        this.city = city;
        this.avgTemperature = avgTemperature;
        this.maxTemperature = maxTemperature;
        this.minTemperature = minTemperature;
        this.avgHumidity = avgHumidity; // Initialize new field
        this.maxWindSpeed = maxWindSpeed; // Initialize new field
        this.dominantCondition = dominantCondition;
    }
}












