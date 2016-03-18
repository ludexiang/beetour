package com.beetour1;

import java.util.List;

import com.mongodb.ConnectionString;

public class Test11 {

	public static void main(String[] args) {
		String optionsPart = "maxpoolsize=20&minpoolsize=1&waitqueuemultiple=4& waitqueuetimeoutms=1500&connecttimeoutms=1000&sockettimeoutms=1500";
		for (String part : optionsPart.split("&|;")) {
			System.out.println(part);
		}
	}

}
