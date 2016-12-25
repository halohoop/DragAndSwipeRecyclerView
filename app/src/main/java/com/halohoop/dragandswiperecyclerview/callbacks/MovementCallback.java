package com.halohoop.dragandswiperecyclerview.callbacks;

import android.graphics.Canvas;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.helper.ItemTouchHelper;

public class MovementCallback extends ItemTouchHelper.Callback {

    private MovementListener mMovementListener;
    private DragListener mDragListener;

    public MovementCallback(MovementListener movementListener, DragListener dragListener) {
        super();
        this.mMovementListener = movementListener;
        this.mDragListener = dragListener;
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
        float alpha = viewHolder.itemView.getAlpha();
        int width = viewHolder.itemView.getWidth();

        float alphaValue = Math.abs(dX / width);
        viewHolder.itemView.setAlpha(1 - alphaValue);

        //reset properties except for position property
        //in case the holder is reused;
        if (alpha == 0) {
            viewHolder.itemView.setAlpha(1);
//				viewHolder.itemView.setTranslationX(0);
        }
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        //-----
//        switch (actionState) {
//            case ItemTouchHelper.ACTION_STATE_SWIPE:
//                break;
//            default:
//                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
//                break;
//        }
    }

}
