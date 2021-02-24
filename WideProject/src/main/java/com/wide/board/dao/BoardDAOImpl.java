package com.wide.board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wide.board.dto.BoardDTO;

@Repository("boardDAO")
public class BoardDAOImpl implements BoardDAO{

	@Autowired  
	private SqlSessionTemplate mybatis;

	public void insertBoard(BoardDTO vo) throws Exception {
		System.out.println("===> insertBoard() 호출");
		mybatis.insert("BoardDAO.insertBoard", vo);
	}

	@Override
	public void updateBoard(BoardDTO vo) {
		System.out.println("===> updateBoard() 호출");
		mybatis.update("BoardDAO.updateBoard", vo);
	}

	@Override
	public void deleteBoard(BoardDTO vo) {
		System.out.println("===> deleteBoard() 호출");
		mybatis.delete("BoardDAO.deleteBoard", vo);
	}

	public BoardDTO getBoard(BoardDTO vo) {
		System.out.println("===> getBoard() 호출");
		return mybatis.selectOne("BoardDAO.getBoard", vo);
	}

	public List<BoardDTO> getBoardList(BoardDTO vo) throws Exception {
		System.out.println("===> getBoardList() 호출");
		return mybatis.selectList("BoardDAO.getBoardList", vo);
	}
	
	
	public void plusCnt(BoardDTO vo) {
		System.out.println("===> plusCnt() 호출");
		mybatis.update("BoardDAO.plusCnt", vo);
	}
}