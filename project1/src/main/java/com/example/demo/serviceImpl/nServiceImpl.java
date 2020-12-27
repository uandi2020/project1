package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.nDao;
import com.example.demo.entity.Nvo;
import com.example.demo.function.Paging;
import com.example.demo.service.nService;


@Service
public class nServiceImpl implements nService {

	@Autowired
	private nDao ndao;

	@Override
	public List<Nvo> getList() {
		// TODO Auto-generated method stub
		return ndao.findAll();
	}
//
//	@Override
//	public ModelAndView getList(int total) {
//		Sort sort = Sort.by(Direction.DESC,"idx");
//		int size = 10;
//		Pageable pageable = PageRequest.of(total-1, size, sort);
//
//		Page<Nvo> paging = ndao.findAll(pageable);
//		List<Nvo> list = paging.getContent();
//
//		Paging p = new Paging();
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("list",list);z
//		mv.addObject("page",p);
//		return mv;
//	}






	@Override
	public void save(Nvo nvo) {

		// TODO Auto-generated method stub
//		Nvo n = new Nvo();
//		n.setImgName(nvo.getImgName());
//		n.setImgOriName(nvo.getImgOriName());
//		n.setImgUrl(nvo.getImgUrl());
		ndao.save(nvo);
	}

	@Override
	public Nvo getByIdx(long idx) {
		// TODO Auto-generated method stub
		return ndao.findByIdx(idx);
	}
	//idx를 가져와서 보기위함이고

	@Override
	public Nvo findByIdx(long idx) {
		// TODO Auto-generated method stub
		Nvo nvo = ndao.findByIdx(idx);
		return nvo;
	}


	@Override
	public void update(Nvo nvo) {
		// TODO Auto-generated method stub
		ndao.findByIdx(nvo.getIdx()); //아이디를 찾아와서
		ndao.save(nvo);	// entity를 저장
	}
	//idx를 찾아서 데이터를 수정해줄것이기 때문에 entity를 매개변수로 받은것임

	@Override
	public void deleteByIdx(long idx) {
		// TODO Auto-generated method stub
		ndao.deleteById(idx);
	}


	@Override
	public List<Nvo> findByTitleContainingIgnoreCase(String keyword) {
		// TODO Auto-generated method stub
		return ndao.findByTitleContainingIgnoreCase(keyword);
	}



	@Override
	public List<Nvo> findByWriterContainingIgnoreCase(String keyWord) {
		// TODO Auto-generated method stub
		return ndao.findByWriterContainingIgnoreCase(keyWord);
	}





}
