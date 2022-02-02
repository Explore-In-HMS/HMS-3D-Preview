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

package com.hms.referenceapp.threedviewer.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.hms.referenceapp.threedviewer.R

class CamModeActivity : AppCompatActivity() {
    private var llNormal: LinearLayout? = null
    private var llRound: LinearLayout? = null
    private var ivBack: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cam_mode)
        llNormal = findViewById(R.id.ll_normal_scan)
        llRound = findViewById(R.id.ll_round_scan)
        ivBack = findViewById(R.id.iv_back)
        val intent = Intent(this@CamModeActivity, NewScanActivity::class.java)
        llNormal?.setOnClickListener {
            intent.putExtra("CAMERA_MODE", 1)
            startActivity(intent)
            finish()
        }
        llRound?.setOnClickListener {
            intent.putExtra("CAMERA_MODE", 2)
            startActivity(intent)
            finish()
        }
        ivBack?.setOnClickListener {
            onBackPressed()
        }
    }

    companion object {
        @JvmStatic
        fun start(context: Context) {
            val starter = Intent(context, CamModeActivity::class.java)
            context.startActivity(starter)
        }
    }

}