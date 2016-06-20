package com.test.service.translate;

import com.test.dto.translate.DailySentence;
import com.test.dto.translate.KingTran;
import com.test.dto.translate.Youdao;

public interface TranslateService {

	/**
	 * 有道翻译
	 * 
	 * @param content
	 * @return
	 * @throws Exception
	 */
	public Youdao youdao(String content) throws Exception;

	/**
	 * 金山翻译
	 * 
	 * @param content
	 * @throws Exception
	 */
	public KingTran kingTranslate(String content) throws Exception;

	/**
	 * 金山 每日一句
	 */
//	public DailySentence icibaEveryDay(String date) throws Exception;

	/**
	 * 金山 每日一句
	 */
	public DailySentence icibaEveryDay_image(String date) throws Exception;

	/**
	 * 金山 每日一句
	 */
	public DailySentence icibaEveryDay_content(String date) throws Exception;

	/**
	 * 金山 每日一句
	 */
	public DailySentence icibaEveryDay_image2(String date) throws Exception;
}
