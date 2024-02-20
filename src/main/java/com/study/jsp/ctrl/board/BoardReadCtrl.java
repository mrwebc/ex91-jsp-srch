package com.study.jsp.ctrl.board;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.jsp.ctrl.Controller;
import com.study.jsp.except.NotExistPostException;
import com.study.jsp.ioc.Factory;
import com.study.jsp.model.BoardDTO;
import com.study.jsp.srv.BoardService;

public class BoardReadCtrl implements Controller {

  @Override
  public Map<String, String> execute(HttpServletRequest req, HttpServletResponse res) {

    Map<String, String> viewInfo = new HashMap<String, String>();
    viewInfo.put("mode", "forward");
    viewInfo.put("viewName", "/board/read.jsp");
    
    int page = 1;
    int spp = 10;
    
    String page_ = req.getParameter("page");
    if(page_!=null) {
      page = Integer.valueOf(page_);
    }
    
    String spp_ = req.getParameter("spp");
    if(spp_!=null) {
      spp = Integer.valueOf(spp_);
    }
    
    String srchType = req.getParameter("srchType");
    String keyword = req.getParameter("keyword");
    
    
    int bno = 0;
    String bno_ = req.getParameter("bno");
    if(!bno_.isEmpty()) {
      bno = Integer.valueOf(bno_);
    }
    
    BoardDTO dto = null;
    
    BoardService boardSrv = Factory.INSTANCE.getBoardService();
    
    try {
      boardSrv.addcnt(bno);
      dto = boardSrv.read(bno);    
      req.setAttribute("dto", dto);
      req.setAttribute("page", page);
      req.setAttribute("spp", spp);
      req.setAttribute("srchType", srchType);
      req.setAttribute("keyword", keyword);
      
    }catch(NotExistPostException e) {
      System.out.println(e.getMessage());
      
      viewInfo.put("mode", "redirect");
      viewInfo.put("viewName", "/board/list.do");
    }
    
    return viewInfo;
  }
  

}
