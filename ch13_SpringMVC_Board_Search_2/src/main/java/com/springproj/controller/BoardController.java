package com.springproj.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springproj.biz.domain.BoardVO;
import com.springproj.biz.service.BoardService;

@Controller
@SessionAttributes("board")
public class BoardController{
	@Autowired
	BoardService boardService;

	//@RequestMapping(value = "/insertBoard.do", method = RequestMethod.GET)
	@GetMapping("/insertBoard.do")
	public String insertBoard(){
		//System.out.println("글 등록 화면 처리");
		
		return "insertBoard";
	}
	
	//@RequestMapping(value = "/insertBoard.do", method = RequestMethod.POST)
	@PostMapping("/insertBoard.do")
	public String insertBoard(BoardVO board) {
		//System.out.println("글 등록 처리");
		
		boardService.insertService(board);
		
		return "redirect:getBoardList.do";
	}
	
	@RequestMapping(value = "/getBoard.do")
	public String getBoard(BoardVO board, Model model) {
		//System.out.println("GetBoardController 처리.");
		
		BoardVO vo = boardService.getService(board.getSeq());
		
		model.addAttribute("board", vo);
		
		return "getBoard";
	}
	
	// 검색 조건 목록 설정
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap() {
		Map<String, String> conditionMap = new HashMap<String, String>();
		
		conditionMap.put("제목", "TITLE");
		conditionMap.put("내용", "CONTENT");
		
		return conditionMap;
	}
	
	// 글 목록 검색 처리
	@RequestMapping(value = "/getBoardList.do")
	public String getBoardList(BoardVO vo, Model model) {
		//System.out.println("글 목록 검색 처리");
		
		System.out.println("검색 조건: " + vo.getSearchCondition());
		System.out.println("검색 단어: " + vo.getSearchKeyword());
		
		if(vo.getSearchCondition() == null) {
			vo.setSearchCondition("TITLE");
		}
		
		if(vo.getSearchKeyword() == null) {
			vo.setSearchKeyword("");
		}
		
		List<BoardVO> list = boardService.getServiceList(vo);
		
		model.addAttribute("boardList", list);
		
		return "getBoardList";
	}
	
	
	@RequestMapping(value = "/updateBoard.do")
	public String updateBoardProc(@ModelAttribute("board") BoardVO vo) {
		//System.out.println("글 수정 처리.");
		System.out.println(vo);
		
		boardService.updateService(vo);
		
		return "redirect:getBoardList.do";
	}
	
	@RequestMapping(value = "/deleteBoard.do")
	public String deleteBoard(BoardVO board) {
		//System.out.println("글 삭제 처리");
		
		boardService.deleteService(board.getSeq());
		
		return "redirect:getBoardList.do";
	}

}
