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
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.SurfaceHolder
import com.huawei.hms.scene.sdk.SceneView

class CustomSceneView : SceneView {
    private var modelName = ""

    constructor(context: Context?) : super(context)
    constructor(
        context: Context?,
        attributeSet: AttributeSet?
    ) : super(context, attributeSet)

    fun setModel(model: String) {
        this.modelName = model
    }

    override fun surfaceCreated(holder: SurfaceHolder) {
        super.surfaceCreated(holder)
        loadScene("${modelName}/scene.gltf")
//        loadSkyBox("skyboxTexture.dds")
        loadSpecularEnvTexture("specularEnvTexture.dds")
        loadDiffuseEnvTexture("diffuseEnvTexture.dds")
    }

    /**
     * surfaceChanged
     * - Generally, you do not need to override this method.
     * - The super method contains the initialization logic.
     * To override the surfaceChanged method, call the super method in the first line.
     *
     * @param holder SurfaceHolder.
     * @param format Surface format.
     * @param width Surface width.
     * @param height Surface height.
     */
    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {
        super.surfaceChanged(holder, format, width, height)
    }

    /**
     * surfaceDestroyed
     * - Generally, you do not need to override this method.
     * - The super method contains the initialization logic.
     * To override the surfaceDestroyed method, call the super method in the first line.
     *
     * @param holder SurfaceHolder.
     */
    override fun surfaceDestroyed(holder: SurfaceHolder) {
        super.surfaceDestroyed(holder)
    }

    /**
     * onTouchEvent
     * - Generally, override this method if you want to implement additional gesture processing logic.
     * - The super method contains the default gesture processing logic.
     * If this logic is not required, the super method does not need to be called.
     *
     * @param motionEvent MotionEvent.
     * @return whether an event is processed.
     */
    override fun onTouchEvent(motionEvent: MotionEvent?): Boolean {
        return super.onTouchEvent(motionEvent)
    }

    /**
     * onDraw
     * - Generally, you do not need to override this method.
     * If extra information (such as FPS) needs to be drawn on the screen, override this method.
     * - The super method contains the drawing logic.
     * To override the onDraw method, call the super method in an appropriate position.
     *
     * @param canvas Canvas
     */
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
    }

}