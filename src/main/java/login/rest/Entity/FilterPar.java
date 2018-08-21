package login.rest.Entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.time.LocalDate;


public class FilterPar {
    private Date date_begin;
    private  Date date_end;

    FilterPar(FilterPar filterPar){
        date_begin = filterPar.date_begin;
        date_end = filterPar.date_end;
    }

    FilterPar(){

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
