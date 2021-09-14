package az.nakhInternet.hr.model;

import lombok.Data;

@Data
public class Employee extends CommonModel {

    private String name;
    private String surname;
    private String father_name;
    private Organization organization;
    private Sector sector;
    private Position position;
}
