package com.foodie.util;

import java.util.ResourceBundle;

import com.jfinal.kit.Prop;
import com.jfinal.kit.PropKit;

public class Const {

	public static Prop prop = PropKit.use("sysParameter.properties");// 读取配置文件

	public static String fileUploadPath = null; // 文件上传实际物理路径
	public static String fileRequestPath = null;// 文件上传服务器请求路径
	public static String hostAddress = null; // 服务器主机地址
	public static String forceUpgrade = null; // 强制升级标识，0：不强制，1：强制
	public static String fileLogPath = null;// 文件日志写入路径
	public static String iosKeyFileDir = null;// ios推送加密文件目录地址
	public static String smsAddress = null;// 短信验证码地址
	public static String weixinAddress = null;// 获取微信用户信息地址
	public static String qqAddress = null;// 获取qq用户信息地址
	public static String readingAddress = null;// 获取点读资源接口地址
	public static String selfUrl = prop.getProperties().getProperty("self_url");// 服务部署URL

	
	/**
	 * 图片验证码保存在session中的名称
	 */
	public static final String VALID_CODE = "random_code";

	/**
	 * 权限访问
	 */
	public static final String JEDIS_CACHE_KEY_PRIVILEGE = "educ_";
	public static final String CACHE_KEY_VALID_RD_LIST = "record_";

	/**
	 * 用户信息
	 */
	public static final String JEDIS_CACHE_NAME = "EUSER_";
	public static final String CACHE_KEY_VALID_STUDENT_LIST = "student_";
	public static final String CACHE_KEY_VALID_TEACHER_LIST = "teacher_";
	public static final String CACHE_KEY_VALID_PERSONS_LIST = "persons_";

	/**
	 * 数据字典
	 */
	public static final String DICTIONARY_CACHE = "dictionary_info";

	/**
	 * 角色对应的功能组
	 */
	public static final String CACHE_KEY_ROLE_FUNC_MAPPING = "RFM_";

	/**
	 * 登录使用的随机加密因子变量名
	 */
	public static final String LOGIN_MCRYPT_KEY = "_$token";

	/**
	 * 成功
	 */
	public static final String SUCCESS = "0";

	/**
	 * 信息反馈
	 */
	public static final String INFO = "1";

	/**
	 * 失败
	 */
	public static final String FAILURE = "-1";

	/**
	 * 无数据
	 */
	public static final String NO_DATA = "-2";
	
	/**
	 * 没有权限
	 */
	public static final String LIMITED = "-5";
	
	/**
	 * 没有登录
	 */
	public static final String NO_LOGIN = "-9";

	/**
	 * 分享对象类型--作业
	 */
	public static final String SHARE_HOMEWORK = "homework";

	/**
	 * 分享对象类型--资源
	 */
	public static final String SHARE_PRODUCT = "product";

	/**
	 * 分享对象类型--Lesson_note(课堂笔记)
	 */
	public static final String SHARE_NOTE = "lesson_note";

	/**
	 * 推送作业
	 */
	public static final String PUSH_TASK = "push_task";

	/**
	 * 推送作业
	 */
	public static final String PUSH_RECORD = "push_record";

	/**
	 * 推送通知
	 */
	public static final String PUSH_NOTICE = "push_notice";

	/**
	 * 推送通知
	 */
	public static final String PUSH_NOTICE_REPLY = "push_notice_reply";

	/**
	 * 推送学习圈
	 */
	public static final String PUSH_CIRCLE = "push_circle";

	/**
	 * 推送产品
	 */
	public static final String PUSH_PRODUCT = "push_product";

	/**
	 * 推送连接
	 */
	public static final String PUSH_URL = "push_url";

	/**
	 * 获取文件上传接口地址
	 */
	public static String getFileUploadUrl() {
		return prop.getProperties().getProperty("file_upload_url");
	}

	/**
	 * 获取文件上传路径
	 */
	public static String getFileUploadPath() {
		if (fileUploadPath == null) {
			ResourceBundle bundle = ResourceBundle.getBundle("sysParameter");
			fileUploadPath = bundle.getString("file_upload_path");
		}
		return fileUploadPath;
	}

	
	public static String getSelfUrl() {
		return selfUrl;
	}

	public static String getFileRequestPath() {
		if (fileRequestPath == null) {
			ResourceBundle bundle = ResourceBundle.getBundle("sysParameter");
			fileRequestPath = bundle.getString("file_request_path");
		}
		return fileRequestPath;
	}

	/**
	 * 获取服务器地址
	 */
	public static String getHostAddress() {
		if (hostAddress == null) {
			ResourceBundle bundle = ResourceBundle.getBundle("sysParameter");
			hostAddress = bundle.getString("host_address");
		}
		return hostAddress;
	}

	/**
	 * 课本图片存放地址
	 * @return
	 */
	public static String getBookImgUrl() {
		return prop.getProperties().getProperty("book_img_url");
	}
	
	/**
	 * 获取强制升级标识 0：不强制，1：强制
	 */
	public static String getForceUpgrade() {
		if (forceUpgrade == null) {
			ResourceBundle bundle = ResourceBundle.getBundle("sysParameter");
			forceUpgrade = bundle.getString("force_upgrade");
		}
		return forceUpgrade;
	}

	/**
	 * 文件日志写入路径
	 */
	public static String getFileLogPath() {
		if (fileLogPath == null) {
			ResourceBundle bundle = ResourceBundle.getBundle("sysParameter");
			fileLogPath = bundle.getString("file_log_path");
		}
		return fileLogPath;
	}

	/**
	 * 文件日志写入路径
	 */
	public static String getIosKeyFileDir() {
		if (iosKeyFileDir == null) {
			ResourceBundle bundle = ResourceBundle.getBundle("sysParameter");
			iosKeyFileDir = bundle.getString("ios_key_file_dir");
		}
		return iosKeyFileDir;
	}

	/**
	 * 获取短信接口地址
	 */
	public static String getSmsAddress() {
		if (smsAddress == null) {
			ResourceBundle bundle = ResourceBundle.getBundle("sysParameter");
			smsAddress = bundle.getString("sms_address");
		}
		return smsAddress;
	}

	/**
	 * 获取微信用户信息地址
	 */
	public static String getWeixinAddress() {
		if (weixinAddress == null) {
			ResourceBundle bundle = ResourceBundle.getBundle("sysParameter");
			weixinAddress = bundle.getString("weixin_address");
		}
		return weixinAddress;
	}

	/**
	 * 获取qq用户信息地址
	 */
	public static String getQQAddress() {
		if (qqAddress == null) {
			ResourceBundle bundle = ResourceBundle.getBundle("sysParameter");
			qqAddress = bundle.getString("qq_address");
		}
		return qqAddress;
	}

	/**
	 * 获取qq用户信息地址
	 */
	public static String getReadingAddress() {
		if (readingAddress == null) {
			ResourceBundle bundle = ResourceBundle.getBundle("sysParameter");
			readingAddress = bundle.getString("reading_address");
		}
		return readingAddress;
	}
}
