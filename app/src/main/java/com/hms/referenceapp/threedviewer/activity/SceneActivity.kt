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

package com.hms.referenceapp.threedviewer

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hms.referenceapp.threedviewer.activity.CustomSceneView

class SceneActivity : AppCompatActivity() {

    private lateinit var customSceneView: CustomSceneView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scene)
        customSceneView = findViewById(R.id.csv_main)
        customSceneView.setModel(model)
    }

    companion object {
        private lateinit var model: String

        @JvmStatic
        fun start(context: Context, modelName: String) {
            val starter = Intent(context, SceneActivity::class.java)
            model = modelName
            context.startActivity(starter)
        }
    }

}