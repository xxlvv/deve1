package com.bw.day114_mvp_demo3.presenter;

import android.graphics.Bitmap;

import com.bw.day114_mvp_demo3.NetUtil;
import com.bw.day114_mvp_demo3.contract;
import com.bw.day114_mvp_demo3.model.Model;

/**
 * Copyright (C)
 * <p>
 * FileName: Presenter
 * <p>
 * Author: zhaozhipeng
 * <p>
 * Date: 2019/11/4 16:04
 * <p>
 * Description:
 */
public class Presenter implements contract.IPresenter {
    private contract.IView mIView;
    private contract.ModelInter modelInter;

    @Override
    public void onAttch(contract.IView iView) {
        this.mIView = iView;
        modelInter = new Model();
    }

    @Override
    public void onStart(String url) {
        NetUtil.getInstance().doGet(url, new NetUtil.Shared() {
            @Override
            public void doGetSuccess(String json) {
                mIView.Success(json);
            }

            @Override
            public void doGetFiled(String error) {
                mIView.Filed(error);
            }

            @Override
            public void doPhotoSuccess(Bitmap json) {

            }

            @Override
            public void doPhotoFiled(String error) {

            }
        });
    }

    @Override
    public void End() {
        if (mIView != null) {
            mIView = null;
        }
        if (modelInter != null) {
            modelInter = null;
        }
    }
}
