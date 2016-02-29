package com.commonpro.core;

public interface  ActionCallbackListener<T> {
	/**
     * �ɹ�ʱ����
     *
     * @param data ���ص�����
     */
    public void onSuccess(T data);

    /**
     * ʧ��ʱ����
     *
     * @param errorEvemt ������
     * @param message    ������Ϣ
     */
    public void onFailure(String errorEvent, String message);
    
    /**
     * ����ִ�н���
     * @param progress 0~100
     */
    public void onProgress(int progress,String desc);
}
