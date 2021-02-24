package com.wide.board.service;

import java.util.List;

import com.wide.board.dto.BoardDTO;

public interface BoardService {

	// 글 등록
	void insertBoard(BoardDTO vo) throws Exception;
	
	// 글 수정
	void updateBoard(BoardDTO vo);

	// 글 삭제
	void deleteBoard(BoardDTO vo);

	// 글 상세 조회
	BoardDTO getBoard(BoardDTO vo);

	// 글 목록 조회
	List<BoardDTO> getBoardList(BoardDTO vo) throws Exception;
	
	// 조회수
	void plusCnt(BoardDTO vo);

}
