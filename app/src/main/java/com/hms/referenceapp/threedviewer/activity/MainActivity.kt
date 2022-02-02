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

import android.Manifest
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.hms.referenceapp.threedviewer.R
import com.hms.referenceapp.threedviewer.activity.CamModeActivity
import com.vmadalin.easypermissions.EasyPermissions
import jonathanfinerty.once.Once

class MainActivity : AppCompatActivity() {
    private var iv3D: ImageView? = null

    private val rc_camera_and_external_storage = 0x01 shl 8

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Once.initialise(this@MainActivity)
        iv3D = findViewById(R.id.iv3DModel)
        iv3D?.setOnClickListener {
            if (EasyPermissions.hasPermissions(
                    this,
                    Manifest.permission.CAMERA,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.INTERNET
                )
            ) {
                CamModeActivity.start(this)
//                val intent = Intent(this, PresentModelActivity::class.java)
//                startActivity(intent)
            } else {
                EasyPermissions.requestPermissions(
                    this,
                    "To use the app, you need to open permissions",
                    rc_camera_and_external_storage,
                    Manifest.permission.CAMERA,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.INTERNET
                )
            }
        }
    }
}