/*
 * www.javagl.de - JglTF
 *
 * Copyright 2015-2016 Marco Hutter - http://www.javagl.de
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

package org.andresoviedo.android_3d_model_engine.services.gltf.jgltf_model.animation;

import java.util.Arrays;

/**
 * Methods to compute {@link Interpolator} keys from a given value and a 
 * (sorted) float array
 */
class InterpolatorKeys
{
    /**
     * Compute the index of the segment that the given key belongs to.
     * If the given key is smaller than the smallest or larger than
     * the largest key, then 0 or <code>keys.length-1<code> will be returned, 
     * respectively.
     * 
     * @param key The key
     * @param keys The sorted keys
     * @return The index for the key
     */
    static int computeIndex(float key, float keys[])
    {
        int index = Arrays.binarySearch(keys, key);
        if (index >= 0)
        {
            return index;
        }
        return Math.max(0, -index - 2);
    }
    
    /**
     * Compute the alpha value for the given key. This is a value in [0,1],
     * describing the relative location of the key in the segment with the
     * given index.
     * 
     * @param key The key
     * @param keys The sorted keys
     * @param index The index of the key
     * @return The alpha value
     */
    static float computeAlpha(float key, float keys[], int index)
    {
        if (key <= keys[0])
        {
            return 0.0f;
        }
        if (key >= keys[keys.length-1])
        {
            return 1.0f;
        }
        float local = key - keys[index];
        float delta = keys[index+1] - keys[index];
        float alpha = local / delta;
        return alpha;
        
    }
    
    /**
     * A basic test
     * @param args Not used
     */
    public static void main(String[] args)
    {
        float keys[] = { 1, 8, 11 };
        for (float d = -1; d <= 12; d+=0.1)
        {
            int index = computeIndex(d, keys);
            float alpha = computeAlpha(d, keys, index);
            System.out.println("For "+d);
            System.out.println("    index "+index);
            System.out.println("    alpha "+alpha);
        }
    }
    
}
