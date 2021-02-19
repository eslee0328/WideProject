package com.wide.board.dao;

import java.util.List;

import com.wide.board.dto.BoardDTO;

public interface BoardDAO {

	// 글 작성
	public void insertBoard(BoardDTO vo);
	
	// 글 수정
	public void updateBoard(BoardDTO vo);
	
	// 글 삭제
	public void deleteBoard(BoardDTO vo);
	
	// 글 상세
	public BoardDTO getBoard(BoardDTO vo);
	
	// 글 목록 조회
	public List<BoardDTO> getBoardList(BoardDTO vo);
	
	// 글 조회수 증가
	public void plusCnt(BoardDTO vo);
	
}
