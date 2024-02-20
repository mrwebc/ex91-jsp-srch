package com.study.jsp.persistence;

import org.junit.Test;

import com.study.jsp.ioc.Factory;
import com.study.jsp.model.BoardDTO;
import com.study.jsp.srv.BoardService;

public class BoardMapperDaoTest {

  private BoardService boardSrv = Factory.INSTANCE.getBoardService();
  
  
  @Test
  public void insertTest() {
    
    for(int i=1;i<300;i++) {
      BoardDTO dto = BoardDTO.builder()
          .title("아기공룡둘리"+i)
          .content("둘리"+i+"은 내친구~!")
          .writer("둘리-"+i)
          .build();
      
      boardSrv.create(dto);
    }//for
  }
  

  //@Test
  public void deleteTest() {
    boardSrv.delete(406);
  }
  
  //@Test
  public void readTest() {
    BoardDTO dto = boardSrv.read(406);
    System.out.println(dto.toString());
  }
  
  //@Test
  public void updateTest() {
    
    BoardDTO dto = BoardDTO.builder()
        .bno(406)
        .title("들장미소녀")
        .content("외로워도 슬퍼도 나는 안울어~!")
        .writer("candy")
        .build();
    
    boardSrv.update(dto);
  }
  
  //@Test
  public void createTest() {
    
    BoardDTO dto = BoardDTO.builder()
        .title("달려라하니")
        .content("이세상 끝까지~!")
        .writer("hani")
        .build();
    
    boardSrv.create(dto);    
  }
}
