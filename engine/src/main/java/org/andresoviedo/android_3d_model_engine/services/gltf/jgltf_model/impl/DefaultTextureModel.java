/*
 * www.javagl.de - JglTF
 *
 * Copyright 2015-2017 Marco Hutter - http://www.javagl.de
 *
 * Permission is hereby granted, free of charge, to any person
 * obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal in the Software without
 * restriction, including without limitation the rights to use,
 * copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following
 * conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
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

package org.andresoviedo.android_3d_model_engine.services.gltf.jgltf_model.impl;

import org.andresoviedo.android_3d_model_engine.services.gltf.jgltf_model.ImageModel;
import org.andresoviedo.android_3d_model_engine.services.gltf.jgltf_model.TextureModel;

/**
 * Implementation of a {@link TextureModel}
 */
public final class DefaultTextureModel extends AbstractNamedModelElement
    implements TextureModel
{
    /**
     * The magnification filter constant
     */
    private final Integer magFilter;

    /**
     * The minification filter constant
     */
    private final Integer minFilter;
    
    /**
     * The wrapping constant for the S-direction
     */
    private final int wrapS;
    
    /**
     * The wrapping constant for the T-direction
     */
    private final int wrapT;
    
    /**
     * The {@link ImageModel}
     */
    private ImageModel imageModel;
    
    /**
     * Creates a new instance
     * 
     * @param magFilter The optional magnification filter
     * @param minFilter The optional minification filter
     * @param wrapS The S-wrapping
     * @param wrapT The T-wrapping
     */
    public DefaultTextureModel(
        Integer magFilter, Integer minFilter, int wrapS, int wrapT)
    {
        this.magFilter = magFilter;
        this.minFilter = minFilter;
        this.wrapS = wrapS;
        this.wrapT = wrapT;
    }
    
    /**
     * Set the {@link ImageModel}
     * 
     * @param imageModel The {@link ImageModel}
     */
    public void setImageModel(ImageModel imageModel)
    {
        this.imageModel = imageModel;
    }
    
    @Override
    public Integer getMagFilter()
    {
        return magFilter;
    }

    @Override
    public Integer getMinFilter()
    {
        return minFilter;
    }

    @Override
    public int getWrapS()
    {
        return wrapS;
    }

    @Override
    public int getWrapT()
    {
        return wrapT;
    }

    @Override
    public ImageModel getImageModel()
    {
        return imageModel;
    }
}
