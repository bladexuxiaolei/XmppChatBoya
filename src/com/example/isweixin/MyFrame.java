package com.example.isweixin;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

public class MyFrame extends FrameLayout {
	/**
	 * ��ָ����X�����
	 */
	private int downY;
	/**
	 * ��ָ����Y�����
	 */
	private int downX;
	private boolean isSlide = false;
	public MyFrame(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	/**
	 * ���������϶�ListView item���߼�
	 */
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN: 
			System.out.println("������onTouchEvent");
			break;
		case MotionEvent.ACTION_MOVE: 
			System.out.println("���໬��onTouchEvent");
			break;
		case MotionEvent.ACTION_UP:
			System.out.println("����ſ�onTouchEvent");
			break;
		}
		return super.onTouchEvent(event);
	}
 
	/**
	 * �ַ��¼�����Ҫ�������жϵ�������Ǹ�item, �Լ�ͨ��postDelayed��������Ӧ���һ����¼�
	 */
	@Override
	public boolean dispatchTouchEvent(MotionEvent event) {
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN: 
			System.out.println("������dispatchTouchEvent");
			break;
		case MotionEvent.ACTION_MOVE: 
			System.out.println("���໬��dispatchTouchEvent");
			break;
		case MotionEvent.ACTION_UP:
			System.out.println("����ſ�dispatchTouchEvent");
			break;
		}
		return super.dispatchTouchEvent(event);
	}
	
//	@Override
//	public boolean onInterceptTouchEvent(MotionEvent event) {
//		switch (event.getAction()) {
//		case MotionEvent.ACTION_DOWN: 
//			System.out.println("������onInterceptTouchEvent");
//			break;
//		case MotionEvent.ACTION_MOVE: 
//			System.out.println("���໬��onInterceptTouchEvent");
//			break;
//		case MotionEvent.ACTION_UP:
//			System.out.println("����ſ�onInterceptTouchEvent");
//			break;
//		}
//		return super.onInterceptTouchEvent(event);
//	}
}
