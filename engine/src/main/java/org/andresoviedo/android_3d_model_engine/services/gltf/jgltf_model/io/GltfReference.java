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

package org.andresoviedo.android_3d_model_engine.services.gltf.jgltf_model.io;

import java.nio.ByteBuffer;
import java.util.Objects;
import java.util.function.Consumer;

/**
 * A reference to an external resource that belongs to a {@link GltfAsset}.
 */
public final class GltfReference
{
    /**
     * The name of the external resource
     */
    private final String name;
    
    /**
     * The (relative) URI of the reference
     */
    private final String uri;
    
    /**
     * The target that is supposed to receive the binary data that was
     * read from the external resource
     */
    private final Consumer<ByteBuffer> target;
    
    /**
     * Default constructor
     * 
     * @param name The name of the external resource
     * @param uri The (relative) URI of the reference
     * @param target The target that is supposed to receive the binary
     * data that was read from the external resource
     */
    public GltfReference(String name, String uri, Consumer<ByteBuffer> target)
    {
        this.name = Objects.requireNonNull(
            name, "The name may not be null");
        this.uri = Objects.requireNonNull(
            uri, "The uri may not be null");
        this.target = Objects.requireNonNull(
            target, "The target may not be null");
    }
    
    /**
     * Returns the name of the external resource
     * 
     * @return The name
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Returns the (relative) URI of the reference
     * 
     * @return The URI
     */
    public String getUri()
    {
        return uri;
    }
    
    /**
     * Returns the target that is supposed to receive the binary
     * data that was read from the external resource
     * 
     * @return The target
     */
    public Consumer<ByteBuffer> getTarget()
    {
        return target;
    }
}
