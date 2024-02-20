package com.study.jsp.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SrchCriteria extends Criteria{

  private String srchType;
  private String keyword;
  
  @Override
  public String toString() {
    return super.toString() + " SrchCriteria "
        + "[srchType="+srchType+", keyword="+keyword+"]";
  }
  
  
}
