package muin.mvc.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import muin.mvc.model.dao.RecommendDAO;
import muin.mvc.model.dto.RecommendDTO;

@Service
public class RecommendServiceImpl implements RecommendService {
	
	@Autowired
	private RecommendDAO recommendDAO;
	
	@Override
	public int insertRecommend(RecommendDTO dto) {		
		return recommendDAO.insertRecommend(dto);
	}

}
