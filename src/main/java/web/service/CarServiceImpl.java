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
        carList.add(new Car( "lada1", 1992));
        carList.add(new Car("lada2", 1992));
        carList.add(new Car("lada3", 1992));
        carList.add(new Car("lada4", 1992));
        carList.add(new Car("lada5", 1992));
        carList.add(new Car("lada6", 1992));
        carList.add(new Car("lada7", 1992));
        carList.add(new Car("lada8", 1992));
        carList.add(new Car("lada9", 1992));
        carList.add(new Car("lada10", 1992));
        carList.add(new Car("lada11", 1992));
        carList.add(new Car("lada12", 1992));
        carList.add(new Car("lada13", 1992));
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
