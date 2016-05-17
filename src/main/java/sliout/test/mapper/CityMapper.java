package sliout.test.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import sliout.test.vo.City;

import java.util.List;

/**
 * Created by Serguei on 5/15/2016.
 */
public interface CityMapper {

    /******************************************
     * Retrieves a city
     * @param id id
     * @return city
     */
    @Select("SELECT * FROM city WHERE id = #{id}")
    City getCity(@Param("id") int id);

    @Select("SELECT * FROM city")
    public List<City> getAllCities();

    /******************************************
     * Insert a city
     * @param city
     * @return int
     */
    @Insert("INSERT INTO city (name,countyCode,district,population) VALUES (#{name},#{countryCode},#{district},#{population})")
    public int addCity(City city);

}
