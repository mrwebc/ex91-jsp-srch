package com.study.jsp.ctrl.board;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.jsp.ctrl.Controller;
import com.study.jsp.ioc.Factory;
import com.study.jsp.model.BoardDTO;
import com.study.jsp.srv.BoardService;

public class BoardRegisterCtrl implements Controller {

  @Override
  public Map<String, String> execute(HttpServletRequest req, HttpServletResponse res) {
    
    Map<String, String> viewInfo = new HashMap<String, String>();
    
    viewInfo.put("mode", "redirect");
    viewInfo.put("viewName", "/board/list.do");
    
    String title = req.getParameter("title");
    String content = req.getParameter("content");
    String writer = req.getParameter("writer");
    
    BoardDTO dto = BoardDTO.builder()
        .title(title)
        .content(content)
        .writer(writer)
        .build();
       
    
    BoardService boardSrv = Factory.INSTANCE.getBoardService();
    boardSrv.create(dto);   
 
    return viewInfo;
  }

}
