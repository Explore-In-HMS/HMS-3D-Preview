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

package org.andresoviedo.android_3d_model_engine.services.gltf.jgltf_model.v1;

import org.andresoviedo.android_3d_model_engine.services.gltf.jgltf_model.impl.v1.GlTF;

/**
 * Utility methods to create {@link IndexMappingSet} instances
 */
class IndexMappingSets
{
    /**
     * Compute the {@link IndexMappingSet} for the given glTF instance.
     * The {@link IndexMappingSet} will contain index mappings for all
     * top-level dictionaries of the given glTF. 
     * 
     * @param gltf The glTF
     * @return The {@link IndexMappingSet}
     */
    static IndexMappingSet create(GlTF gltf)
    {
        IndexMappingSet indexMappingSet = new IndexMappingSet();
        indexMappingSet.generate("accessors", gltf.getAccessors());
        indexMappingSet.generate("animations", gltf.getAnimations());
        indexMappingSet.generate("buffers", gltf.getBuffers());
        indexMappingSet.generate("bufferViews", gltf.getBufferViews());
        indexMappingSet.generate("cameras", gltf.getCameras());
        indexMappingSet.generate("images", gltf.getImages());
        indexMappingSet.generate("materials", gltf.getMaterials());
        indexMappingSet.generate("meshes", gltf.getMeshes());
        indexMappingSet.generate("nodes", gltf.getNodes());
        indexMappingSet.generate("programs", gltf.getPrograms());
        indexMappingSet.generate("samplers", gltf.getSamplers());
        indexMappingSet.generate("scenes", gltf.getScenes());
        indexMappingSet.generate("shaders", gltf.getShaders());
        indexMappingSet.generate("skins", gltf.getSkins());
        indexMappingSet.generate("techniques", gltf.getTechniques());
        indexMappingSet.generate("textures", gltf.getTextures());
        return indexMappingSet;
    }

    /**
     * Private constructor to prevent instantiation
     */
    private IndexMappingSets()
    {
        // Private constructor to prevent instantiation
    }
}
