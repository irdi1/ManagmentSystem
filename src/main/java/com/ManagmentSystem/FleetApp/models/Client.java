package com.ManagmentSystem.FleetApp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    private String name;
    private String address;
    private String city;
    private String phone;
    private String mobile;
    private String website;
    private String email;

    @ManyToOne
    @JoinColumn(name="countryid", insertable=false, updatable =false)
    private Country country;
    private Integer countryid;

    @ManyToOne
    @JoinColumn(name = "stateid", insertable = false, updatable = false)
    private State state;
    private Integer stateid;

    private String details;
}
