package com.yf.bet.adapter;

import androidx.annotation.NonNull;

import com.chad.library.adapter.base.BaseDelegateMultiAdapter;
import com.chad.library.adapter.base.delegate.BaseMultiTypeDelegate;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.yf.bet.R;
import com.yf.bet.model.NormalItem;

import java.util.List;

/**
 * <pre>
 *     author: 杨帆
 *     email: yangfan@haibingtech.com
 *     date: 2024/10/7 12:33
 *     desc  :
 *     history:
 * </pre>
 */
public class MyRecyclerViewAdapter extends BaseDelegateMultiAdapter<NormalItem, BaseViewHolder> {

    public MyRecyclerViewAdapter(List<NormalItem> data) {
        super(data);
        setMultiTypeDelegate(new BaseMultiTypeDelegate<NormalItem>() {
            @Override
            public int getItemType(@NonNull List<? extends NormalItem> list, int i) {
                return 1;
            }
        });

        if(getMultiTypeDelegate() != null){
            getMultiTypeDelegate().addItemType(1, R.layout.item_icon_text);
        }
    }

    @Override
    protected void convert(@NonNull BaseViewHolder baseViewHolder, NormalItem normalItem) {
        baseViewHolder.setText(R.id.text, normalItem.getTitle());
        baseViewHolder.setImageResource(R.id.icon, normalItem.getResourceId());
    }
}
