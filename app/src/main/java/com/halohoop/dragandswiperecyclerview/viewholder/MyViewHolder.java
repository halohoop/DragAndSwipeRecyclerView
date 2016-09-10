package com.halohoop.dragandswiperecyclerview.viewholder;

import com.halohoop.dragandswiperecyclerview.R;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MyViewHolder extends ViewHolder {

	public ImageView mIv;
	public TextView mTv;

	public MyViewHolder(View itemView) {
		super(itemView);
		mTv = (TextView) itemView.findViewById(R.id.tv);
		mIv = (ImageView) itemView.findViewById(R.id.iv);
		
	}
	
	

}
