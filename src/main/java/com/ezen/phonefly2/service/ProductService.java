package com.ezen.phonefly2.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.ListModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.phonefly2.dao.IMainDao;
import com.ezen.phonefly2.dao.IProductDao;
import com.ezen.phonefly2.dto.ColorVO;
import com.ezen.phonefly2.dto.ProductVO;
import com.ezen.phonefly2.dto.ReviewVO;
import com.ezen.phonefly2.dto.RplanVO;

@Service
public class ProductService {

	@Autowired
	IProductDao pdao;

	@Autowired
	IMainDao mdao;

	public HashMap<String, Object> getProduct(int pseq) {
		HashMap<String, Object> result = new HashMap<>();
		ProductVO pvo = pdao.getProduct(pseq);
		List<ColorVO> colorList = mdao.getColorList(pvo.getPseq());
		pvo.setColorList(colorList);
		List<RplanVO> rplanList = pdao.getRplanList();
		result.put("productVO", pvo);
		result.put("rplanList", rplanList);
		return result;
	}

	public List<ProductVO> getMfcList(String mfc) {
		List<ProductVO> mfcList = pdao.getMfcList(mfc);
		for (ProductVO pvo : mfcList) {
			List<ColorVO> colorList = mdao.getColorList(pvo.getPseq());
			pvo.setColorList(colorList);
		}
		return mfcList;
	}

	public int countOrderById(String id, int pseq) {
		return pdao.countOrderById(id, pseq);
	}

	public List<ReviewVO> getReviews(int pseq) {
		return pdao.getReviews(pseq);
	}

	public void productCompare(HashMap<String, Object> result) {
		List<Integer> pseqList = (List<Integer>)result.get("pseqList");
		List<ProductVO> productList = new ArrayList<>();
		int compareFlag = 1;
		if (pseqList != null) {
			for (Integer pseq : pseqList) {
				ProductVO pvo = pdao.getProduct(pseq);
				if (pvo != null) {
					List<ColorVO> colorList = mdao.getColorList(pseq);
					pvo.setColorList(colorList);
					if (pvo != null) {
						productList.add(pvo);
					}
				}
			}
		} else {
			compareFlag = 0;
			productList = pdao.getProductList();
			for (ProductVO pvo : productList) {
				List<ColorVO> colorList = mdao.getColorList(pvo.getPseq());
				pvo.setColorList(colorList);
			}
		}
		result.put("productList", productList);
		result.put("compareFlag", compareFlag);
	}

	public void reviewWrite(ReviewVO rvo) {
		pdao.writeReview(rvo);
	}

}
