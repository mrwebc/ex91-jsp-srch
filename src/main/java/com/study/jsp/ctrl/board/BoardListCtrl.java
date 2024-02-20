package com.study.jsp.ctrl.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.jsp.ctrl.Controller;
import com.study.jsp.ioc.Factory;
import com.study.jsp.model.BoardDTO;
import com.study.jsp.model.PaginationMaker;
import com.study.jsp.model.SrchCriteria;
import com.study.jsp.srv.BoardService;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class BoardListCtrl implements Controller{
  

  @Override
  public Map<String, String> execute(HttpServletRequest req, HttpServletResponse res) {

    //log.info("★★★★ listSrch 컨트롤러 호출~! ★★★★★");
    
    Map<String, String> viewInfo = new HashMap<String, String>();
    viewInfo.put("mode", "forward");
    viewInfo.put("viewName", "/board/list.jsp");
    
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
    
    //log.info("★★★★★★★★ spp= "+spp);
    String srchType = req.getParameter("srchType");
    String keyword = req.getParameter("keyword");
    
    SrchCriteria s_cri = new SrchCriteria();
    s_cri.setPage(page);
    s_cri.setSpp(spp);
    s_cri.setSrchType(srchType);
    s_cri.setKeyword(keyword);
    
    //log.info("★★★★★★★★ s_cri="+s_cri.toString());
    
    PaginationMaker pagiMaker = new PaginationMaker();
    pagiMaker.setCri(s_cri);
    
    BoardService boardSrv = Factory.INSTANCE.getBoardService();
    pagiMaker.setTotalCount(boardSrv.totSrch(s_cri));
    
    
    List<BoardDTO> list = boardSrv.listSrch(s_cri);

    req.setAttribute("s_cri", s_cri);
    req.setAttribute("pagiMaker", pagiMaker);
    req.setAttribute("list", list);
        
    
    return viewInfo;
  }
}
