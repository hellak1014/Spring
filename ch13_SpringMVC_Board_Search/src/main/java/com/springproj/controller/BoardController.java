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
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springproj.biz.domain.BoardVO;
import com.springproj.biz.service.BoardService;


@Controller
@SessionAttributes("board") //컨트롤러 안에 있는 매서드들 중에서 model에다가 board라는 이름으로 저장하는 데이터가 있다면, 모델뿐만 아니라 세션에도 저장해줘
public class BoardController{
//annotation을 하면서 추상매서드 형으로 윗 부모를 상속해오지 않고도 bean이 생성되었기 때문에 servlet에서 bean을 생성하지 않아도 된다. 
//그리고 직관적인 이름으로 handelRequest를 변경.
//그리고 이젠 더는 오버라이딩을 하지 않기 때문에 오버라이딩을 지운다.
//그리고 우리가 핸들러 mapping에게 이곳에서 처리를 해야 한다고 알려줘야 하기 때문에 핸들러 맵핑이 인식되는 annotation을 해줘야한다.
//그게 requestmapping이고, 옆에 value값으로 servlet-context에서 설정한 key값을 둔다. 맞는 .do를 넣어줄것.
//이때, value에 .do 값만 넣게 될 경우 value는 생략이 가능하다. 
//마지막으로 컨트롤러로 상속을 받지 않아도 되고, 이름을 정해서 맵핑을 할 수 있게 되면서 하나의 자료형으로 모두 모아서 작성할 수 있게 되었다.
//또있음... 매서드에 있는 ModelAndView를 지울수있음... 대신 String으로 처리.
//대신 이렇게 되면 insertBoard로 이동을 해야 하기 때문에 리턴값을 이동할 곳으로 넣어줌. 
//그렇게 되면... throws exception이 필요 없어진다. 그냥 값을 받을 괄호만 남겨줌.
	
	
	@Autowired
	BoardService boardService;
	
	//@RequestMapping(value="/insertBoard.do", method = RequestMethod.GET )
	@GetMapping ("/insertBoard.do") //4.3버전 이후에만 적용되는 것. 위의것이랑 똑같음.
	public String insertBoard(){
		//System.out.println("글 등록 화면 처리 작동");
		
		
		return "insertBoard";
	}
	
	
//insertBoard와 근본적으로 삽입이라는 액션이 같다. 따라서 이 경우, list에서 글쓰기로 이동하면 get방식으로 요청이 되고,
//get으로 들어가서 폼으로 전송받을때는 post방식이므로, method를 이용해서 같은 곳으로 이동한뒤 method를 통해 분류가 가능하다. 
//따라서 /insertBoardproc.do가 아닌 /insertBoard.do로 받아도 된다. 어짜피 method를 통해 분류가 되니까.
//insertBoardProc도 어짜피 액션이 같으므로 매서드 오버로딩으로 insertBoard를 사용할 수 있다.
//insertBoardProc는 response가 없고, 컨트롤러가 없어서 이제 throw Exception도 없어도 된다.
//-----------------------------------------------------------------------------------------	
//정보를 가져오는 setter 삭제. 
//전달받은 정보를 보고 BoardVO 자바빈이 전달받은 데이터를 보고 알아서 setter매서드에 넣어서 전달을 해줌.
//전송받은 데이터는 파라미터에 담겨서 오기 때문에 가능한 일. 
//조건은 폼에 담겨온 파라미터name과 자바빈(VO)에서 설정한 변수 이름이 같아야 한다. 
	
	
	//@RequestMapping(value="/insertBoard.do", method = RequestMethod.POST)
	@PostMapping("/insertBoard.do") //4.3버전 이후에만 적용되는 것. 위의것이랑 똑같음.
	public String insertBoard(BoardVO board){
		//System.out.println("글 등록 화면 처리 작동");
		
		//1. 사용자 입력 정보 추출.
		/* BoardVO board = new BoardVO(); */
		
		/*
		 * board.setTitle(request.getParameter("title")); //request에서 값을 꺼내와서 board
		 * settertitle에 저장 board.setWriter(request.getParameter("writer"));
		 * board.setContent(request.getParameter("content"));
		 */
		
		boardService.insertService(board);
		
		//리스트를 보여주게끔 하면 되는데 getBoardList.do를 만들었기 때문에 이걸 호출해서 돌아가게끔 하면 됨.
		
		/*
		 * ModelAndView mav = new ModelAndView();
		 * mav.setViewName("redirect:getBoardList.do");
		 */
		
		return "redirect:getBoardList.do" ;
	}

	
	@RequestMapping(value="/deleteBoard.do")
	public String deleteBoard(BoardVO board){ //자바빈 매개변수를 요청. 
		
		//System.out.println("글 삭제 처리 입장. 처리 전.");
		
		boardService.deleteService(board.getSeq()); //넘어온 Seq를 getter로 잡아서  비즈니스로직으로 보내주기.
		
		return "redirect:getBoardList.do";
	}
	
