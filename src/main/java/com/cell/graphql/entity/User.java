package com.cell.graphql.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Order> orders=new ArrayList<Order>();
    private String email;

    private String  mobile_no;

    private String alternate_no;

    private String whtsappMobNo;

    private String title;

    private String first_name;

    private String last_name;

    private String father_name;

    private String mother_name;

    private String presentAddress;

    private String permanentAddress;

    private String gender;

    private Date dateOfBirth;

    private Integer age;

    //private Role role;
    private String subRole;
    private String referralCode;

  //  private FileDb userImage;

    private String description;

    // in months
    private Integer experience;

    private Long lastUpdatedBy;

    private Long createdBy;

    private String designation;

    private String status;

    private String remarks;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", updatable = false)
    private Date created_at;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updated_at;

    @Column(name = "deviceId", length = 700)
    private String deviceId;




}
