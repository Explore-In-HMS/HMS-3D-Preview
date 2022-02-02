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
 * Targets an animation's sampler at a node's property. 
 * 
 * Auto-generated for animation.channel.schema.json 
 * 
 */
public class AnimationChannel
    extends GlTFProperty
{

    /**
     * The index of a sampler in this animation used to compute the value for 
     * the target. (required) 
     * 
     */
    private Integer sampler;
    /**
     * The index of the node and TRS property to target. (required) 
     * 
     */
    private AnimationChannelTarget target;

    /**
     * The index of a sampler in this animation used to compute the value for 
     * the target. (required) 
     * 
     * @param sampler The sampler to set
     * @throws NullPointerException If the given value is <code>null</code>
     * 
     */
    public void setSampler(Integer sampler) {
        if (sampler == null) {
            throw new NullPointerException((("Invalid value for sampler: "+ sampler)+", may not be null"));
        }
        this.sampler = sampler;
    }

    /**
     * The index of a sampler in this animation used to compute the value for 
     * the target. (required) 
     * 
     * @return The sampler
     * 
     */
    public Integer getSampler() {
        return this.sampler;
    }

    /**
     * The index of the node and TRS property to target. (required) 
     * 
     * @param target The target to set
     * @throws NullPointerException If the given value is <code>null</code>
     * 
     */
    public void setTarget(AnimationChannelTarget target) {
        if (target == null) {
            throw new NullPointerException((("Invalid value for target: "+ target)+", may not be null"));
        }
        this.target = target;
    }

    /**
     * The index of the node and TRS property to target. (required) 
     * 
     * @return The target
     * 
     */
    public AnimationChannelTarget getTarget() {
        return this.target;
    }

}
