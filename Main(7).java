/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
public class AlertingThresholdTest {
    public static void main(String[] args) {
        WeatherData data1 = new WeatherData("Delhi", 34.0, "Clear", new Date());
        WeatherData data2 = new WeatherData("Delhi", 36.0, "Clear", new Date());
        
        WeatherAlert.checkForAlerts(data1); // Should not trigger alert
        WeatherAlert.checkForAlerts(data2); // Should trigger alert
        
        // Validate that alert is triggered
        // Assuming we have a way to check if an alert was logged
        assert WeatherAlert.getAlertCount() == 1 : "Alert should have been triggered.";
        
        System.out.println("Alerting thresholds verified: Alerts triggered correctly.");
    }
}









