package com.halohoop.dragandswiperecyclerview.callbacks;

import android.graphics.Canvas;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;

public class MovementCallback extends ItemTouchHelper.Callback {

	private MovementListener mMovementListener;

	public MovementCallback(MovementListener movementListener) {
		super();
		this.mMovementListener = movementListener;
	}

	@Override
	public int getMovementFlags(RecyclerView recyclerView, ViewHolder viewHolder) {
		int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
		int swipeFlags = ItemTouchHelper.LEFT /* | ItemTouchHelper.RIGHT */;
		return makeMovementFlags(dragFlags, swipeFlags);
	}

	@Override
	public boolean onMove(RecyclerView recyclerView, ViewHolder viewHolder, ViewHolder target) {
		mMovementListener.onItemMoveUpAndDown(viewHolder.getAdapterPosition(), target.getAdapterPosition());
		return false;
	}

	@Override
	public void onSwiped(ViewHolder viewHolder, int direction) {
		// switch (direction) {
		// case ItemTouchHelper.LEFT:
		// Log.i("halohoop", "LEFT");
		// break;
		// case ItemTouchHelper.RIGHT:
		// Log.i("halohoop", "RIGHT");
		// break;
		// default:
		// break;
		// }
		mMovementListener.onSwipeLeftAndRight(viewHolder.itemView, viewHolder.getAdapterPosition());
	}

	@Override
	public boolean isLongPressDragEnabled() {
		// return super.isLongPressDragEnabled();
		return true;
	}

	@Override
	public void onChildDraw(Canvas c, RecyclerView recyclerView, ViewHolder viewHolder, float dX, float dY,
			int actionState, boolean isCurrentlyActive) {
		switch (actionState) {
		case ItemTouchHelper.ACTION_STATE_SWIPE:
			// float scaleX = ;
			// float scaleY;
			// viewHolder.itemView.setScaleX(scaleX);
			// viewHolder.itemView.setScaleY(scaleY);
			int width = viewHolder.itemView.getWidth();
			
			viewHolder.itemView.setPivotX(width / 2);
			viewHolder.itemView.setPivotY(viewHolder.itemView.getHeight() / 2);
			viewHolder.itemView.setRotationX(-dX/2.0f);
			
			float alphaValue = Math.abs(dX / width);
			viewHolder.itemView.setAlpha(1 - alphaValue);
			
			viewHolder.itemView.setTranslationX(dX);
			
			//reset properties except for position property
			//in case the holder is reused;
			if(dX==-width){
				viewHolder.itemView.setPivotX(0);
				viewHolder.itemView.setPivotY(0);
				viewHolder.itemView.setRotationX(0);
				viewHolder.itemView.setAlpha(1);
//				viewHolder.itemView.setTranslationX(0);
			}
			
			break;
		default:
			super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
			break;
		}
	}

}
