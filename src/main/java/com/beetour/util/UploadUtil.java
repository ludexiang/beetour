package com.beetour.util;
import com.qiniu.util.Auth;

public class UploadUtil {
	 //设置好账号的ACCESS_KEY和SECRET_KEY
	  static String ACCESS_KEY = "1";
	  static String SECRET_KEY = "1";
	  //要上传的空间
	  static String bucketname = "1";
	

	  //简单上传，使用默认策略，只需要设置上传的空间名就可以了
	  public static String getUpToken(){
		  //密钥配置
		  Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
		  String uploadToken = auth.uploadToken(bucketname);
		  return uploadToken;
		  
	  }

}
