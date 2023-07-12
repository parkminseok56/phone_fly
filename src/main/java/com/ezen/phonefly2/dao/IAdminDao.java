package com.ezen.phonefly2.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ezen.phonefly2.dto.BannerVO;
import com.ezen.phonefly2.dto.ColorVO;
import com.ezen.phonefly2.dto.EventVO;
import com.ezen.phonefly2.dto.MemberVO;
import com.ezen.phonefly2.dto.NoticeVO;
import com.ezen.phonefly2.dto.OrderDetailVO;
import com.ezen.phonefly2.dto.ProductVO;
import com.ezen.phonefly2.dto.QnaVO;
import com.ezen.phonefly2.util.Paging;

@Mapper
public interface IAdminDao {

	String getPwd(String workId);

	int getAllCount(String string, String string2, String key);

	List<ProductVO> listProduct(Paging paging, String key);

	List<MemberVO> listMember(Paging paging, String key);

	List<QnaVO> listQna(Paging paging, String key);

	List<NoticeVO> listNotice(Paging paging, String key);

	List<EventVO> listEvent(Paging paging, String key);

	List<OrderDetailVO> listOrder(Paging paging, String key);

	List<BannerVO> getBannerList();
	
	void insertBanner(HashMap<String, Object> paramMap);
	
	void updateSeq(int changeval, String useyn, int bseq);

	void deleteBanner(int bseq);

	void qnaReply(int qseq, String reply);

	void insertProduct(ProductVO productvo);

	void insertColor(HashMap<String, Object> paramMap);
	
	int getAllCountColor(String string, String string2, String key, int pseq);

	List<ColorVO> listColor(int pseq);

	BannerVO getBanner(int bseq);

  void deleteProduct(int pseq);

	void updateProduct(ProductVO pvo);

	ColorVO getColor(int cseq);

	void updateColor(ColorVO cvo);

  void updateBanner(BannerVO bannervo);

  void deleteColor(int cseq);

}
