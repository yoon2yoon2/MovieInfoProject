package kosta.mvc.model.dao;

import java.util.List;

import kosta.mvc.model.dto.MovieDTO;





public interface MovieDAO{
	/**
	  * ���ڵ� ��ü �˻�
	  * */
	  List<MovieDTO> selectAll() ;
	  
	  /**
		  * �𵨹�ȣ�� �ش��ϴ� ���ڵ� �˻�
		  * */
	  MovieDTO selectByModelNum(String modelNum) ;
	  
	  /**
	   * �𵨹�ȣ�� �ش��ϴ� ���ڵ� ��ȸ�� �����ϱ�
	   * */
	  int readnumUpdate(String modelNum);
	  
	/**
	 * ���ڵ� ����
	 * */
	  int insert(MovieDTO electronics);
	  
	  /**
	   * �𵨹�ȣ�� �ش��ϴ� ���ڵ� ����
	   * */
	   int delete(String modelNum, String password);
	  
	   /**
	    * �𵨹�ȣ�� �ش��ϴ� ���ڵ� ����
	    * */
	   int update(MovieDTO electronics);

}
