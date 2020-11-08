package com.thoughtworks.capability.gtb.restfulapidesign.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
  private int number;
  private String name;
  private String gender;
  private String note;
}
