package com.example.hanth2.simpleproject.simpleadapter;

import android.content.Context;
import android.os.Looper;
import android.support.v7.appcompat.BuildConfig;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by HanTH2 on 8/5/2016.
 */
public abstract class BaseSimpleAdapter<TItem, TViewHolder extends BaseSimpleViewHolder> extends RecyclerView.Adapter{

    private static final int TYPE_ITEM = 1;
    private static final int TYPE_LOADING = 2;
    private Context mContext;
    private List<TItem> mItems;
    private WeakReference<View> mLoadingMoreView;

    public BaseSimpleAdapter(Context context){
        super();
        mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        checkIfMainThread();
        switch (viewType){
            case TYPE_ITEM:
                View view = LayoutInflater.from(mContext).inflate(getItemLayoutResource(), parent, false);
                TViewHolder holder = createHolder(view);
                return holder;
            case TYPE_LOADING:
                // Footer view is loading more
                mLoadingMoreView.get().setLayoutParams(new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                return new RecyclerView.ViewHolder(mLoadingMoreView.get()) {};
            default:
                throw new UnsupportedOperationException("The item type is invalid");
        }
    }

    public TViewHolder createHolder(View view){
        throw new UnsupportedOperationException("You must implement this method at " + this.getClass().toString());
    }

    public int getItemLayoutResource(){
        throw new UnsupportedOperationException("You must implement this method at " + this.getClass().toString());
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        checkIfMainThread();
        int viewType = getItemViewType(position);
        switch (viewType){
            case TYPE_ITEM:
                TItem item = mItems.get(position);
                ((TViewHolder)holder).bind(item);
                break;
            case TYPE_LOADING:
                // No need to bind for footer view
                break;
            default:
                throw new UnsupportedOperationException("The item type is invalid");
        }
    }

    public BaseSimpleAdapter items(List<TItem> items){
        checkIfMainThread();
        if (isEmpty(items)){
            items = new ArrayList<>();
        }
        items.addAll(items);
        return this;
    }

    public void set(List<TItem> items){
        mItems = items;
    }

    public void addFooterView(View loadingView){
        checkIfMainThread();
        mLoadingMoreView = new WeakReference<View>(loadingView);
        notifyDataSetChanged();
    }

    public void removeFooterView(){
        checkIfMainThread();
        mLoadingMoreView = null;
        notifyDataSetChanged();
    }

    private void checkIfMainThread(){
        if (BuildConfig.DEBUG && Looper.myLooper() != Looper.getMainLooper()){
            throw new IllegalStateException("Current thread is not main thread");
        }
    }

    @Override
    public int getItemCount() {
        checkIfMainThread();
        int count = 0;
        if (isNotEmpty(mItems)) {
            count += mItems.size();
        }
        if (mLoadingMoreView != null) {
            count ++;
        }
        Log.d("BaseAdapter", "Item count: " + count);
        return count;
    }

    private boolean isEmpty(Collection collection){
        return collection == null || collection.isEmpty();
    }

    private boolean isNotEmpty(Collection collection){
        return collection != null && !collection.isEmpty();
    }

    public void releaseAll(){
        if (isNotEmpty(mItems)) {
            mItems.clear();
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position < mItems.size()){
            return TYPE_ITEM;
        }else if (position < getItemCount()){
            return TYPE_LOADING;
        }else {
            return super.getItemViewType(position);
        }
    }
}
