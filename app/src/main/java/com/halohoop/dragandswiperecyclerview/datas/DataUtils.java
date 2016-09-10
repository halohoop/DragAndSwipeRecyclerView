package com.halohoop.dragandswiperecyclerview.datas;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class DataUtils {
	public static List<MyBean> prepareDatas(Context context){
		List<MyBean> arrayList = new ArrayList<MyBean>();
		for(int i=0;i<132;i++){
			int identifier = context.getResources()
			.getIdentifier("aa"+i, "mipmap", context.getPackageName());
			MyBean myBean = new MyBean();
			myBean.setmImgId(identifier);
			myBean.setmName(Cheeses.CHEESES[i]);
			arrayList.add(myBean);
		}
		return arrayList;
	}
}
