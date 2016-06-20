/**
 * @ClassName UploadUtil
 * @Description TODO
 * @Author dairong
 * @Date 2015-12-8下午04:14:17
 * <p></p>
 * 
 */
package com.test.util;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName UploadUtil
 * @Description TODO
 * @Author dairong
 * @Date 2015-12-8下午04:14:17
 * <p>上传图片工具类</p>
 */
public class UploadUtil {
	
	public static final String SEPARATOR = File.separator;
	
	public static final String ROOT_PATH = "picture";  // 保存咨询图片 根路径
	
	/**
	 * 36个小写字母和数字
	 */
	public static final char[] N36_CHARS = { '0', '1', '2', '3', '4', '5', '6',
			'7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
			'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
			'x', 'y', 'z' };
	
	/**
	 * 日期格式化对象
	 */
	public static final DateFormat MONTH_FORMAT = new SimpleDateFormat(
			"/yyyyMM/ddHHmmss");
	
	public static final DateFormat YEAR_MONTH_TIME_FORMAT = new SimpleDateFormat(
			"yyyyMMddHHmmss");
	
	public static final DateFormat YEAR_MONTH_FORMAT = new SimpleDateFormat(
	"yyyyMM");
//	
//	/**
//	 * <p>生成文件名称	path+"/201512/08171718gauo"+"."+ext</p> 
//	 * @param path
//	 * @param ext
//	 * @return
//	 */
//	public static String generateFilename(String path, String ext) {
//		return path + MONTH_FORMAT.format(new Date())
//				+ RandomStringUtils.random(4, N36_CHARS) + "." + ext;
//	}
//	
//	/**
//	 * <p>生成文件名称	"20151208171718gauo"+"."+ext</p> 
//	 * @param path
//	 * @param ext
//	 * @return
//	 */
//	public static String generateFilename(String ext) {
//		return YEAR_MONTH_TIME_FORMAT.format(new Date())
//				+ RandomStringUtils.random(4, N36_CHARS) + "." + ext;
//	}
//	
//	/**
//	 * <p>生成年月格式  201512</p> 
//	 * @return
//	 */
//	public static String generateMonthname() {
//		return YEAR_MONTH_FORMAT.format(new Date());
//	}
//	
//	/**
//	 * <p>检测文件夹是否存在	不存在则新建</p> 
//	 * @param dir
//	 */
//	public static void checkDirAndCreate(File dir) {
//		if (!dir.exists())
//			dir.mkdirs();
//	}
//	
//	/**
//	 * <p>检测文件名是否包含多个.</p> 
//	 * @param filename
//	 * @return
//	 */
//	public static boolean isSingleExtension(final String filename) {
//		return filename.matches("[^\\.]+\\.[^\\.]+");
//	}
//	
//	/**
//	 * <p>替换文件名中的所有点,除了最后一个。</p> 
//	 * @param filename
//	 * @return
//	 */
//	public static String forceSingleExtension(final String filename) {
//		return filename.replaceAll("\\.(?![^.]+$)", "_");
//	}
//	
//	/**
//	 * <p>替换文件夹中的特殊字符</p> 
//	 * @param folderName
//	 * @return
//	 */
//	public static String sanitizeFolderName(final String folderName) {
//
//		if (StringUtils.isBlank(folderName))
//			return folderName;
//		
//		// Remove . \ / | : ? * " < > 'Control Chars' with _
//		return folderName.replaceAll(
//				"\\.|\\\\|/|\\||:|\\?|\\*|\"|<|>|\\p{Cntrl}", "_");
//	}
//	
//	/**
//	 * <p>获得唯一文件名</p> 
//	 * @param file
//	 * @return
//	 */
//	public static File getUniqueFile(final File file) {
//		if (!file.exists())
//			return file;
//
//		File tmpFile = new File(file.getAbsolutePath());
//		File parentDir = tmpFile.getParentFile();
//		int count = 1;
//		String extension = FilenameUtils.getExtension(tmpFile.getName());
//		String baseName = FilenameUtils.getBaseName(tmpFile.getName());
//		do {
//			tmpFile = new File(parentDir, baseName + "(" + count++ + ")."
//					+ extension);
//		} while (tmpFile.exists());
//		return tmpFile;
//	}
//	
//	/**
//	 * <p>创建一个通用的多部分解析器</p> 
//	 * @param request
//	 * @return
//	 */
//	public static CommonsMultipartResolver createCommonsMultipartResolver(HttpServletRequest request){
//		return new CommonsMultipartResolver(request.getSession().getServletContext());
//	}
	
	/**
	 * <p>保存multirequest上传的文件</p> 
	 * @param multiRequest
	 * @param path 文件路径 不含文件名称
	 */
//	public static List<String> saveFiles(MultipartHttpServletRequest multiRequest,String path){
//		
//		//	取得request中的所有文件名
//		List<String> result = new ArrayList<String>();
//		Iterator<String> iter = multiRequest.getFileNames();
//		
//		while(iter.hasNext()){
//			//	取得上传文件
//			MultipartFile file = multiRequest.getFile(iter.next());
//			if(file != null){
//				//	取得当前上传文件的文件名称
//				String myFileName = file.getOriginalFilename();
//				//	如果名称不为“”,说明该文件存在，否则说明该文件不存在
//				if(myFileName.trim() !=""){
//					// 文件重命名
//					String fileName = generateFilename(myFileName.substring(myFileName.lastIndexOf(".")+1));
//					String dateDir = generateMonthname();
//					// 文件夹-绝对路径
//					String uploadPath = path + SEPARATOR + ROOT_PATH + SEPARATOR + dateDir;
//					// 文件-相对路径
//					String relativePath = ROOT_PATH + SEPARATOR + dateDir + SEPARATOR + fileName ;
//					result.add(relativePath);
//					// 检测路径是否存在
//					UploadUtil.checkDirAndCreate(new File(uploadPath));
//					// 上传文件路径
//					uploadPath = uploadPath + SEPARATOR + fileName ;
//					// 唯一文件名称
//					File localFile = new File(uploadPath);
//					localFile = getUniqueFile(localFile);
//					try {
//						file.transferTo(localFile);
//					} catch (IllegalStateException e) {
//						e.printStackTrace();
//					} catch (IOException e) {
//						e.printStackTrace();
//					}
//				}
//			}
//		}
//		return result;
//	}
	
}
