
package com.halohoop.dragandswiperecyclerview.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.halohoop.dragandswiperecyclerview.R;
import com.halohoop.dragandswiperecyclerview.callbacks.DragListener;
import com.halohoop.dragandswiperecyclerview.callbacks.MovementListener;
import com.halohoop.dragandswiperecyclerview.datas.MyBean;

import java.util.Collections;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> implements MovementListener {

    private List<MyBean> datas;

    private LayoutInflater from;
    private DragListener mDragListener;

    public MyAdapter(List<MyBean> datas, DragListener dragListener) {
        super();
        this.datas = datas;
        this.mDragListener = dragListener;
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    @Override
    public void onBindViewHolder(final MyViewHolder myViewHolder, int arg1) {
        MyBean myBean = datas.get(arg1);
        myViewHolder.mIv.setImageResource(myBean.getmImgId());
        myViewHolder.mTv.setText(myBean.getmName());
        myViewHolder.mIv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    mDragListener.startDrag(myViewHolder);
                }
                return false;
            }
        });
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

    class MyViewHolder extends RecyclerView.ViewHolder {

        public ImageView mIv;
        public TextView mTv;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTv = (TextView) itemView.findViewById(R.id.tv);
            mIv = (ImageView) itemView.findViewById(R.id.iv);
        }
    }
}
