/*
 * glTF JSON model
 * 
 * Do not modify this class. It is automatically generated
 * with JsonModelGen (https://github.com/javagl/JsonModelGen)
 * Copyright (c) 2016 Marco Hutter - http://www.javagl.de
 */

// Copyright 2022. Explore in HMS. All rights reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at

// http://www.apache.org/licenses/LICENSE-2.0

// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package org.andresoviedo.android_3d_model_engine.services.gltf.jgltf_model.impl.v2;



/**
 * Image data used to create a texture. Image can be referenced by URI or 
 * `bufferView` index. `mimeType` is required in the latter case. 
 * 
 * Auto-generated for image.schema.json 
 * 
 */
public class Image
    extends GlTFChildOfRootProperty
{

    /**
     * The uri of the image. (optional) 
     * 
     */
    private String uri;
    /**
     * The image's MIME type. (optional)<br> 
     * Valid values: ["image/jpeg", "image/png"] 
     * 
     */
    private String mimeType;
    /**
     * The index of the bufferView that contains the image. Use this instead 
     * of the image's uri property. (optional) 
     * 
     */
    private Integer bufferView;

    /**
     * The uri of the image. (optional) 
     * 
     * @param uri The uri to set
     * 
     */
    public void setUri(String uri) {
        if (uri == null) {
            this.uri = uri;
            return ;
        }
        this.uri = uri;
    }

    /**
     * The uri of the image. (optional) 
     * 
     * @return The uri
     * 
     */
    public String getUri() {
        return this.uri;
    }

    /**
     * The image's MIME type. (optional)<br> 
     * Valid values: ["image/jpeg", "image/png"] 
     * 
     * @param mimeType The mimeType to set
     * @throws IllegalArgumentException If the given value does not meet
     * the given constraints
     * 
     */
    public void setMimeType(String mimeType) {
        if (mimeType == null) {
            this.mimeType = mimeType;
            return ;
        }
        if ((!"image/jpeg".equals(mimeType))&&(!"image/png".equals(mimeType))) {
            throw new IllegalArgumentException((("Invalid value for mimeType: "+ mimeType)+", valid: [\"image/jpeg\", \"image/png\"]"));
        }
        this.mimeType = mimeType;
    }

    /**
     * The image's MIME type. (optional)<br> 
     * Valid values: ["image/jpeg", "image/png"] 
     * 
     * @return The mimeType
     * 
     */
    public String getMimeType() {
        return this.mimeType;
    }

    /**
     * The index of the bufferView that contains the image. Use this instead 
     * of the image's uri property. (optional) 
     * 
     * @param bufferView The bufferView to set
     * 
     */
    public void setBufferView(Integer bufferView) {
        if (bufferView == null) {
            this.bufferView = bufferView;
            return ;
        }
        this.bufferView = bufferView;
    }

    /**
     * The index of the bufferView that contains the image. Use this instead 
     * of the image's uri property. (optional) 
     * 
     * @return The bufferView
     * 
     */
    public Integer getBufferView() {
        return this.bufferView;
    }

}
