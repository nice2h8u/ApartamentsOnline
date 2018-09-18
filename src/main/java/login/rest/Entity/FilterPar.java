package login.rest.Entity;


import java.sql.Date;



public class FilterPar {
    private Date date_begin;
    private  Date date_end;
    private Integer apart_cost;
    private  String apart_city;

    FilterPar(){

    }

    public FilterPar(Date date_begin, Date date_end, Integer apart_cost, String apart_city) {
        this.date_begin = date_begin;
        this.date_end = date_end;
        this.apart_cost = apart_cost;
        this.apart_city = apart_city;
    }

    public Integer getApart_cost() {
        return apart_cost;
    }

    public void setApart_cost(Integer apart_cost) {
        this.apart_cost = apart_cost;
    }

    public String getApart_city() {
        return apart_city;
    }

    public void setApart_city(String apart_city) {
        this.apart_city = apart_city;
    }

    public Date getDate_begin() {
        return date_begin;
    }

    public void setDate_begin(Date date_begin) {
        this.date_begin = date_begin;
    }

    public Date getDate_end() {
        return date_end;
    }

    public void setDate_end(Date date_end) {
        this.date_end = date_end;
    }
}
