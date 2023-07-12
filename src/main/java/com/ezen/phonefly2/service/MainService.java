package com.ezen.phonefly2.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.phonefly2.dao.IMainDao;
import com.ezen.phonefly2.dto.BannerVO;
import com.ezen.phonefly2.dto.ColorVO;
import com.ezen.phonefly2.dto.ProductVO;

@Service
public class MainService {

	@Autowired
	IMainDao mdao;

	public void getMainProduct(HashMap<String, Object> result) {
		// author : bhs
		List<ProductVO> mainBestList = mdao.getBestList();
		for (ProductVO pvo : mainBestList) {
			List<ColorVO> colorList = mdao.getColorList(pvo.getPseq());
			pvo.setColorList(colorList);
		}
		List<ProductVO> mainEventList = mdao.getEventList();
		for (ProductVO pvo : mainEventList) {
			List<ColorVO> colorList = mdao.getColorList(pvo.getPseq());
			pvo.setColorList(colorList);
		}
		List<BannerVO> bannerList = mdao.getBannerList();
		result.put("mainBestList", mainBestList);
		result.put("mainEventList", mainEventList);
		result.put("bannerList", bannerList);
	}
}
