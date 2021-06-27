package lk.easy.carrental.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Maintain {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer maintainId;
    private String status;
    private String date;

    @ManyToOne
    @JoinColumn(name = "vehicleNum",referencedColumnName = "vehicleNum")
    private Car car;
}
