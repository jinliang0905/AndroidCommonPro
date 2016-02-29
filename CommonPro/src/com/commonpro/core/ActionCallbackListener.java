package com.commonpro.core;

public interface  ActionCallbackListener<T> {
	/**
     * 成功时调用
     *
     * @param data 返回的数据
     */
    public void onSuccess(T data);

    /**
     * 失败时调用
     *
     * @param errorEvemt 错误码
     * @param message    错误信息
     */
    public void onFailure(String errorEvent, String message);
    
    /**
     * 返回执行进度
     * @param progress 0~100
     */
    public void onProgress(int progress,String desc);
}
