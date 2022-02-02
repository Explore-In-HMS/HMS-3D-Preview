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

/**
 * Methods to create {@link Interpolator} instances
 */
class Interpolators
{
    /**
     * Creates an {@link Interpolator} for the given {@link InterpolatorType}.
     * If the given {@link InterpolatorType} is <code>null</code>, then 
     * a {@link InterpolatorType#LINEAR linear} interpolator will be returned.
     * 
     * @param interpolatorType The {@link InterpolatorType}
     * @return The {@link Interpolator}
     */
    static Interpolator create(InterpolatorType interpolatorType)
    {
        if (interpolatorType == null)
        {
            return new LinearInterpolator();
        }
        switch (interpolatorType)
        {
            case SLERP: 
                return new SlerpQuaternionInterpolator();

            case LINEAR:
                return new LinearInterpolator();

            case STEP:
                return new StepInterpolator();

            default:
                throw new IllegalArgumentException(
                    "Invalid interpolator type: "+interpolatorType);
        }
    }
    
    /**
     * Private constructor to prevent instantiation
     */
    private Interpolators()
    {
        // Private constructor to prevent instantiation
    }
}
