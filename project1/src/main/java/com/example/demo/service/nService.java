package com.example.demo.service;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Nvo;


public interface nService {
    //껍데기 ->실질적인 코딩은 impl q
	public List<Nvo> getList();

//	public void save(Nvo nvo);

	public Nvo getByIdx(long idx);

	public Nvo findByIdx(long idx);

	public void update(Nvo nvo);

	public void deleteByIdx(long idx);

	public void save(Nvo nvo);


	public List<Nvo> findByTitleContainingIgnoreCase(String keyword);

	public List<Nvo> findByWriterContainingIgnoreCase(String keyWord);









}
