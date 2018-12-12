package login.rest.Entity;

public class FilterApart {


        private Integer apartId;


        private String apart_name;


        private String apart_city;


        private String apart_address;


        private String apart_phone;


        private String apart_x;


        private String apart_y;

        private Integer apart_cost;


        private String apart_description;


        private String apart_image_url;

        public FilterApart(){

        }

    public FilterApart(Integer apartId, String apart_name, String apart_city, String apart_address, String apart_phone, String apart_x, String apart_y, Integer apart_cost, String apart_description, String apart_image_url) {
        this.apartId = apartId;
        this.apart_name = apart_name;
        this.apart_city = apart_city;
        this.apart_address = apart_address;
        this.apart_phone = apart_phone;
        this.apart_x = apart_x;
        this.apart_y = apart_y;
        this.apart_cost = apart_cost;
        this.apart_description = apart_description;
        this.apart_image_url = apart_image_url;
    }

    public Integer getApartId() {
        return apartId;
    }

    public void setApartId(Integer apartId) {
        this.apartId = apartId;
    }

    public String getApart_name() {
        return apart_name;
    }

    public void setApart_name(String apart_name) {
        this.apart_name = apart_name;
    }

    public String getApart_city() {
        return apart_city;
    }

    public void setApart_city(String apart_city) {
        this.apart_city = apart_city;
    }

    public String getApart_address() {
        return apart_address;
    }

    public void setApart_address(String apart_address) {
        this.apart_address = apart_address;
    }

    public String getApart_phone() {
        return apart_phone;
    }

    public void setApart_phone(String apart_phone) {
        this.apart_phone = apart_phone;
    }

    public String getApart_x() {
        return apart_x;
    }

    public void setApart_x(String apart_x) {
        this.apart_x = apart_x;
    }

    public String getApart_y() {
        return apart_y;
    }

    public void setApart_y(String apart_y) {
        this.apart_y = apart_y;
    }

    public Integer getApart_cost() {
        return apart_cost;
    }

    public void setApart_cost(Integer apart_cost) {
        this.apart_cost = apart_cost;
    }

    public String getApart_description() {
        return apart_description;
    }

    public void setApart_description(String apart_description) {
        this.apart_description = apart_description;
    }

    public String getApart_image_url() {
        return apart_image_url;
    }

    public void setApart_image_url(String apart_image_url) {
        this.apart_image_url = apart_image_url;
    }
}
