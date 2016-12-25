/*
 * Copyright (C) 2016, TP-LINK TECHNOLOGIES CO., LTD.
 *
 * DragListener.java
 *
 * 
 *
 * Author huanghaiqi, Created at 2016-12-25
 *
 * Ver 1.0, 2016-12-25, huanghaiqi, Create file.
 */

package com.halohoop.dragandswiperecyclerview.callbacks;

import android.support.v7.widget.RecyclerView;

public interface DragListener {
    void startDrag(RecyclerView.ViewHolder viewHolder);
}
