package com.example.wyl.androidviewautoadapter;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by WYL on 2016/6/15.
 */
public class ViewAutoAdapter {

    private float  deviceScreenWidth = 0;
    private float  deviceScreenHeight = 0;
    private float  uiScreenWidth = 0;
    private float  uiScreenHeight = 0;

    /**
     * 计算方式 ：
     *      deviceScreen    displayView
     *      —————— = -------------
     *       uiScreen        uiView
     *
     *
     *       deviceScreen 为实际屏幕的宽或高
     *
     *       uiScreen  为UI设计时采用的屏幕宽或高
     *
     *       displayView 为控件在屏幕上显示的宽或高
     *
     *       uiView  为UI设计时控件的宽或高
     *   因此要求实际显示的宽（高）displayView：
     *
     *       scaleWidth = deviceScreenWidth / uiScreenWidth
     *
     *       ddisplayView = uiView * scaleWidth
     *
     */
    //屏幕 与 ui 宽度比  scaleWidth = deviceScreenWidth / uiScreenWidth
    private float  scaleWidth =1;
    //屏幕 与 ui 高度比  scaleHeight = deviceScreenHeight / uiScreenHeight
    private float  scaleHeight =1;


    private static ViewAutoAdapter viewAutoAdapter;

    public static ViewAutoAdapter getInstance()
    {
        if(viewAutoAdapter==null)
        {
            viewAutoAdapter = new ViewAutoAdapter();
        }
        return viewAutoAdapter;
    }


    /**
     *
     * @param deviceScreenWidth
     * @param deviceScreenHeight
     * @param uiScreenWidth
     * @param uiScreenHeight
     */
    public void init(float deviceScreenWidth,float deviceScreenHeight,float uiScreenWidth,float uiScreenHeight)
    {
        this.deviceScreenWidth = deviceScreenWidth;
        this.deviceScreenHeight = deviceScreenHeight;
        this.uiScreenWidth = uiScreenWidth;
        this.uiScreenHeight = uiScreenHeight;
    }

    /**
     *  自动适配大小
     * @param view
     * @param uiViewWidth
     * @param uiViewHeight
     */
    public void fitView(View view,float uiViewWidth,float uiViewHeight)
    {
//        ViewParent viewParent = view.getParent();
//        Log.i("Test","viewParent:"+ (viewParent instanceof LinearLayout));
//
//        Log.i("Test","view"+(view.getClass() == TextView.class));           //false
//        Log.i("Test","view"+(view.getClass().equals(TextView.class)));     //false
//        Log.i("Test","view"+(view instanceof  TextView));                    //true
        ViewParent viewParent = view.getParent();

        if(viewParent instanceof LinearLayout) {
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) view.getLayoutParams();
            if(uiViewHeight>0)
            {
                params.height = (int)( uiViewHeight*scaleHeight);
            }
            if(uiViewWidth>0)
            {
                params.width = (int) (uiViewWidth*scaleWidth);
            }
            view.setLayoutParams(params);
        }else  if(viewParent instanceof RelativeLayout) {
            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) view.getLayoutParams();
            if(uiViewHeight>0)
            {
                params.height =  (int)( uiViewHeight*scaleHeight);
            }
            if(uiViewWidth>0)
            {
                params.width = (int) (uiViewWidth*scaleWidth);
            }
            view.setLayoutParams(params);
        }



    }

    /**
     * 自动适配大小
     * @param resId
     * @param uiViewWidth
     * @param uiViewHeight
     */
    public void fitView(Activity activity, int resId, float uiViewWidth, float uiViewHeight)
    {
            View view = activity.findViewById(resId);
            if(view!=null) //如果resId的 不归属于读取Activity，则是null
            {
                fitView(view,uiViewWidth,uiViewHeight);
            }

    }

    /**
     * 自动适配大小
     * @param resId
     * @param uiViewWidth
     * @param uiViewHeight
     */
    public void fitView(View viewRoot, int resId, float uiViewWidth, float uiViewHeight)
    {
        View view = viewRoot.findViewById(resId);
        if(view!=null) //如果resId的 不归属于读取Activity，则是null
        {
            fitView(view,uiViewWidth,uiViewHeight);
        }

    }
    public void setMar()
    {

    }

}
