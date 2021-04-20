package com.javastart.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GroupResponseDTO {
   private Object[] response;

   public String  getResponse() {
      return response[0].toString();
   }
}
