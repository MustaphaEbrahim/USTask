package com.mostafa.ustask_mostafaibrahim.Base;

public interface OnDialogActionResponse<T> {

    void onPositiveButton(T response);

    void onNegativeButton();
}
