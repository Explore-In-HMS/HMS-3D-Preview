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
 * A texture and its sampler. 
 * 
 * Auto-generated for texture.schema.json 
 * 
 */
public class Texture
    extends GlTFChildOfRootProperty
{

    /**
     * The index of the sampler used by this texture. When undefined, a 
     * sampler with repeat wrapping and auto filtering should be used. 
     * (optional) 
     * 
     */
    private Integer sampler;
    /**
     * The index of the image used by this texture. (optional) 
     * 
     */
    private Integer source;

    /**
     * The index of the sampler used by this texture. When undefined, a 
     * sampler with repeat wrapping and auto filtering should be used. 
     * (optional) 
     * 
     * @param sampler The sampler to set
     * 
     */
    public void setSampler(Integer sampler) {
        if (sampler == null) {
            this.sampler = sampler;
            return ;
        }
        this.sampler = sampler;
    }

    /**
     * The index of the sampler used by this texture. When undefined, a 
     * sampler with repeat wrapping and auto filtering should be used. 
     * (optional) 
     * 
     * @return The sampler
     * 
     */
    public Integer getSampler() {
        return this.sampler;
    }

    /**
     * The index of the image used by this texture. (optional) 
     * 
     * @param source The source to set
     * 
     */
    public void setSource(Integer source) {
        if (source == null) {
            this.source = source;
            return ;
        }
        this.source = source;
    }

    /**
     * The index of the image used by this texture. (optional) 
     * 
     * @return The source
     * 
     */
    public Integer getSource() {
        return this.source;
    }

}
