
package com.halohoop.dragandswiperecyclerview.callbacks;

import android.view.View;

public interface MovementListener {
    void onItemMoveUpAndDown(int oldPosition, int position);

    void onSwipeLeftAndRight(View view, int position);
}
