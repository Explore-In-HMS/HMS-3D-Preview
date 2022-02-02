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
 * The index of the node and TRS property that an animation channel 
 * targets. 
 * 
 * Auto-generated for animation.channel.target.schema.json 
 * 
 */
public class AnimationChannelTarget
    extends GlTFProperty
{

    /**
     * The index of the node to target. (optional) 
     * 
     */
    private Integer node;
    /**
     * The name of the node's TRS property to modify, or the "weights" of the 
     * Morph Targets it instantiates. (required)<br> 
     * Valid values: ["translation", "rotation", "scale", "weights"] 
     * 
     */
    private String path;

    /**
     * The index of the node to target. (optional) 
     * 
     * @param node The node to set
     * 
     */
    public void setNode(Integer node) {
        if (node == null) {
            this.node = node;
            return ;
        }
        this.node = node;
    }

    /**
     * The index of the node to target. (optional) 
     * 
     * @return The node
     * 
     */
    public Integer getNode() {
        return this.node;
    }

    /**
     * The name of the node's TRS property to modify, or the "weights" of the 
     * Morph Targets it instantiates. (required)<br> 
     * Valid values: ["translation", "rotation", "scale", "weights"] 
     * 
     * @param path The path to set
     * @throws NullPointerException If the given value is <code>null</code>
     * @throws IllegalArgumentException If the given value does not meet
     * the given constraints
     * 
     */
    public void setPath(String path) {
        if (path == null) {
            throw new NullPointerException((("Invalid value for path: "+ path)+", may not be null"));
        }
        if ((((!"translation".equals(path))&&(!"rotation".equals(path)))&&(!"scale".equals(path)))&&(!"weights".equals(path))) {
            throw new IllegalArgumentException((("Invalid value for path: "+ path)+", valid: [\"translation\", \"rotation\", \"scale\", \"weights\"]"));
        }
        this.path = path;
    }

    /**
     * The name of the node's TRS property to modify, or the "weights" of the 
     * Morph Targets it instantiates. (required)<br> 
     * Valid values: ["translation", "rotation", "scale", "weights"] 
     * 
     * @return The path
     * 
     */
    public String getPath() {
        return this.path;
    }

}
