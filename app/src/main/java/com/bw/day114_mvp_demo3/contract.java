package com.bw.day114_mvp_demo3;

/**
 * Copyright (C)
 * <p>
 * FileName: contract
 * <p>
 * Author: zhaozhipeng
 * <p>
 * Date: 2019/11/4 15:52
 * <p>
 * Description:
 */
public interface contract {
    interface ModelInter {
        void doData_GET(String url,ModelShared modelShared);

        void doData_POST(String url,ModelShared modelShared);
    }

    interface IPresenter {
        void onAttch(IView iView);

        void onStart(String url);

        void End();
    }

    interface IView {
        void Success(String json);

        void Filed(String error);
    }

    interface ModelShared {
        void Success(String json);

        void Filed(String error);
    }
}
