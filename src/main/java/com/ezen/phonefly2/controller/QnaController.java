package com.ezen.phonefly2.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ezen.phonefly2.dto.MemberVO;
import com.ezen.phonefly2.dto.QnaVO;
import com.ezen.phonefly2.service.QnaService;
import com.ezen.phonefly2.util.Paging;

@Controller
public class QnaController {
	// 다시 작성 : bhs

	@Autowired
	QnaService qs;

	@RequestMapping("qnaList")
	public ModelAndView qnaList(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO)session.getAttribute("loginUser");
		String url = "member/loginForm";
		if(mvo != null) {
			HashMap<String, Object> result = new HashMap<>();
			result.put("id", mvo.getId());
			result.put("request", request);
			qs.qnaList(result);
			mav.addObject("qnaList", (List<QnaVO>)result.get("qnaList"));
			mav.addObject("paging", (Paging)result.get("paging"));
			url = "qna/qnaList";
		}
		mav.setViewName(url);
		return mav;
	}

	@RequestMapping("/qnaDetail")
	public ModelAndView qnaView(HttpServletRequest request, @RequestParam("qseq") int qseq) {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO) session.getAttribute("loginUser");
		String url = "member/loginForm";
		if (mvo != null) {
			mav.addObject("qnaVO", qs.getQna(qseq));
			url = "qna/qnaDetail";
		}
		mav.setViewName(url);
		return mav;
	}

	@RequestMapping("/qnaWriteForm")
	public String qnaWriteForm(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO)session.getAttribute("loginUser");
		String url = "member/loginForm";
		if (mvo != null) {
			url = "qna/qnaWriteForm";
		}
		return url;
	}

	@PostMapping("/qnaWrite")
	public ModelAndView qnaWrite(@ModelAttribute("dto") QnaVO qvo, HttpServletRequest request) {
		HttpSession session = request.getSession();
		ModelAndView mav = new ModelAndView();
		MemberVO mvo = (MemberVO) session.getAttribute("loginUser");
		String url = "member/loginForm";
		if (mvo != null) {
			qvo.setId(mvo.getId());
			qs.qnaWrite(qvo);
			url = "redirect:/qnaList";
		}
		mav.setViewName(url);
		return mav;
	}

	@RequestMapping("/qnaUpdateform")
	public String qnaUpdateform(@RequestParam("qseq") int qseq, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO)session.getAttribute("loginUser");
		String url = "member/loginForm";
		if (mvo != null) {
			QnaVO qvo = qs.getQna(qseq);
			model.addAttribute("qvo", qvo);
			url = "qna/qnaUpdateForm";
		}
		return url;
	}

	@PostMapping("/qnaUpdate")
	public ModelAndView qnaUpdate(@ModelAttribute("dto") QnaVO qvo, BindingResult result, HttpServletRequest request) {
		HttpSession session = request.getSession();
		ModelAndView mav = new ModelAndView();
		MemberVO mvo = (MemberVO)session.getAttribute("loginUser");
		String url = "member/loginForm";
		if (mvo != null) {
			qvo.setId(mvo.getId());
			qs.qnaUpdate(qvo);
			url = "redirect:/qnaList";
		}
		mav.setViewName(url);
		return mav;
	}

	@RequestMapping("/qnaDelete")
	public String qnaDelete(@RequestParam("qseq") int qseq, HttpServletRequest request) {
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO) session.getAttribute("loginUser");
		String url = "member/login";
		if (mvo != null) {
			qs.qnaDelete(qseq);
			url = "redirect:/qnaList";
		}
		return url;
	}
}
