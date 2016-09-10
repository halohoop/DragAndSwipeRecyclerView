package com.halohoop.dragandswiperecyclerview.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.support.v7.widget.helper.ItemTouchHelper.Callback;

import com.halohoop.dragandswiperecyclerview.R;
import com.halohoop.dragandswiperecyclerview.adapters.MyAdapter;
import com.halohoop.dragandswiperecyclerview.callbacks.MovementCallback;
import com.halohoop.dragandswiperecyclerview.datas.DataUtils;
import com.halohoop.dragandswiperecyclerview.datas.MyBean;
import com.halohoop.dragandswiperecyclerview.dividers.RecycleViewDivider;

import java.util.List;

public class MainActivity extends Activity {

	private RecyclerView mRcv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		List<MyBean> prepareDatas = DataUtils.prepareDatas(this);

		mRcv = (RecyclerView) findViewById(R.id.rcv);
		mRcv.setLayoutManager(new LinearLayoutManager(this));
		MyAdapter myAdapter = new MyAdapter(prepareDatas);
		mRcv.setAdapter(myAdapter);
		mRcv.addItemDecoration(new RecycleViewDivider(MainActivity.this, LinearLayoutManager.HORIZONTAL));
		Callback movementCallback = new MovementCallback(myAdapter);
		ItemTouchHelper itemTouchHelper = new ItemTouchHelper(movementCallback);
		itemTouchHelper.attachToRecyclerView(mRcv);
	}

}
