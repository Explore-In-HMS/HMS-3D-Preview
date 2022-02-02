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

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Helper class storing a set of index mappings, identified via names.
 * Each index mapping maps string IDs to integer values.
 */
final class IndexMappingSet
{
    /**
     * The index mappings
     */
    private final Map<Object, Map<String, Integer>> indexMappings;
    
    /**
     * Default constructor
     */
    IndexMappingSet()
    {
        indexMappings = new LinkedHashMap<Object, Map<String,Integer>>();
    }
    
    /**
     * Return the index mapping for the given name, creating it if necessary
     * 
     * @param name The name
     * @return The index mapping
     */
    private Map<String, Integer> get(Object name)
    {
        Map<String, Integer> indexMapping = 
            indexMappings.computeIfAbsent(name, 
                n -> new LinkedHashMap<String, Integer>());
        return indexMapping;
    }
    
    /**
     * Generate an index mapping for the given name. This mapping will map
     * the keys of the given map to consecutive integer values, starting
     * with 0, in iteration order.
     * 
     * @param name The name 
     * @param map The map to initialize the mapping from 
     */
    void generate(Object name, Map<String, ?> map)
    {
        if (map != null)
        {
            get(name).putAll(IndexMappings.computeIndexMapping(map));
        }
    }
    
    /**
     * Returns the integer that is stored in the index mapping under the 
     * given key, in the index mapping that is identified with
     * the given map name
     * 
     * @param name The name of the index mapping
     * @param key The key to look up in the index mapping
     * @return The index
     */
    Integer getIndex(String name, String key)
    {
        if (key == null)
        {
            return null;
        }
        return get(name).get(key);
    }
    
    
}