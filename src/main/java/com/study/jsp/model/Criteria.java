package com.study.jsp.model;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Getter
//검색기준, 분류기준
public class Criteria {

  private int page;//요청페이지번호
  private int spp;//sizePerPage 페이지당 게시물의 노출개수
  
  public Criteria() {
    this.page = 1;
    this.spp = 10;
  }
  
  public void setPage(int page) {
    if(page<2) {
      this.page = 1;
      return;
    }
    
    this.page = page;
  }
  
  
  public void setSpp(int spp) {

    log.info("★★★★★★★★ spp= "+spp);
    if(spp<2 || spp>100) {
      this.spp = 10;
      return;
    }
    
    this.spp = spp;
  }
  
  public int getOffset() {
    return (page-1)*spp;
  }

  @Override
  public String toString() {
    return String.format("Criteria [page = %d, spp = %d]",page,spp)   ;
  }
}
