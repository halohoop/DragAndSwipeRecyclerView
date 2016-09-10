
package com.halohoop.dragandswiperecyclerview.adapters;

import java.util.Collections;
import java.util.List;

import com.halohoop.dragandswiperecyclerview.R;
import com.halohoop.dragandswiperecyclerview.callbacks.MovementListener;
import com.halohoop.dragandswiperecyclerview.datas.MyBean;
import com.halohoop.dragandswiperecyclerview.viewholder.MyViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> implements MovementListener {

	private List<MyBean> datas;

	private LayoutInflater from;

	public MyAdapter(List<MyBean> datas) {
		super();
		this.datas = datas;
	}

	@Override
	public int getItemCount() {
		return datas.size();
	}

	@Override
	public void onBindViewHolder(MyViewHolder myViewHolder, int arg1) {
		MyBean myBean = datas.get(arg1);
		myViewHolder.mIv.setImageResource(myBean.getmImgId());
		myViewHolder.mTv.setText(myBean.getmName());
	}

	@Override
	public MyViewHolder onCreateViewHolder(ViewGroup arg0, int arg1) {
		if (from == null) {
			from = LayoutInflater.from(arg0.getContext());
		}
		View inflate = from.inflate(R.layout.item, arg0, false);
		return new MyViewHolder(inflate);
	}

	@Override
	public void onItemMoveUpAndDown(int oldPosition, int position) {
		Collections.swap(datas, oldPosition, position);
		notifyItemMoved(oldPosition, position);
	}

	@Override
	public void onSwipeLeftAndRight(View view, int position) {
		datas.remove(position);
		notifyItemRemoved(position);
	}

}
