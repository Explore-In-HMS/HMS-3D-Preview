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

import java.util.ArrayList;
import java.util.List;


/**
 * Joints and matrices defining a skin. 
 * 
 * Auto-generated for skin.schema.json 
 * 
 */
public class Skin
    extends GlTFChildOfRootProperty
{

    /**
     * The index of the accessor containing the floating-point 4x4 
     * inverse-bind matrices. The default is that each matrix is a 4x4 
     * identity matrix, which implies that inverse-bind matrices were 
     * pre-applied. (optional) 
     * 
     */
    private Integer inverseBindMatrices;
    /**
     * The index of the node used as a skeleton root. When undefined, joints 
     * transforms resolve to scene root. (optional) 
     * 
     */
    private Integer skeleton;
    /**
     * Indices of skeleton nodes, used as joints in this skin. (required)<br> 
     * Minimum number of items: 1<br> 
     * Array elements:<br> 
     * &nbsp;&nbsp;The elements of this array (optional)<br> 
     * &nbsp;&nbsp;Minimum: 0 (inclusive) 
     * 
     */
    private List<Integer> joints;

    /**
     * The index of the accessor containing the floating-point 4x4 
     * inverse-bind matrices. The default is that each matrix is a 4x4 
     * identity matrix, which implies that inverse-bind matrices were 
     * pre-applied. (optional) 
     * 
     * @param inverseBindMatrices The inverseBindMatrices to set
     * 
     */
    public void setInverseBindMatrices(Integer inverseBindMatrices) {
        if (inverseBindMatrices == null) {
            this.inverseBindMatrices = inverseBindMatrices;
            return ;
        }
        this.inverseBindMatrices = inverseBindMatrices;
    }

    /**
     * The index of the accessor containing the floating-point 4x4 
     * inverse-bind matrices. The default is that each matrix is a 4x4 
     * identity matrix, which implies that inverse-bind matrices were 
     * pre-applied. (optional) 
     * 
     * @return The inverseBindMatrices
     * 
     */
    public Integer getInverseBindMatrices() {
        return this.inverseBindMatrices;
    }

    /**
     * The index of the node used as a skeleton root. When undefined, joints 
     * transforms resolve to scene root. (optional) 
     * 
     * @param skeleton The skeleton to set
     * 
     */
    public void setSkeleton(Integer skeleton) {
        if (skeleton == null) {
            this.skeleton = skeleton;
            return ;
        }
        this.skeleton = skeleton;
    }

    /**
     * The index of the node used as a skeleton root. When undefined, joints 
     * transforms resolve to scene root. (optional) 
     * 
     * @return The skeleton
     * 
     */
    public Integer getSkeleton() {
        return this.skeleton;
    }

    /**
     * Indices of skeleton nodes, used as joints in this skin. (required)<br> 
     * Minimum number of items: 1<br> 
     * Array elements:<br> 
     * &nbsp;&nbsp;The elements of this array (optional)<br> 
     * &nbsp;&nbsp;Minimum: 0 (inclusive) 
     * 
     * @param joints The joints to set
     * @throws NullPointerException If the given value is <code>null</code>
     * @throws IllegalArgumentException If the given value does not meet
     * the given constraints
     * 
     */
    public void setJoints(List<Integer> joints) {
        if (joints == null) {
            throw new NullPointerException((("Invalid value for joints: "+ joints)+", may not be null"));
        }
        if (joints.size()< 1) {
            throw new IllegalArgumentException("Number of joints elements is < 1");
        }
        for (Integer jointsElement: joints) {
            if (jointsElement< 0) {
                throw new IllegalArgumentException("jointsElement < 0");
            }
        }
        this.joints = joints;
    }

    /**
     * Indices of skeleton nodes, used as joints in this skin. (required)<br> 
     * Minimum number of items: 1<br> 
     * Array elements:<br> 
     * &nbsp;&nbsp;The elements of this array (optional)<br> 
     * &nbsp;&nbsp;Minimum: 0 (inclusive) 
     * 
     * @return The joints
     * 
     */
    public List<Integer> getJoints() {
        return this.joints;
    }

    /**
     * Add the given joints. The joints of this instance will be replaced 
     * with a list that contains all previous elements, and additionally the 
     * new element. 
     * 
     * @param element The element
     * @throws NullPointerException If the given element is <code>null</code>
     * 
     */
    public void addJoints(Integer element) {
        if (element == null) {
            throw new NullPointerException("The element may not be null");
        }
        List<Integer> oldList = this.joints;
        List<Integer> newList = new ArrayList<Integer>();
        if (oldList!= null) {
            newList.addAll(oldList);
        }
        newList.add(element);
        this.joints = newList;
    }

    /**
     * Remove the given joints. The joints of this instance will be replaced 
     * with a list that contains all previous elements, except for the 
     * removed one. 
     * 
     * @param element The element
     * @throws NullPointerException If the given element is <code>null</code>
     * 
     */
    public void removeJoints(Integer element) {
        if (element == null) {
            throw new NullPointerException("The element may not be null");
        }
        List<Integer> oldList = this.joints;
        List<Integer> newList = new ArrayList<Integer>();
        if (oldList!= null) {
            newList.addAll(oldList);
        }
        newList.remove(element);
        this.joints = newList;
    }

}
