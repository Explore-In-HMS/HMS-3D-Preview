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

package org.andresoviedo.android_3d_model_engine.services.collada.entities;

import java.util.ArrayList;
import java.util.List;



/**
 * Contains the extracted data for a single joint in the model. This stores the
 * joint's index, name, and local bind transform.
 * 
 * @author Karl
 *
 */
public class JointData {

	public final int index;
	public final String nameId;
	public final float[] bindLocalTransform;
    public final float[] inverseBindTransform;
    public String meshId;

	public final List<JointData> children = new ArrayList<>();

	public JointData(int index, String nameId, float[] bindLocalTransform, float[] inverseBindTransform) {
		this.index = index;
		this.nameId = nameId;
		this.bindLocalTransform = bindLocalTransform;
		this.inverseBindTransform = inverseBindTransform;
	}

	public void addChild(JointData child) {
		children.add(child);
	}

	public JointData setMeshId(String meshId) {
		this.meshId = meshId;
		return this;
	}
}
