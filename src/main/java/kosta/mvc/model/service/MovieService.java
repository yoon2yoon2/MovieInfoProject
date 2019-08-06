package kosta.mvc.model.service;

import java.util.List;

import kosta.mvc.model.dto.MovieDTO;





public interface MovieService {
	/**
	  * ���ڵ� ��ü �˻�
	  * */
	  List<MovieDTO> selectAll() ;
	  
	  /**
		  * �𵨹�ȣ�� �ش��ϴ� ���ڵ� �˻�
		  * @param: state true�̸� ��ȸ������, false�̸� ��ȸ��������.
		  * */
	  MovieDTO selectByModelNum(String modelNum , boolean state) ;
	  
	 
	  
	/**
	 * ���ڵ� ����
	 * */
	  int insert(MovieDTO movieDto);
	  
	  /**
	   * �𵨹�ȣ�� �ش��ϴ� ���ڵ� ����
	   * */
	   int delete(String modelNum, String password);
	  
	   /**
	    * �𵨹�ȣ�� �ش��ϴ� ���ڵ� ����
	    * */
	   int update(MovieDTO movieDto);
}
