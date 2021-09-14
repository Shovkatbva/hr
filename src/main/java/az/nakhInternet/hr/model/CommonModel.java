package az.nakhInternet.hr.model;

import lombok.Data;

import java.util.Date;

@Data
public abstract class CommonModel {
    private Long r;
    private Long id;
    private Date dataDate;
    private Integer active;
}
