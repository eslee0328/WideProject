package com.wide.board.Controller;


import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.wide.board.dto.BoardDTO;
import com.wide.board.dto.PageDTO;
import com.wide.board.service.BoardService;


@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/{step}.do")
	public String viewPage(@PathVariable String step) {
		return step;
	}
	
	@RequestMapping("/saveBoard.do")
	public String saveBoard(BoardDTO vo) throws Exception {
		/*
		 * if(vo.getWriter() == null || vo.getWriter().equals("")) { throw new
		 * IllegalArgumentException("작성자는 반드시 입력하셔야 합니다."); }
		 * 
		 * // 게시판 파일 업로드 MultipartFile uploadFile = vo.getUploadFile();
		 * if(!uploadFile.isEmpty()) { String fileName =
		 * uploadFile.getOriginalFilename(); uploadFile.transferTo(new File("D:/" +
		 * fileName)); }
		 */
		boardService.insertBoard(vo);
		return "redirect:/getBoardList.do"; 
	}
	
	/*
	 * @RequestMapping("/getBoardList.do") public void getBoardList(BoardDTO vo,
	 * Model m) throws Exception { List<BoardDTO> result =
	 * boardService.getBoardList(vo) ; m.addAttribute("boardList",result); }
	 */

	// 게시판 수정
	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardDTO vo) {
	   boardService.updateBoard(vo);
	   return "redirect:/getBoardList.do";
	   }
	
	// 게시판 삭제
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardDTO vo) {
	   boardService.deleteBoard(vo);
	   return "redirect:/getBoardList.do";
	   }
	
	// 게시판 조회수
	   @RequestMapping("/getBoard.do")
	   public void getBoard(BoardDTO vo, Model m)
	   {
	      boardService.plusCnt(vo);
	      BoardDTO result = boardService.getBoard(vo);   
	      System.out.println(result);
	      m.addAttribute("board", result);
	   }
	   
	   // 페이징 처리
	   @RequestMapping("/getBoardList.do")
	   public String boardList(PageDTO vo, Model model
	   		, @RequestParam(value="nowPage", required=false)String nowPage
	   		, @RequestParam(value="cntPerPage", required=false)String cntPerPage) {
	   	
	   	int total = boardService.countBoard();
	   	if (nowPage == null && cntPerPage == null) {
	   		nowPage = "1";
	   		cntPerPage = "5";
	   	} else if (nowPage == null) {
	   		nowPage = "1";
	   	} else if (cntPerPage == null) { 
	   		cntPerPage = "5";
	   	}
	   	vo = new PageDTO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
	   	model.addAttribute("paging", vo);
	   	model.addAttribute("viewAll", boardService.selectBoard(vo));
	   	return "boardPaging";
	   }

	   
	   
}