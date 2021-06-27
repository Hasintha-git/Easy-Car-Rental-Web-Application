package lk.easy.carrental.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sun.rmi.runtime.Log;

import javax.persistence.*;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer customerId;
    @ManyToOne
    @JoinColumn(name = "userName",referencedColumnName = "userName")
    private Login login;
//    private String userName;
    private String nicImg;
    private String drivingImg;
    private String address;
    private String contact;

}
