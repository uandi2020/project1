package com.example.demo.function;

import java.util.ArrayList;


import org.springframework.ui.Model;



public class Paging {



	public int startRow;
	public int endRow;

	public void page(int total,String st,Model model){
		// total --> db의 row갯수 즉 list의 갯수

		int currpage=Integer.parseInt(st); // 1,2,3,4 ....
        model.addAttribute("c",currpage);

        int pagesize=10; //한 페이지당 보여지는 데이터의 갯수 지정
        int pageblock=5; //밑에서 보여줄 페이지 블럭

        int _끄트머리  = total%pagesize; //  int to=total%pagesize; <뒤에 짤리는 수 (끄트머리)> 페이지 사이즈에 따른 페이지 블럭 갯수
        if(_끄트머리 == 0) { 	//갯수가 만약 30개다 그러면 0
        	_끄트머리=0;
        }else { 				//갯수가 만약 23개다 그러면 1
        	_끄트머리=1;
        }
        int cnt = total / pagesize + _끄트머리; //  int cnt=total / pagesize + to; //최종으로 나오는 페이지 블럭 수
        //총페이지 갯수
        model.addAttribute("cnt",cnt); // 3


        //시작 끝 행 번호[db레코드 rownum)
        int startRow=(currpage - 1) * pagesize + 1; // currpage가 1일 때는 1-1*10+1 ; 2일 때는 2-1*10+1; 즉 다음페이지는 11로 넘어가서 20까지( 데이터 나눠서 select 하려고 파라미터로 넘겨주는 것)
        // startRow ~ 부터 currpage 기준으로 데이터를 몇번째부터 몇번째까지 가져오는 변수
        int endRow=currpage * pagesize; // ~까지 (endRow)
        //시작페이지
        int na=(currpage%pageblock); //1%5 =1;
        if(na==0) {
           na=1;
        }else {
           na=0;
        }

        int startpage=((currpage/pageblock) - na) * pageblock + 1; // 1
        //끝페이지
        int endpage=startpage +pageblock -1; //1
        if(endpage > cnt) {
           endpage=cnt;
        }
        model.addAttribute("endpage",endpage);
        //forEach문 들어갈 시작  끝
        int fs=pageblock-1;
        model.addAttribute("fs",fs);


        //[이전]
//        if(startpage > pageblock) {
//           int back=endpage-pageblock;
//           System.out.println(back);
//           model.addAttribute("back",back);
//           int yes=1;
//           model.addAttribute("startyes",yes);
//        }else {
//           int yes=0;
//           model.addAttribute("startyes",yes);
//        }


        //1~5
        int a=startpage;
        ArrayList<Integer> num= new ArrayList<Integer>();
        for(int i=startpage;i<=endpage;i++) {
           num.add(a);
           a++;
        }
        model.addAttribute("num",num);



        //[다음]
//        if(endpage<cnt) {
//           int nexts=startpage+pageblock;
//           model.addAttribute("nexts",nexts);
//           int no=1;
//           model.addAttribute("endno",no);
//        }else {
//           int no=0;
//           model.addAttribute("endno",no);
//        }
        this.startRow=startRow;
	    this.endRow=endRow;
	}


}
