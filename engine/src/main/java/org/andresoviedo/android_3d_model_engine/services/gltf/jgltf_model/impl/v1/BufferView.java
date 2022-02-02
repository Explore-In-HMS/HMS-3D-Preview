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

package org.andresoviedo.android_3d_model_engine.services.gltf.jgltf_model.impl.v1;



/**
 * A view into a buffer generally representing a subset of the buffer. 
 * 
 * Auto-generated for bufferView.schema.json 
 * 
 */
public class BufferView
    extends GlTFChildOfRootProperty
{

    /**
     * The ID of the buffer. (required) 
     * 
     */
    private String buffer;
    /**
     * The offset into the buffer in bytes. (required)<br> 
     * Minimum: 0 (inclusive) 
     * 
     */
    private Integer byteOffset;
    /**
     * The length of the bufferView in bytes. (optional)<br> 
     * Default: 0<br> 
     * Minimum: 0 (inclusive) 
     * 
     */
    private Integer byteLength;
    /**
     * The target that the WebGL buffer should be bound to. (optional)<br> 
     * Valid values: [34962, 34963] 
     * 
     */
    private Integer target;

    /**
     * The ID of the buffer. (required) 
     * 
     * @param buffer The buffer to set
     * @throws NullPointerException If the given value is <code>null</code>
     * 
     */
    public void setBuffer(String buffer) {
        if (buffer == null) {
            throw new NullPointerException((("Invalid value for buffer: "+ buffer)+", may not be null"));
        }
        this.buffer = buffer;
    }

    /**
     * The ID of the buffer. (required) 
     * 
     * @return The buffer
     * 
     */
    public String getBuffer() {
        return this.buffer;
    }

    /**
     * The offset into the buffer in bytes. (required)<br> 
     * Minimum: 0 (inclusive) 
     * 
     * @param byteOffset The byteOffset to set
     * @throws NullPointerException If the given value is <code>null</code>
     * @throws IllegalArgumentException If the given value does not meet
     * the given constraints
     * 
     */
    public void setByteOffset(Integer byteOffset) {
        if (byteOffset == null) {
            throw new NullPointerException((("Invalid value for byteOffset: "+ byteOffset)+", may not be null"));
        }
        if (byteOffset< 0) {
            throw new IllegalArgumentException("byteOffset < 0");
        }
        this.byteOffset = byteOffset;
    }

    /**
     * The offset into the buffer in bytes. (required)<br> 
     * Minimum: 0 (inclusive) 
     * 
     * @return The byteOffset
     * 
     */
    public Integer getByteOffset() {
        return this.byteOffset;
    }

    /**
     * The length of the bufferView in bytes. (optional)<br> 
     * Default: 0<br> 
     * Minimum: 0 (inclusive) 
     * 
     * @param byteLength The byteLength to set
     * @throws IllegalArgumentException If the given value does not meet
     * the given constraints
     * 
     */
    public void setByteLength(Integer byteLength) {
        if (byteLength == null) {
            this.byteLength = byteLength;
            return ;
        }
        if (byteLength< 0) {
            throw new IllegalArgumentException("byteLength < 0");
        }
        this.byteLength = byteLength;
    }

    /**
     * The length of the bufferView in bytes. (optional)<br> 
     * Default: 0<br> 
     * Minimum: 0 (inclusive) 
     * 
     * @return The byteLength
     * 
     */
    public Integer getByteLength() {
        return this.byteLength;
    }

    /**
     * Returns the default value of the byteLength<br> 
     * @see #getByteLength 
     * 
     * @return The default byteLength
     * 
     */
    public Integer defaultByteLength() {
        return  0;
    }

    /**
     * The target that the WebGL buffer should be bound to. (optional)<br> 
     * Valid values: [34962, 34963] 
     * 
     * @param target The target to set
     * @throws IllegalArgumentException If the given value does not meet
     * the given constraints
     * 
     */
    public void setTarget(Integer target) {
        if (target == null) {
            this.target = target;
            return ;
        }
        if ((target!= 34962)&&(target!= 34963)) {
            throw new IllegalArgumentException((("Invalid value for target: "+ target)+", valid: [34962, 34963]"));
        }
        this.target = target;
    }

    /**
     * The target that the WebGL buffer should be bound to. (optional)<br> 
     * Valid values: [34962, 34963] 
     * 
     * @return The target
     * 
     */
    public Integer getTarget() {
        return this.target;
    }

}