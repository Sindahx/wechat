package com.test.util;

public class ReplaceString {

	public static String replace(String jieguo){
		
		if (jieguo.contains("int.")) { //感叹词,Interjections (int.) 代替名词、数词、形容词等 oh,hello,hi,yeah 
			jieguo = jieguo.replace("int.", "\nint.");
		}
		if (jieguo.contains("n.")) { //名词,Nouns (n.) 表示人或事物的名称 box,pen,tree,apple 
			jieguo = jieguo.replace("n.", "\nn.");
		}
		if (jieguo.contains("vt.")) { //vt.是及物动词,vt.后必须跟宾语：sing a song 
			jieguo = jieguo.replace("vt.", "\nvt.");
		}
		if (jieguo.contains("vi.")) { //vi.是不及物动词,vi.后不直接带宾语或不带宾语:jump high
			jieguo = jieguo.replace("vi.", "\nvi.");
		}
		if (jieguo.contains("aux.")) { //aux.v = 助动词 ,auxiliary的缩写 
			jieguo = jieguo.replace("aux.", "\naux.");
		}
		if (jieguo.contains("adv.")) { //副词,Adverbs（adv.) 修饰动、形、副等词,表示动作特征 there,widely,suddenly
			jieguo = jieguo.replace("adv.", "\nadv.");
		}
		if (jieguo.contains("adj.")) { //形容词,Adjectives(adj.) 用来修饰名词,表示人或事物的特征 good,sad,high,short 
			jieguo = jieguo.replace("adj.", "\nadj.");
		}
		if (jieguo.contains("pron.")) { //代词,Pronouns (pron.)代替名词、数词、形容词We,this,them,myself 
			jieguo = jieguo.replace("pron.", "\npron.");
		}
		if (jieguo.contains("num.")) { //数词,Numerals(num.)表示数目或顺序 one,two,first 
			jieguo = jieguo.replace("num.", "\nnum.");
		}
		if (jieguo.contains("art.")) { //冠词,Articles (art.) 用在名词前,帮助说明名词所指的范围 a,an,the 
			jieguo = jieguo.replace("art.", "\nart.");
		}
		if (jieguo.contains("prep.")) { //介词,Prepositions (prep.) 用在名词或代词前,说明它与别的词的关系 in,on,down,up
			jieguo = jieguo.replace("prep.", "\nprep.");
		}
		if (jieguo.contains("conj.")) { //连词,Conjunctions (conj.) 表示人或事物的名称if,because,but 
			jieguo = jieguo.replace("conj.", "\nconj.");
		}
		if (jieguo.contains("interj.")) { //感叹词
			jieguo = jieguo.replace("interj.", "\ninterj.");
		}
		
		//动词,Verb (v.) 表示动作或状态 Jump,sing,visit 
		if (jieguo.contains("复数:")) {
			jieguo = jieguo.replace("复数:", "\n复数:");
		}
		if (jieguo.contains("过去式:")) {
			jieguo = jieguo.replace("过去式:", "\n过去式:");
		}
		if (jieguo.contains("过去分词:")) {
			jieguo = jieguo.replace("过去分词:", "\n过去分词:");
		}
		if (jieguo.contains("现在分词:")) {
			jieguo = jieguo.replace("现在分词:", "\n现在分词:");
		}
		if (jieguo.contains("第三人称单数:")) {
			jieguo = jieguo.replace("第三人称单数:", "\n第三人称单数:");
		}
		if (jieguo.contains("比较级:")) {
			jieguo = jieguo.replace("比较级:", "\n比较级:");
		}
		if (jieguo.contains("最高级:")) {
			jieguo = jieguo.replace("最高级:", "\n最高级:");
		}
		
		return jieguo;
	}
}
