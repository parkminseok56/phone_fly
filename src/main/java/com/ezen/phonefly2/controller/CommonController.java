package com.ezen.phonefly2.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ezen.phonefly2.dto.EventVO;
import com.ezen.phonefly2.dto.NoticeVO;
import com.ezen.phonefly2.service.CommonService;
import com.ezen.phonefly2.util.Paging;

@Controller
public class CommonController {
	// 다시작성 : bhs

	@Autowired
	CommonService cs;

	@RequestMapping("/intro")
	public String intro() {
		return "guide/intro";
	}

	@RequestMapping("/noticeList")
	public ModelAndView noticeList(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		HashMap<String, Object> result = new HashMap<>();
		result.put("request", request);
		cs.getNoticeList(result);
		mav.addObject("noticeList", (List<NoticeVO>)result.get("noticeList"));
		mav.addObject("paging", (Paging)result.get("paging"));
		mav.setViewName("notice/noticeList");
		return mav;
	}

	@RequestMapping("/noticeDetail")
	public ModelAndView noticeDetail(@RequestParam("nseq") int nseq) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("noticeVO", cs.getNotice(nseq));
		mav.setViewName("notice/noticeDetail");
		return mav;
	}

	@RequestMapping("/eventList")
	public ModelAndView eventList(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		HashMap<String, Object> result = new HashMap<>();
		result.put("request", request);
		cs.getEventList(result);
		mav.addObject("eventList", (List<EventVO>)result.get("eventList"));
		mav.addObject("paging", (Paging) result.get("paging"));
		mav.setViewName("event/eventList");
		return mav;
	}

	@RequestMapping("/eventDetail")
	public ModelAndView eventDetail(@RequestParam("eseq") int eseq) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("eventVO", (EventVO)cs.getEvent(eseq));
		mav.setViewName("event/eventDetail");
		return mav;
	}

	@RequestMapping("/FAQList")
	public String faqList() {
		return "faq/faq";
	}

	@RequestMapping("/guide1")
	public String guide1() {
		return "guide/guide1";
	}

	@RequestMapping("/guide2")
	public String guide2() {
		return "guide/guide2";
	}

	@RequestMapping("/guide3")
	public String guide3() {
		return "guide/guide3";
	}
}
