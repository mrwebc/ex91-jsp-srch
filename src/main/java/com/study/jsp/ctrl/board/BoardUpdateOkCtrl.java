package com.study.jsp.ctrl.board;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.jsp.ctrl.Controller;
import com.study.jsp.ioc.Factory;
import com.study.jsp.model.BoardDTO;
import com.study.jsp.srv.BoardService;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class BoardUpdateOkCtrl implements Controller {

  @Override
  public Map<String, String> execute(HttpServletRequest req, HttpServletResponse res) {
    
    Map<String, String> viewInfo = new HashMap<String, String>();        
    viewInfo.put("mode", "redirect");
    
    int bno = 0;
    String bno_ = req.getParameter("bno");
    if(!bno_.isEmpty()) {
      bno = Integer.valueOf(bno_);
    }
    
    
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
    
    log.info("★★★★★ keyword="+keyword);
    
    String title = req.getParameter("title");
    String content = req.getParameter("content");
    String writer = req.getParameter("writer");
    
    BoardDTO dto = BoardDTO.builder()
        .bno(bno)
        .title(title)
        .content(content)
        .writer(writer)
        .build();
       
    
    BoardService boardSrv = Factory.INSTANCE.getBoardService();
    boardSrv.update(dto);
    
    
    @SuppressWarnings("deprecation")
    String viewName = String.format("/board/list.do?page=%d&spp=%d&srchType=%s&keyword=%s", page,spp,srchType,URLEncoder.encode(keyword));
    log.info("viewName = "+viewName);
    viewInfo.put("viewName", viewName);
    
    return viewInfo;
  }

}
