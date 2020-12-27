package com.example.demo.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Nvo;

//db처리하는구간
//@SuppressWarnings("unused")
public interface nDao extends JpaRepository<Nvo, Long> {

	@Query
	Nvo findByIdx(Long idx);

	@Query
	List<Nvo> findByContentsContainingIgnoreCaseOrTitleContainingIgnoreCase(String title, String contents);


	@Query
	public List<Nvo> findByTitleContainingIgnoreCase(String keyword);

	@Query
	public List<Nvo> findByWriterContainingIgnoreCase(String keyWord);



}
