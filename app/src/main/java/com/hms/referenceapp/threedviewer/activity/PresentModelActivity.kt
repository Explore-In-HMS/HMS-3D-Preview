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

import android.content.ActivityNotFoundException
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.hms.referenceapp.threedviewer.R
import com.hms.referenceapp.threedviewer.SceneActivity
import org.andresoviedo.android_3d_model_engine.services.wavefront.WavefrontLoader
import org.andresoviedo.util.android.AssetUtils
import org.andresoviedo.util.android.ContentUtils
import java.util.*

class PresentModelActivity : AppCompatActivity() {
    private var loadModelParameters: MutableMap<String, Any> = HashMap()
    private val REQUEST_CODE_OPEN_FILE = 1101
    private val REQUEST_CODE_OPEN_MATERIAL = 1102
    private val REQUEST_CODE_OPEN_TEXTURE = 1103

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_present_model)
        loadModelFromAssets()
    }

    private fun loadModelFromAssets() {
        AssetUtils.createChooserDialog(
            this, "Select file", null, "models", "(?i).*"
        ) { file: String? ->
            if (file != null) {
                ContentUtils.provideAssets(this)
                launchModelRendererActivity(Uri.parse("assets://$packageName/$file"), file)
            }
        }
    }

    private fun launchModelRendererActivity(uri: Uri, fileName: String = "") {
        Log.i("Menu", "Launching renderer for '$uri'")
        SceneActivity.start(this, fileName)
    }

    private fun askForRelatedFiles(modelType: Int = 0) {
        loadModelParameters["type"] = modelType
        // check if model references material file
        val materialFile = WavefrontLoader.getMaterialLib(getUserSelectedModel())
        if (materialFile == null) {
            getUserSelectedModel()?.let { launchModelRendererActivity(it) }
            return
        }
        ContentUtils.showDialog(
            this, "Select material file", "This model references a " +
                    "material file (" + materialFile + "). Please select it", "OK",
            "Cancel"
        ) { _: DialogInterface?, which: Int ->
            when (which) {
                DialogInterface.BUTTON_NEGATIVE -> getUserSelectedModel()?.let {
                    launchModelRendererActivity(
                        it
                    )
                }
                DialogInterface.BUTTON_POSITIVE -> {
                    loadModelParameters["file"] = materialFile
                    askForFile(REQUEST_CODE_OPEN_MATERIAL, "*/*")
                }
            }
        }
    }

    private fun askForFile(requestCode: Int, mimeType: String) {
        val target = ContentUtils.createGetContentIntent(mimeType)
        val intent = Intent.createChooser(target, "Select file")
        try {
            startActivityForResult(intent, requestCode)
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(this, "Error. Please install a file content provider", Toast.LENGTH_LONG)
                .show()
        }
    }

    private fun getUserSelectedModel(): Uri? {
        return loadModelParameters["model"] as Uri?
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        ContentUtils.setThreadActivity(this)
        when (requestCode) {
            REQUEST_CODE_OPEN_FILE -> {
                if (resultCode != RESULT_OK) {
                    return
                }
                val uri = data?.data ?: return
                loadModelParameters["model"] = uri
                when {
                    uri.toString().lowercase(Locale.getDefault()).endsWith(".obj") -> {
                        askForRelatedFiles(0)
                    }
                    uri.toString().lowercase(Locale.getDefault()).endsWith(".stl") -> {
                        askForRelatedFiles(1)
                    }
                    uri.toString().lowercase(Locale.getDefault()).endsWith(".dae") -> {
                        askForRelatedFiles(2)
                    }
                    uri.toString().lowercase(Locale.getDefault()).endsWith(".gltf") -> {
                        askForRelatedFiles(3)
                    }
                    else -> {
                        // no model type from filename, ask user...
                        ContentUtils.showListDialog(
                            this, "Select type", arrayOf(
                                "Wavefront (*.obj)", "Stereolithography (*" +
                                        ".stl)", "Collada (*.dae)", "Gltf (*.gltf)"
                            )
                        ) { _: DialogInterface?, which: Int ->
                            askForRelatedFiles(
                                which
                            )
                        }
                    }
                }
            }
            REQUEST_CODE_OPEN_MATERIAL -> {
                if (resultCode != RESULT_OK || data?.data == null) {
                    getUserSelectedModel()?.let { launchModelRendererActivity(it) }
                    return
                }
                val filename = loadModelParameters["file"] as String?
                ContentUtils.addUri(filename, data.data)
                // check if material references texture file
                val textureFile = WavefrontLoader.getTextureFile(data.data)
                if (textureFile == null) {
                    getUserSelectedModel()?.let { launchModelRendererActivity(it) }
                    return
                }
                ContentUtils.showDialog(
                    this, "Select texture file", "This model references a " +
                            "texture file (" + textureFile + "). Please select it", "OK",
                    "Cancel"
                ) { _: DialogInterface?, which: Int ->
                    when (which) {
                        DialogInterface.BUTTON_NEGATIVE -> getUserSelectedModel()?.let {
                            launchModelRendererActivity(
                                it
                            )
                        }
                        DialogInterface.BUTTON_POSITIVE -> {
                            loadModelParameters["file"] = textureFile
                            askForFile(
                                REQUEST_CODE_OPEN_TEXTURE,
                                "image/*"
                            )
                        }
                    }
                }
            }
            REQUEST_CODE_OPEN_TEXTURE -> {
                if (resultCode != RESULT_OK || data?.data == null) {
                    getUserSelectedModel()?.let { launchModelRendererActivity(it) }
                    return
                }
                val textureFilename = loadModelParameters["file"] as String?
                ContentUtils.addUri(textureFilename, data.data)
                getUserSelectedModel()?.let { launchModelRendererActivity(it) }
            }
        }
    }

}