package com.study.jsp.ctrl;

import java.util.HashMap;
import java.util.Map;

import com.study.jsp.ctrl.board.BoardDeleteCtrl;
import com.study.jsp.ctrl.board.BoardListCtrl;
import com.study.jsp.ctrl.board.BoardReadCtrl;
import com.study.jsp.ctrl.board.BoardRegisterCtrl;
import com.study.jsp.ctrl.board.BoardUpdateCtrl;
import com.study.jsp.ctrl.board.BoardUpdateOkCtrl;

public class HanderMapping {

  Map<String, Controller> urlMap = null;// url과 command 객체를 서로 연결시켜 주는 역할

  // 생성자에서 맵초기화
  public HanderMapping() {
    urlMap = new HashMap<String, Controller>();
    urlMap.put("/board/write.do", new BoardRegisterCtrl());
    urlMap.put("/board/list.do", new BoardListCtrl());
    urlMap.put("/board/read.do", new BoardReadCtrl());
    urlMap.put("/board/delete.do", new BoardDeleteCtrl());
    urlMap.put("/board/update.do", new BoardUpdateCtrl());
    urlMap.put("/board/updateOk.do", new BoardUpdateOkCtrl());
    
  }

  public Controller getController(String viewName) {
    return urlMap.get(viewName);
  }
}
