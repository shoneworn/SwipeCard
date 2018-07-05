package com.ailin.shone;

import android.graphics.Canvas;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.lang.reflect.Method;
import java.util.List;

public class SwipeCardCallback extends ItemTouchHelper.SimpleCallback {

    private RecyclerView mRv;
    private RecyclerView.Adapter mAdapter;
    private List mDatas;

    public SwipeCardCallback(int dragDirs, int swipeDirs,
                             RecyclerView.Adapter adapter, List datas,
                             RecyclerView recyclerView) {
        super(0, ItemTouchHelper.DOWN | ItemTouchHelper.UP |
                ItemTouchHelper.RIGHT | ItemTouchHelper.LEFT);
        mRv = recyclerView;
        mAdapter = adapter;
        mDatas = datas;

    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        return false;
    }

    @Override
    public boolean isItemViewSwipeEnabled() {
        return true;
    }

    // 在swipe 运动动画结束的时候调用
    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        Object object = mDatas.remove(viewHolder.getLayoutPosition());
        mDatas.add(0,object);
//        mAdapter.notifyDataSetChanged();
        mAdapter.notifyItemMoved(viewHolder.getLayoutPosition(), 0);
    }


    @Override
    public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        double maxDistance = recyclerView.getWidth() * 0.5f;
        double distance = Math.sqrt(dX* dX + dY * dY);
        double fraction = distance / maxDistance;

        if (fraction > 1) {
            fraction = 1;
        }

        int itemCount = recyclerView.getChildCount();
        for (int i = 0; i < itemCount; i ++) {
            View view = recyclerView.getChildAt(i);
            int level = itemCount - i - 1;
            System.out.println("cxx:level="+level);
            if (level >= 0) {
                if (level < CardConfig.MAX_SHOW_COUNT -1) {
                    view.setTranslationY((float) (CardConfig.TRANS_Y_GAP *level - fraction * CardConfig.TRANS_Y_GAP));
                    view.setScaleX((float) (1 - CardConfig.SCALE_GAP * level + fraction *CardConfig.SCALE_GAP));
                    view.setScaleY((float) (1 - CardConfig.SCALE_GAP * level + fraction *CardConfig.SCALE_GAP));

                } else if (level == CardConfig.MAX_SHOW_COUNT -1){ // 控制的是最下层的Item
                    view.setTranslationY((float) (CardConfig.TRANS_Y_GAP *(level -1)));
                    view.setScaleX((float) (1 - CardConfig.SCALE_GAP * (level- 1)));
                    view.setScaleY((float) (1 - CardConfig.SCALE_GAP * (level -1)));
                }
            }
            if(level== 0){
                view.setAlpha((float) (1 -  fraction*0.3f ));

            }
        }


        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
    }

    @Override
    public long getAnimationDuration(RecyclerView recyclerView, int animationType, float animateDx, float animateDy) {
        return 100;
    }

    @Override
    public float getSwipeThreshold(RecyclerView.ViewHolder viewHolder) {
        return 0.5f;
    }

    private void changeItemViewSwipeEnabled(int position){
        try{
            Class clazz = ItemTouchHelper.class;
            Method method = clazz.getDeclaredMethod("");
            method.setAccessible(true);

        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
