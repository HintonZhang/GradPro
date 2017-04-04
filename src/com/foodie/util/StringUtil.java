package com.foodie.util;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;



public class StringUtil {
	private static final int DEF_DIV_SCALE = 10;
	
	/**
	 * @see 转换null字符串
	 * @param o
	 *            原字符串
	 * @return 字符串
	 * 
	 * */
	public static String getString(Object o) {
		if (o == null) {
			return "";
		} else {
			return o + "";
		}
	}

	/**
	 * @see 替换[']为['']
	 * @param o
	 *            原字符串
	 * @return 新字符串
	 * 
	 * */
	public static String replace(Object o) {
		if (o != null && !"".equals(o)) {
			String tmp = o.toString().replace("'", "\'");
			tmp = tmp.replace("   ", "");
			tmp = tmp.replace("　　　", "");
			tmp = tmp.replace("(null);", "");
			tmp = tmp.replace("(null)", "");
			return tmp;
		} else {
			return "";
		}
	}

	/**
	 * @see 将字符串转换为整型
	 * @param o
	 *            原字符串
	 * @return 整型
	 * 
	 * */
	public static Integer getInt(Object o) {
		try {
			if (o == null || "".equals(o)) {
				return null;
			} else {
				if (o.toString().indexOf(".") > 0) {
					Double d = Double.parseDouble(o + "");
					return d.intValue();
				}
				return Integer.parseInt(o + "");
			}
		} catch (Exception ex) {
			return null;
		}
	}

	/**
	 * @see 将字符串转换为整型
	 * @param o
	 *            原字符串
	 * @return 整型
	 * 
	 * */
	public static Long getLong(Object o) {
		try {
			if (o == null || "".equals(o)) {
				return null;
			} else {
				if (o.toString().indexOf(".") > 0) {
					Double d = Double.parseDouble(o + "");
					return d.longValue();
				}
				return Long.parseLong(o + "");
			}
		} catch (Exception ex) {
			return null;
		}
	}
	/**
	 * @see 将字符串转换为整型
	 * @param o
	 *            原字符串
	 * @return 整型
	 * 
	 * */
	public static Double getDouble(Object o) {
		if (o == null || "".equals(o)) {
			return null;
		} else {
			return Double.parseDouble(o + "");
		}
	}

	public static Integer getInt(HashMap<String, Object> parameters, String key) {
		if (parameters == null) {
			return null;
		} else {
			return Integer.parseInt(parameters.get(key) + "");
		}
	}

	public static String getString(HashMap<String, Object> parameters,
			String key) {
		if (parameters != null) {
			return parameters.get(key) + "";
		}
		return null;
	}

	/**
	 * @see 获取解密字符串
	 * @param str1
	 *            原字符串
	 * @param str2
	 *            原字符串
	 * @return 字符串
	 * 
	 * */
	// public static String getDecryptString(String str1, String str2){
	// String[] tmp = new String[]{str1, str2};
	// String upd = StringUtil.makeSha1(tmp,true);
	// String key = Const.SOURCE_DOWNLOAD_KEY.substring(8, 15) +
	// Const.SOURCE_DOWNLOAD_KEY.substring(20, 28);
	//
	// return upd.substring(19,25) + key.substring(5,10) + str2.substring(5,10);
	// }

