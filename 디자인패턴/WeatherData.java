package daeunkwak;

import java.util.ArrayList;
import java.util.Observable;
// import java.util.Observer;

interface Observer {
    public void update(float temp, float humidity, float pressure);
}

interface DisplayElements{
    public void display();
}


// subject는 interface / abstract class 두가지로 정의 가능함
interface Subject {
    public void registerObserver(Observer o); // 구독
    public void removeObserver(Observer o);   // 구독 해지
    public void notifyObservers();
}

public class WeatherData implements Subject{
    private float temperature;
    private float humidity;
    private float pressure;
    private ArrayList<Observer> observers = new ArrayList<Observer>();

    // 생성자 작성
    public WeatherData(){
        observers = new ArrayList<Observer>();
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;

        // 변화가 생기면 notifyObservers() 호출!
        // -> 아까 작성한 .update() 코드3줄이 필요 없어진다
        notifyObservers();

    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }

    // 리스트를 관리해야함
    @Override
    public void registerObserver(Observer o) {
        // Observer객체 ArrayList에 등록
        this.observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        // 리스트에서 제거하기 -> 인덱스 찾아서 지우기
        int i = observers.indexOf(o);
        if (i >= 0){
            observers.remove(i);
        }
    }

    @Override
    public void notifyObservers() {
        // loop를 돌면서 update된 객체마다 한번씩 호출해준다.
        for (Observer observer : observers){
            observer.update(temperature, humidity, pressure);
        }
    }
}


class WeatherStation {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        // observer parameter
        // 여기에도 생성자에 맞추어서 weatherData를 넣어준다.
        CurrentConditionsDisplay currentDisplay =
                new CurrentConditionsDisplay(weatherData);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);

        weatherData.setMeasurements(80, 65, 30.4f);
        // Observer 설정함으로써 필요없어진 코드
//        currentDisplay.update(weatherData.getTemperature(), weatherData.getHumidity(), weatherData.getPressure());
//        statisticsDisplay.update(weatherData.getTemperature(), weatherData.getHumidity(), weatherData.getPressure());
//        forecastDisplay.update(weatherData.getTemperature(), weatherData.getHumidity(), weatherData.getPressure());

        weatherData.setMeasurements(82, 70, 29.2f);
//        currentDisplay.update(weatherData.getTemperature(), weatherData.getHumidity(), weatherData.getPressure());
//        statisticsDisplay.update(weatherData.getTemperature(), weatherData.getHumidity(), weatherData.getPressure());
//        forecastDisplay.update(weatherData.getTemperature(), weatherData.getHumidity(), weatherData.getPressure());

        weatherData.setMeasurements(78, 90, 29.2f);
//        currentDisplay.update(weatherData.getTemperature(), weatherData.getHumidity(), weatherData.getPressure());
//        statisticsDisplay.update(weatherData.getTemperature(), weatherData.getHumidity(), weatherData.getPressure());
//        forecastDisplay.update(weatherData.getTemperature(), weatherData.getHumidity(), weatherData.getPressure());
    }
}

// current -> statistics
// max, min값 비교하기
class StatisticsDisplay implements Observer, DisplayElements{
    private float maxTemp = 0.0f;
    private float minTemp = 200;
    private float tempSum= 0.0f;
    private int numReadings;

    // 생성된 객체를 Observer에 등록해주는 과정 (구독자 등록)
    // 생성자가 바뀌었으니 parameter도 WeatherData를 넣어주어야함
    public StatisticsDisplay(WeatherData weatherData) {
        weatherData.registerObserver(this);  // 나를 등록!
    }

    public void update(float temp, float humidity, float pressure) {
        tempSum += temp;
        numReadings++;

        if (temp > maxTemp) {
            maxTemp = temp;
        }

        if (temp < minTemp) {
            minTemp = temp;
        }

        display();
    }

    public void display() {
        System.out.println("Avg/Max/Min temperature = " + (tempSum / numReadings)
                + "/" + maxTemp + "/" + minTemp);
    }
}

// current가 가장 먼저 작동
class CurrentConditionsDisplay implements Observer, DisplayElements{
    private float temperature;
    private float humidity;

    public CurrentConditionsDisplay(WeatherData weatherData) {
        weatherData.registerObserver(this);
    }

    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }

    public void display() {
        System.out.println("Current conditions: " + temperature
                + "F degrees and " + humidity + "% humidity");
    }
}


// 3번째로 작동
// pressure 비교하여 display
class ForecastDisplay implements Observer, DisplayElements{
    private float currentPressure = 29.92f;
    private float lastPressure;

    public ForecastDisplay(WeatherData weatherData) {
        weatherData.registerObserver(this);
    }

    public void update(float temp, float humidity, float pressure) {
        lastPressure = currentPressure;
        currentPressure = pressure;
        display();
    }

    public void display() {
        System.out.print("Forecast: ");
        if (currentPressure > lastPressure) {
            System.out.println("Improving weather on the way!");
        } else if (currentPressure == lastPressure) {
            System.out.println("More of the same");
        } else if (currentPressure < lastPressure) {
            System.out.println("Watch out for cooler, rainy weather");
        }
    }
}

class HeatIndexDisplay implements Observer, DisplayElements {
    float heatIndex = 0.0f;
    private WeatherData weatherData;

    public HeatIndexDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    public void update(float t, float rh, float pressure) {
        heatIndex = computeHeatIndex(t, rh);
        display();
    }

    private float computeHeatIndex(float t, float rh) {
        float index = (float)((16.923 + (0.185212 * t) + (5.37941 * rh) - (0.100254 * t * rh)
                + (0.00941695 * (t * t)) + (0.00728898 * (rh * rh))
                + (0.000345372 * (t * t * rh)) - (0.000814971 * (t * rh * rh)) +
                (0.0000102102 * (t * t * rh * rh)) - (0.000038646 * (t * t * t)) + (0.0000291583 *
                (rh * rh * rh)) + (0.00000142721 * (t * t * t * rh)) +
                (0.000000197483 * (t * rh * rh * rh)) - (0.0000000218429 * (t * t * t * rh * rh)) +
                0.000000000843296 * (t * t * rh * rh * rh)) -
                (0.0000000000481975 * (t * t * t * rh * rh * rh)));
        return index;
    }

    public void display() {
        System.out.println("Heat index is " + heatIndex);
    }
}

class WeatherStationHeatIndex {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
        HeatIndexDisplay heatIndexDisplay = new HeatIndexDisplay(weatherData);

        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(82, 70, 29.2f);
        weatherData.setMeasurements(78, 90, 29.2f);
    }
}