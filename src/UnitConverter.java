public class UnitConverter {

    public int someData = 0;
    private static final double RATIO = (9.0/5.0);
    //static keyword

    public static double MillisecondToMinutes(double ms){
        //first convert to seconds
        //then divide by 60
        double seconds = (ms / 1000);
        double minutes = seconds / 60;
        return minutes;
    }
    public static double CelciusToFahrenheit(double tempCelcius){
        double tempFahrenheit = (tempCelcius * (RATIO) ) + 32;
        return tempFahrenheit;
    }



}
