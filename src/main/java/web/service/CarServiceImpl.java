package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {
    private static List<Car> carList;

    static {
        carList = new ArrayList<>();
        carList.add(new Car(1L, "lada1", 1992));
        carList.add(new Car(2L, "lada2", 1992));
        carList.add(new Car(3L, "lada3", 1992));
        carList.add(new Car(4L, "lada4", 1992));
        carList.add(new Car(5L, "lada5", 1992));
        carList.add(new Car(6L, "lada6", 1992));
        carList.add(new Car(7L, "lada7", 1992));
        carList.add(new Car(8L, "lada8", 1992));
        carList.add(new Car(9L, "lada9", 1992));
        carList.add(new Car(10L, "lada10", 1992));
        carList.add(new Car(11L, "lada11", 1992));
        carList.add(new Car(12L, "lada12", 1992));
        carList.add(new Car(13L, "lada13", 1992));
    }

    public List<Car> getMyList(Integer count) {
        if (count == null || count >= 5) {
            return carList;
        } else  return carList.stream().limit(count).collect(Collectors.toList());
    }

    public CarServiceImpl() {
    }

    public CarServiceImpl(List<Car> carList) {
        CarServiceImpl.carList = carList;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void setCarList(List<Car> carList) {
        CarServiceImpl.carList = carList;
    }
}
