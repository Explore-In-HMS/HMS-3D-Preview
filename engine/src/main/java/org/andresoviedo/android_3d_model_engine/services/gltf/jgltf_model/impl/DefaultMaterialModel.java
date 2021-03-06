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

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import org.andresoviedo.android_3d_model_engine.services.gltf.jgltf_model.MaterialModel;
import org.andresoviedo.android_3d_model_engine.services.gltf.jgltf_model.gl.TechniqueModel;

/**
 * Implementation of a {@link MaterialModel}
 */
public final class DefaultMaterialModel extends AbstractNamedModelElement
    implements MaterialModel
{
    /**
     * The {@link TechniqueModel}
     */
    private TechniqueModel techniqueModel;
    
    /**
     * The material parameter values
     */
    private Map<String, Object> values;
    
    /**
     * Creates a new instance
     */
    public DefaultMaterialModel()
    {
        this.values = Collections.emptyMap();
    }
    
    /**
     * Set the material parameter values to be an unmodifiable shallow
     * copy of the given map (or the empty map if the given map is
     * <code>null</code>)
     * 
     * @param values The material parameter values
     */
    public void setValues(Map<String, Object> values)
    {
        if (values == null)
        {
            this.values = Collections.emptyMap();
        }
        else
        {
            this.values = Collections.unmodifiableMap(
                new LinkedHashMap<String, Object>(values));
        }
    }
    
    /**
     * Set the {@link TechniqueModel} 
     * 
     * @param techniqueModel The {@link TechniqueModel}
     */
    public void setTechniqueModel(TechniqueModel techniqueModel)
    {
        this.techniqueModel = techniqueModel;
    }

    @Override
    public TechniqueModel getTechniqueModel()
    {
        return techniqueModel;
    }

    @Override
    public Map<String, Object> getValues()
    {
        return values;
    }
    
}