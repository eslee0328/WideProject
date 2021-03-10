package com.wide.board.dao;

import java.util.List;

import com.wide.board.dto.BoardDTO;
import com.wide.board.dto.PageDTO;

public interface BoardDAO {

	// 글 작성
	public void insertBoard(BoardDTO vo) throws Exception;
	
	// 글 수정
	public void updateBoard(BoardDTO vo);
	
	// 글 삭제
	public void deleteBoard(BoardDTO vo);
	
	// 글 상세
	public BoardDTO getBoard(BoardDTO vo);
	
	// 글 목록 조회
	public List<BoardDTO> getBoardList(BoardDTO vo) throws Exception;
	
	// 글 조회수 증가
	public void plusCnt(BoardDTO vo);
	
	// 게시물 총 갯수
	public int countBoard(PageDTO vo);

	// 페이징 처리 게시글 조회
	public List<BoardDTO> selectBoard(PageDTO vo);
	
}
