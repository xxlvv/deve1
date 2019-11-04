package com.bw.day114_mvp_demo3.model;

import android.graphics.Bitmap;

import com.bw.day114_mvp_demo3.NetUtil;
import com.bw.day114_mvp_demo3.contract;

/**
 * Copyright (C)
 * <p>
 * FileName: Model
 * <p>
 * Author: zhaozhipeng
 * <p>
 * Date: 2019/11/4 16:02
 * <p>
 * Description:
 */
public class Model implements contract.ModelInter {

    @Override
    public void doData_GET(String url, final contract.ModelShared modelShared) {
        NetUtil.getInstance().doGet(url, new NetUtil.Shared() {
            @Override
            public void doGetSuccess(String json) {
                modelShared.Success(json);
            }

            @Override
            public void doGetFiled(String error) {
                modelShared.Filed(error);
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
    public void doData_POST(String url, contract.ModelShared modelShared) {

    }
}
