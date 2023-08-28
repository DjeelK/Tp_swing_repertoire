package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.swing.*;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private int id;
    private String name;
    private boolean isWomen;
    private int age;
    private String bloodGroup;
    private String phoneNumber;
    private Qualification qualification;
    private Date startDate;
    private String address;
    private ImageIcon imageIcon;

}
