package kosta.mvc.model.movie.dao;

import java.util.List;

import kosta.mvc.model.movie.dto.MovieDTO;



public interface MovieDAO{
	/**
	  * 레코드 전체 검색
	  * */
	  List<MovieDTO> selectAll() ;
	  
	  /**
		  * 모델번호에 해당하는 레코드 검색
		  * */
	  MovieDTO selectByModelNum(String modelNum) ;
	  
	  /**
	   * 모델번호에 해당하는 레코드 조회수 증가하기
	   * */
	  int readnumUpdate(String modelNum);
	  
	/**
	 * 레코드 삽입
	 * */
	  int insert(MovieDTO electronics);
	  
	  /**
	   * 모델번호에 해당하는 레코드 삭제
	   * */
	   int delete(String modelNum, String password);
	  
	   /**
	    * 모델번호에 해당하는 레코드 수정
	    * */
	   int update(MovieDTO electronics);

}
