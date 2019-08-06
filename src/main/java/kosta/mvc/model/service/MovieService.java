package kosta.mvc.model.service;

import java.util.List;

import kosta.mvc.model.dto.MovieDTO;





public interface MovieService {
	/**
	  * 레코드 전체 검색
	  * */
	  List<MovieDTO> selectAll() ;
	  
	  /**
		  * 모델번호에 해당하는 레코드 검색
		  * @param: state true이면 조회수증가, false이면 조회증가안함.
		  * */
	  MovieDTO selectByModelNum(String modelNum , boolean state) ;
	  
	 
	  
	/**
	 * 레코드 삽입
	 * */
	  int insert(MovieDTO movieDto);
	  
	  /**
	   * 모델번호에 해당하는 레코드 삭제
	   * */
	   int delete(String modelNum, String password);
	  
	   /**
	    * 모델번호에 해당하는 레코드 수정
	    * */
	   int update(MovieDTO movieDto);
}
