package com.study.jsp.model;

public class PaginationMaker {

  private int totalCount; 
  private int startPage;
  private int endPage;
  private boolean prev;
  private boolean next;
  
  private int displayPagiNum = 10;//한페이지 보이는 페이지네이션개수
  
  private Criteria cri;
  public void setCri(Criteria cri) {
    this.cri = cri;
  }
  
  public Criteria getCri() {
    return cri;
  }
  
  public int getTotalCount() {
    return totalCount;
  }  
  
  //게시물의 총개수 1161~1170 -> 117
  public void setTotalCount(int totalCount) {
    this.totalCount = totalCount;
    
    //가장 중요한 계산은 totCount가 설정되는 시점에 calData()를 호출해서 계산한다.
    calData();
  }
  
  private void calData() {
    
    //endPage = (현재페이지/페이지네이션개수)*페이지네이션개수
    //요청받은 페이지번호를 displayPagiNum로 나눈후 올림처리한다.
    //나눈 결과에 displayPagiNum을 곱한다.    
    endPage = (int)(Math.ceil((double)cri.getPage()/displayPagiNum)*displayPagiNum);// 페이지네이션 끝번호

    //페이지네이션 시작번호
    //startPage = (endPage - 페이지네이션개수) + 1;
    startPage = (endPage - displayPagiNum) +1;
    System.out.println("startPage = "+startPage);
    
    //realEndPage = (전체개시물개수/페이지당노출게시물개수)
    // totCount/sizePerPage 계산후 Math.ceil()로 무조건올림처리한다.
    // 결과가 실수이므로 int로 다운캐스팅 처리    
    int realEndPage = (int)(Math.ceil((double)totalCount/cri.getSpp()));
    
    //endPage 재계산
    if(endPage>realEndPage){
      endPage = realEndPage;
    }

    //이전,다음 버튼 활성화 여부 prev, next
    prev = (startPage>1)?true:false;
    System.out.println("prev = "+prev);
    
    next = (endPage<realEndPage)?true:false;
    System.out.println("next = "+next);

  }

  public int getStartPage() {
    return startPage;
  }

  public int getEndPage() {
    return endPage;
  }

  public boolean getPrev() {
    return prev;
  }

  public boolean getNext() {
    return next;
  }

  public int getdisplayPagiNum() {
    return displayPagiNum;
  }

  public void setdisplayPagiNum(int displayPagiNum) {
    this.displayPagiNum = displayPagiNum;
  }

}

