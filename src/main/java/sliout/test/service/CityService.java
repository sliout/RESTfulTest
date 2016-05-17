package sliout.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import sliout.test.mapper.CityMapper;
import sliout.test.vo.City;

import java.util.List;

/**
 * Created by Serguei on 5/15/2016.
 */
public class CityService {

    @Autowired
    private CityMapper cityMapper;

    public List<City> getAllCities() {
        return cityMapper.getAllCities();
    }
    public City getCity(int id) {
        return cityMapper.getCity(id);
    }
    public int addCity(City city){
        return cityMapper.addCity(city);
    }

}