	//검색 조건 목록 설정
	//ModelAttribute : 매서드 위에 붙었을때 괄호 안에 이름을 붙여주면 괄호 안의 이름이 key, 리턴값을 value로 놓고 동작한다.
	// 왜냐하면 model이 값을 받을때 mav.addobject (key, value) 형식으로 받았기 때문이다.
	@ModelAttribute("conditionMap") 
	public Map<String, String> searchConditionMap() {			//리턴값은 conditionmap이므로 그 값을 리턴하고있다. 
			Map<String, String> conditionMap = new HashMap<String, String>();
		
		conditionMap.put("제목", "TITLE");
		conditionMap.put("내용", "CONTENT");
		
		return conditionMap;
	}
	
	
	//글 목록 검색 처리
	@RequestMapping(value="/getBoardList.do")
	public String getBoardList(BoardVO vo, Model model) { //커맨드객체에게 view와 controller에서 공유하는 객체를 공유하도록 요청.
		//vo를 수정하고 키워드와 단어를 getter setter 추가함. 
		
		//System.out.println("글 목록 검색 처리");
		
		//참조변수로 getServiceList 불러오기. 
		
		System.out.println("검색 조건 : " + vo.getSearchCondition());
		System.out.println("검색 단어 : " + vo.getSearchKeyword());
		
		if(vo.getSearchCondition() == null ) {
			vo.setSearchCondition("TITLE");
		}
		
		if(vo.getSearchKeyword() == null) {
			vo.setSearchKeyword("");
		} //키워드가 없을때 리스트를 불러올 경우 에러가 뜨지 않도록 디폴트값을 설정해줌. 
		
		//검색 기능이 추가됨에 따라서 조건에 따라 sql구문이 달라지므로 이것에 맞는 쿼리문을 전달해야한다. getServiceList(vo)
		List<BoardVO> list = boardService.getServiceList(vo); // 반환형 타입의 리스트로 읽어와라
		
		//모델을 입력으로 요청 받으면 된다. 
		model.addAttribute("boardList", list); //boardList와 list로 출력중이다. <c:forEach items="${boardList}" var="board"> 
		
		return "getBoardList";
	}

	
	
	
	@RequestMapping(value="/getBoard.do")
	public String getBoard(BoardVO board, Model model) {
		//System.out.println("GetBoardController 처리.");
		
		BoardVO vo = boardService.getService(board.getSeq());	//BoardVO에서 온 데이터 vo에 담아둠. 
		
		model.addAttribute("board", vo); //모델&뷰를 분해. 위에 모델로 받으면 알아서 스프링이 new로 만들어온다. 
		
		return "getBoard";
	}
	
	
	
	
	@RequestMapping(value="/updateBoard.do")
	public String updateBoardProc(@ModelAttribute("board") BoardVO vo) { //매개변수로만 요청 
		//System.out.println("글 수정 처리");
		
		/*
		 * String seq = request.getParameter("seq"); String title =
		 * request.getParameter("title"); String content =
		 * request.getParameter("content");
		 * 
		 * BoardVO board = new BoardVO();
		 * 
		 * board.setSeq(Integer.parseInt(seq)); board.setTitle(title);
		 * board.setContent(content);
		 */
		
		boardService.updateService(vo);
		
		/*
		 * ModelAndView mav = new ModelAndView();
		 * //mav.setViewName("redirect:getBoard.do?seq="+seq); mav.setViewName();
		 */
		
		return "redirect:getBoardList.do" ;
	}
	
}
