/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
public class WeatherAlert {
    private static final double TEMPERATURE_THRESHOLD = 35.0;
    private static int consecutiveBreaches = 0;
    private static final int REQUIRED_CONSECUTIVE_BREACHES = 2;

    public static void checkForAlerts(WeatherData data) {
        if (data.temperature > TEMPERATURE_THRESHOLD) {
            consecutiveBreaches++;
            if (consecutiveBreaches >= REQUIRED_CONSECUTIVE_BREACHES) {
                triggerAlert(data.city, "Temperature exceeded " + TEMPERATURE_THRESHOLD + "°C for " + REQUIRED_CONSECUTIVE_BREACHES + " consecutive updates.");
            }
        } else {
            consecutiveBreaches = 0; // Reset the counter if threshold is not breached
        }
    }

    private static void triggerAlert(String city, String message) {
        System.out.println("ALERT: " + city + " - " + message);
        // Additional code to log the alert or send notifications can be added here
    }
}




