package kosta.mvc.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kosta.mvc.model.movie.dto.MovieDTO;
import kosta.mvc.model.movie.service.MovieService;


@Controller
@RequestMapping("")
public class AdminController {
//   전제조건 : 자료실 이용은 반드시 로그인 된 사용자만 접근 가능.
	@Autowired
	private MovieService movieService;
	private String path = "C:\\Edu\\Spring\\SaveFile";
	
	/**
	 * 등록 폼
	 * */
	   @RequestMapping("/write")
	    public void write(HttpSession session){
	        
	     
	    }
	   
		/**
		 * 등록 하기
		 * */
		   @RequestMapping("/insert")
		    public String insert(HttpSession session,MovieDTO dto)throws IOException{
			   MultipartFile file = dto.getFile();
			   if(file.getSize()>0) {//파일이 첨부되었다면 . . 
				   String fileName= file.getOriginalFilename();
				   long fileSize = file.getSize();
				   
				   dto.setFname(fileName);
				   dto.setFsize(fileSize);
				   
				   //파일저장
				   file.transferTo(new File(path+"/"+fileName));
			   }
			   movieService.insert(dto);
		        
		        return "redirect:list";
		    }


	/**
	 * 검색
	 * */

		
		@RequestMapping("/list")
		public void selectAll(HttpSession session, Model model) {
			List<MovieDTO> list = movieService.selectAll();
			model.addAttribute("list", list);
		}
		
	

	
	
	/**
	 * 상세보기
	 * */
	@RequestMapping("/read/{modelNum}")
		public ModelAndView read(HttpSession session,@PathVariable String modelNum){
		MovieDTO elecDTO =movieService.selectByModelNum(modelNum, true);
		return new ModelAndView("board/read", "elec",elecDTO); //setViewName안해도되니까
	}
		
	
	/**
	 * 다운로드하기
	 * */
	@RequestMapping("/down")
	public ModelAndView down(HttpSession session,String fname) {
		File file =new File(path+"/"+fname);
		return new ModelAndView("downLoadView", "fname", file);
	}
	
	/**
	 * 수정폼
	 * */
	@RequestMapping("/updateForm")
	  public ModelAndView updateForm(HttpSession session,String modelNum) {
		  MovieDTO elecDTO =movieService.selectByModelNum(modelNum, false);
		  
		  return new ModelAndView("board/update", "elec", elecDTO);
				  
	  }
	
	/**
	 * 수정하기
	 * */
	@RequestMapping("/update")
	public ModelAndView update(HttpSession session,MovieDTO dto) {
		movieService.update(dto);
		//성공했으니 read.jsp이동하기전에 게시물 검색
	//	MovieDTO dbDTO =movieService.selectByModelNum(dto.getMovieNo(), false);
		return null;// new ModelAndView("board/read","elec",dbDTO);
	}
	
	/**
	 * 삭제하기
	 * */
	@RequestMapping("/delete")
	public String delete(HttpSession session,String modelNum, String password){
		movieService.delete(modelNum, password);
		return "redirect:list";
	}
}