	/**
	 * 获取客户端的IP地址
	 * 
	 * */
//	public static String getIpAddr(HttpServletRequest request) {
	public static String getIpAddr(Map<String,String> request) {
//		String ip = request.getHeader("x-forwarded-for");
		String ip = request.get("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//			ip = request.getHeader("Proxy-Client-IP");
			ip = request.get("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//			ip = request.getHeader("WL-Proxy-Client-IP");
			ip = request.get("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//			ip = request.getRemoteAddr();
			ip = request.get("remoteAddr");
		}
		return ip;
	}

	/**
	 * 是否不为NULL
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str) {
		if (str == null)
			return false;
		if ("".equals(str.trim()))
			return false;
		return true;
	}

	public static boolean isNotEmpty(Object obj) {
		if (obj == null)
			return false;
		if ("".equals(String.valueOf(obj)))
			return false;
		return true;
	}

	/**
	 * 提供精确的加法运算。
	 * 
	 * @param v1
	 *            被加数
	 * @param v2
	 *            加数
	 * @return 两个参数的和
	 */
	public static double add(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.add(b2).doubleValue();
	}

	/**
	 * 
	 * 提供精确的减法运算。
	 * 
	 * @param v1
	 *            被减数
	 * @param v2
	 *            减数
	 * @return 两个参数的差
	 */
	public static double sub(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.subtract(b2).doubleValue();
	}

	/**
	 * 提供精确的乘法运算。
	 * 
	 * @param v1
	 *            被乘数
	 * @param v2
	 *            乘数
	 * @return 两个参数的积
	 */
	public static double mul(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.multiply(b2).doubleValue();
	}

	/**
	 * 提供（相对）精确的除法运算，当发生除不尽的情况时，精确到 小数点以后10位，以后的数字四舍五入。
	 * 
	 * @param v1
	 *            被除数
	 * @param v2
	 *            除数
	 * @return 两个参数的商
	 */
	public static double div(double v1, double v2) {
		return div(v1, v2, DEF_DIV_SCALE);
	}

	/**
	 * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指 定精度，以后的数字四舍五入。
	 * 
	 * @param v1
	 *            被除数
	 * @param v2
	 *            除数
	 * @param scale
	 *            表示表示需要精确到小数点以后几位。
	 * @return 两个参数的商
	 */

	public static double div(double v1, double v2, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException(
					"The scale must be a positive integer or zero");
		}

		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	/**
	 * 
	 * 提供精确的小数位四舍五入处理。
	 * 
	 * @param v
	 *            需要四舍五入的数字
	 * @param scale
	 *            小数点后保留几位
	 * @return 四舍五入后的结果
	 */
	public static double round(double v, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException(
					"The scale must be a positive integer or zero");
		}
		BigDecimal b = new BigDecimal(Double.toString(v));
		BigDecimal one = new BigDecimal("1");
		return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();

	}

	public static boolean isEmpty(Object o) {
		if (o == null || "".equals(o))
			return true;
		return false;
	}

	/**
	 * 半角转全角
	 * 
	 * @param input
	 *            String.
	 * @return 全角字符串.
	 */
	public static String b2qChange(String input) {
		char c[] = input.toCharArray();
		for (int i = 0; i < c.length; i++) {
			if (c[i] == ' ') {
				c[i] = '\u3000';
			} else if (c[i] < '\177') {
				c[i] = (char) (c[i] + 65248);

			}
		}
		return new String(c);
	}

	/**
	 * 全角转半角
	 * 
	 * @param input
	 *            String.
	 * @return 半角字符串
	 */
	public static String q2bChange(String input) {
		char c[] = input.toCharArray();
		for (int i = 0; i < c.length; i++) {
			if (c[i] == '\u3000') {
				c[i] = ' ';
			} else if (c[i] > '\uFF00' && c[i] < '\uFF5F') {
				c[i] = (char) (c[i] - 65248);

			}
		}
		String returnString = new String(c);

		return returnString;
	}
	
	/**
	 * num位随机数字
	 * @param num
	 * @return
	 */
	public static String random(int num) {
		String str = "";
		for (int i=0;i<num ;i++) {
			Random rdm = new Random();
			int intRd = Math.abs(rdm.nextInt()) % 10 ;
			str =str+intRd;
			
		}
	
		return str;
	}
	
	/**
	 * 获取 0--num的整数
	 * @param num
	 * @return
	 */
	public static int randomInt(int num) {
			Random rdm = new Random();
			return Math.abs(rdm.nextInt())% num  ;
	}
	/**
	 * Main unit test method.
	 * 
	 * @param args
	 *            Command line arguments.
	 * 
	 */
	public static void main(String args[]) {
		try {

//			String str = "updir/abc/2014/08/09/a.jpg;updir/abc/2014/08/09/b.jpg;updir/abc/2014/08/09/c.jpg;";
//
//			String tmp = getSmallImagePath(str);

			System.out.println(("ｘīｎ jí rú fén"));
			System.out.println(q2bChange("ｘīｎ jí rú fén"));

		} catch (Exception e) {
			System.err.println("Error:" + e.toString());
		}
	}
	
	public static String[] partString(String str){
		String[] dishOrder = str.split(",");//正则表达式
		return dishOrder;
	}
}

