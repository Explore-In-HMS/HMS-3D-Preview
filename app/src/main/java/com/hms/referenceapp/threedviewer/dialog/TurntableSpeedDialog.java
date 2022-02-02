/**
 * Copyright 2022. Huawei Technologies Co., Ltd. All rights reserved.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * https://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hms.referenceapp.threedviewer.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.hms.referenceapp.threedviewer.R;
import com.hms.referenceapp.threedviewer.activity.NewScanActivity;
import com.huawei.hms.magicresource.util.Utils;

public class TurntableSpeedDialog extends Dialog {
    NewScanActivity mContext;
    TextView tvConfirm;
    EditText editText;

    public TurntableSpeedDialog(@NonNull NewScanActivity context) {
        super(context, R.style.BottomAnimDialogStyle);
        mContext = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    private void init() {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(mContext.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.turntable_speed_layout, null);
        Window window = this.getWindow();
        if (window != null) {
            window.setGravity(Gravity.BOTTOM);
            WindowManager.LayoutParams lp = window.getAttributes();
            lp.y = Utils.dip2px(mContext, 32);
            window.setAttributes(lp);
        }
        initView(view);
        setContentView(view);
    }

    private void initView(View view) {
        tvConfirm = view.findViewById(R.id.tv_confirm);
        editText = view.findViewById(R.id.edt_num);
        tvConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!editText.getText().toString().equals("") &&
                        Integer.parseInt(editText.getText().toString()) >= 20 &&
                        Integer.parseInt(editText.getText().toString()) <= 200) {
                    mContext.getTurnTableTime(Integer.parseInt(editText.getText().toString()));
                } else {
                    Toast.makeText(mContext, "Input is illegal", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
