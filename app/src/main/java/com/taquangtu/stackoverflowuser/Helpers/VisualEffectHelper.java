package com.taquangtu.stackoverflowuser.Helpers;


import com.taquangtu.stackoverflowuser.Dialogs.DialogLoading;

public class VisualEffectHelper {
    private DialogLoading dialogLoading = new DialogLoading();
    private boolean isShow;
    private static VisualEffectHelper instance = new VisualEffectHelper();
    public static VisualEffectHelper getInstance(){
        return instance;
    }
    private VisualEffectHelper(){}
    public void showLoading(){
        if(isShow){
            //do nothing
        }else{
            dialogLoading.show();
        }
        isShow = true;
    }
    public void hideLoading(){
        if(dialogLoading.isResumed()){
            dialogLoading.hide();

        }
        isShow = false;
    }
}
