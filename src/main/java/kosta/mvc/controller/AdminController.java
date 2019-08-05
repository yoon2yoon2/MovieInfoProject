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
//   �������� : �ڷ�� �̿��� �ݵ�� �α��� �� ����ڸ� ���� ����.
	@Autowired
	private MovieService movieService;
	private String path = "C:\\Edu\\Spring\\SaveFile";
	
	/**
	 * ��� ��
	 * */
	   @RequestMapping("/write")
	    public void write(HttpSession session){
	        
	     
	    }
	   
		/**
		 * ��� �ϱ�
		 * */
		   @RequestMapping("/insert")
		    public String insert(HttpSession session,MovieDTO dto)throws IOException{
			   MultipartFile file = dto.getFile();
			   if(file.getSize()>0) {//������ ÷�εǾ��ٸ� . . 
				   String fileName= file.getOriginalFilename();
				   long fileSize = file.getSize();
				   
				   dto.setFname(fileName);
				   dto.setFsize(fileSize);
				   
				   //��������
				   file.transferTo(new File(path+"/"+fileName));
			   }
			   movieService.insert(dto);
		        
		        return "redirect:list";
		    }


	/**
	 * �˻�
	 * */

		
		@RequestMapping("/list")
		public void selectAll(HttpSession session, Model model) {
			List<MovieDTO> list = movieService.selectAll();
			model.addAttribute("list", list);
		}
		
	

	
	
	/**
	 * �󼼺���
	 * */
	@RequestMapping("/read/{modelNum}")
		public ModelAndView read(HttpSession session,@PathVariable String modelNum){
		MovieDTO elecDTO =movieService.selectByModelNum(modelNum, true);
		return new ModelAndView("board/read", "elec",elecDTO); //setViewName���ص��Ǵϱ�
	}
		
	
	/**
	 * �ٿ�ε��ϱ�
	 * */
	@RequestMapping("/down")
	public ModelAndView down(HttpSession session,String fname) {
		File file =new File(path+"/"+fname);
		return new ModelAndView("downLoadView", "fname", file);
	}
	
	/**
	 * ������
	 * */
	@RequestMapping("/updateForm")
	  public ModelAndView updateForm(HttpSession session,String modelNum) {
		  MovieDTO elecDTO =movieService.selectByModelNum(modelNum, false);
		  
		  return new ModelAndView("board/update", "elec", elecDTO);
				  
	  }
	
	/**
	 * �����ϱ�
	 * */
	@RequestMapping("/update")
	public ModelAndView update(HttpSession session,MovieDTO dto) {
		movieService.update(dto);
		//���������� read.jsp�̵��ϱ����� �Խù� �˻�
	//	MovieDTO dbDTO =movieService.selectByModelNum(dto.getMovieNo(), false);
		return null;// new ModelAndView("board/read","elec",dbDTO);
	}
	
	/**
	 * �����ϱ�
	 * */
	@RequestMapping("/delete")
	public String delete(HttpSession session,String modelNum, String password){
		movieService.delete(modelNum, password);
		return "redirect:list";
	}
}
