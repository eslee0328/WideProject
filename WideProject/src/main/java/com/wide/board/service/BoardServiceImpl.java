package com.wide.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wide.board.dao.BoardDAOImpl;
import com.wide.board.dto.BoardDTO;
import com.wide.board.dto.PageDTO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDAOImpl boardDAO;
	
	public void insertBoard(BoardDTO vo) throws Exception {
		boardDAO.insertBoard(vo);
	}
	
	// 글 수정
	public void updateBoard(BoardDTO vo) {
		boardDAO.updateBoard(vo);
	}

	// 글 삭제
	public void deleteBoard(BoardDTO vo) {
		boardDAO.deleteBoard(vo);
	}
	
	// 글 상세
	public BoardDTO getBoard(BoardDTO vo) {
		return boardDAO.getBoard(vo);
	}
	
	// 글 목록
	public List<BoardDTO> getBoardList(BoardDTO vo) throws Exception {
		return boardDAO.getBoardList(vo);
	}
	
	// 글 조회수
	public void plusCnt(BoardDTO vo) {
		boardDAO.plusCnt(vo);
	}
	
	@Override
	public int countBoard() {
		return boardDAO.countBoard(null);
	}

	@Override
	public List<BoardDTO> selectBoard(PageDTO vo) {
		return boardDAO.selectBoard(vo);
	}

}
