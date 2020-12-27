package com.example.demo.controller;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Nvo;
import com.example.demo.function.Paging;
import com.example.demo.service.nService;



@Controller
public class nController {

	@Autowired
	nService service;


	@GetMapping("/list")
	public String noticeList(Model model) {
		List<Nvo> list = service.getList();
		model.addAttribute("list",list);
		return "list";
	}

	@GetMapping("/list.do")
	public String Search(Model model,
			Pageable pageable,
			@RequestParam(value="keyWord") String keyWord,
			@RequestParam(value="searchType") String searchType) throws Exception {

		System.out.println("keyWord"+keyWord);
		System.out.println("searchType"+searchType);

		switch (searchType) {
      case "01":
//         Page = Service.findByTitleContainingIgnoreCase(searchKeyWord , pageable);
    	  List<Nvo> title = service.findByTitleContainingIgnoreCase(keyWord);
    	  model.addAttribute("list", title);
         break;
      case "02":
//         Page = Service.findByEventContentsContainingIgnoreCase(searchKeyWord , pageable);
    	  List<Nvo> writer = service.findByWriterContainingIgnoreCase(keyWord);
    	  model.addAttribute("list", writer);
    	  break;
      default:
         throw new Exception("�삱諛붾Ⅴ吏� �븡�� �젒洹쇱엯�땲�떎.");
      }

		List<Nvo> title = service.findByTitleContainingIgnoreCase(keyWord);
		List<Nvo> writer = service.findByWriterContainingIgnoreCase(keyWord);



		System.out.println("keWord"+keyWord);

		return "list";
	}

	@GetMapping("/write.do")
	public String write() {
		return "write";
	}

	@PostMapping("/write.do")
	public String save(@RequestPart MultipartFile files, Nvo nvo) {
		try {
			Nvo file = new Nvo();
			String sourceFileName = files.getOriginalFilename();
	        		String sourceFileNameExtension = FilenameUtils.getExtension(sourceFileName).toLowerCase();
	        		File destinationFile;
	        		String destinationFileName;
	        		String fileUrl = "D:/tmp/e4.17/src/main/resources/static/images/";

	        		do {
	            			destinationFileName = RandomStringUtils.randomAlphanumeric(32) + "." + sourceFileNameExtension;
	            			destinationFile = new File(fileUrl + destinationFileName);

	        		} while (destinationFile.exists());

	        		destinationFile.getParentFile().mkdirs();
	        		files.transferTo(destinationFile);

	        		file.setFilename(destinationFileName);
	        		file.setFileOriName(sourceFileName);
	        		file.setFileurl(fileUrl);
	        		file.setContents(nvo.getContents());
	        		file.setTitle(nvo.getTitle());

	        		service.save(file);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return "redirect:/list";
	}

//	@RequestMapping("/delete/{idx}")
//	public String delete(@PathVariable Long idx, Model model) {
//		Nvo nvo = service.findByIdx(idx);
//		model.addAttribute("list", nvo);
//		return "redirect:/list";
//	}

	@RequestMapping("/detail/{idx}")
	public String detail(@PathVariable Long idx, Model model) {
		Nvo nvo = service.getByIdx(idx);
		model.addAttribute("list", nvo);
		return "detail";
	}

	@RequestMapping("/update")
	public String update(Nvo nvo) {
		nvo.setWriter("이승미");
		service.save(nvo);
		return "redirect:/list";
	}


}
