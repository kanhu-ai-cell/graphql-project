package com.cell.graphql.payload;


import com.cell.graphql.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCO {

    private String username;
    private String password;
    private String email;

    private String mobile_no;
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

    private String subRole;
    private String referralCode;

    private String description;
    private Integer experience;

    private String designation;
    private String status;
    private String remarks;

    private String deviceId;



    public static User mapUser(UserCO input) {
        User user=null;
        if(input !=null) {
            user=new User();

            user.setUsername(input.getUsername());
            user.setPassword(input.getPassword());
            user.setEmail(input.getEmail());

            user.setMobile_no(input.getMobile_no());
            user.setAlternate_no(input.getAlternate_no());
            user.setWhtsappMobNo(input.getWhtsappMobNo());

            user.setTitle(input.getTitle());
            user.setFirst_name(input.getFirst_name());
            user.setLast_name(input.getLast_name());

            user.setFather_name(input.getFather_name());
            user.setMother_name(input.getMother_name());

            user.setPresentAddress(input.getPresentAddress());
            user.setPermanentAddress(input.getPermanentAddress());

            user.setGender(input.getGender());
            user.setDateOfBirth(input.getDateOfBirth());
            user.setAge(input.getAge());

            user.setSubRole(input.getSubRole());
            user.setReferralCode(input.getReferralCode());

            user.setDescription(input.getDescription());
            user.setExperience(input.getExperience());

            user.setDesignation(input.getDesignation());
            user.setStatus(input.getStatus());
            user.setRemarks(input.getRemarks());

            user.setDeviceId(input.getDeviceId());
        }
        return user;
    }

}
