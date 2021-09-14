package az.nakhInternet.hr.model;

import lombok.Data;

@Data
public class Position extends CommonModel{

    private String position_name;
    private Organization organization;
}
