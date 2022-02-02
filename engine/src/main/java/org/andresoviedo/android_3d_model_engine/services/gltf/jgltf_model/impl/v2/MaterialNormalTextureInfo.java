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
 * Auto-generated for material.normalTextureInfo.schema.json 
 * 
 */
public class MaterialNormalTextureInfo
    extends TextureInfo
{

    /**
     * The scalar multiplier applied to each normal vector of the normal 
     * texture. (optional)<br> 
     * Default: 1.0 
     * 
     */
    private Float scale;

    /**
     * The scalar multiplier applied to each normal vector of the normal 
     * texture. (optional)<br> 
     * Default: 1.0 
     * 
     * @param scale The scale to set
     * 
     */
    public void setScale(Float scale) {
        if (scale == null) {
            this.scale = scale;
            return ;
        }
        this.scale = scale;
    }

    /**
     * The scalar multiplier applied to each normal vector of the normal 
     * texture. (optional)<br> 
     * Default: 1.0 
     * 
     * @return The scale
     * 
     */
    public Float getScale() {
        return this.scale;
    }

    /**
     * Returns the default value of the scale<br> 
     * @see #getScale 
     * 
     * @return The default scale
     * 
     */
    public Float defaultScale() {
        return  1.0F;
    }

}
